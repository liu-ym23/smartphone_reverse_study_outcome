package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import android.util.Pair;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import java.io.Serializable;
import java.nio.ByteBuffer;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class PureColorDetector extends GLDefaultFilter {
    private static final String RGBA2NV12Shader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uOffset;\nconst vec3 COEF_Y = vec3( 0.299,  0.587,  0.114);\nconst vec3 COEF_U = vec3(-0.147, -0.289,  0.436);\nconst vec3 COEF_V = vec3( 0.615, -0.515, -0.100);\nconst float UV_DIVIDE_LINE = 2.0 / 3.0;\nvoid main() {\n    vec2 texelOffset = vec2(uOffset, 0.0);\n    if(vTextureCoord.y <= UV_DIVIDE_LINE) {\n        vec2 texCoord = vec2(vTextureCoord.x, vTextureCoord.y * 3.0 / 2.0);\n        vec4 color0 = texture2D(sTexture, texCoord);\n        vec4 color1 = texture2D(sTexture, texCoord + texelOffset);\n        vec4 color2 = texture2D(sTexture, texCoord + texelOffset * 2.0);\n        vec4 color3 = texture2D(sTexture, texCoord + texelOffset * 3.0);\n\n        float y0 = dot(color0.rgb, COEF_Y);\n        float y1 = dot(color1.rgb, COEF_Y);\n        float y2 = dot(color2.rgb, COEF_Y);\n        float y3 = dot(color3.rgb, COEF_Y);\n        gl_FragColor = vec4(y0, y1, y2, y3);\n    } else {\n        vec2 texCoord = vec2(vTextureCoord.x, (vTextureCoord.y - UV_DIVIDE_LINE) * 3.0);\n        vec4 color0 = texture2D(sTexture, texCoord);\n        vec4 color1 = texture2D(sTexture, texCoord + texelOffset);\n        vec4 color2 = texture2D(sTexture, texCoord + texelOffset * 2.0);\n        vec4 color3 = texture2D(sTexture, texCoord + texelOffset * 3.0);\n\n        float v0 = dot(color0.rgb, COEF_V) + 0.5;\n        float u0 = dot(color1.rgb, COEF_U) + 0.5;\n        float v1 = dot(color2.rgb, COEF_V) + 0.5;\n        float u1 = dot(color3.rgb, COEF_U) + 0.5;\n        gl_FragColor = vec4(u0, v0, u1, v1);\n    }\n}";
    private int mFbTextureId;
    private FrameBuffer mFrameBuffer;
    ByteBuffer mImageBuffer;
    private final int mImageHeight;
    private final int mImageWidth;
    private long mLastDetectTime;
    private Params mParams;
    private final int mTextureHeight;
    private final int mTextureWidth;
    int mUOffsetHandle;

    public interface Callback extends Serializable {
        void onDetectPureColor(DetectResult r100);
    }

    public class DetectResult {
        public boolean isPureColor;
        public long pts;
        final /* synthetic */ PureColorDetector this$0;

        public DetectResult(PureColorDetector r100, long r101, boolean r102) {
            this.this$0 = r100;
            this.pts = r101;
            this.isPureColor = r102;
        }
    }

    public static class Params {
        public Callback callback;
        public double colorRangeRatioUV;
        public double colorRangeRatioY;
        public int detectOperate;
        public int enable;
        public int histogramStep;
        public int interval;
        public double maxFreqColorRatioUV;
        public double maxFreqColorRatioY;
        public final int minPixelCount;
        public int uploadAllInfo;

        public Params() {
            this.enable = 0;
            this.interval = 1000;
            this.detectOperate = 0;
            this.histogramStep = 2;
            this.maxFreqColorRatioUV = 0.9d;
            this.maxFreqColorRatioY = 0.3d;
            this.colorRangeRatioUV = 0.06d;
            this.colorRangeRatioY = 0.1d;
            this.uploadAllInfo = 0;
            this.minPixelCount = 10;
            this.callback = null;
        }

        public Params(Bundle r100) {
            this.enable = 0;
            this.interval = 1000;
            this.detectOperate = 0;
            this.histogramStep = 2;
            this.maxFreqColorRatioUV = 0.9d;
            this.maxFreqColorRatioY = 0.3d;
            this.colorRangeRatioUV = 0.06d;
            this.colorRangeRatioY = 0.1d;
            this.uploadAllInfo = 0;
            this.minPixelCount = 10;
            this.callback = null;
            if (r100 != null) goto L5;
            return;
        L5:
            this.enable = r100.getInt("Enable", 0);
            this.interval = r100.getInt("Interval", this.interval);
            this.detectOperate = r100.getInt("DetectOperate", this.detectOperate);
            this.histogramStep = r100.getInt("HistogramStep", this.histogramStep);
            this.maxFreqColorRatioUV = r100.getDouble("MaxFreqColorRatioUV", this.maxFreqColorRatioUV);
            this.maxFreqColorRatioY = r100.getDouble("MaxFreqColorRatioY", this.maxFreqColorRatioY);
            this.colorRangeRatioUV = r100.getDouble("ColorRangeRatioUV", this.colorRangeRatioUV);
            this.colorRangeRatioY = r100.getDouble("ColorRangeRatioY", this.colorRangeRatioY);
            this.uploadAllInfo = r100.getInt("UploadAllInfo", this.uploadAllInfo);
            this.callback = (Callback) r100.getSerializable("callback");
        }

        public void setToBundle(Bundle r100) {
            r100.putInt("Enable", this.enable);
            r100.putInt("Interval", this.interval);
            r100.putInt("DetectOperate", this.detectOperate);
            r100.putInt("HistogramStep", this.histogramStep);
            r100.putDouble("MaxFreqColorRatioUV", this.maxFreqColorRatioUV);
            r100.putDouble("MaxFreqColorRatioY", this.maxFreqColorRatioY);
            r100.putDouble("ColorRangeRatioUV", this.colorRangeRatioUV);
            r100.putDouble("ColorRangeRatioY", this.colorRangeRatioY);
            r100.putInt("UploadAllInfo", this.uploadAllInfo);
            r100.putSerializable("callback", this.callback);
        }

        public Params(JSONObject r100, Callback r101) {
            this.enable = 0;
            this.interval = 1000;
            this.detectOperate = 0;
            this.histogramStep = 2;
            this.maxFreqColorRatioUV = 0.9d;
            this.maxFreqColorRatioY = 0.3d;
            this.colorRangeRatioUV = 0.06d;
            this.colorRangeRatioY = 0.1d;
            this.uploadAllInfo = 0;
            this.minPixelCount = 10;
            this.callback = null;
            if (r100 != null) goto L5;
            return;
        L5:
            this.callback = r101;
            this.enable = r100.optInt("Enable", 0);
            this.interval = r100.optInt("Interval", this.interval);
            this.detectOperate = r100.optInt("DetectOperate", this.detectOperate);
            this.histogramStep = r100.optInt("HistogramStep", this.histogramStep);
            this.maxFreqColorRatioUV = r100.optDouble("MaxFreqColorRatioUV", this.maxFreqColorRatioUV);
            this.maxFreqColorRatioY = r100.optDouble("MaxFreqColorRatioY", this.maxFreqColorRatioY);
            this.colorRangeRatioUV = r100.optDouble("ColorRangeRatioUV", this.colorRangeRatioUV);
            this.colorRangeRatioY = r100.optDouble("ColorRangeRatioY", this.colorRangeRatioY);
            this.uploadAllInfo = r100.optInt("UploadAllInfo", this.uploadAllInfo);
        }
    }

    private void detectPuleColor() {
        int r100 = 256 >> this.mParams.histogramStep;
        int[] r101 = new int[r100];
        int[] r102 = new int[r100];
        int[] r103 = new int[r100];
        byte[] r104 = this.mImageBuffer.array();
        boolean r105 = false;
        int r106 = 0;
    L4:
        if (r106 >= 160) goto L9;
        int r107 = 0;
    L6:
        if (r107 >= 160) goto L8;
        int r108 = (r104[(r106 * 160) + r107] & UByte.MAX_VALUE) >> this.mParams.histogramStep;
        r101[r108] = r101[r108] + 1;
        r107 = r107 + 1;
        goto L6
    L8:
        r106 = r106 + 1;
        goto L4
    L9:
        int r109 = 160;
    L11:
        if (r109 >= 240.0d) goto L16;
        int r110 = 0;
    L13:
        if (r110 >= 160) goto L15;
        int r111 = (r109 * 160) + r110;
        int r112 = r104[r111] & UByte.MAX_VALUE;
        int r113 = this.mParams.histogramStep;
        int r114 = r112 >> r113;
        int r115 = (r104[r111 + 1] & UByte.MAX_VALUE) >> r113;
        r102[r114] = r102[r114] + 1;
        r103[r115] = r103[r115] + 1;
        r110 = r110 + 2;
        goto L13
    L15:
        r109 = r109 + 1;
        goto L11
    L16:
        Pair<Double, Double> r116 = calMaxFrequencyAndColorRange(r101);
        Pair<Double, Double> r117 = calMaxFrequencyAndColorRange(r102);
        Pair<Double, Double> r118 = calMaxFrequencyAndColorRange(r103);
        int r119 = this.mParams.detectOperate;
        if (r119 == 0) goto L19;
        if (r119 == 1) goto L33;
    L45:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "PureColorDetector detected: " + r105 + ", y max freq: " + r116.first + " color range: " + r116.second + ", u max freq: " + r117.first + " color range: " + r117.second + ", v max freq: " + r118.first + " color range: " + r118.second);
        Callback r120 = this.mParams.callback;
        if (r120 != null) goto L48;
        return;
    L48:
        r120.onDetectPureColor(new DetectResult(this, this.mSurfaceTexture.getTimestamp(), r105));
        return;
    L33:
        if (((Double) r116.first).doubleValue() > this.mParams.maxFreqColorRatioY) goto L37;
        if (((Double) r116.second).doubleValue() >= this.mParams.colorRangeRatioY) goto L45;
    L37:
        if (((Double) r117.first).doubleValue() > this.mParams.maxFreqColorRatioUV) goto L41;
        if (((Double) r117.second).doubleValue() >= this.mParams.colorRangeRatioUV) goto L45;
    L41:
        if (((Double) r118.first).doubleValue() <= this.mParams.maxFreqColorRatioUV) goto L43;
    L30:
        r105 = true;
        goto L45
    L43:
        if (((Double) r118.second).doubleValue() >= this.mParams.colorRangeRatioUV) goto L45;
    L19:
        if (((Double) r116.first).doubleValue() > this.mParams.maxFreqColorRatioY) goto L30;
        if (((Double) r116.second).doubleValue() < this.mParams.colorRangeRatioY) goto L30;
        if (((Double) r117.first).doubleValue() > this.mParams.maxFreqColorRatioUV) goto L30;
        if (((Double) r117.second).doubleValue() < this.mParams.colorRangeRatioUV) goto L30;
        if (((Double) r118.first).doubleValue() > this.mParams.maxFreqColorRatioUV) goto L30;
        if (((Double) r118.second).doubleValue() >= this.mParams.colorRangeRatioUV) goto L45;
        goto L30
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "PureColorDetector release, tex type: " + this.mTexType);
        if (this.mFrameBuffer == null) goto L6;
        TexGLUtils.deleteTexture(this.mFbTextureId);
        this.mFrameBuffer.release();
        this.mFrameBuffer = null;
    L6:
        return super.release();
    }

    public PureColorDetector(int r100) {
        super(r100);
        this.mFrameBuffer = null;
        this.mFbTextureId = -1;
        this.mImageWidth = 160;
        this.mImageHeight = 160;
        this.mTextureWidth = 40;
        this.mTextureHeight = 240;
        this.mImageBuffer = ByteBuffer.allocate(38400);
        this.mParams = new Params();
        this.mLastDetectTime = -1;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "PureColorDetector construct, tex type: " + this.mTexType);
    }

    private Pair<Double, Double> calMaxFrequencyAndColorRange(int[] r110) {
        int r100 = r110.length;
        int r101 = 0;
        long r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r101 >= r100) goto L9;
        int r105 = r110[r101];
        r103 = Math.max(r103, r105);
        r102 = r102 + ((long) r105);
        this.mParams.getClass();
        if (r105 <= 10) goto L7;
        r104 = r104 + 1;
    L7:
        r101 = r101 + 1;
        goto L3
    L9:
        return new Pair(Double.valueOf(((double) r103) / r102), Double.valueOf(((double) r104) / ((double) r110.length)));
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11001) goto L5;
        return RGBA2NV12Shader;
    L5:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        super.init(r110);
        if (this.mFrameBuffer != null) goto L5;
        this.mFrameBuffer = new FrameBuffer();
        this.mFbTextureId = TexGLUtils.genTexture(3553);
        GLES20.glTexImage2D(3553, 0, 6408, 40, 240, 0, 6408, 5121, null);
    L5:
        this.mUOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "uOffset");
        this.mInTextureTarget = 3553;
        this.mLastDetectTime = -1;
        return 0;
    }

    public void process(EffectTexture r110) {
        long r100 = System.nanoTime();
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 != null) goto L5;
        return;
    L5:
        Params r102 = r101.getPureColorDetectorParams();
        this.mParams = r102;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.enable == 1) goto L11;
        return;
    L11:
        long r103 = System.currentTimeMillis();
        long r104 = this.mLastDetectTime;
        if (r104 != (-1)) goto L16;
        this.mLastDetectTime = r103;
        return;
    L16:
        if ((r103 - r104) >= this.mParams.interval) goto L18;
        return;
    L18:
        this.mLastDetectTime = r103;
        if (this.mSurfaceTexture.getIntOption(126, this.mEffectType) != (-1)) goto L22;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
    L22:
        if (r110.getTexTarget() == this.mInTextureTarget) goto L26;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r110.getTexTarget());
        this.mSurfaceTexture.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r110.getTexTarget());
        return;
    L26:
        if (this.mProgram != 0) goto L29;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
        this.mSurfaceTexture.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
        return;
    L29:
        int r105 = TexGLUtils.checkGLError(this.mTexType, "filter process start,type:" + this.mEffectType);
        if (r105 == 0) goto L33;
        this.mGLError = -1;
        this.mSurfaceTexture.notifyError(r105, this.mEffectType, "");
        return;
    L33:
        this.mViewPortWidth = 40;
        this.mViewPortHeight = 240;
        this.mViewPortX = 0;
        this.mViewPortY = 0;
        this.mFrameBuffer.bindTexture(this.mFbTextureId);
        GLES20.glUseProgram(this.mProgram);
        if (this.mNeedClear == false) goto L36;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
    L36:
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        this.mTriangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, this.mTextureVertices);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r110.getTexID());
        GLES20.glTexParameteri(this.mInTextureTarget, 10241, this.mTextureMinFilter);
        GLES20.glTexParameteri(this.mInTextureTarget, 10240, this.mTextureMagFilter);
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        GLES20.glUniform1f(this.mUOffsetHandle, 1.0f / r110.getWidth());
        this.mFrameBuffer.bindTexture2D(this.mFbTextureId);
        int r106 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays before,type:" + this.mEffectType);
        if (r106 != 0) goto L39;
        GLES20.glDrawArrays(5, 0, 4);
        this.mGLError = 0;
    L40:
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        GLES20.glFinish();
        this.mImageBuffer.rewind();
        GLES20.glReadPixels(0, 0, 40, 240, 6408, 5121, this.mImageBuffer);
        detectPuleColor();
        this.mFrameBuffer.unbindTexture2D();
        int r107 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays after,type:" + this.mEffectType);
        if (this.mGLError != 0) goto L44;
        if (r107 != 0) goto L44;
        this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
        r110.giveBack();
    L45:
        long r108 = System.nanoTime() - r100;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "pure color detect cost: " + (r108 / 1000000.0f) + " ms");
        return;
    L44:
        this.mSurfaceTexture.notifyError(r107, this.mEffectType, "filter glDrawArrays after,type:" + this.mEffectType);
        this.mGLError = -1;
        goto L45
    L39:
        this.mGLError = -1;
        this.mSurfaceTexture.notifyError(r106, this.mEffectType, "filter glDrawArrays before,type:" + this.mEffectType);
        goto L40
    }
}

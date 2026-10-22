package com.ss.texturerender.fov;

import android.opengl.GLES20;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import java.util.Arrays;
import java.util.LinkedList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes40.dex */
public class GLTileCompositeFilter extends GLDefaultFilter {
    private final String fragmentShader;
    private int mAntiColorHandle;
    private TileInfo mBackgroundTileInfos;
    private TileInfo[] mCurrTileInfos;
    private int mDecodedBackgroundTexHeight;
    private int mDecodedBackgroundTexWidth;
    private int mDepthZHandle;
    private int mGlobalClampHandle;
    private int mScaleOffsetHandle;
    private int mVertexScaleOffsetHandle;
    private final String vertexShader;

    public GLTileCompositeFilter(int r100) {
        super(r100, 18);
        this.vertexShader = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform float DepthZ;\nuniform vec2 globalClamp;\nuniform vec4 vertexScaleOffset;\nvoid main() {\n  vec2 positionXY = (vec2(aPosition.x, aPosition.y) / 2.0 + 0.5) * vertexScaleOffset.xy + vertexScaleOffset.zw;\n  positionXY = (positionXY - 0.5) * 2.0;\n  gl_Position = vec4(positionXY.x, positionXY.y, DepthZ, 1.0);\n  vTextureCoord = clamp(aTextureCoord.xy, vec2(globalClamp.x), vec2(globalClamp.y));\n}\n";
        this.fragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec4 scaleOffset;\nuniform int antiColor;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord * scaleOffset.xy + scaleOffset.zw);\n  if (antiColor == 1) {\n      gl_FragColor.rgba = gl_FragColor.bgra;\n  }\n}\n";
        this.mBackgroundTileInfos = null;
        this.mCurrTileInfos = null;
        this.mDecodedBackgroundTexWidth = 0;
        this.mDecodedBackgroundTexHeight = 0;
        this.mOrder = 99;
    }

    private void drawBackground(TileInfo r210) {
        GLES20.glUniform1f(this.mDepthZHandle, 0.9f);
        GLES20.glUniform2f(this.mGlobalClampHandle, 3.0f / this.mDecodedBackgroundTexWidth, 1.0f - (3.0f / this.mDecodedBackgroundTexHeight));
        GLES20.glUniform1i(this.mAntiColorHandle, 0);
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r210.backgroundTileHeightCount) goto L17;
        int r110 = r100;
        int r104 = r101;
        int r105 = r102;
        int r106 = 0;
        int r211 = 0;
    L6:
        int r107 = r210.backgroundTileWidthCount;
        if (r106 >= r107) goto L16;
        if (r105 != (r107 - 1)) goto L11;
        int r108 = r210.backgroundTileHeightCount;
        int r109 = r105;
        int r111 = r106;
        int r212 = r103;
        drawTile(r107, r108, r107, r108, r104, r109, r110, r110, r211, r111, r212, r212, r210.tileWidth, r210.tileHeight, r210.getDecodedFrameWidth(), r210.getDecodedFrameHeight(), r210.paddingY, r210.is3DInput());
        r110 = r110 + 1;
        r211 = r111 + 1;
        int r213 = r111;
        r104 = 0;
        r105 = 0;
    L15:
        r106 = r213 + 1;
        r210 = r210;
        r103 = r212;
        goto L6
    L11:
        int r112 = r106;
        r212 = r103;
        if (r112 != (r107 - 1)) goto L14;
        int r113 = r210.backgroundTileHeightCount;
        int r214 = r105;
        r213 = r112;
        drawTile(r107, r113, r107, r113, r104, r105, r110, r110, r211, r112, r212, r212, r210.tileWidth, r210.tileHeight, r210.getDecodedFrameWidth(), r210.getDecodedFrameHeight(), r210.paddingY, r210.is3DInput());
        r104 = r214 + 1;
        r105 = r104;
        goto L15
    L14:
        r213 = r112;
        r105 = r105 + 1;
        goto L15
    L16:
        r103 = r103 + 1;
        r101 = r104;
        r100 = r110;
        r102 = r105;
        goto L4
    }

    private void drawOverlay(TileInfo r210) {
        TileInfo r110 = r210;
        GLES20.glUniform1f(this.mDepthZHandle, 0.1f);
        GLES20.glUniform2f(this.mGlobalClampHandle, 0.0f, 1.0f);
        GLES20.glUniform1i(this.mAntiColorHandle, 1);
        int r111 = r110.visibleArray.length();
        int[] r100 = new int[r111];
        int r101 = 0;
    L3:
        int r112 = -1;
        if (r101 >= r110.visibleArray.length()) goto L10;
        r100[r101] = JSONArrayProtectorUtils.getInt(r110.visibleArray, r101);     // Catch: JSONException -> L7
    L9:
        r101 = r101 + 1;
    L7:
        e = move-exception;
        r100[r101] = -1;
        e.printStackTrace();
        goto L9
    L10:
        int r102 = 0;
    L11:
        if (r102 >= r111) goto L17;
        int r103 = r100[r102];
        if (r103 == r112) goto L16;
        int r104 = r110.srcTileWidthCount;
        int r105 = r102 / r104;
        int r106 = r102 % r104;
        int r113 = r110.dstTileWidthCount;
        int r114 = r103 / r113;
        int r107 = r103 % r113;
        drawTile(r104, r110.srcTileHeightCount, r113, r110.dstTileHeightCount, r106, r106, r105, r105, r107, r107, r114, r114, r110.tileWidth, r110.tileHeight, r210.getDecodedFrameWidth(), r210.getDecodedFrameHeight(), r110.paddingY, r210.is3DInput());
    L16:
        r102 = r102 + 1;
        r112 = -1;
        r110 = r210;
        r100 = r100;
        r111 = r111;
        goto L11
    }

    private void updateMappingInfo(long r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        LinkedList<VideoSurfaceTexture.FrameMetaData> r102 = r101.getFrameMetaData(r101.getTimestamp(), r100);
        if (r102 == null) goto L12;
        int r103 = 0;
    L6:
        if (r103 >= r102.size()) goto L17;
        String r104 = r102.get(r103).getStringifiedTileInfo();
        TileInfo r105 = updateTileInfo(r104);
        int r106 = r105.streamIndex;
        if (r106 != 0) goto L10;
        this.mBackgroundTileInfos = r105;
    L11:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "debug -> tile info " + r104);
        r103 = r103 + 1;
        goto L6
    L10:
        this.mCurrTileInfos[r106 - 1] = r105;
        goto L11
    L17:
        return;
    L12:
        updateTileInfo(null);
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "debug -> frameMetaData not found, ts " + this.mSurfaceTexture.getTimestamp());
    }

    private TileInfo updateTileInfo(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return TileInfo.create(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform float DepthZ;\nuniform vec2 globalClamp;\nuniform vec4 vertexScaleOffset;\nvoid main() {\n  vec2 positionXY = (vec2(aPosition.x, aPosition.y) / 2.0 + 0.5) * vertexScaleOffset.xy + vertexScaleOffset.zw;\n  positionXY = (positionXY - 0.5) * 2.0;\n  gl_Position = vec4(positionXY.x, positionXY.y, DepthZ, 1.0);\n  vTextureCoord = clamp(aTextureCoord.xy, vec2(globalClamp.x), vec2(globalClamp.y));\n}\n";
    L5:
        if (r100 != 11001) goto L7;
        return "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec4 scaleOffset;\nuniform int antiColor;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord * scaleOffset.xy + scaleOffset.zw);\n  if (antiColor == 1) {\n      gl_FragColor.rgba = gl_FragColor.bgra;\n  }\n}\n";
    L7:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        super.init(r100);
        this.mInTextureTarget = 36197;
        this.mVertexScaleOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "vertexScaleOffset");
        this.mDepthZHandle = GLES20.glGetUniformLocation(this.mProgram, "DepthZ");
        this.mScaleOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "scaleOffset");
        this.mGlobalClampHandle = GLES20.glGetUniformLocation(this.mProgram, "globalClamp");
        this.mAntiColorHandle = GLES20.glGetUniformLocation(this.mProgram, "antiColor");
        this.mLayoutMode = 0;
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r110, FrameBuffer r111) {
        int r112 = r110.getExtraEffectTexture().length;
        TileInfo[] r100 = this.mCurrTileInfos;
        if (r100 != null) goto L5;
    L6:
        this.mCurrTileInfos = new TileInfo[r112];
    L7:
        this.mBackgroundTileInfos = null;
        Arrays.fill(this.mCurrTileInfos, null);
        updateMappingInfo(r112 + 1);
        TileInfo r113 = this.mBackgroundTileInfos;
        if (r113 != null) goto L10;
    L14:
        this.mOutTexWidth = this.mSurfaceTexture.getTexWidth();
        this.mOutTexHeight = this.mSurfaceTexture.getTexHeight();
        if (r110.getTexTarget() == this.mInTextureTarget) goto L18;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r110.getTexTarget());
        return r110;
    L18:
        this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        if (updateRenderParam(r110, null) != (-1)) goto L21;
        updateDefaultRenderParam(r110, null);
    L21:
        GLES20.glUseProgram(this.mProgram);
        if (this.mNeedClear == false) goto L24;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
    L24:
        this.mTriangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, this.mTextureVertices);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        onDrawFrameBefore();
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        if (this.mBackgroundTileInfos == null) goto L27;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r110.getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        GLES20.glTexParameteri(this.mInTextureTarget, 10241, 9729);
        GLES20.glTexParameteri(this.mInTextureTarget, 10240, 9729);
        drawBackground(this.mBackgroundTileInfos);
    L27:
        int r114 = 0;
    L28:
        TileInfo[] r101 = this.mCurrTileInfos;
        if (r114 >= r101.length) goto L34;
        if (r101[r114] == null) goto L33;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r110.getExtraEffectTexture()[r114].getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        GLES20.glTexParameteri(this.mInTextureTarget, 10241, 9728);
        GLES20.glTexParameteri(this.mInTextureTarget, 10240, 9728);
        drawOverlay(this.mCurrTileInfos[r114]);
    L33:
        r114 = r114 + 1;
        goto L28
    L34:
        onDrawFrameAfter();
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
        r110.giveBack();
        GLES20.glFinish();
        this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        return null;
    L10:
        if (this.mDecodedBackgroundTexWidth == r113.getBackgroundTexWidth()) goto L12;
    L13:
        this.mDecodedBackgroundTexWidth = this.mBackgroundTileInfos.getBackgroundTexWidth();
        this.mDecodedBackgroundTexHeight = this.mBackgroundTileInfos.getBackgroundTexHeight();
        goto L14
    L12:
        if (this.mDecodedBackgroundTexHeight == this.mBackgroundTileInfos.getBackgroundTexHeight()) goto L14;
    L5:
        if (r100.length == r112) goto L7;
        goto L6
    }

    private void drawTile(int r110, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312, int r313, int r314, int r315, boolean r316) {
        float r100 = r110;
        float r101 = ((r214 - r213) + 1) / r100;
        float r111 = r210;
        float r112 = ((r216 - r215) + 1) / r111;
        float r102 = r213 / r100;
        float r103 = r215 / r111;
        float r113 = r211;
        float r104 = ((r218 - r217) + 1) / r113;
        float r114 = r212;
        float r115 = ((r310 - r219) + 1) / r114;
        float r105 = r217 / r113;
        float r106 = ((r212 - r219) - 1) / r114;
        if (r316 == false) goto L5;
        float r107 = r315;
        float r116 = (r112 * (1.0f - (r107 / r312))) / 2.0f;
        float r108 = r107 / 4.0f;
        float r109 = r314;
        GLES20.glUniform4f(this.mScaleOffsetHandle, r101, r116, r102, (r108 / r109) + r103);
        float r117 = (-r115) / 2.0f;
        float r118 = r106 / 2.0f;
        float r119 = r115 / 2.0f;
        GLES20.glUniform4f(this.mVertexScaleOffsetHandle, r104, r117, r105, (r118 + 0.5f) + r119);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glUniform4f(this.mScaleOffsetHandle, r101, r116, r102, (r103 + r116) + ((r108 * 3.0f) / r109));
        GLES20.glUniform4f(this.mVertexScaleOffsetHandle, r104, r119, r105, r118);
        GLES20.glDrawArrays(5, 0, 4);
        return;
    L5:
        float r120 = r315;
        GLES20.glUniform4f(this.mScaleOffsetHandle, r101, r112 * (1.0f - (r120 / r312)), r102, r103 + ((r120 / 2.0f) / r314));
        GLES20.glUniform4f(this.mVertexScaleOffsetHandle, r104, -r115, r105, r106 + r115);
        GLES20.glDrawArrays(5, 0, 4);
    }
}

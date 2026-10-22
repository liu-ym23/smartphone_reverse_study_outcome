package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.realx.base.JniCommon;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class YuvConverter {
    public static final int FORMAT_TEXTURE_2D = 10;
    public static final int FORMAT_TEXTURE_OES = 11;
    private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    private static final int TEXTURE_MAX_COUNT = 45;
    private static float[] TEX_MATRIX;
    private final GlGenericDrawer drawer;
    private final GlTextureFrameBuffer i420TextureFrameBuffer;
    private int mFrameBufferId;
    private int mTextureCnt;
    private GlRectDrawer mTextureDrawer;
    private List<Integer> mTextureFreeQueue;
    private HashMap<Integer, Integer> mTextureHeightMap;
    private List<Integer> mTextureUsedQueue;
    private HashMap<Integer, Integer> mTextureWidthMap;
    private final ShaderCallbacks shaderCallbacks;
    private final ThreadUtils.ThreadChecker threadChecker;

    /* JADX INFO: renamed from: com.bytedance.realx.video.YuvConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private static final float[] uCoeffs = null;
        private static final float[] vCoeffs = null;
        private static final float[] yCoeffs = null;
        private float[] coeffs;
        private int coeffsLoc;
        private float stepSize;
        private int xUnitLoc;

        static {
            yCoeffs = new float[]{0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
            uCoeffs = new float[]{-0.148223f, -0.290993f, 0.439216f, 0.501961f};
            vCoeffs = new float[]{0.439216f, -0.367788f, -0.0714274f, 0.501961f};
        }

        private ShaderCallbacks() {
        }

        public void setPlaneU() {
            this.coeffs = uCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneV() {
            this.coeffs = vCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneY() {
            this.coeffs = yCoeffs;
            this.stepSize = 1.0f;
        }

        public /* synthetic */ ShaderCallbacks(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader r100) {
            this.xUnitLoc = r100.getUniformLocation("xUnit");
            this.coeffsLoc = r100.getUniformLocation("coeffs");
        }

        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader r100, float[] r101, int r102, int r103, int r104, int r105) {
            GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
            int r106 = this.xUnitLoc;
            float r107 = this.stepSize;
            float r108 = r102;
            GLES20.glUniform2f(r106, (r101[0] * r107) / r108, (r107 * r101[1]) / r108);
        }
    }

    public static /* synthetic */ void a(ByteBuffer r100) {
        lambda$convert$0(r100);
    }

    static {
        TEX_MATRIX = new float[16];
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.drawer.release();
        this.i420TextureFrameBuffer.release();
        GlRectDrawer r100 = this.mTextureDrawer;
        if (r100 == null) goto L5;
        r100.release();
        this.mTextureDrawer = null;
    L5:
        int r101 = this.mFrameBufferId;
        if (r101 <= 0) goto L8;
        GLES20.glDeleteFramebuffers(1, new int[]{r101}, 0);
        this.mFrameBufferId = 0;
    L8:
        List<Integer> r102 = this.mTextureFreeQueue;
        if (r102 != null) goto L11;
    L17:
        List<Integer> r103 = this.mTextureUsedQueue;
        if (r103 != null) goto L20;
    L26:
        this.threadChecker.detachThread();
        return;
    L20:
        if (r103.size() <= 0) goto L26;
        Iterator<Integer> r104 = this.mTextureUsedQueue.iterator();
    L23:
        if (r104.hasNext() == false) goto L25;
        GLES20.glDeleteTextures(1, new int[]{r104.next().intValue()}, 0);
        goto L23
    L25:
        this.mTextureUsedQueue.clear();
        goto L26
    L11:
        if (r102.size() <= 0) goto L17;
        Iterator<Integer> r105 = this.mTextureFreeQueue.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        GLES20.glDeleteTextures(1, new int[]{r105.next().intValue()}, 0);
        goto L14
    L16:
        this.mTextureFreeQueue.clear();
        goto L17
    }

    public YuvConverter() {
        this.mTextureFreeQueue = new LinkedList();
        this.mTextureUsedQueue = new LinkedList();
        this.mTextureWidthMap = new HashMap();
        this.mTextureHeightMap = new HashMap();
        this.mTextureCnt = 0;
        this.mFrameBufferId = 0;
        ThreadUtils.ThreadChecker r100 = new ThreadUtils.ThreadChecker();
        this.threadChecker = r100;
        this.i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
        ShaderCallbacks r101 = new ShaderCallbacks(null);
        this.shaderCallbacks = r101;
        this.drawer = new GlGenericDrawer(FRAGMENT_SHADER, r101);
        r100.detachThread();
    }

    private static /* synthetic */ void lambda$convert$0(ByteBuffer r100) {
        JniCommon.nativeFreeByteBuffer(r100);
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer r100) {
        return convert(r100, FilterType.Origin, 0, 0);
    }

    public void queueTexture(int r100) {
        List<Integer> r101 = this.mTextureUsedQueue;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(Integer.valueOf(r100)) == false) goto L11;
        this.mTextureUsedQueue.remove(new Integer(r100));
        List<Integer> r102 = this.mTextureFreeQueue;
        if (r102 == null) goto L12;
        r102.add(Integer.valueOf(r100));
        return;
    L12:
        return;
    }

    public int dequeueTexture(int r100, int r101) {
        int[] r102 = new int[1];
        List<Integer> r103 = this.mTextureFreeQueue;
        if (r103 == null) goto L25;
        if (r103.size() != 0) goto L9;
        int r104 = generateTexture(3553, r100, r101);
        r102[0] = r104;
        if (r104 <= 0) goto L25;
        this.mTextureUsedQueue.add(Integer.valueOf(r104));
        this.mTextureWidthMap.put(Integer.valueOf(r102[0]), Integer.valueOf(r100));
        this.mTextureHeightMap.put(Integer.valueOf(r102[0]), Integer.valueOf(r101));
        goto L25
    L9:
        int r105 = 0;
    L11:
        if (r105 >= this.mTextureFreeQueue.size()) goto L18;
        int r106 = ((Integer) ListProtector.get(this.mTextureFreeQueue, r105)).intValue();
        if (this.mTextureWidthMap.get(Integer.valueOf(r106)).intValue() != r100) goto L17;
        if (this.mTextureHeightMap.get(Integer.valueOf(r106)).intValue() != r101) goto L17;
    L19:
        if (r105 < 0) goto L21;
        r102[0] = ((Integer) ListProtector.get(this.mTextureFreeQueue, r105)).intValue();
        ListProtector.remove(this.mTextureFreeQueue, 0);
        this.mTextureUsedQueue.add(Integer.valueOf(r102[0]));
        goto L25
    L21:
        int r107 = generateTexture(3553, r100, r101);
        r102[0] = r107;
        if (r107 <= 0) goto L25;
        this.mTextureUsedQueue.add(Integer.valueOf(r107));
        this.mTextureWidthMap.put(Integer.valueOf(r102[0]), Integer.valueOf(r100));
        this.mTextureHeightMap.put(Integer.valueOf(r102[0]), Integer.valueOf(r101));
    L17:
        r105 = r105 + 1;
        goto L11
    L18:
        r105 = -1;
    L25:
        return r102[0];
    }

    private int generateTexture(int r110, int r111, int r112) {
        if (this.mTextureCnt != 45) goto L5;
        return 0;
    L5:
        int r113 = GlUtil.generateTexture(r110);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r113);
        GLES20.glTexImage2D(3553, 0, 6408, r111, r112, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        if (GLES20.glGetError() == 0) goto L8;
        return 0;
    L8:
        this.mTextureCnt++;
        return r113;
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer r210, FilterType r211, int r212, int r213) {
        this.threadChecker.checkIsOnValidThread();
        GlUtil.clearGLES2Error("YUVConverter");
        int r110 = r210.getWidth();
        int r111 = r210.getHeight();
        int r112 = ((r110 + 63) / 64) * 64;
        int r100 = ((r110 + 7) / 8) * 8;
        int r113 = (r111 + 1) / 2;
        int r101 = r111 + r113;
        final ByteBuffer r114 = JniCommon.nativeAllocateByteBuffer((r112 * r101) + r112);
        if (r114 != null) goto L5;
        return null;
    L5:
        int r115 = r112 / 4;
        int r116 = r100 / 4;
        Matrix r117 = new Matrix();
        r117.preTranslate(0.5f, 0.5f);
        r117.preScale(1.0f, -1.0f);
        r117.preTranslate(-0.5f, -0.5f);
        if (r100 == r110) goto L8;
        r117.preScale((r100 * 1.0f) / r110, 1.0f);
    L8:
        this.i420TextureFrameBuffer.setSize(r115, r101);
        GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
        GlUtil.checkNoGLES2Error("glBindFramebuffer");
        this.shaderCallbacks.setPlaneY();
        RTCVideoFrameDrawer.drawTexture(this.drawer, r210, r117, r110, r111, 0, 0, r116, r111, r211, r212, r213);
        this.shaderCallbacks.setPlaneU();
        int r118 = r116 / 2;
        RTCVideoFrameDrawer.drawTexture(this.drawer, r210, r117, r110, r111, 0, r111, r118, r113, r211, r212, r213);
        this.shaderCallbacks.setPlaneV();
        RTCVideoFrameDrawer.drawTexture(this.drawer, r210, r117, r110, r111, r115 / 2, r111, r118, r113, r211, r212, r213);
        GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, 5121, r114);
        int r102 = GLES20.glGetError();
        if (r102 == 0) goto L19;
        RXLogging.e("YUVConverter", "convert i420 failed as opengl error " + r102);
        if (1285 != r102) goto L13;
    L17:
        JniCommon.nativeFreeByteBuffer(r114);
        return null;
    L13:
        if (1282 == r102) goto L17;
        throw new RuntimeException("YuvConverter.convert: GLES20 error: " + r102);
    L19:
        GLES20.glBindFramebuffer(36160, 0);
        int r103 = (r112 * r111) + 0;
        int r104 = r112 / 2;
        int r105 = r103 + r104;
        r114.position(0);
        r114.limit(r103);
        ByteBuffer r106 = r114.slice();
        r114.position(r103);
        int r119 = ((r113 - 1) * r112) + r104;
        r114.limit(r103 + r119);
        ByteBuffer r107 = r114.slice();
        r114.position(r105);
        r114.limit(r105 + r119);
        return JavaI420Buffer.wrap(r110, r111, r106, r112, r107, r112, r114.slice(), r112, new e0(r114));
    }

    public void drawTexture(int r210, int r211, int r212, int r213, int r214) {
        if (this.mTextureDrawer != null) goto L5;
        this.mTextureDrawer = new GlRectDrawer();
    L5:
        GlUtil.checkNoGLES2Error("TextureHelper construct");
        android.opengl.Matrix.setIdentityM(TEX_MATRIX, 0);
        if (this.mFrameBufferId != 0) goto L8;
        int[] r100 = new int[1];
        GLES20.glGenFramebuffers(1, r100, 0);
        this.mFrameBufferId = r100[0];
    L8:
        GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r212, 0);
        if (r210 != 10) goto L11;
        this.mTextureDrawer.drawRgb(r211, TEX_MATRIX, r213, r214, 0, 0, r213, r214);
    L15:
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glFinish();
        GlUtil.checkNoGLES2Error("TextureHelper drawTexture");
        return;
    L11:
        if (r210 != 11) goto L15;
        this.mTextureDrawer.drawOes(r211, TEX_MATRIX, r213, r214, 0, 0, r213, r214);
        goto L15
    }
}

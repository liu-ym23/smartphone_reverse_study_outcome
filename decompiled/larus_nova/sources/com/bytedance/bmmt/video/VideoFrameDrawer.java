package com.bytedance.bmmt.video;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import com.bytedance.bmmt.video.memory.BmmtVideoByteMemoryInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface;
import com.bytedance.bmmt.video.memory.NativeBmmtByteMemory;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public class VideoFrameDrawer {
    static final float[] srcPoints = null;
    private int dstHeight;
    private final float[] dstPoints;
    private int dstWidth;
    private BmmtVideoFrameInterface lastI420Frame;
    private int renderHeight;
    private final Matrix renderMatrix;
    private final Point renderSize;
    private int renderWidth;
    private final YuvUploader yuvUploader;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.VideoFrameDrawer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$PixelFormat = null;

        static {
            int[] r100 = new int[PixelFormat.values().length];
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat = r100;
            r100[PixelFormat.kTextureOES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bmmt$video$PixelFormat[PixelFormat.kTexture2D.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class YuvUploader {
        private ByteBuffer copyBuffer;
        private int[] yuvTextures;

        private YuvUploader() {
        }

        public /* synthetic */ YuvUploader(int r100) {
            this();
        }

        public void release() {
            this.copyBuffer = null;
            int[] r100 = this.yuvTextures;
            if (r100 == null) goto L6;
            GLES20.glDeleteTextures(3, r100, 0);
            this.yuvTextures = null;
            return;
        }

        public int[] getYuvTextures() {
            return this.yuvTextures;
        }

        public int[] uploadFromBuffer(BmmtVideoByteMemoryInterface r100) {
            if (r100.getPixelFormat() == PixelFormat.kI420) goto L7;
            return null;
        L7:
            return uploadYuvData(r100.getWidth(), r100.getHeight(), new int[]{r100.getPlaneLineSize(0), r100.getPlaneLineSize(1), r100.getPlaneLineSize(2)}, new ByteBuffer[]{r100.getPlaneData(0), r100.getPlaneData(1), r100.getPlaneData(2)});
        }

        public int[] uploadYuvData(int r110, int r210, int[] r211, ByteBuffer[] r212) {
            int r100 = 0;
            int r101 = r110 / 2;
            int[] r102 = {r110, r101, r101};
            int r103 = r210 / 2;
            int[] r104 = {r210, r103, r103};
            int r105 = 0;
            int r106 = 0;
        L3:
            if (r105 >= 3) goto L8;
            int r107 = r211[r105];
            int r108 = r102[r105];
            if (r107 <= r108) goto L7;
            r106 = Math.max(r106, r108 * r104[r105]);
        L7:
            r105 = r105 + 1;
            goto L3
        L8:
            if (r106 <= 0) goto L15;
            ByteBuffer r109 = this.copyBuffer;
            if (r109 != null) goto L12;
        L13:
            this.copyBuffer = ByteBuffer.allocateDirect(r106);
            goto L15
        L12:
            if (r109.capacity() < r106) goto L13;
        L15:
            if (this.yuvTextures != null) goto L19;
            this.yuvTextures = new int[3];
            int r111 = 0;
        L17:
            if (r111 >= 3) goto L19;
            this.yuvTextures[r111] = GlUtil.generateTexture(3553);
            r111 = r111 + 1;
        L19:
            if (r100 >= 3) goto L26;
            GLES20.glPixelStorei(3317, 1);
            GLES20.glActiveTexture(33984 + r100);
            GLES20.glBindTexture(3553, this.yuvTextures[r100]);
            int r112 = r211[r100];
            int r113 = r102[r100];
            if (r112 != r113) goto L23;
            ByteBuffer r114 = r212[r100];
        L24:
            GLES20.glTexImage2D(3553, 0, 6409, r102[r100], r104[r100], 0, 6409, 5121, r114);
            GLES20.glPixelStorei(3317, 4);
            r100 = r100 + 1;
            goto L19
        L23:
            YuvHelper.copyPlane(r212[r100], r112, this.copyBuffer, r113, r113, r104[r100]);
            r114 = this.copyBuffer;
            goto L24
        L26:
            return this.yuvTextures;
        }
    }

    static {
        srcPoints = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    }

    public void release() {
        this.yuvUploader.release();
        this.lastI420Frame = null;
    }

    public VideoFrameDrawer() {
        this.dstPoints = new float[6];
        this.renderSize = new Point();
        this.dstWidth = 0;
        this.dstHeight = 0;
        this.yuvUploader = new YuvUploader(0);
        this.renderMatrix = new Matrix();
    }

    public void drawFrame(BmmtVideoFrameInterface r100, RendererCommon.GlDrawer r101) {
        drawFrame(r100, r101, null);
    }

    private void calculateTransformedRenderSize(int r100, int r101, Matrix r110) {
        if (r110 != null) goto L5;
        this.renderWidth = r100;
        this.renderHeight = r101;
        return;
    L5:
        r110.mapPoints(this.dstPoints, srcPoints);
        int r102 = 0;
    L7:
        if (r102 >= 3) goto L9;
        float[] r103 = this.dstPoints;
        int r104 = r102 * 2;
        int r105 = r104 + 0;
        r103[r105] = r103[r105] * r100;
        int r106 = r104 + 1;
        r103[r106] = r103[r106] * r101;
        r102 = r102 + 1;
        goto L7
    L9:
        float[] r107 = this.dstPoints;
        this.renderWidth = distance(r107[0], r107[1], r107[2], r107[3]);
        float[] r108 = this.dstPoints;
        this.renderHeight = distance(r108[0], r108[1], r108[4], r108[5]);
    }

    public void drawFrame(BmmtVideoFrameInterface r100, RendererCommon.GlDrawer r110, Matrix r111) {
        drawFrame(r100, r110, r111, 0, 0, r100.getRotatedWidth(), r100.getRotatedHeight());
    }

    private static int distance(float r100, float r101, float r102, float r103) {
        return (int) Math.round(Math.hypot(r102 - r100, r103 - r101));
    }

    public void drawFrame(BmmtVideoFrameInterface r110, RendererCommon.GlDrawer r210, Matrix r211, int r212, int r213, int r214, int r215) {
        if (r110 != null) goto L5;
        return;
    L5:
        BmmtVideoMemoryInterface r100 = r110.getAndRetainVideoFrameMemory();
        if (r100 != null) goto L53;
        return;
    L53:
        calculateTransformedRenderSize(r110.getRotatedWidth(), r110.getRotatedHeight(), r211);     // Catch: Throwable -> L47 Exception -> L52
        if (r100.getMemoryType() != BmmtVideoMemoryType.kOPENGL_TEXTURE) goto L11;
        boolean r101 = true;
    L12:
        this.renderMatrix.reset();     // Catch: Throwable -> L47 Exception -> L52
        this.renderMatrix.preTranslate(0.5f, 0.5f);     // Catch: Throwable -> L47 Exception -> L52
        if (r101 == true) goto L15;
        this.renderMatrix.preScale(1.0f, -1.0f);     // Catch: Throwable -> L47 Exception -> L52
    L15:
        this.renderMatrix.preRotate(r110.getRotation().value());     // Catch: Throwable -> L47 Exception -> L52
        this.renderMatrix.preTranslate(-0.5f, -0.5f);     // Catch: Throwable -> L47 Exception -> L52
        if (r211 == null) goto L18;
        this.renderMatrix.preConcat(r211);     // Catch: Throwable -> L47 Exception -> L52
    L18:
        if (r101 == false) goto L34;
        if (this.renderWidth <= 0) goto L34;
        BmmtVideoOpenGLMemoryInterface r102 = (BmmtVideoOpenGLMemoryInterface) r100;     // Catch: Throwable -> L47 Exception -> L52
        VideoScaleFilter r103 = r102.getScaleFilter();     // Catch: Throwable -> L47 Exception -> L52
        if (r103 != null) goto L25;
        r103 = VideoScaleFilter.kOpenGLOrigin;     // Catch: Throwable -> L47 Exception -> L52
    L25:
        FilterType r111 = FilterType.fromValue(r103.value());     // Catch: Throwable -> L47 Exception -> L52
        int r112 = r102.getUnScaledWidth();     // Catch: Throwable -> L47 Exception -> L52
        int r113 = r102.getUnScaledHeight();     // Catch: Throwable -> L47 Exception -> L52
        this.lastI420Frame = null;     // Catch: Throwable -> L47 Exception -> L52
        if (r111 != null) goto L28;
    L32:
        drawTexture(r210, r102, this.renderMatrix, this.renderWidth, this.renderHeight, r212, r213, r214, r215, FilterType.Origin, 0, 0, this.dstWidth, this.dstHeight);     // Catch: Throwable -> L47 Exception -> L52
        goto L50
    L28:
        if (r111 == FilterType.Origin) goto L32;
        if (r112 == 0) goto L32;
        if (r113 == 0) goto L32;
        drawTexture(r210, r102, this.renderMatrix, this.renderWidth, this.renderHeight, r212, r213, r214, r215, r111, r112, r113, this.dstWidth, this.dstHeight);     // Catch: Throwable -> L47 Exception -> L52
    L34:
        if (r110 == this.lastI420Frame) goto L45;
        this.lastI420Frame = r110;     // Catch: Throwable -> L47 Exception -> L52
        BmmtVideoFrameInterface r104 = r110.toI420();     // Catch: Throwable -> L47 Exception -> L52
        if (r104 != null) goto L39;
        r100.release();
        return;
    L39:
        BmmtVideoMemoryInterface r105 = r104.getAndRetainVideoFrameMemory();     // Catch: Throwable -> L47 Exception -> L52
        if ((r105 instanceof NativeBmmtByteMemory) == true) goto L44;
        r104.release();     // Catch: Throwable -> L47 Exception -> L52
        r100.release();
        return;
    L44:
        this.yuvUploader.uploadFromBuffer((BmmtVideoByteMemoryInterface) r105);     // Catch: Throwable -> L47 Exception -> L52
        r105.release();     // Catch: Throwable -> L47 Exception -> L52
        r104.release();     // Catch: Throwable -> L47 Exception -> L52
    L45:
        r210.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, r212, r213, r214, r215, FilterType.Origin, 0, 0, this.dstWidth, this.dstHeight);     // Catch: Throwable -> L47 Exception -> L52
        goto L50
    L11:
        r101 = false;
    L47:
        th = move-exception;
        r100.release();
        throw th;
    L50:
        r100.release();
    }

    public void drawFrame(BmmtVideoFrameInterface r100, RendererCommon.GlDrawer r101, Matrix r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.dstWidth = r107;
        this.dstHeight = r108;
        drawFrame(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void drawTexture(RendererCommon.GlDrawer r110, BmmtVideoOpenGLMemoryInterface r111, Matrix r112, int r113, int r114, int r115, int r116, int r210, int r211, FilterType r212, int r213, int r214) {
        Matrix r100 = new Matrix(r111.getAndroidTextureMatrix());
        r100.preConcat(r112);
        float[] r101 = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r100);
        int r102 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$PixelFormat[r111.getTextureTarget().ordinal()];
        if (r102 != 1) goto L5;
        r110.drawOes(r111.getTextureId(), r101, r113, r114, r115, r116, r210, r211, r212, r213, r214);
        return;
    L5:
        if (r102 != 2) goto L8;
        r110.drawRgb(r111.getTextureId(), r101, r113, r114, r115, r116, r210, r211, r212, r213, r214);
        return;
    L8:
        throw new RuntimeException("Unknown texture type.");
    }

    public static void drawTexture(RendererCommon.GlDrawer r110, BmmtVideoOpenGLMemoryInterface r111, Matrix r112, int r113, int r114, int r210, int r211, int r212, int r213, FilterType r214, int r215, int r216, int r217, int r218) {
        Matrix r100 = new Matrix(r111.getAndroidTextureMatrix());
        r100.preConcat(r112);
        float[] r101 = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r100);
        int r102 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$PixelFormat[r111.getTextureTarget().ordinal()];
        if (r102 != 1) goto L5;
        r110.drawOes(r111.getTextureId(), r101, r113, r114, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        return;
    L5:
        if (r102 != 2) goto L8;
        r110.drawRgb(r111.getTextureId(), r101, r113, r114, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        return;
    L8:
        throw new RuntimeException("Unknown texture type.");
    }
}

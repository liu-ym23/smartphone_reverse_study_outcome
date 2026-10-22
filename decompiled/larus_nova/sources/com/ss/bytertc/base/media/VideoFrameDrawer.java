package com.ss.bytertc.base.media;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvHelper;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class VideoFrameDrawer {
    static final float[] srcPoints = null;
    private final float[] dstPoints;
    private VideoFrame lastI420Frame;
    private int renderHeight;
    private final Matrix renderMatrix;
    private final Point renderSize;
    private int renderWidth;
    private final YuvUploader yuvUploader;

    /* JADX INFO: renamed from: com.ss.bytertc.base.media.VideoFrameDrawer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$VideoFrame$TextureBuffer$Type = null;

        static {
            int[] r100 = new int[VideoFrame.TextureBuffer.Type.values().length];
            $SwitchMap$com$bytedance$realx$video$VideoFrame$TextureBuffer$Type = r100;
            r100[VideoFrame.TextureBuffer.Type.OES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$realx$video$VideoFrame$TextureBuffer$Type[VideoFrame.TextureBuffer.Type.RGB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class YuvUploader {
        private ByteBuffer copyBuffer;
        private int[] yuvTextures;

        private YuvUploader() {
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

        public /* synthetic */ YuvUploader(AnonymousClass1 r100) {
            this();
        }

        public int[] uploadFromBuffer(VideoFrame.I420Buffer r100) {
            return uploadYuvData(r100.getWidth(), r100.getHeight(), new int[]{r100.getStrideY(), r100.getStrideU(), r100.getStrideV()}, new ByteBuffer[]{r100.getDataY(), r100.getDataU(), r100.getDataV()});
        }

        public int[] uploadYuvData(int r110, int r111, int[] r112, ByteBuffer[] r210) {
            int r100 = 0;
            int r101 = r110 / 2;
            int[] r102 = {r110, r101, r101};
            int r103 = r111 / 2;
            int[] r104 = {r111, r103, r103};
            int r105 = 0;
            int r106 = 0;
        L3:
            if (r105 >= 3) goto L8;
            int r107 = r112[r105];
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
            int r113 = 0;
        L17:
            if (r113 >= 3) goto L19;
            this.yuvTextures[r113] = GlUtil.generateTexture(3553);
            r113 = r113 + 1;
        L19:
            if (r100 >= 3) goto L26;
            GLES20.glActiveTexture(33984 + r100);
            GLES20.glBindTexture(3553, this.yuvTextures[r100]);
            int r114 = r112[r100];
            int r115 = r102[r100];
            if (r114 != r115) goto L23;
            ByteBuffer r116 = r210[r100];
        L24:
            GLES20.glTexImage2D(3553, 0, 6409, r102[r100], r104[r100], 0, 6409, 5121, r116);
            r100 = r100 + 1;
            goto L19
        L23:
            YuvHelper.copyPlane(r210[r100], r114, this.copyBuffer, r115, r115, r104[r100]);
            r116 = this.copyBuffer;
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
        this.yuvUploader = new YuvUploader(null);
        this.renderMatrix = new Matrix();
    }

    public void drawFrame(VideoFrame r100, RendererCommon.GlDrawer r101) {
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

    public void drawFrame(VideoFrame r100, RendererCommon.GlDrawer r110, Matrix r111) {
        drawFrame(r100, r110, r111, 0, 0, r100.getRotatedWidth(), r100.getRotatedHeight());
    }

    private static int distance(float r100, float r101, float r102, float r103) {
        return (int) Math.round(Math.hypot(r102 - r100, r103 - r101));
    }

    public void drawFrame(VideoFrame r110, RendererCommon.GlDrawer r111, Matrix r112, int r113, int r210, int r211, int r212) {
        calculateTransformedRenderSize(r110.getRotatedWidth(), r110.getRotatedHeight(), r112);     // Catch: Exception -> L27
        boolean r100 = r110.getBuffer() instanceof VideoFrame.TextureBuffer;     // Catch: Exception -> L27
        this.renderMatrix.reset();     // Catch: Exception -> L27
        this.renderMatrix.preTranslate(0.5f, 0.5f);     // Catch: Exception -> L27
        if (r100 == true) goto L6;
        this.renderMatrix.preScale(1.0f, -1.0f);     // Catch: Exception -> L27
    L6:
        this.renderMatrix.preRotate(r110.getRotation());     // Catch: Exception -> L27
        this.renderMatrix.preTranslate(-0.5f, -0.5f);     // Catch: Exception -> L27
        if (r112 == null) goto L9;
        this.renderMatrix.preConcat(r112);     // Catch: Exception -> L27
    L9:
        if (r100 == false) goto L21;
        if (this.renderWidth <= 0) goto L21;
        FilterType r114 = ((VideoFrame.TextureBuffer) r110.getBuffer()).getScaleFilter();     // Catch: Exception -> L27
        int r115 = ((VideoFrame.TextureBuffer) r110.getBuffer()).getUnscaledWidth();     // Catch: Exception -> L27
        int r116 = ((VideoFrame.TextureBuffer) r110.getBuffer()).getUnscaledHeight();     // Catch: Exception -> L27
        this.lastI420Frame = null;     // Catch: Exception -> L27
        if (r114 != null) goto L15;
    L19:
        drawTexture(r111, (VideoFrame.TextureBuffer) r110.getBuffer(), this.renderMatrix, this.renderWidth, this.renderHeight, r113, r210, r211, r212, FilterType.Origin, 0, 0);     // Catch: Exception -> L27
        return;
    L15:
        if (r114 == FilterType.Origin) goto L19;
        if (r115 == 0) goto L19;
        if (r116 == 0) goto L19;
        drawTexture(r111, (VideoFrame.TextureBuffer) r110.getBuffer(), this.renderMatrix, this.renderWidth, this.renderHeight, r113, r210, r211, r212, r114, r115, r116);     // Catch: Exception -> L27
        return;
    L21:
        if (r110 == this.lastI420Frame) goto L25;
        this.lastI420Frame = r110;     // Catch: Exception -> L27
        if (r110.getBuffer() == null) goto L25;
        VideoFrame.I420Buffer r101 = r110.getBuffer().toI420();     // Catch: Exception -> L27
        this.yuvUploader.uploadFromBuffer(r101);     // Catch: Exception -> L27
        r101.release();     // Catch: Exception -> L27
    L25:
        r111.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, r113, r210, r211, r212, FilterType.Origin, 0, 0);     // Catch: Exception -> L27
        return;
    }

    public static void drawTexture(RendererCommon.GlDrawer r110, VideoFrame.TextureBuffer r111, Matrix r112, int r113, int r114, int r115, int r116, int r210, int r211, FilterType r212, int r213, int r214) {
        Matrix r100 = new Matrix(r111.getTransformMatrix());
        r100.preConcat(r112);
        float[] r101 = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r100);
        int r102 = AnonymousClass1.$SwitchMap$com$bytedance$realx$video$VideoFrame$TextureBuffer$Type[r111.getType().ordinal()];
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
}

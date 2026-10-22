package com.bytedance.realx.video.memory.bridge;

import android.graphics.Matrix;
import android.opengl.EGLContext;
import com.bytedance.realx.base.RefCountDelegate;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoScaleFilter;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: loaded from: classes21.dex */
public class RXWebRTCTextureBuffer implements VideoFrame.TextureBuffer {
    private boolean isAgfxTexture;
    private final long nativeRXVideoFrame;
    private final RefCountDelegate refCountDelegate;

    public static /* synthetic */ void a(long r100) {
        lambda$new$0(r100);
    }

    private static native long nativeCreateTextureRXVideoFrame(long r100, float[] r101, int r102, int r103, int r104, int r105, RXVideoScaleFilter r106);

    private static native EGLContext nativeGetAndroidEGLContext(long r100);

    private static native EGLContext nativeGetEGLContext(long r100);

    private static native float[] nativeGetFloatTextureMatrix(long r100);

    private static native int nativeGetHeight(long r100);

    private static native RXPixelFormat nativeGetPixelFormat(long r100);

    private static native RXVideoScaleFilter nativeGetRXVideoScaleFilter(long r100);

    private static native int nativeGetTextureId(long r100);

    private static native int nativeGetUnscaledHeight(long r100);

    private static native int nativeGetUnscaledWidth(long r100);

    private static native int nativeGetWidth(long r100);

    private static native void nativeReleaseRXVideoFrame(long r100);

    private static native VideoFrame.I420Buffer nativeToI420(long r100);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ VideoFrame.NV12Buffer toNV12() {
        return VideoFrame.Buffer.CC.$default$toNV12(this);
    }

    public EGLContext getEGLContext() {
        return nativeGetAndroidEGLContext(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public EGLContext getEglContext() {
        return nativeGetEGLContext(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return nativeGetHeight(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public FilterType getScaleFilter() {
        return FilterType.fromValue(nativeGetRXVideoScaleFilter(this.nativeRXVideoFrame).value());
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTextureId() {
        return nativeGetTextureId(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return RendererCommon.convertMatrixToAndroidGraphicsMatrix(nativeGetFloatTextureMatrix(this.nativeRXVideoFrame));
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        RXPixelFormat r100 = nativeGetPixelFormat(this.nativeRXVideoFrame);
        if (r100 != RXPixelFormat.kTexture2D) goto L7;
        return VideoFrame.TextureBuffer.Type.RGB;
    L7:
        if (r100 == RXPixelFormat.kTextureOES) goto L9;
        return null;
    L9:
        return VideoFrame.TextureBuffer.Type.OES;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledHeight() {
        return nativeGetUnscaledHeight(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledWidth() {
        return nativeGetUnscaledWidth(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return nativeGetWidth(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public float[] nativeGetTransFormMatrix() {
        return nativeGetFloatTextureMatrix(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return nativeToI420(this.nativeRXVideoFrame);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer, com.bytedance.realx.video.VideoFrame.Buffer
    public int getBufferType() {
        return VideoFrame.TextureBuffer.CC.$default$getBufferType(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        EGLContext r100 = getEGLContext();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getNativeHandle();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTypeGlTarget() {
        return getType().getGlTarget();
    }

    private static /* synthetic */ void lambda$new$0(long r100) {
        nativeReleaseRXVideoFrame(r100);
    }

    public RXWebRTCTextureBuffer(final long r100, boolean r101) {
        this.nativeRXVideoFrame = r100;
        this.isAgfxTexture = r101;
        this.refCountDelegate = new RefCountDelegate(new a(r100));
    }

    public VideoFrame.TextureBuffer applyTransformMatrix(Matrix r100, int r101, int r110) {
        return applyTransformMatrix(r100, r101, r110, r101, r110, FilterType.Origin);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r101, int r102, int r103) {
        if (this.isAgfxTexture == false) goto L6;
        return null;
    L6:
        Matrix r104 = new Matrix();
        int r105 = Math.min(r100, (getWidth() * r101) / getHeight());
        int r106 = Math.min(r101, (getHeight() * r100) / getWidth());
        r104.preScale(r105 / getWidth(), r106 / getHeight());
        r104.preTranslate(r102 / r100, (r101 - (r103 + r106)) / r101);
        return applyTransformMatrix(r104, r100, r101);
    }

    private VideoFrame.TextureBuffer applyTransformMatrix(Matrix r110, int r111, int r112, int r113, int r114, FilterType r115) {
        if (this.isAgfxTexture == false) goto L6;
        return null;
    L6:
        Matrix r100 = new Matrix(getTransformMatrix());
        r100.preConcat(r110);
        retain();
        RXVideoScaleFilter r101 = RXVideoScaleFilter.fromId(r115.toInt());
        float[] r102 = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r100);
        return new RXWebRTCTextureBuffer(nativeCreateTextureRXVideoFrame(this.nativeRXVideoFrame, r102, r111, r112, r113, r114, r101), false);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r110, int r111, int r112, int r113, int r114, int r115) {
        if (this.isAgfxTexture == false) goto L6;
        return null;
    L6:
        int r100 = getWidth();
        int r101 = getHeight();
        int r102 = getUnscaledWidth();
        int r103 = getUnscaledHeight();
        Matrix r104 = new Matrix();
        float r105 = r100;
        float r106 = r101 - (r111 + r113);
        float r107 = r101;
        r104.preTranslate(r110 / r105, r106 / r107);
        r104.preScale(r112 / r105, r113 / r107);
        return applyTransformMatrix(r104, Math.round((r102 * r112) / r105), Math.round((r103 * r113) / r107), r114, r115, FilterType.Origin);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.Buffer cropAndScaleWithFilter(int r110, int r111, int r112, int r113, int r114, int r115, int r116) {
        if (this.isAgfxTexture == false) goto L6;
        return null;
    L6:
        int r100 = getWidth();
        int r101 = getHeight();
        int r102 = getUnscaledWidth();
        int r103 = getUnscaledHeight();
        Matrix r104 = new Matrix();
        float r105 = r100;
        float r106 = r101 - (r111 + r113);
        float r107 = r101;
        r104.preTranslate(r110 / r105, r106 / r107);
        r104.preScale(r112 / r105, r113 / r107);
        return applyTransformMatrix(r104, Math.round((r102 * r112) / r105), Math.round((r103 * r113) / r107), r114, r115, FilterType.fromValue(r116));
    }
}

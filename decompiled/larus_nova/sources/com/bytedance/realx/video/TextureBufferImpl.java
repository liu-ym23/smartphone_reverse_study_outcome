package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import com.bytedance.realx.base.RefCountDelegate;
import com.bytedance.realx.base.ThreadUtils;

/* JADX INFO: loaded from: classes21.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    private final int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f267128id;
    private final RefCountDelegate refCountDelegate;
    private FilterType scaleFilter;
    private final Handler toI420Handler;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int unscaledHeight;
    private final int unscaledWidth;
    private final int width;
    private final YuvConverter yuvConverter;

    public static /* synthetic */ VideoFrame.I420Buffer a(TextureBufferImpl r100) {
        return r100.lambda$toI420$1();
    }

    public static /* synthetic */ EGLContext b() {
        return lambda$getEglContext$0();
    }

    public static /* synthetic */ VideoFrame.I420Buffer c(TextureBufferImpl r100) {
        return r100.lambda$toI420$2();
    }

    public static /* synthetic */ TextureBufferImpl d(TextureBufferImpl r100) {
        return r100.lambda$copyData$4();
    }

    public static /* synthetic */ void e(TextureBufferImpl r100, int r101) {
        r100.lambda$copyData$3(r101);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer, com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ int getBufferType() {
        return VideoFrame.TextureBuffer.CC.$default$getBufferType(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ VideoFrame.NV12Buffer toNV12() {
        return VideoFrame.Buffer.CC.$default$toNV12(this);
    }

    private /* synthetic */ TextureBufferImpl lambda$copyData$4() throws Exception {
        final int r100 = this.yuvConverter.dequeueTexture(this.width, this.height);
        if (r100 != 0) goto L7;
        return null;
    L7:
        if (this.type != VideoFrame.TextureBuffer.Type.OES) goto L9;
        int r101 = 11;
    L10:
        this.yuvConverter.drawTexture(r101, this.f267128id, r100, this.width, this.height);
        return new TextureBufferImpl(this.width, this.height, VideoFrame.TextureBuffer.Type.RGB, r100, this.transformMatrix, this.toI420Handler, this.yuvConverter, new b0(this, r100));
    L9:
        r101 = 10;
        goto L10
    }

    private /* synthetic */ VideoFrame.I420Buffer lambda$toI420$1() throws Exception {
        return this.yuvConverter.convert(this);
    }

    private /* synthetic */ VideoFrame.I420Buffer lambda$toI420$2() throws Exception {
        return this.yuvConverter.convert(this, this.scaleFilter, this.unscaledWidth, this.unscaledHeight);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return (VideoFrame.Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new a0(this));
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public EGLContext getEglContext() {
        Handler r100 = this.toI420Handler;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (EGLContext) ThreadUtils.invokeAtFrontUninterruptibly(r100, new c0());
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTypeGlTarget() {
        return this.type.getGlTarget();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public float[] nativeGetTransFormMatrix() {
        return RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.transformMatrix);
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
        FilterType r100 = this.scaleFilter;
        if (r100 == null) goto L10;
        if (r100 == FilterType.Origin) goto L10;
        return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new z(this));
    L10:
        return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new y(this));
    }

    private static /* synthetic */ EGLContext lambda$getEglContext$0() throws Exception {
        return EGL14.eglGetCurrentContext();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        EGLContext r100 = getEglContext();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getNativeHandle();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public FilterType getScaleFilter() {
        return this.scaleFilter;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.f267128id;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledHeight() {
        return this.unscaledHeight;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledWidth() {
        return this.unscaledWidth;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    private /* synthetic */ void lambda$copyData$3(int r100) {
        this.yuvConverter.queueTexture(r100);
    }

    public TextureBufferImpl applyTransformMatrix(Matrix r100, int r101, int r102) {
        return applyTransformMatrix(r100, r101, r102, r101, r102);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r101, int r102, int r103) {
        Matrix r104 = new Matrix();
        int r105 = Math.min(r100, (getWidth() * r101) / getHeight());
        int r106 = Math.min(r101, (getHeight() * r100) / getWidth());
        r104.preScale(r105 / getWidth(), r106 / getHeight());
        r104.preTranslate(r102 / r100, (r101 - (r103 + r106)) / r101);
        return applyTransformMatrix(r104, r100, r101);
    }

    private TextureBufferImpl applyTransformMatrix(Matrix r110, int r111, int r112, int r113, int r114) {
        Matrix r100 = new Matrix(this.transformMatrix);
        r100.preConcat(r110);
        retain();
        return new TextureBufferImpl(r111, r112, r113, r114, this.type, this.f267128id, this.scaleFilter, r100, this.toI420Handler, this.yuvConverter, new d0(this));
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r100, int r101, int r102, int r110, int r111, int r112) {
        Matrix r103 = new Matrix();
        int r104 = this.height;
        r103.preTranslate(r100 / this.width, (r104 - (r101 + r110)) / r104);
        r103.preScale(r102 / this.width, r110 / this.height);
        this.scaleFilter = FilterType.Origin;
        return applyTransformMatrix(r103, Math.round((this.unscaledWidth * r102) / this.width), Math.round((this.unscaledHeight * r110) / this.height), r111, r112);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.Buffer cropAndScaleWithFilter(int r100, int r101, int r102, int r110, int r111, int r112, int r113) {
        Matrix r103 = new Matrix();
        int r104 = this.height;
        r103.preTranslate(r100 / this.width, (r104 - (r101 + r110)) / r104);
        r103.preScale(r102 / this.width, r110 / this.height);
        this.scaleFilter = FilterType.fromValue(r113);
        return applyTransformMatrix(r103, Math.round((this.unscaledWidth * r102) / this.width), Math.round((this.unscaledHeight * r110) / this.height), r111, r112);
    }

    public TextureBufferImpl(int r100, int r101, VideoFrame.TextureBuffer.Type r102, int r103, Matrix r104, Handler r105, YuvConverter r106, Runnable r107) {
        this.unscaledWidth = r100;
        this.unscaledHeight = r101;
        this.width = r100;
        this.height = r101;
        this.type = r102;
        this.f267128id = r103;
        this.transformMatrix = r104;
        this.toI420Handler = r105;
        this.yuvConverter = r106;
        this.refCountDelegate = new RefCountDelegate(r107);
    }

    private TextureBufferImpl(int r100, int r101, int r102, int r103, VideoFrame.TextureBuffer.Type r104, int r105, FilterType r106, Matrix r107, Handler r108, YuvConverter r110, Runnable r111) {
        this.unscaledWidth = r100;
        this.unscaledHeight = r101;
        this.width = r102;
        this.height = r103;
        this.type = r104;
        this.f267128id = r105;
        this.scaleFilter = r106;
        this.transformMatrix = r107;
        this.toI420Handler = r108;
        this.yuvConverter = r110;
        this.refCountDelegate = new RefCountDelegate(r111);
    }
}

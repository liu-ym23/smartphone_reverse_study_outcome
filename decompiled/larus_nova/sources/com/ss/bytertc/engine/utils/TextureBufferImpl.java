package com.ss.bytertc.engine.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.opengl.EGLContext;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.bytertc.engine.video.ITextureBuffer;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer, EglContextCarrier, ITextureBuffer {
    private final int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f456227id;
    private EglBase.Context mEglBaseContext;
    private int refCount;
    private final Object refCountLock;
    private final Runnable releaseCallback;
    private FilterType scaleFilter;
    private final TextureHelper textureHelper;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int width;
    private YuvImage yuvImage;

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer, com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ int getBufferType() {
        return VideoFrame.TextureBuffer.CC.$default$getBufferType(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ VideoFrame.NV12Buffer toNV12() {
        return VideoFrame.Buffer.CC.$default$toNV12(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        final int r100 = this.textureHelper.dequeueTexture();
        if (r100 != 0) goto L5;
        return null;
    L5:
        VideoFrame.TextureBuffer.Type r101 = this.type;
        if (r101 != VideoFrame.TextureBuffer.Type.RGB) goto L9;
        int r102 = 10;
    L11:
        this.textureHelper.drawTexture(r102, this.f456227id, r100);
        return new TextureBufferImpl(this.width, this.height, this.type, this.f456227id, this.transformMatrix, this.textureHelper, new AnonymousClass2(this, r100));
    L9:
        if (r101 != VideoFrame.TextureBuffer.Type.OES) goto L13;
        r102 = 11;
        goto L11
    L13:
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public EGLContext getEglContext() {
        TextureHelper r100 = this.textureHelper;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getEglBaseContext().getEgl14Context();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        TextureHelper r100 = this.textureHelper;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getNativeEglContext();
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
        Object r100 = this.refCountLock;
        monitor-enter(r100);
        int r101 = this.refCount - 1;     // Catch: Throwable -> L11
        this.refCount = r101;     // Catch: Throwable -> L11
        if (r101 != 0) goto L9;
        Runnable r102 = this.releaseCallback;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r102.run();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        Object r100 = this.refCountLock;
        monitor-enter(r100);
        this.refCount++;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return this.textureHelper.textureToYuv(this);
    }

    @Override // com.ss.bytertc.engine.utils.EglContextCarrier
    public EglBase.Context getEglBaseContext() {
        return this.mEglBaseContext;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public FilterType getScaleFilter() {
        return FilterType.Origin;
    }

    public TextureHelper getTextureHelper() {
        return this.textureHelper;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.f456227id;
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
        return this.height;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledWidth() {
        return this.width;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    public static /* synthetic */ TextureHelper access$000(TextureBufferImpl r100) {
        return r100.textureHelper;
    }

    @Override // com.ss.bytertc.engine.utils.EglContextCarrier
    public void setEglBaseContext(EglBase.Context r100) {
        this.mEglBaseContext = r100;
    }

    public void setTransFormMatrix(float[] r100) {
        RendererCommon.convertMatrixToAndroidGraphicsMatrix(r100);
    }

    public void saveMyBitmap(String r100, byte[] r101, int r102, int r110) {
        LogUtil.i("texturebuffer", "saveMyBitmap");
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);
        r103.createNewFile();     // Catch: IOException -> L19
    L27:
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r103);     // Catch: FileNotFoundException -> L6
    L8:
        YuvImage r105 = new YuvImage(r101, 17, this.width, this.height, null);
        r105.compressToJpeg(new Rect(0, 0, this.width, this.height), 50, r104);     // Catch: Exception -> L20
    L29:
        r104.flush();     // Catch: IOException -> L12
    L21:
        r104.close();     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    L6:
        e = move-exception;
        e.printStackTrace();
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r110, int r111, int r112) {
        Matrix r101 = new Matrix();
        int r102 = Math.min(r100, (getWidth() * r110) / getHeight());
        int r103 = Math.min(r110, (getHeight() * r100) / getWidth());
        r101.preScale(r102 / getWidth(), r103 / getHeight());
        r101.preTranslate(r111 / r100, (r110 - (r112 + r103)) / r110);
        return new TextureBufferImpl(r100, r110, this.type, this.f456227id, r101, this.textureHelper, new AnonymousClass5(this));
    }

    public TextureBufferImpl(int r100, int r101, int r102, final int r103, final TextureHelper r104) {
        this.refCountLock = new Object();
        this.width = r100;
        this.height = r101;
        VideoFrame.TextureBuffer.Type r105 = VideoFrame.TextureBuffer.Type.OES;
        if (r102 != r105.getGlTarget()) goto L5;
        this.type = r105;
    L6:
        this.f456227id = r103;
        Matrix r106 = new Matrix();
        this.transformMatrix = r106;
        r106.reset();
        this.textureHelper = r104;
        this.releaseCallback = new AnonymousClass1(this, r104, r103);
        this.refCount = 1;
        return;
    L5:
        this.type = VideoFrame.TextureBuffer.Type.RGB;
        goto L6
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r110, int r111, int r112, int r113, int r114, int r115) {
        retain();
        Matrix r100 = new Matrix();
        int r101 = this.height;
        r100.preTranslate(r110 / this.width, (r101 - (r111 + r113)) / r101);
        r100.preScale(r112 / this.width, r113 / this.height);
        this.scaleFilter = null;
        Matrix r102 = new Matrix(this.transformMatrix);
        r102.preConcat(r100);
        return new TextureBufferImpl(r114, r115, this.type, this.f456227id, r102, this.textureHelper, new AnonymousClass3(this));
    }

    public TextureBufferImpl(int r100, int r101, VideoFrame.TextureBuffer.Type r102, int r103, Matrix r104, TextureHelper r105, Runnable r106) {
        this.refCountLock = new Object();
        this.width = r100;
        this.height = r101;
        this.type = r102;
        this.f456227id = r103;
        this.transformMatrix = r104;
        this.textureHelper = r105;
        this.releaseCallback = r106;
        this.refCount = 1;
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.Buffer cropAndScaleWithFilter(int r110, int r111, int r112, int r113, int r114, int r115, int r116) {
        Matrix r100 = new Matrix();
        int r101 = this.height;
        r100.preTranslate(r110 / this.width, (r101 - (r111 + r113)) / r101);
        r100.preScale(r112 / this.width, r113 / this.height);
        this.scaleFilter = FilterType.fromValue(r116);
        Matrix r102 = new Matrix(this.transformMatrix);
        r102.preConcat(r100);
        return new TextureBufferImpl(r114, r115, this.type, this.f456227id, r102, this.textureHelper, new AnonymousClass4(this));
    }
}

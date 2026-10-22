package com.ss.bytertc.engine.video;

import android.graphics.Matrix;
import android.opengl.EGLContext;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public class WebrtcTextureBufferWrapper implements ITextureBuffer, VideoFrame.TextureBuffer {
    TextureBufferImpl webrtcTextureBuffer;

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
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.copyData();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public EGLContext getEglContext() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getEglContext();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getHeight();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getNativeEglContext();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer, com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTextureId() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getTextureId();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return new Matrix();
    L7:
        return r100.getTransformMatrix();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return VideoFrame.TextureBuffer.Type.OES;
    L7:
        return r100.getType();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer, com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getTypeGlTarget() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getType().getGlTarget();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledHeight() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getUnscaledHeight();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public int getUnscaledWidth() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getUnscaledWidth();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWidth();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer, com.bytedance.realx.video.VideoFrame.TextureBuffer
    public float[] nativeGetTransFormMatrix() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return new float[]{0.0f};
    L7:
        return RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r100.getTransformMatrix());
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer, com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.release();
    }

    @Override // com.ss.bytertc.engine.video.ITextureBuffer, com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.retain();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        TextureBufferImpl r100 = this.webrtcTextureBuffer;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toI420();
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public FilterType getScaleFilter() {
        return FilterType.Origin;
    }

    public WebrtcTextureBufferWrapper(TextureBufferImpl r100) {
        this.webrtcTextureBuffer = r100;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r101, int r102, int r103) {
        TextureBufferImpl r104 = this.webrtcTextureBuffer;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.scaleAndFill(r100, r101, r102, r103);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r100, int r101, int r110, int r111, int r112, int r113) {
        TextureBufferImpl r102 = this.webrtcTextureBuffer;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.cropAndScale(r100, r101, r110, r111, r112, r113);
    }

    @Override // com.bytedance.realx.video.VideoFrame.TextureBuffer
    public VideoFrame.Buffer cropAndScaleWithFilter(int r100, int r101, int r110, int r111, int r112, int r113, int r114) {
        TextureBufferImpl r102 = this.webrtcTextureBuffer;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.cropAndScale(r100, r101, r110, r111, r112, r113);
    }
}

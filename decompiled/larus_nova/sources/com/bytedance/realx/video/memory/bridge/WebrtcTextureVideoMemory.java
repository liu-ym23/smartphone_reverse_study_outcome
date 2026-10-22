package com.bytedance.realx.video.memory.bridge;

import android.opengl.EGLContext;
import com.bytedance.realx.video.FilterType;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;
import com.bytedance.realx.video.RXVideoScaleFilter;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.memory.RXVideoTextureMemory;

/* JADX INFO: loaded from: classes21.dex */
public class WebrtcTextureVideoMemory extends RXVideoTextureMemory {
    EGLContext eglContext;
    RXVideoRotation rotation;
    private VideoFrame.TextureBuffer textureBuffer;

    public static /* synthetic */ void b(WebrtcTextureVideoMemory r100) {
        r100.lambda$new$0();
    }

    private /* synthetic */ void lambda$new$0() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public int getHeight() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getHeight();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public long getNativeEGLContext() {
        EGLContext r100 = this.eglContext;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getNativeHandle();
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public RXVideoRotation getRotation() {
        if (this.textureBuffer != null) goto L7;
        return RXVideoRotation.VIDEO_ROTATION_0;
    L7:
        return this.rotation;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public RXVideoScaleFilter getScaleFilter() {
        FilterType r100 = this.textureBuffer.getScaleFilter();
        if (r100 != null) goto L7;
        return RXVideoScaleFilter.kOpenGLOrigin;
    L7:
        return RXVideoScaleFilter.fromId(r100.toInt());
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getTextureId() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getTextureId();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public float[] getTextureMatrix() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 != null) goto L7;
        float[] r101 = new float[16];
        r101[0] = 1.0f;
        r101[5] = 1.0f;
        r101[10] = 1.0f;
        r101[15] = 1.0f;
        return r101;
    L7:
        return r100.nativeGetTransFormMatrix();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public RXPixelFormat getTextureTarget() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 != null) goto L7;
        return null;
    L7:
        return RXPixelFormat.fromId(r100.getTypeGlTarget());
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getUnScaledHeight() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getUnscaledHeight();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getUnScaledWidth() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getUnscaledWidth();
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public int getWidth() {
        VideoFrame.TextureBuffer r100 = this.textureBuffer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWidth();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public EGLContext getEGLContext() {
        return this.eglContext;
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public RXVideoMemoryType getMemoryType() {
        return RXVideoMemoryType.kOPENGL_TEXTURE;
    }

    public WebrtcTextureVideoMemory(VideoFrame.TextureBuffer r100, EGLContext r101, RXVideoRotation r102) {
        this.textureBuffer = r100;
        this.eglContext = r101;
        this.rotation = r102;
        if (r100 == null) goto L5;
        r100.retain();
    L5:
        setReleaseCallback(new b(this));
    }
}

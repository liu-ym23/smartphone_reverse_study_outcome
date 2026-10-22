package com.ss.texturerender.effect;

import android.opengl.GLES20;
import com.ss.texturerender.TexGLUtils;

/* JADX INFO: loaded from: classes40.dex */
public class FrameBufferOES extends FrameBuffer {
    @Override // com.ss.texturerender.effect.FrameBuffer
    public void release() {
        int r100 = this.mFboID;
        if (r100 <= 0) goto L6;
        TexGLUtils.deleteFbo(r100);
        return;
    }

    public FrameBufferOES() {
        this.mFboID = TexGLUtils.createFbo();
        this.mFrameBufferTarget = 36160;
    }

    @Override // com.ss.texturerender.effect.FrameBuffer
    public void bind() {
        GLES20.glBindFramebuffer(36160, this.mFboID);
    }

    @Override // com.ss.texturerender.effect.FrameBuffer
    public void unBind() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    @Override // com.ss.texturerender.effect.FrameBuffer
    public void unbindTexture() {
        GLES20.glFramebufferTexture2D(36160, 36064, 36197, 0, 0);
        unBind();
    }

    @Override // com.ss.texturerender.effect.FrameBuffer
    public int bindTexture(int r100) {
        bind();
        GLES20.glFramebufferTexture2D(36160, 36064, 36197, r100, 0);
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) goto L6;
        return -1;
    L6:
        return 0;
    }
}

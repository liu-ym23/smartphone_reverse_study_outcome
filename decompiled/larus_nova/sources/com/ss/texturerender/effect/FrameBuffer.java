package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.ss.texturerender.TexGLUtils;

/* JADX INFO: loaded from: classes40.dex */
public class FrameBuffer {
    public static int[] GL_COLOR_ATTACHMENTS;
    protected int mFboID;
    public int mFrameBufferTarget;

    static {
        GL_COLOR_ATTACHMENTS = new int[]{36064, 36065};
    }

    public void release() {
        TexGLUtils.deleteFbo(this.mFboID);
    }

    public void unbindTexture2D() {
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
        unBind();
    }

    public FrameBuffer() {
        this.mFboID = TexGLUtils.createFbo();
        this.mFrameBufferTarget = 36160;
    }

    public void bind() {
        GLES20.glBindFramebuffer(36160, this.mFboID);
    }

    public void unBind() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    public int getFboId() {
        return this.mFboID;
    }

    public void unbindTexture() {
        unbindTexture2D();
    }

    public int bindTexture(int r100) {
        return bindTexture2D(r100);
    }

    public int bindTexture2D(int r100) {
        bind();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r100, 0);
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) goto L6;
        return -1;
    L6:
        return 0;
    }

    public void unbindTexture2Ds(int[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        GLES20.glFramebufferTexture2D(36160, r100[r101], 3553, 0, 0);
        r101 = r101 + 1;
        goto L4
    L6:
        unBind();
    }

    public int bindTexture2Ds(int[] r100, int[] r101) {
        bind();
        int r102 = r100.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L6;
        GLES20.glFramebufferTexture2D(36160, r101[r103], 3553, r100[r103], 0);
        r103 = r103 + 1;
        goto L4
    L6:
        GLES30.glDrawBuffers(r102, r101, 0);
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) goto L10;
        return -1;
    L10:
        return 0;
    }
}

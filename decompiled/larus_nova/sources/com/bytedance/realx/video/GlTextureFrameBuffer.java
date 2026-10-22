package com.bytedance.realx.video;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes21.dex */
public class GlTextureFrameBuffer {
    private int frameBufferId;
    private int height;
    private final int pixelFormat;
    private int textureId;
    private int width;

    public void release() {
        GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
        this.textureId = 0;
        GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
        this.frameBufferId = 0;
        this.width = 0;
        this.height = 0;
    }

    public int getFrameBufferId() {
        return this.frameBufferId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTextureId() {
        return this.textureId;
    }

    public int getWidth() {
        return this.width;
    }

    public GlTextureFrameBuffer(int r100) {
        switch(r100) {
            case 6407: goto L6;
            case 6408: goto L6;
            case 6409: goto L6;
            default: goto L5;
        };
    L6:
        this.pixelFormat = r100;
        this.width = 0;
        this.height = 0;
        return;
    L5:
        throw new IllegalArgumentException("Invalid pixel format: " + r100);
    }

    public void setSize(int r110, int r111) {
        if (r110 <= 0) goto L22;
        if (r111 <= 0) goto L22;
        if (r110 == this.width) goto L7;
    L9:
        this.width = r110;
        this.height = r111;
        if (this.textureId != 0) goto L13;
        this.textureId = GlUtil.generateTexture(3553);
    L13:
        if (this.frameBufferId != 0) goto L15;
        int[] r100 = new int[1];
        GLES20.glGenFramebuffers(1, r100, 0);
        this.frameBufferId = r100[0];
    L15:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.textureId);
        int r101 = this.pixelFormat;
        GLES20.glTexImage2D(3553, 0, r101, r110, r111, 0, r101, 5121, null);
        GLES20.glBindTexture(3553, 0);
        GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureId, 0);
        int r112 = GLES20.glCheckFramebufferStatus(36160);
        if (r112 != 36053) goto L20;
        GLES20.glBindFramebuffer(36160, 0);
        return;
    L20:
        throw new IllegalStateException("Framebuffer not complete, status: " + r112);
    L7:
        if (r111 != this.height) goto L9;
        return;
    L22:
        throw new IllegalArgumentException("Invalid size: " + r110 + "x" + r111);
    }
}

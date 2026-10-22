package com.ss.texturerender.effect;

import android.opengl.GLES30;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public class GLBlitOESFliter extends GLBlitFilter {
    public GLBlitOESFliter(int r100) {
        super(r100, 26);
        this.mInTextureTarget = 36197;
        this.mOrder = -1;
        this.mFrameBufferTarget = 36160;
    }

    @Override // com.ss.texturerender.effect.GLBlitFilter
    public void glblitAfter(FrameBuffer r100) {
        GLES30.glBindFramebuffer(36008, 0);
        GLES30.glBindFramebuffer(36009, 0);
        this.mReadFrameBuffer.bind();
        this.mReadFrameBuffer.unbindTexture();
        if (r100 == null) goto L6;
        r100.bind();
        r100.unbindTexture();
        return;
    }

    @Override // com.ss.texturerender.effect.GLBlitFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L8;
        if (r101.getIntOption(126, this.mEffectType) != (-1)) goto L8;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
    L8:
        if (this.mReadFrameBuffer != null) goto L10;
        this.mReadFrameBuffer = new FrameBufferOES();
    L10:
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLBlitFilter
    public int glBlitProcess(FrameBuffer r110, EffectTexture r111) {
        GLES30.glBindFramebuffer(36008, this.mReadFrameBuffer.getFboId());
        if (r110 == null) goto L5;
        GLES30.glBindFramebuffer(36009, r110.getFboId());
    L6:
        int r100 = this.mSrcx0;
        int r101 = this.mSrcy1;
        int r102 = this.mSrcx1;
        int r103 = this.mSrcy0;
        int r104 = this.mViewPortX;
        int r105 = this.mViewPortY;
        GLES30.glBlitFramebuffer(r100, r101, r102, r103, r104, r105, r104 + this.mViewPortWidth, r105 + this.mViewPortHeight, 16384, 9729);
        if (this.mProcessSuccess == 0) goto L9;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "gl oes blit success");
        this.mProcessSuccess = 0;
    L9:
        return 0;
    L5:
        GLES30.glBindFramebuffer(36009, 0);
        goto L6
    }
}

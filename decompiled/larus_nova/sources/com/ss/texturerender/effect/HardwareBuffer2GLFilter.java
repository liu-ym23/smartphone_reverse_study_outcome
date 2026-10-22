package com.ss.texturerender.effect;

import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.base.EGLExt;

/* JADX INFO: loaded from: classes40.dex */
public class HardwareBuffer2GLFilter extends AbsEffect {
    private EGLDisplay mDisplay;
    private EffectTexture mEffectTexture;
    private int mTexID;

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        TexGLUtils.deleteTexture(this.mTexID);
        this.mTexID = 0;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        return super.release();
    }

    public HardwareBuffer2GLFilter(int r100, EGLDisplay r101) {
        super(r100, 23);
        this.mDisplay = r101;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r110, FrameBuffer r111) {
        if (r110 != null) goto L4;
        return r110;
    L4:
        if (r110.getSourceType() != 1) goto L7;
        return r110;
    L7:
        if (this.mTexID != 0) goto L11;
        int[] r112 = new int[1];
        GLES20.glGenTextures(1, r112, 0);
        int r113 = r112[0];
        this.mTexID = r113;
        if (r113 != 0) goto L11;
        return r110;
    L11:
        int r114 = EGLExt.bindHardwareBufferToTexture(this.mDisplay, r110.getHardwareBuffer(), this.mTexID, 36197);
        if (r114 == 0) goto L15;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "bindHardwareBufferToTexture fail,ret:" + r114);
        return r110;
    L15:
        EffectTexture r115 = this.mEffectTexture;
        if (r115 != null) goto L18;
    L23:
        this.mEffectTexture = new EffectTexture(null, this.mTexID, r110.getWidth(), r110.getHeight(), 36197, r110.getInternalFormat(), r110.getFormat(), r110.getType(), null);
    L25:
        return this.mEffectTexture;
    L18:
        if (r115.getWidth() != r110.getWidth()) goto L23;
        if (this.mEffectTexture.getHeight() != r110.getHeight()) goto L23;
        if (this.mEffectTexture.getTexTarget() == 36197) goto L25;
        goto L23
    }
}

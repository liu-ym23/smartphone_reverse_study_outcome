package com.ss.texturerender.effect;

import android.os.Bundle;
import android.util.SparseArray;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.base.EGLExt;

/* JADX INFO: loaded from: classes40.dex */
public class HardwareBufferEglPoolFilter extends AbsEffect {
    private static final int HARDWARE_EGL_POOL_SIZE = 30;
    private SparseArray<EffectTexture> mEffectTextures;
    private long mHardwareBufferEglPoolPtr;
    private float[] mRect;

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        long r100 = this.mHardwareBufferEglPoolPtr;
        if (r100 == 0) goto L5;
        EGLExt.destroyHardwareBufferEglPool(r100);
    L5:
        this.mEffectTextures.clear();
        return super.release();
    }

    public HardwareBufferEglPoolFilter(int r100) {
        super(r100, 24);
        this.mEffectTextures = new SparseArray();
        this.mRect = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        this.mHardwareBufferEglPoolPtr = 0;
    }

    private boolean rectChanged(EffectTexture r100) {
        Bundle r101 = r100.getRect();
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r101.getFloat("x") == this.mRect[0]) goto L8;
        return true;
    L8:
        if (r101.getFloat("y") == this.mRect[1]) goto L10;
        return true;
    L10:
        if (r101.getFloat("width") == this.mRect[2]) goto L12;
        return true;
    L12:
        if (r101.getFloat("height") != this.mRect[3]) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r210, FrameBuffer r211) {
        if (r210 != null) goto L5;
    L40:
        return r210;
    L5:
        if (r210.getSourceType() != 3) goto L40;
        if (this.mHardwareBufferEglPoolPtr != 0) goto L11;
        this.mHardwareBufferEglPoolPtr = EGLExt.createHardwareBufferEglPool(30);
    L11:
        if (r210.getHardwareBuffer() != null) goto L13;
    L39:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "getOrCreateTextureByHardwareBuffer fail, invalid HardwareBuffer");
        goto L40
    L13:
        if (r210.getHardwareBuffer().isClosed() == true) goto L39;
        int r100 = EGLExt.getOrCreateTextureByHardwareBuffer(this.mHardwareBufferEglPoolPtr, r210.getHardwareBuffer(), r210.getWidth(), r210.getHeight(), 36197);
        if (r100 > 0) goto L21;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "getOrCreateTextureByHardwareBuffer fail,ret:" + r100);
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L20;
        r101.getEventLogger().setHardwareBufferProcessError(TexGLUtils.checkGLError(this.mTexType, "HardwareBuffer process failed"));
    L20:
        return r210;
    L21:
        int r102 = r210.getWidth();
        int r103 = r210.getHeight();
        int[] r104 = this.mSurfaceTexture.getRect();
        if (r104 != null) goto L24;
    L26:
        int r105 = r102;
        int r106 = 0;
        int r107 = 0;
    L27:
        int r110 = r210.getWidth();
        int r111 = r210.getHeight();
        float[] r112 = this.mRect;
        float r113 = r110;
        r112[0] = (r106 * 1.0f) / r113;
        float r108 = ((r111 - r103) - r107) * 1.0f;
        float r109 = r111;
        r112[1] = r108 / r109;
        r112[2] = (r105 * 1.0f) / r113;
        r112[3] = (r103 * 1.0f) / r109;
        EffectTexture r114 = this.mEffectTextures.get(r100);
        if (r114 != null) goto L30;
    L37:
        Bundle r115 = new Bundle();
        r115.putFloat("x", this.mRect[0]);
        r115.putFloat("y", this.mRect[1]);
        r115.putFloat("width", this.mRect[2]);
        r115.putFloat("height", this.mRect[3]);
        EffectTexture r116 = new EffectTexture(null, r100, r210.getWidth(), r210.getHeight(), 36197, r210.getInternalFormat(), r210.getFormat(), r210.getType(), r115);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create effectTexture:" + r116 + " rect:" + r115);
        this.mEffectTextures.put(r100, r116);
        return r116;
    L30:
        if (r114.getWidth() != r210.getWidth()) goto L37;
        if (r114.getHeight() != r210.getHeight()) goto L37;
        if (r114.getTexTarget() != 36197) goto L37;
        if (rectChanged(r114) == true) goto L37;
        return r114;
    L24:
        if (r104.length != 4) goto L26;
        r106 = r104[0];
        int r117 = r104[1];
        r105 = r104[2];
        int r118 = r104[3];
        r107 = r117;
        r103 = r118;
        goto L27
    }
}

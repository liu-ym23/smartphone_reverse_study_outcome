package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Bundle;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes40.dex */
public class EffectTextureManager {
    private final String LOG_TAG;
    private int mMaxSize;
    private int mTexType;
    private LinkedList<EffectTexture> mTextureList;
    private boolean useGLForsr;

    public void release() {
    L3:
        if (this.mTextureList.isEmpty() == true) goto L5;
        EffectTexture r100 = this.mTextureList.poll();
        TexGLUtils.deleteTexture(r100.getTexID());
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release delTex:" + r100);
        goto L3
    }

    public String toString() {
        return this.LOG_TAG;
    }

    public EffectTextureManager(int r100) {
        this.useGLForsr = false;
        this.mTexType = -1;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTextureList = new LinkedList();
        this.mMaxSize = 4;
        if (DeviceManager.isVRDevice() == false) goto L5;
        this.useGLForsr = true;
    L5:
        this.mTexType = r100;
    }

    public void onTextureReturn(EffectTexture r100) {
        Iterator<EffectTexture> r101 = this.mTextureList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r100.isEqualTo(r101.next()) == false) goto L4;
        return;
    L8:
        this.mTextureList.offer(r100);
    L10:
        if (this.mTextureList.size() <= this.mMaxSize) goto L12;
        EffectTexture r102 = this.mTextureList.poll();
        TexGLUtils.deleteTexture(r102.getTexID());
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "onTextureReturn delTex:" + r102);
        goto L10
    }

    public EffectTexture genTexture(int r100, int r101, Bundle r110) {
        return genTexture(r100, r101, 6408, 6408, 5121, r110);
    }

    public EffectTexture genTexture(int r100, int r110, int r111, Bundle r112) {
        if (r111 < 10) goto L7;
        return genTexture(r100, r110, 32857, 6408, 33640, r112);
    L7:
        return genTexture(r100, r110, r112);
    }

    public EffectTexture genTexture(int r110, int r111, int r210, int r211, int r212, Bundle r213) {
        Iterator<EffectTexture> r100 = this.mTextureList.iterator();
        EffectTexture r101 = null;
    L4:
        if (r100.hasNext() == false) goto L21;
        r101 = r100.next();
        if (r110 != r101.getWidth()) goto L4;
        if (r111 != r101.getHeight()) goto L4;
        if (r210 != r101.getInternalFormat()) goto L4;
        if (r211 != r101.getFormat()) goto L4;
        if (r212 != r101.getType()) goto L4;
        r100.remove();
        return r101;
    L21:
        if (this.useGLForsr == true) goto L24;
        r101 = this.mTextureList.poll();
    L24:
        if (r101 != null) goto L26;
    L29:
        int r102 = TexGLUtils.genTexture(3553);
    L30:
        int r112 = r102;
        GLES20.glBindTexture(3553, r112);
        if (this.useGLForsr == false) goto L33;
        GLES30.glTexStorage2D(3553, 1, 32856, r110, r111);
    L34:
        EffectTexture r113 = new EffectTexture(this, r112, r110, r111, 3553, r210, r211, r212, r213);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "genTexture:" + r113.toString());
        return r113;
    L33:
        GLES20.glTexImage2D(3553, 0, r210, r110, r111, 0, r211, r212, null);
        goto L34
    L26:
        if (this.useGLForsr == true) goto L29;
        r102 = r101.getTexID();
        goto L30
    }
}

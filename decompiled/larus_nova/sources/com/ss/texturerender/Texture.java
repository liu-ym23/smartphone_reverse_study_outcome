package com.ss.texturerender;

import android.opengl.GLES20;
import android.util.AndroidRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class Texture implements ITexture {
    private final String TAG;
    private int mForbidTextureReuse;
    private ReentrantLock mLock;
    private IRef mRef;
    private int mTexTarget;
    private int mTexType;
    private int mTextureId;
    private OnTextureReturnListener mTextureReturnListener;

    public interface OnTextureReturnListener {
        void onTextureReturn(ITexture r100);
    }

    @Override // com.ss.texturerender.IRef
    public int addRef() {
        int r100 = this.mRef.addRef();
        TextureRenderLog.i(this.mTexType, this.TAG, "add ref " + r100);
        return r100;
    }

    @Override // com.ss.texturerender.IRef
    public int decRef() {
        int r100 = this.mRef.decRef();
        TextureRenderLog.i(this.mTexType, this.TAG, "dec ref " + r100);
        if (r100 != 1) goto L5;
        this.mTextureReturnListener.onTextureReturn(this);
        return 0;
    L5:
        if (r100 < 1) goto L9;
        return 0;
    L9:
        throw new RuntimeException(new Exception("reference idx " + (r100 - 1) + " app abort!!"));
    }

    @Override // com.ss.texturerender.ITexture
    public int lock() {
        if (this.mLock.isHeldByCurrentThread() == true) goto L7;
        this.mLock.lock();
        return this.mTextureId;
    L7:
        throw new AndroidRuntimeException("Dead lock!!");
    }

    @Override // com.ss.texturerender.IRef
    public int refCnt() {
        return this.mRef.refCnt();
    }

    public void release() {
        TextureRenderLog.i(this.mTexType, this.TAG, "release = " + this.mTextureId);
        lock();
        GLES20.glDeleteTextures(1, new int[]{this.mTextureId}, 0);
        unlock();
        TextureRenderLog.i(this.mTexType, this.TAG, "release end = " + this.mTextureId);
    }

    @Override // com.ss.texturerender.ITexture
    public void unlock() {
        this.mLock.unlock();
    }

    public int getForbidTextureReuse() {
        return this.mForbidTextureReuse;
    }

    @Override // com.ss.texturerender.ITexture
    public int getTexTarget() {
        return this.mTexTarget;
    }

    public String toString() {
        return this.TAG;
    }

    public void setForbidTextureReuse(int r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "setForbidTextureReuse: " + r100);
        this.mForbidTextureReuse = r100;
    }

    @Override // com.ss.texturerender.ITexture
    public int tryLock(int r100) {
        if (this.mLock.tryLock(r100, TimeUnit.MILLISECONDS) == false) goto L11;
        return this.mTextureId;
    L11:
        return -1;
    L12:
        return -1;
    }

    public Texture(int r100, int r101, OnTextureReturnListener r102, int r103) {
        this.mForbidTextureReuse = 0;
        this.mTexType = -1;
        String r104 = TextureRenderLog.getLogTag(this);
        this.TAG = r104;
        this.mTexType = r103;
        TextureRenderLog.i(r103, r104, "new texture = " + r100);
        this.mTextureId = r100;
        this.mTextureReturnListener = r102;
        this.mRef = new Ref();
        this.mLock = new ReentrantLock();
        this.mTexTarget = r101;
    }
}

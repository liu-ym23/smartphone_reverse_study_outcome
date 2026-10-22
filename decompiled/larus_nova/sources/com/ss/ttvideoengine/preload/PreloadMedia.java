package com.ss.ttvideoengine.preload;

import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public class PreloadMedia {
    protected String mCacheKey;
    private IPreLoaderItemCallBackListener mCallBackListener;
    protected long mContentLength;
    protected long mDuration;
    protected float mPreloadSecond;
    protected long mPreloadSize;
    public String mSceneId;
    protected String mVideoId;

    public int hashCode() {
        return Objects.hash(new Object[]{this.mCacheKey, this.mVideoId, this.mCallBackListener});
    }

    public PreloadMedia() {
        this.mCacheKey = null;
        this.mVideoId = null;
        this.mPreloadSize = 0;
        this.mContentLength = 0;
        this.mDuration = 0;
        this.mPreloadSecond = 0.0f;
        this.mSceneId = null;
        this.mCallBackListener = null;
    }

    public String getCacheKey() {
        return this.mCacheKey;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.mCallBackListener;
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public float getPreloadSecond() {
        return this.mPreloadSecond;
    }

    public long getPreloadSize() {
        return this.mPreloadSize;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public boolean equals(Object r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (super.equals(r100) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof PreloadMedia) == true) goto L11;
        return false;
    L11:
        PreloadMedia r102 = (PreloadMedia) r100;
        if (this.mPreloadSize != r102.mPreloadSize) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
    L19:
        boolean r104 = false;
    L20:
        IPreLoaderItemCallBackListener r105 = this.mCallBackListener;
        if (r105 == null) goto L23;
    L24:
        if (r105 != null) goto L26;
    L27:
        r104 = false;
    L28:
        if (r104 == false) goto L36;
        if (r104 == false) goto L34;
        if (r105 != r102.mCallBackListener) goto L34;
        r101 = true;
    L34:
        return r101;
    L36:
        return r104;
    L26:
        if (r102.mCallBackListener != null) goto L28;
    L23:
        if (r102.mCallBackListener != null) goto L24;
        return r104;
    L17:
        if (this.mCacheKey.equals(r102.mCacheKey) == false) goto L19;
        r104 = true;
        goto L20
    L14:
        r103 = false;
        goto L15
    }

    public void setCacheKey(String r100) {
        this.mCacheKey = r100;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener r100) {
        this.mCallBackListener = r100;
    }

    public void setContentLength(long r100) {
        this.mContentLength = r100;
    }

    public void setDuration(long r100) {
        this.mDuration = r100;
    }

    public void setPreloadSize(long r100) {
        this.mPreloadSize = r100;
    }

    public void setVideoId(String r100) {
        this.mVideoId = r100;
    }
}

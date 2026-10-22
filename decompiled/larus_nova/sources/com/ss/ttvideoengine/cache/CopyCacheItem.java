package com.ss.ttvideoengine.cache;

/* JADX INFO: loaded from: classes34.dex */
public class CopyCacheItem {
    public String mCustomDir;
    public String mDestPath;
    public String mFileKey;
    public boolean mForceCopyUnfinished;
    public final CopyCacheListener mListener;
    public boolean mWaitIfCaching;

    public CopyCacheItem(String r100, String r101, CopyCacheListener r102) {
        this.mFileKey = r100;
        this.mDestPath = r101;
        this.mListener = r102;
        this.mCustomDir = null;
        this.mWaitIfCaching = false;
        this.mForceCopyUnfinished = false;
    }

    public CopyCacheItem(String r100, String r101, boolean r102, CopyCacheListener r103) {
        this.mFileKey = r100;
        this.mDestPath = r101;
        this.mListener = r103;
        this.mCustomDir = null;
        this.mWaitIfCaching = r102;
        this.mForceCopyUnfinished = false;
    }

    public CopyCacheItem(String r100, String r101, boolean r102, boolean r103, CopyCacheListener r104) {
        this.mFileKey = r100;
        this.mDestPath = r101;
        this.mListener = r104;
        this.mCustomDir = null;
        this.mWaitIfCaching = r102;
        this.mForceCopyUnfinished = r103;
        if (r103 == false) goto L6;
        this.mWaitIfCaching = false;
        return;
    }
}

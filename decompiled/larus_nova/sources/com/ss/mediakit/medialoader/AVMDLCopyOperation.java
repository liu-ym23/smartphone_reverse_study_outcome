package com.ss.mediakit.medialoader;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLCopyOperation {
    public String mCustomDir;
    String mDestPath;
    String mFileKey;
    boolean mForceCopyUnfinished;
    public final AVMDLCopyOperationListener mListener;
    boolean mWaitIfCaching;

    public AVMDLCopyOperation(String r100, String r101, AVMDLCopyOperationListener r102) {
        this.mFileKey = r100;
        this.mDestPath = r101;
        this.mListener = r102;
        this.mCustomDir = null;
        this.mWaitIfCaching = false;
    }

    public AVMDLCopyOperation(String r100, String r101, boolean r102, AVMDLCopyOperationListener r103) {
        this.mFileKey = r100;
        this.mDestPath = r101;
        this.mListener = r103;
        this.mCustomDir = null;
        this.mWaitIfCaching = r102;
    }

    public AVMDLCopyOperation(String r100, String r101, boolean r102, boolean r103, AVMDLCopyOperationListener r104) {
        this.mFileKey = r100;
        this.mDestPath = r101;
        this.mListener = r104;
        this.mCustomDir = null;
        this.mWaitIfCaching = r103;
        this.mForceCopyUnfinished = r102;
        if (r102 == false) goto L6;
        this.mWaitIfCaching = false;
        return;
    }
}

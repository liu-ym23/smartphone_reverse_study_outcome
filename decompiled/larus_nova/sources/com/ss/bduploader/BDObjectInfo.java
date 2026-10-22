package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public class BDObjectInfo {
    public String mEncryptionMeta;
    public long mErrorCode;
    public int mFileIndex;
    public String mImageTosKey;
    public String mMetaInfo;
    public long mProgress;

    public BDObjectInfo(String r100, long r101, int r102, String r103, String r104) {
        this.mImageTosKey = r100;
        this.mProgress = r101;
        this.mErrorCode = r101;
        this.mFileIndex = r102;
        this.mMetaInfo = r103;
        this.mEncryptionMeta = r104;
    }
}

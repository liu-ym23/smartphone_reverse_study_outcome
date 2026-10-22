package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public class BDImageInfo {
    public String mEncryptionMeta;
    public long mErrorCode;
    public String mErrorMsg;
    public int mFileIndex;
    public String mImageTosKey;
    public String mMetaInfo;
    public long mProgress;

    public BDImageInfo(String r100, long r101, String r102, int r103, String r104, String r105) {
        this.mImageTosKey = r100;
        this.mProgress = r101;
        this.mErrorCode = r101;
        this.mErrorMsg = r102;
        this.mFileIndex = r103;
        this.mMetaInfo = r104;
        this.mEncryptionMeta = r105;
    }
}

package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public class BDImageXInfo {
    public String mEncryptionMeta;
    public BDImageXE2EEncryptionInfo mEnd2EndEncryption;
    public long mErrorCode;
    public String mErrorMsg;
    public int mFileIndex;
    public String mImageTosKey;
    public String mMetaInfo;
    public long mProgress;

    public BDImageXInfo(String r100, long r101, int r102, String r103, String r104, BDImageXE2EEncryptionInfo r105) {
        this.mImageTosKey = r100;
        this.mProgress = r101;
        this.mErrorCode = r101;
        this.mFileIndex = r102;
        this.mMetaInfo = r103;
        this.mEncryptionMeta = r104;
        this.mEnd2EndEncryption = r105;
    }
}

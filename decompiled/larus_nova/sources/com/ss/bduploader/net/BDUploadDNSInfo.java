package com.ss.bduploader.net;

/* JADX INFO: loaded from: classes40.dex */
public class BDUploadDNSInfo {
    public Error mErr;
    public String mErrorStr;
    public long mExpiredTime;
    public String mExtraInfo;
    public String mHost;
    public String mId;
    public String mIpList;
    public int mType;

    public BDUploadDNSInfo(int r100, String r101, String r102, long r103, String r104) {
        this.mType = r100;
        this.mHost = r101;
        this.mIpList = r102;
        this.mExpiredTime = r103;
        this.mId = r104;
        this.mErr = null;
    }

    public BDUploadDNSInfo(int r100, String r101, String r102, long r103, String r104, String r105) {
        this.mType = r100;
        this.mHost = r101;
        this.mIpList = r102;
        this.mExpiredTime = r103;
        this.mId = r104;
        this.mErrorStr = r105;
        this.mErr = null;
    }
}

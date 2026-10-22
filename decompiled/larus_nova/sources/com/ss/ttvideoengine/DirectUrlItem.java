package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public class DirectUrlItem {
    private static final String TAG = "DirectUrlItem";
    private int mBitrate;
    private long mCDNUrlExpiredTime;
    private String[] mExpireTimes;
    private final String mFileKey;
    private String mFormat;
    private String[] mUrls;
    private String mVideoId;

    public String[] allUrls() {
        return this.mUrls;
    }

    public long cdnExpiredTime() {
        return this.mCDNUrlExpiredTime;
    }

    public String fileKey() {
        return this.mFileKey;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public String[] urlExpireTimes() {
        return this.mExpireTimes;
    }

    public String vid() {
        return this.mVideoId;
    }

    public DirectUrlItem(String[] r100, String r101, String r102, long r103) {
        this.mExpireTimes = null;
        this.mBitrate = -1;
        this.mVideoId = r102;
        this.mUrls = r100;
        this.mCDNUrlExpiredTime = r103;
        this.mFileKey = r101;
    }

    public DirectUrlItem(String[] r100, String r101, String r102, long r103, String[] r104) {
        this.mBitrate = -1;
        this.mVideoId = r102;
        this.mUrls = r100;
        this.mCDNUrlExpiredTime = r103;
        this.mFileKey = r101;
        this.mExpireTimes = r104;
    }

    public DirectUrlItem(String[] r100, String r101, String r102, long r103, String[] r104, String r105, int r106) {
        this.mVideoId = r102;
        this.mUrls = r100;
        this.mCDNUrlExpiredTime = r103;
        this.mFileKey = r101;
        this.mExpireTimes = r104;
        this.mFormat = r105;
        this.mBitrate = r106;
    }
}

package com.ttnetuploader.uploader.discovery;

/* JADX INFO: loaded from: classes41.dex */
public class ServerInfo {
    private final long mFindTime;
    private final String mIpv4;
    private final String mKey;
    private final int mPort;
    private final String mSn;

    public String getIpv4() {
        String r100 = this.mIpv4;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getKey() {
        String r100 = this.mKey;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getSn() {
        String r100 = this.mSn;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public long getFindTime() {
        return this.mFindTime;
    }

    public int getPort() {
        return this.mPort;
    }

    public ServerInfo(String r100, String r101, String r102, int r103, long r104) {
        this.mKey = r100;
        this.mSn = r101;
        this.mIpv4 = r102;
        this.mPort = r103;
        this.mFindTime = r104;
    }
}

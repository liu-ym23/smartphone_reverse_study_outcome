package com.bytedance.geckox.model;

/* JADX INFO: loaded from: classes19.dex */
public class LocalPackageModel {
    private String accessKey;
    private String channel;
    private String channelPath;
    private long latestVersion;

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getChannelPath() {
        return this.channelPath;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public void setAccessKey(String r100) {
        this.accessKey = r100;
    }

    public void setChannel(String r100) {
        this.channel = r100;
    }

    public void setChannelPath(String r100) {
        this.channelPath = r100;
    }

    public void setLatestVersion(long r100) {
        this.latestVersion = r100;
    }

    public LocalPackageModel(String r100, String r101) {
        this.accessKey = r100;
        this.channel = r101;
    }
}

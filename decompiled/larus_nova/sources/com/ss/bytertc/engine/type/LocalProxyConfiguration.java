package com.ss.bytertc.engine.type;

/* JADX INFO: loaded from: classes40.dex */
public class LocalProxyConfiguration {
    public String localProxyIp;
    public String localProxyPassword;
    public int localProxyPort;
    public LocalProxyType localProxyType;
    public String localProxyUsername;

    public LocalProxyConfiguration(LocalProxyType r100, String r101, int r102, String r103, String r104) {
        this.localProxyType = r100;
        this.localProxyIp = r101;
        this.localProxyPort = r102;
        this.localProxyUsername = r103;
        this.localProxyPassword = r104;
    }
}

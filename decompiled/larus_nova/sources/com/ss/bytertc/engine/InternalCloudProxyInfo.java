package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.CloudProxyInfo;

/* JADX INFO: loaded from: classes40.dex */
public class InternalCloudProxyInfo {
    public String cloudProxyIp;
    public int cloudProxyPort;

    public String getCloudProxyIp() {
        String r100 = this.cloudProxyIp;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public int getCloudProxyPort() {
        return this.cloudProxyPort;
    }

    public InternalCloudProxyInfo(CloudProxyInfo r100) {
        this.cloudProxyIp = r100.cloudProxyIp;
        this.cloudProxyPort = r100.cloudProxyPort;
    }

    public InternalCloudProxyInfo(String r100, int r101) {
        this.cloudProxyIp = r100;
        this.cloudProxyPort = r101;
    }
}

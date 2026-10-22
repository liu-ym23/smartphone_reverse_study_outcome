package com.bytedance.crypto.cloudsync.network;

/* JADX INFO: loaded from: classes15.dex */
public class SyncKeyData {
    private String appId;
    private int keyVersion;
    private String syncKeyCipher;

    public SyncKeyData(String r100, String r101, int r102) {
        this.appId = r100;
        this.syncKeyCipher = r101;
        this.keyVersion = r102;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public String getSyncKeyCipher() {
        return this.syncKeyCipher;
    }
}

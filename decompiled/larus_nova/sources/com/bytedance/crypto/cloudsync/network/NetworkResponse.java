package com.bytedance.crypto.cloudsync.network;

import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class NetworkResponse {
    private int code;
    private List<SyncKeyData> keyDataList;
    private String message;
    private String serverPubKey;

    public NetworkResponse(int r100, String r101, List<SyncKeyData> r102, String r103) {
        this.code = r100;
        this.message = r101;
        this.keyDataList = r102;
        this.serverPubKey = r103;
    }

    public int getCode() {
        return this.code;
    }

    public List<SyncKeyData> getKeyDataList() {
        return this.keyDataList;
    }

    public String getMessage() {
        return this.message;
    }

    public String getServerPubKey() {
        return this.serverPubKey;
    }
}

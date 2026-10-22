package com.bytedance.ies.sdk.widgets;

/* JADX INFO: loaded from: classes19.dex */
public class KVData {
    private Object data;
    private String key;

    public <T> T getData() {
        T r100 = (T) this.data;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    public String getKey() {
        return this.key;
    }

    public <T> T getData(T r100) {
        return (T) DataCenter.get(this.data, r100);
    }

    public KVData(String r100, Object r101) {
        this.key = r100;
        this.data = r101;
    }
}

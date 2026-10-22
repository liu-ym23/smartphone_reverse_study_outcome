package com.bytedance.ee.bear.contract.net;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes16.dex */
public class DefaultResponse extends Result<String> {
    public String response() {
        return (String) this.data;
    }

    public DefaultResponse(String r100) {
        this.data = r100;
    }
}

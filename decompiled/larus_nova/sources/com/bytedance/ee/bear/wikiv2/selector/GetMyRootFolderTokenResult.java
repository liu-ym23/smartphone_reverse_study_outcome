package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes18.dex */
public class GetMyRootFolderTokenResult extends Result<String> {
    private String token;

    public GetMyRootFolderTokenResult() {
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}

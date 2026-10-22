package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GetMyRootFolderTokenResult extends Result<String> {
    private String token;

    public GetMyRootFolderTokenResult() {
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}

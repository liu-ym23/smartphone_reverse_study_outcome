package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AuthorizeAdapter implements AuthorizeCallback {
    private String platform;

    public abstract void onAuthError(AuthorizeErrorResponse r100);

    public abstract void onAuthSuccess(Bundle r100);

    public AuthorizeAdapter(String r100) {
        this.platform = r100;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onError(AuthorizeErrorResponse r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "auth", 0, r100.platformErrorCode, r100.platformErrorMsg, r100.isCancel);
        onAuthError(r100);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public void onSuccess(Bundle r100) {
        com.bytedance.sdk.account.monitor.c.i(this.platform, "auth", 1, null, null, false);
        onAuthSuccess(r100);
    }
}

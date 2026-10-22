package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OneLoginCallback;

/* JADX INFO: loaded from: classes22.dex */
public interface IOnekeyLoginAdapter extends OneLoginCallback {
    void onLoginError(AuthorizeErrorResponse r100);

    void onLoginSuccess(xa7.g r100);
}

package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* JADX INFO: loaded from: classes22.dex */
public interface IOneKeyOnlyLoginAdapter extends AuthorizeCallback {
    void onLoginError(AuthorizeErrorResponse r100);

    void onLoginSuccess(xa7.g r100);
}

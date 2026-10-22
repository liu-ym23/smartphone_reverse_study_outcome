package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import ua7.h;

/* JADX INFO: loaded from: classes22.dex */
public interface IPlatformLoginAdapter extends AuthorizeCallback {
    void onLoginError(h r100);

    void onLoginSuccess(h r100);
}

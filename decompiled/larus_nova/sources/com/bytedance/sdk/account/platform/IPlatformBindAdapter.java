package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import ua7.h;

/* JADX INFO: loaded from: classes22.dex */
public interface IPlatformBindAdapter extends AuthorizeCallback {

    public interface BindController {
        void doNext();
    }

    void onBindError(h r100);

    void onBindExist(h r100, String r101, String r102, String r103, BindController r104);

    void onBindSuccess(h r100);
}

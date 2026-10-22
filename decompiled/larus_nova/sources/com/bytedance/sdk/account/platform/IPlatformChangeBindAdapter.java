package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import ua7.h;

/* JADX INFO: loaded from: classes22.dex */
public interface IPlatformChangeBindAdapter extends AuthorizeCallback {

    public interface BindController {
        void doNext();
    }

    void onBindExist(h r100, String r101, String r102, String r103, IPlatformBindAdapter.BindController r104);

    void onChangeBindError(h r100);

    void onChangeBindSuccess(h r100);
}

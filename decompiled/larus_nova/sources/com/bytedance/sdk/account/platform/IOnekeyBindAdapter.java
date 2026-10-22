package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OneLoginCallback;

/* JADX INFO: loaded from: classes22.dex */
public interface IOnekeyBindAdapter extends OneLoginCallback {
    void onBindError(AuthorizeErrorResponse r100);

    void onBindSuccess(ua7.e<wb7.f> r100);
}

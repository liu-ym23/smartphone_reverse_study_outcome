package com.bytedance.sdk.account.platform;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* JADX INFO: loaded from: classes22.dex */
public interface IOneKeyForceBindAdapter extends AuthorizeCallback {
    void onBindError(AuthorizeErrorResponse r100);

    void onBindSuccess(ua7.e<wb7.g> r100);
}

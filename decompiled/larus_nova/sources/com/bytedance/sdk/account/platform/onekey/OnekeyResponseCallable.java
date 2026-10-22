package com.bytedance.sdk.account.platform.onekey;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* JADX INFO: loaded from: classes22.dex */
public class OnekeyResponseCallable<T> {
    public AuthorizeCallback mCallback;
    public final T response;
    public final String scene;

    public OnekeyResponseCallable(AuthorizeCallback r100, T r101) {
        this(r100, r101, null);
    }

    public OnekeyResponseCallable(AuthorizeCallback r100, T r101, String r102) {
        this.mCallback = r100;
        this.response = r101;
        this.scene = r102;
    }
}

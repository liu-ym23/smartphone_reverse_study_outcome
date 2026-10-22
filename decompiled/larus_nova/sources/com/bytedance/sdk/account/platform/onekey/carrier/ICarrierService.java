package com.bytedance.sdk.account.platform.onekey.carrier;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface ICarrierService {
    void cancel();

    void getAuthToken(String r100, int r101, boolean r102, AuthorizeCallback r103);

    void getPhoneInfo(String r100, String r101, int r102, boolean r103, AuthorizeCallback r104);

    void getValidateToken(String r100, int r101, boolean r102, AuthorizeCallback r103);
}

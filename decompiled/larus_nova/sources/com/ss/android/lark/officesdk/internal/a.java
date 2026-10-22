package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    void a(OfficeSDKInitConfig r100);

    void b(IOfficeSDKRuntime r100);

    IUserManager getUserManager();
}

package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.lark.sdk.Sdk;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class y implements com.lark.kmp.rustclient.api.f {
    public y() {
    }

    @Override // com.lark.kmp.rustclient.api.f
    public final InvokeResponse a(com.lark.kmp.rustclient.api.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        int r101 = spc.a.f542919a;
        int r102 = r100.f282473a;
        byte[] r103 = r100.f282474b;
        Intrinsics.checkNotNullParameter(r103, "data");
        return Sdk.Companion._invokeV2(r102, r103);
    }

    @Override // com.lark.kmp.rustclient.api.f
    public final void b(com.lark.kmp.rustclient.api.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        int r101 = spc.a.f542919a;
        int r102 = r100.f282473a;
        byte[] r103 = r100.f282474b;
        long r104 = r100.f282475c;
        Intrinsics.checkNotNullParameter(r103, HiAnalyticsConstant.Direction.REQUEST);
        Sdk.Companion._invokeAsyncV2(r102, r103, r104);
    }
}

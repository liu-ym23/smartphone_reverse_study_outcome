package com.larus.dora.impl;

import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;

/* JADX INFO: loaded from: classes4.dex */
public final class n0 implements pk4.f {
    public n0() {
    }

    @Override // pk4.f
    public final String a() {
        return ILoginService.f286097a.getAccountInfo().f531530c;
    }

    @Override // pk4.f
    public final boolean b() {
        return ObricFeatureServiceDelegate.f387839b.b();
    }

    @Override // pk4.f
    public final String c() {
        return com.larus.platform.service.o.f365780a.getDeviceId();
    }

    @Override // pk4.f
    public final int f() {
        return AppHost.f326268a.getUpdateVersionCode();
    }
}

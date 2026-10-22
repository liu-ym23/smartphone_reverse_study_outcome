package com.larus.voicecall.impl;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.larus.audio.call.b {
    public f() {
    }

    public final String a() {
        return AppHost.f326268a.getVersionName();
    }

    public final String b() {
        return com.larus.platform.service.o.f365780a.getDeviceId();
    }

    public final String c() {
        return AccountService.f365697a.getUserId();
    }

    public final boolean d() {
        return AppHost.f326268a.a().isAppBackground();
    }

    public final boolean e() {
        return AppHost.f326268a.isDebug();
    }

    public final boolean f() {
        return AppHost.f326268a.isOversea();
    }

    public final boolean g() {
        return AppHost.f326268a.isTestChannel();
    }

    @Override // com.larus.audio.call.b
    public Context getContext() {
        return AppHost.f326268a.getApplication();
    }

    public final String h() {
        return String.valueOf(AppHost.f326268a.getUpdateVersionCode());
    }
}

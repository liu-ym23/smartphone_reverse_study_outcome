package com.ss.android.lark.officesdk.ab.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import etb.a;
import ftb.b;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory implements Factory<a> {
    private final ftb.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideIOfficeMiniAppEnabled(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory(ftb.a r100) {
        this.module = r100;
    }

    public static OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory create(ftb.a r100) {
        return new OfficeMiniAppEnabledModule_ProvideIOfficeMiniAppEnabledFactory(r100);
    }

    public static a provideIOfficeMiniAppEnabled(ftb.a r100) {
        r100.getClass();
        Object r101 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        StringBuilder r102 = new StringBuilder("provideIOfficeMiniAppEnabled, is null ? ");
        if (r101 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r102.append(' ');
        Log.i("OfficeMiniAppEnabledModule", r102.toString());
        if (r101 != null) goto L10;
        r101 = new b();
    L10:
        return (a) Preconditions.checkNotNullFromProvides(r101);
    L5:
        r103 = false;
        goto L6
    }
}

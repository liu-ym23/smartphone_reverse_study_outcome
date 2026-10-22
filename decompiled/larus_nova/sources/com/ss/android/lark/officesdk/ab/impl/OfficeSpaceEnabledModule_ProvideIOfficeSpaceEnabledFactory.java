package com.ss.android.lark.officesdk.ab.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import etb.d;
import ftb.e;
import ftb.f;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory implements Factory<d> {
    private final e module;

    @Override // javax.inject.Provider
    public d get() {
        return provideIOfficeSpaceEnabled(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory(e r100) {
        this.module = r100;
    }

    public static OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory create(e r100) {
        return new OfficeSpaceEnabledModule_ProvideIOfficeSpaceEnabledFactory(r100);
    }

    public static d provideIOfficeSpaceEnabled(e r100) {
        r100.getClass();
        Object r101 = (d) OfficeSDKManager.getHostGlobalService(d.class);
        StringBuilder r102 = new StringBuilder("provideIOfficeMiniAppEnabled, is null ? ");
        if (r101 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r102.append(' ');
        Log.i("OfficeSpaceEnabledModule", r102.toString());
        if (r101 != null) goto L10;
        r101 = new f();
    L10:
        return (d) Preconditions.checkNotNullFromProvides(r101);
    L5:
        r103 = false;
        goto L6
    }
}

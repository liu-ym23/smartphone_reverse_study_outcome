package com.ss.android.lark.integrator.im.impl.share;

import cnb.c;
import cnb.d;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import uza.a;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory implements Factory<a> {
    private final d module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfficeSDKSharePanel(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory(d r100) {
        this.module = r100;
    }

    public static OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory create(d r100) {
        return new OfficeSDKSharePanelModule_ProvideOfficeSDKSharePanelFactory(r100);
    }

    public static a provideOfficeSDKSharePanel(d r100) {
        r100.getClass();
        Object r101 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r101 != null) goto L6;
        r101 = new c();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r101);
    }
}

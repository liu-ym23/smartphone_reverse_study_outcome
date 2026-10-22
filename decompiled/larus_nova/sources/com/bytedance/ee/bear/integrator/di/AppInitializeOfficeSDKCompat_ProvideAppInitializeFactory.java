package com.bytedance.ee.bear.integrator.di;

import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes16.dex */
public final class AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory implements Factory<hb5.a> {
    private final d module;

    @Override // javax.inject.Provider
    public hb5.a get() {
        return provideAppInitialize(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory(d r100) {
        this.module = r100;
    }

    public static AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory create(d r100) {
        return new AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory(r100);
    }

    public static hb5.a provideAppInitialize(d r100) {
        r100.getClass();
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r101 = new OfficeAppInitializeImpl();
    L10:
        return (hb5.a) Preconditions.checkNotNullFromProvides(r101);
    L8:
        r101 = new c();
        goto L10
    }
}

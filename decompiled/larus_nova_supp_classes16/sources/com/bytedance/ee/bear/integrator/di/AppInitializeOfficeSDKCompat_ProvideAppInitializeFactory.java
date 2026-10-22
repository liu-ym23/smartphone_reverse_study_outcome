package com.bytedance.ee.bear.integrator.di;

import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory implements Factory<hb5.a> {
    private final d module;

    public hb5.a get() {
        return provideAppInitialize(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m408get() {
        return get();
    }

    public AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory(d r1) {
        this.module = r1;
    }

    public static AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory create(d r1) {
        return new AppInitializeOfficeSDKCompat_ProvideAppInitializeFactory(r1);
    }

    public static hb5.a provideAppInitialize(d r0) {
        r0.getClass();
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r1 = new OfficeAppInitializeImpl();
    L10:
        return (hb5.a) Preconditions.checkNotNullFromProvides(r1);
    L8:
        r1 = new c();
        goto L10
    }
}

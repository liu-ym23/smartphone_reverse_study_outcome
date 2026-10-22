package com.bytedance.ee.bear.integrator.services;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import hb5.a;
import hb5.b;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeCoreServiceModule_ProvideAppInitializeFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final sb5.a module;
    private final Provider<j> passportServiceProvider;

    public a get() {
        return provideAppInitialize(this.module, (j) this.passportServiceProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m415get() {
        return get();
    }

    public OfficeCoreServiceModule_ProvideAppInitializeFactory(sb5.a r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportServiceProvider = r2;
        this.accessorProvider = r3;
    }

    public static OfficeCoreServiceModule_ProvideAppInitializeFactory create(sb5.a r1, Provider<j> r2, Provider<v> r3) {
        return new OfficeCoreServiceModule_ProvideAppInitializeFactory(r1, r2, r3);
    }

    public static a provideAppInitialize(sb5.a r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        b r3 = new b(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}

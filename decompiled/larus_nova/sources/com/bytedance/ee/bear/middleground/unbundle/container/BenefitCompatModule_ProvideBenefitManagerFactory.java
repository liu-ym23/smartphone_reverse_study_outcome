package com.bytedance.ee.bear.middleground.unbundle.container;

import bj5.a;
import bj5.b;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class BenefitCompatModule_ProvideBenefitManagerFactory implements Factory<BenefitManagerAPI> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public BenefitManagerAPI get() {
        return provideBenefitManager(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BenefitCompatModule_ProvideBenefitManagerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static BenefitCompatModule_ProvideBenefitManagerFactory create(Provider<j> r100, Provider<v> r101) {
        return new BenefitCompatModule_ProvideBenefitManagerFactory(r100, r101);
    }

    public static BenefitManagerAPI provideBenefitManager(j r100, v r101) {
        int r102 = a.f19242a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        b r103 = new b(r100, r101);
        h.a(r103);
        return (BenefitManagerAPI) Preconditions.checkNotNullFromProvides(r103);
    }
}

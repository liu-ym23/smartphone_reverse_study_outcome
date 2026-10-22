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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BenefitCompatModule_ProvideBenefitManagerFactory implements Factory<BenefitManagerAPI> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public BenefitManagerAPI get() {
        return provideBenefitManager((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m302get() {
        return get();
    }

    public BenefitCompatModule_ProvideBenefitManagerFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static BenefitCompatModule_ProvideBenefitManagerFactory create(Provider<j> r1, Provider<v> r2) {
        return new BenefitCompatModule_ProvideBenefitManagerFactory(r1, r2);
    }

    public static BenefitManagerAPI provideBenefitManager(j r1, v r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        b r3 = new b(r1, r2);
        h.a(r3);
        return (BenefitManagerAPI) Preconditions.checkNotNullFromProvides(r3);
    }
}

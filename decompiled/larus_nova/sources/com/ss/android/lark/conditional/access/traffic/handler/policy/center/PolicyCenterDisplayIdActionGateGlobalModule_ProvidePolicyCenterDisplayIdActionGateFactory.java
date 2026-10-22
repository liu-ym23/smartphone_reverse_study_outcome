package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return providePolicyCenterDisplayIdActionGate(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory create(Provider<j> r100, Provider<v> r101) {
        return new PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory(r100, r101);
    }

    public static a providePolicyCenterDisplayIdActionGate(j r100, v r101) {
        int r102 = b.f418441a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        return (a) Preconditions.checkNotNullFromProvides(new c(r100, r101));
    }
}

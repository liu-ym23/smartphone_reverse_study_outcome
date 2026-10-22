package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowPassportMFAServiceImpl_Factory implements Factory<u> {
    private final Provider<FlowMfaEngine> engineProvider;

    @Override // javax.inject.Provider
    public u get() {
        return newInstance(this.engineProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowPassportMFAServiceImpl_Factory(Provider<FlowMfaEngine> r100) {
        this.engineProvider = r100;
    }

    public static FlowPassportMFAServiceImpl_Factory create(Provider<FlowMfaEngine> r100) {
        return new FlowPassportMFAServiceImpl_Factory(r100);
    }

    public static u newInstance(FlowMfaEngine r100) {
        return new u(r100);
    }
}

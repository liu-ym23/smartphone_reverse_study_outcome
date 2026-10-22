package com.ss.android.lark.passport.applink;

import com.ss.android.lark.passport.flow.mfa.FlowMfaEngine;
import dagger.internal.Factory;
import javax.inject.Provider;
import pyb.a;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKPassportApplinkCapacityImpl_Factory implements Factory<a> {
    private final Provider<FlowMfaEngine> engineProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.engineProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKPassportApplinkCapacityImpl_Factory(Provider<FlowMfaEngine> r100) {
        this.engineProvider = r100;
    }

    public static OfficeSDKPassportApplinkCapacityImpl_Factory create(Provider<FlowMfaEngine> r100) {
        return new OfficeSDKPassportApplinkCapacityImpl_Factory(r100);
    }

    public static a newInstance(FlowMfaEngine r100) {
        return new a(r100);
    }
}

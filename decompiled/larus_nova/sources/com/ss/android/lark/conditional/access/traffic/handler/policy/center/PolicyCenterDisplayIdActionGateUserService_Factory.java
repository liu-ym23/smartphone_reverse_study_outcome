package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PolicyCenterDisplayIdActionGateUserService_Factory implements Factory<d> {
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.userIdProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PolicyCenterDisplayIdActionGateUserService_Factory(Provider<String> r100) {
        this.userIdProvider = r100;
    }

    public static PolicyCenterDisplayIdActionGateUserService_Factory create(Provider<String> r100) {
        return new PolicyCenterDisplayIdActionGateUserService_Factory(r100);
    }

    public static d newInstance(String r100) {
        return new d(r100);
    }
}

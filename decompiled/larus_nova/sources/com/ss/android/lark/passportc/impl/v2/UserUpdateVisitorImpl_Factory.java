package com.ss.android.lark.passportc.impl.v2;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserUpdateVisitorImpl_Factory implements Factory<e> {
    private final Provider<l0c.c> userFlowMonitorProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.userFlowMonitorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserUpdateVisitorImpl_Factory(Provider<l0c.c> r100) {
        this.userFlowMonitorProvider = r100;
    }

    public static UserUpdateVisitorImpl_Factory create(Provider<l0c.c> r100) {
        return new UserUpdateVisitorImpl_Factory(r100);
    }

    public static e newInstance(l0c.c r100) {
        return new e(r100);
    }
}

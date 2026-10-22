package com.ss.android.lark.passportc.task.monitor;

import dagger.internal.Factory;
import javax.inject.Provider;
import l0c.e;
import zyb.c;

/* JADX INFO: loaded from: classes37.dex */
public final class PassportUserFlowMonitorImpl_Factory implements Factory<e> {
    private final Provider<c> monitorServiceProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.monitorServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PassportUserFlowMonitorImpl_Factory(Provider<c> r100) {
        this.monitorServiceProvider = r100;
    }

    public static PassportUserFlowMonitorImpl_Factory create(Provider<c> r100) {
        return new PassportUserFlowMonitorImpl_Factory(r100);
    }

    public static e newInstance(c r100) {
        return new e(r100);
    }
}

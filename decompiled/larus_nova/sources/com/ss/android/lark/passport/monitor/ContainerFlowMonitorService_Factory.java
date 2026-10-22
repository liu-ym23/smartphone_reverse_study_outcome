package com.ss.android.lark.passport.monitor;

import dagger.internal.Factory;
import javax.inject.Provider;
import zyb.a;
import zyb.d;
import zyb.e;

/* JADX INFO: loaded from: classes37.dex */
public final class ContainerFlowMonitorService_Factory implements Factory<a> {
    private final Provider<d> enterAppFlowMonitorServiceProvider;
    private final Provider<e> switchMonitorServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.enterAppFlowMonitorServiceProvider.get(), this.switchMonitorServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ContainerFlowMonitorService_Factory(Provider<d> r100, Provider<e> r101) {
        this.enterAppFlowMonitorServiceProvider = r100;
        this.switchMonitorServiceProvider = r101;
    }

    public static ContainerFlowMonitorService_Factory create(Provider<d> r100, Provider<e> r101) {
        return new ContainerFlowMonitorService_Factory(r100, r101);
    }

    public static a newInstance(d r100, e r101) {
        return new a(r100, r101);
    }
}

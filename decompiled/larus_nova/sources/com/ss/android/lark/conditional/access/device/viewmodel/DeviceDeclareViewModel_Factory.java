package com.ss.android.lark.conditional.access.device.viewmodel;

import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class DeviceDeclareViewModel_Factory implements Factory<DeviceDeclareViewModel> {
    private final Provider<g> fgServiceProvider;
    private final Provider<ConditionalAccessNetDependency> networkDependencyProvider;

    @Override // javax.inject.Provider
    public DeviceDeclareViewModel get() {
        DeviceDeclareViewModel r100 = newInstance(this.fgServiceProvider.get());
        r100.networkDependency = this.networkDependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DeviceDeclareViewModel newInstance(g r100) {
        return new DeviceDeclareViewModel(r100);
    }

    public DeviceDeclareViewModel_Factory(Provider<g> r100, Provider<ConditionalAccessNetDependency> r101) {
        this.fgServiceProvider = r100;
        this.networkDependencyProvider = r101;
    }

    public static DeviceDeclareViewModel_Factory create(Provider<g> r100, Provider<ConditionalAccessNetDependency> r101) {
        return new DeviceDeclareViewModel_Factory(r100, r101);
    }
}

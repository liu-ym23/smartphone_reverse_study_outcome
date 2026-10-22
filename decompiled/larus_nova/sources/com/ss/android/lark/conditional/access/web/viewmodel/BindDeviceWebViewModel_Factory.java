package com.ss.android.lark.conditional.access.web.viewmodel;

import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class BindDeviceWebViewModel_Factory implements Factory<BindDeviceWebViewModel> {
    private final Provider<ConditionalAccessNetDependency> networkDependencyProvider;

    public static BindDeviceWebViewModel newInstance() {
        return new BindDeviceWebViewModel();
    }

    @Override // javax.inject.Provider
    public BindDeviceWebViewModel get() {
        BindDeviceWebViewModel r100 = newInstance();
        r100.networkDependency = this.networkDependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BindDeviceWebViewModel_Factory(Provider<ConditionalAccessNetDependency> r100) {
        this.networkDependencyProvider = r100;
    }

    public static BindDeviceWebViewModel_Factory create(Provider<ConditionalAccessNetDependency> r100) {
        return new BindDeviceWebViewModel_Factory(r100);
    }
}

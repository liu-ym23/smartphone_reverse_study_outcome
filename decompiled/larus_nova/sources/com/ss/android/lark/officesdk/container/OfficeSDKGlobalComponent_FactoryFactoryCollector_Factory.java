package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory implements Factory<OfficeSDKGlobalComponent_FactoryFactoryCollector> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    @Override // javax.inject.Provider
    public OfficeSDKGlobalComponent_FactoryFactoryCollector get() {
        return newInstance(this.factoryProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        this.factoryProvider = r100;
    }

    public static OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory(r100);
    }

    public static OfficeSDKGlobalComponent_FactoryFactoryCollector newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new OfficeSDKGlobalComponent_FactoryFactoryCollector(r100);
    }
}

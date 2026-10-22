package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKGlobalComponent_FactoryFactoryCollector implements DwarfViewModelFactories.FactoryFactoryCollector {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factory;

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryCollector
    public DwarfViewModelFactories.DwarfInternalFactoryFactory getDwarfInternalFactoryFactory() {
        return this.factory.get();
    }

    @Inject
    public OfficeSDKGlobalComponent_FactoryFactoryCollector(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        this.factory = r100;
    }
}

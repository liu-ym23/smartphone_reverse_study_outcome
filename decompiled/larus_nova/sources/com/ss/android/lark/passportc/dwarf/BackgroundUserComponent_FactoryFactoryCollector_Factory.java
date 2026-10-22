package com.ss.android.lark.passportc.dwarf;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.internal.Factory;
import e0c.d;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class BackgroundUserComponent_FactoryFactoryCollector_Factory implements Factory<d> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.factoryProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BackgroundUserComponent_FactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        this.factoryProvider = r100;
    }

    public static BackgroundUserComponent_FactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new BackgroundUserComponent_FactoryFactoryCollector_Factory(r100);
    }

    public static d newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new d(r100);
    }
}

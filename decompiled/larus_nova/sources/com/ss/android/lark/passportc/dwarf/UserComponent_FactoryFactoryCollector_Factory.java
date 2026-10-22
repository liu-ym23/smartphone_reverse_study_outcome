package com.ss.android.lark.passportc.dwarf;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.internal.Factory;
import e0c.o;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserComponent_FactoryFactoryCollector_Factory implements Factory<o> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    @Override // javax.inject.Provider
    public o get() {
        return newInstance(this.factoryProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserComponent_FactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        this.factoryProvider = r100;
    }

    public static UserComponent_FactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new UserComponent_FactoryFactoryCollector_Factory(r100);
    }

    public static o newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new o(r100);
    }
}

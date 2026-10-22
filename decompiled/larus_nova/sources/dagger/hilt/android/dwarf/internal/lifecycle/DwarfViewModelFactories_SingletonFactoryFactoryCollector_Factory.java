package dagger.hilt.android.dwarf.internal.lifecycle;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DwarfViewModelFactories_SingletonFactoryFactoryCollector_Factory implements Factory<DwarfViewModelFactories.SingletonFactoryFactoryCollector> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    @Override // javax.inject.Provider
    public DwarfViewModelFactories.SingletonFactoryFactoryCollector get() {
        return newInstance(this.factoryProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DwarfViewModelFactories_SingletonFactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        this.factoryProvider = r100;
    }

    public static DwarfViewModelFactories_SingletonFactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new DwarfViewModelFactories_SingletonFactoryFactoryCollector_Factory(r100);
    }

    public static DwarfViewModelFactories.SingletonFactoryFactoryCollector newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        return new DwarfViewModelFactories.SingletonFactoryFactoryCollector(r100);
    }
}

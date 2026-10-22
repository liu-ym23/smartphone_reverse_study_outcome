package dagger.hilt.android.dwarf.internal.lifecycle;

import android.app.Application;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory implements Factory<DwarfViewModelFactories.DwarfInternalFactoryFactory> {
    private final Provider<Application> applicationProvider;
    private final Provider<Set<String>> assistedKeySetProvider;
    private final Provider<Set<String>> keySetProvider;

    @Override // javax.inject.Provider
    public DwarfViewModelFactories.DwarfInternalFactoryFactory get() {
        return newInstance(this.applicationProvider.get(), this.keySetProvider.get(), this.assistedKeySetProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory(Provider<Application> r100, Provider<Set<String>> r101, Provider<Set<String>> r102) {
        this.applicationProvider = r100;
        this.keySetProvider = r101;
        this.assistedKeySetProvider = r102;
    }

    public static DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory create(Provider<Application> r100, Provider<Set<String>> r101, Provider<Set<String>> r102) {
        return new DwarfViewModelFactories_DwarfInternalFactoryFactory_Factory(r100, r101, r102);
    }

    public static DwarfViewModelFactories.DwarfInternalFactoryFactory newInstance(Application r100, Set<String> r101, Set<String> r102) {
        return new DwarfViewModelFactories.DwarfInternalFactoryFactory(r100, r101, r102);
    }
}

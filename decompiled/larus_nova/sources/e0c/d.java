package e0c;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements DwarfViewModelFactories.FactoryFactoryCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> f470670a;

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryCollector
    public final DwarfViewModelFactories.DwarfInternalFactoryFactory getDwarfInternalFactoryFactory() {
        return this.f470670a.get();
    }

    @Inject
    public d(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        this.f470670a = r100;
    }
}

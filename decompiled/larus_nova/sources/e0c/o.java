package e0c;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class o implements DwarfViewModelFactories.FactoryFactoryCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> f470673a;

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryCollector
    public final DwarfViewModelFactories.DwarfInternalFactoryFactory getDwarfInternalFactoryFactory() {
        return this.f470673a.get();
    }

    @Inject
    public o(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r100) {
        this.f470673a = r100;
    }
}

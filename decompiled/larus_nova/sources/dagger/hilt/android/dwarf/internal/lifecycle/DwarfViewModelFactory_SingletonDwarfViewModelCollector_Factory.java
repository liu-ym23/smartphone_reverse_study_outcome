package dagger.hilt.android.dwarf.internal.lifecycle;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DwarfViewModelFactory_SingletonDwarfViewModelCollector_Factory implements Factory<DwarfViewModelFactory.SingletonDwarfViewModelCollector> {
    private final Provider<Map<String, Object>> assistedFactoriesProvider;
    private final Provider<Map<String, Provider<ViewModel>>> factoriesProvider;

    @Override // javax.inject.Provider
    public DwarfViewModelFactory.SingletonDwarfViewModelCollector get() {
        return newInstance(this.factoriesProvider.get(), this.assistedFactoriesProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DwarfViewModelFactory_SingletonDwarfViewModelCollector_Factory(Provider<Map<String, Provider<ViewModel>>> r100, Provider<Map<String, Object>> r101) {
        this.factoriesProvider = r100;
        this.assistedFactoriesProvider = r101;
    }

    public static DwarfViewModelFactory_SingletonDwarfViewModelCollector_Factory create(Provider<Map<String, Provider<ViewModel>>> r100, Provider<Map<String, Object>> r101) {
        return new DwarfViewModelFactory_SingletonDwarfViewModelCollector_Factory(r100, r101);
    }

    public static DwarfViewModelFactory.SingletonDwarfViewModelCollector newInstance(Map<String, Provider<ViewModel>> r100, Map<String, Object> r101) {
        return new DwarfViewModelFactory.SingletonDwarfViewModelCollector(r100, r101);
    }
}

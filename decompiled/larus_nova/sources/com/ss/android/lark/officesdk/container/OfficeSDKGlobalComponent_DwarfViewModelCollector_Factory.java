package com.ss.android.lark.officesdk.container;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory implements Factory<OfficeSDKGlobalComponent_DwarfViewModelCollector> {
    private final Provider<Map<String, Object>> assistedFactoriesProvider;
    private final Provider<Map<String, Provider<ViewModel>>> factoriesProvider;

    @Override // javax.inject.Provider
    public OfficeSDKGlobalComponent_DwarfViewModelCollector get() {
        return newInstance(this.factoriesProvider.get(), this.assistedFactoriesProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory(Provider<Map<String, Provider<ViewModel>>> r100, Provider<Map<String, Object>> r101) {
        this.factoriesProvider = r100;
        this.assistedFactoriesProvider = r101;
    }

    public static OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory create(Provider<Map<String, Provider<ViewModel>>> r100, Provider<Map<String, Object>> r101) {
        return new OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory(r100, r101);
    }

    public static OfficeSDKGlobalComponent_DwarfViewModelCollector newInstance(Map<String, Provider<ViewModel>> r100, Map<String, Object> r101) {
        return new OfficeSDKGlobalComponent_DwarfViewModelCollector(r100, r101);
    }
}

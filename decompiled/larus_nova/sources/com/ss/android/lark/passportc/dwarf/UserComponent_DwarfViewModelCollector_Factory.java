package com.ss.android.lark.passportc.dwarf;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import e0c.n;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserComponent_DwarfViewModelCollector_Factory implements Factory<n> {
    private final Provider<Map<String, Object>> assistedFactoriesProvider;
    private final Provider<Map<String, Provider<ViewModel>>> factoriesProvider;

    @Override // javax.inject.Provider
    public n get() {
        return newInstance(this.factoriesProvider.get(), this.assistedFactoriesProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserComponent_DwarfViewModelCollector_Factory(Provider<Map<String, Provider<ViewModel>>> r100, Provider<Map<String, Object>> r101) {
        this.factoriesProvider = r100;
        this.assistedFactoriesProvider = r101;
    }

    public static UserComponent_DwarfViewModelCollector_Factory create(Provider<Map<String, Provider<ViewModel>>> r100, Provider<Map<String, Object>> r101) {
        return new UserComponent_DwarfViewModelCollector_Factory(r100, r101);
    }

    public static n newInstance(Map<String, Provider<ViewModel>> r100, Map<String, Object> r101) {
        return new n(r100, r101);
    }
}

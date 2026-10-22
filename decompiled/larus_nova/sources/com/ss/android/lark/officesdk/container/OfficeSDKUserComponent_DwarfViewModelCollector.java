package com.ss.android.lark.officesdk.container;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKUserComponent_DwarfViewModelCollector implements DwarfViewModelFactory.DwarfViewModelCollector {
    private final Map<String, Object> assistedFactories;
    private final Map<String, Provider<ViewModel>> factories;

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollector
    public Map<String, Object> getDwarfViewModelAssistedMap() {
        return this.assistedFactories;
    }

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollector
    public Map<String, Provider<ViewModel>> getDwarfViewModelMap() {
        return this.factories;
    }

    @Inject
    public OfficeSDKUserComponent_DwarfViewModelCollector(Map<String, Provider<ViewModel>> r100, Map<String, Object> r101) {
        this.factories = r100;
        this.assistedFactories = r101;
    }
}

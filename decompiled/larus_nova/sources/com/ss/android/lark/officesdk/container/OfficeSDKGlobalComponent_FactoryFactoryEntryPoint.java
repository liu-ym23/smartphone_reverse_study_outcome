package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;

/* JADX INFO: loaded from: classes37.dex */
public interface OfficeSDKGlobalComponent_FactoryFactoryEntryPoint extends DwarfViewModelFactories.FactoryFactoryEntryPoint {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_FactoryFactoryEntryPoint$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ DwarfViewModelFactories.FactoryFactoryCollector $default$factoryFactoryCollector(OfficeSDKGlobalComponent_FactoryFactoryEntryPoint r100) {
            return r100.factoryFactoryCollector();
        }
    }

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryEntryPoint
    OfficeSDKGlobalComponent_FactoryFactoryCollector factoryFactoryCollector();

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryEntryPoint
    /* bridge */ /* synthetic */ DwarfViewModelFactories.FactoryFactoryCollector factoryFactoryCollector();
}

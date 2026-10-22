package com.ss.android.lark.officesdk;

import com.ss.android.lark.officesdk.container.HiltWrapper_OfficeSDKGlobalComponent_KeySetModule;
import com.ss.android.lark.officesdk.container.HiltWrapper_OfficeSDKGlobalComponent_MapModule;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_FactoryFactoryEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import dagger.Subcomponent;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import dagger.hilt.internal.GeneratedComponent;

/* JADX INFO: loaded from: classes37.dex */
@Subcomponent(modules = {l0.class, n0.class, HiltWrapper_OfficeSDKGlobalComponent_KeySetModule.class, HiltWrapper_OfficeSDKGlobalComponent_MapModule.class})
@OfficeSDKGlobalScope
public abstract class k0 implements DwarfSPIEntryPoint, OfficeSDKGlobalComponent, OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint, OfficeSDKGlobalComponent_FactoryFactoryEntryPoint, OfficeSDKGlobalEntryPoint, GeneratedComponent {
    public k0() {
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint, dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint
    public /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector dwarfViewModelCollector() {
        return dwarfViewModelCollector();
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_FactoryFactoryEntryPoint, dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryEntryPoint
    public /* bridge */ /* synthetic */ DwarfViewModelFactories.FactoryFactoryCollector factoryFactoryCollector() {
        return factoryFactoryCollector();
    }
}

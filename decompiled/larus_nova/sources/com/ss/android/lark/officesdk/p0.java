package com.ss.android.lark.officesdk;

import com.ss.android.lark.officesdk.container.HiltWrapper_OfficeSDKUserComponent_KeySetModule;
import com.ss.android.lark.officesdk.container.HiltWrapper_OfficeSDKUserComponent_MapModule;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_DwarfViewModelCollectorEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_FactoryFactoryEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import dagger.Subcomponent;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import dagger.hilt.internal.GeneratedComponent;

/* JADX INFO: loaded from: classes37.dex */
@Subcomponent(modules = {q0.class, s0.class, HiltWrapper_OfficeSDKUserComponent_KeySetModule.class, HiltWrapper_OfficeSDKUserComponent_MapModule.class})
@OfficeSDKUserScope
public abstract class p0 implements DwarfSPIEntryPoint, OfficeSDKUserComponent, OfficeSDKUserComponent_DwarfViewModelCollectorEntryPoint, OfficeSDKUserComponent_FactoryFactoryEntryPoint, OfficeSDKUserEntryPoint, GeneratedComponent {
    public p0() {
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_DwarfViewModelCollectorEntryPoint, dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint
    public /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector dwarfViewModelCollector() {
        return dwarfViewModelCollector();
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_FactoryFactoryEntryPoint, dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories.FactoryFactoryEntryPoint
    public /* bridge */ /* synthetic */ DwarfViewModelFactories.FactoryFactoryCollector factoryFactoryCollector() {
        return factoryFactoryCollector();
    }
}

package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;

/* JADX INFO: loaded from: classes37.dex */
public interface OfficeSDKUserComponent_DwarfViewModelCollectorEntryPoint extends DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.container.OfficeSDKUserComponent_DwarfViewModelCollectorEntryPoint$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector $default$dwarfViewModelCollector(OfficeSDKUserComponent_DwarfViewModelCollectorEntryPoint r100) {
            return r100.dwarfViewModelCollector();
        }
    }

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint
    OfficeSDKUserComponent_DwarfViewModelCollector dwarfViewModelCollector();

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint
    /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector dwarfViewModelCollector();
}

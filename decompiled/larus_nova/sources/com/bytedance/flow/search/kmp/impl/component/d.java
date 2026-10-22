package com.bytedance.flow.search.kmp.impl.component;

import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements IComponentRegistry {
    public d() {
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final int priority() {
        return 0;
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final void register() {
        IComponentRegistry.a r100 = IComponentRegistry.f375180a;
        Function1 r101 = new b();
        r100.getClass();
        IComponentRegistry.a.b(r101);
    }
}

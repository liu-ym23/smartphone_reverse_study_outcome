package com.larus.kmp.voice_setting.voice.component;

import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class y7 implements IComponentRegistry {
    public y7() {
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final int priority() {
        return 0;
    }

    @Override // com.larus.ui.arch.modulizer.di.IComponentRegistry
    public final void register() {
        IComponentRegistry.a r100 = IComponentRegistry.f375180a;
        Function1 r101 = new x6();
        r100.getClass();
        IComponentRegistry.a.b(r101);
        IComponentRegistry.a.b(new i7());
        IComponentRegistry.a.b(new q7());
        Iterator r102 = CollectionsKt.listOf(new ContainerFilter[]{ContainerFilter.VOICE_SETTING_DOUBLE_TAB_SHELL, ContainerFilter.VOICE_SETTING_SINGLE_SCREEN, ContainerFilter.VOICE_SETTING_PUBLIC_LIST}).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final ContainerFilter r103 = (ContainerFilter) r102.next();
        IComponentRegistry.a r104 = IComponentRegistry.f375180a;
        Function1 r105 = new r7(r103);
        r104.getClass();
        IComponentRegistry.a.c(r105);
        goto L4
    }
}

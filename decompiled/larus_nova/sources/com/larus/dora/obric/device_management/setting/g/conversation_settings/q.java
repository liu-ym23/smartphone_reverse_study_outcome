package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class q<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment f340313a;

    public q(DoraObricGDoubaoConversationSettingsFragment r100) {
        this.f340313a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        com.larus.dora.impl.device.ailab.a r102 = (com.larus.dora.impl.device.ailab.a) r100;
        if (r102 == null) goto L10;
        boolean r103 = r102.f333532d;
        DoraObricGDoubaoConversationSettingsFragment r104 = this.f340313a;
        if (r104.f340278p == r103) goto L9;
        r104.f340278p = r103;
        r104.ja0();
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }
}

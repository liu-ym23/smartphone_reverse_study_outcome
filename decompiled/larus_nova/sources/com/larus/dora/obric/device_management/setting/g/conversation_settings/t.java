package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class t<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment f340316a;

    public t(DoraObricGDoubaoConversationSettingsFragment r100) {
        this.f340316a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        int r102 = ((Number) r100).intValue();
        DoraObricGDoubaoConversationSettingsFragment r103 = this.f340316a;
        int r104 = DoraObricGDoubaoConversationSettingsFragment.f340267w;
        r103.na0(r102);
        return Unit.INSTANCE;
    }
}

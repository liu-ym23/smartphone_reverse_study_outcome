package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class p implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment f340312a;

    public /* synthetic */ p(DoraObricGDoubaoConversationSettingsFragment r100) {
        this.f340312a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        DoraObricGDoubaoConversationSettingsFragment r101 = this.f340312a;
        boolean r102 = ((Boolean) r100).booleanValue();
        int r103 = DoraObricGDoubaoConversationSettingsFragment.f340267w;
        r101.fa0().setQuickContinuousConversationEnable(r102);
        return Unit.INSTANCE;
    }
}

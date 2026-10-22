package com.larus.dora.obric.device_management.setting.g.conversation_settings;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class l implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricGDoubaoConversationSettingsFragment f340309a;

    public /* synthetic */ l(DoraObricGDoubaoConversationSettingsFragment r100) {
        this.f340309a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        DoraObricGDoubaoConversationSettingsFragment r101 = this.f340309a;
        boolean r102 = ((Boolean) r100).booleanValue();
        int r103 = DoraObricGDoubaoConversationSettingsFragment.f340267w;
        r101.ea0().updateConvStartEndSoundEnable(r102);
        return Unit.INSTANCE;
    }
}

package com.larus.bmhome.bot;

import kotlin.Pair;

/* JADX INFO: loaded from: classes25.dex */
public final class c6 implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServiceBotSettingFragment f296525a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f296525a.f296494h.getClass();
        com.larus.platform.service.o.f365780a.b("click_clear_message_cancel", com.larus.utils.f.c(new Pair[0]));
    }

    public c6(ServiceBotSettingFragment r100) {
        this.f296525a = r100;
    }
}

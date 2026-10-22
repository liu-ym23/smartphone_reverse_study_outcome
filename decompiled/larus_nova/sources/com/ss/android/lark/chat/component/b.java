package com.ss.android.lark.chat.component;

import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin;
import com.ss.android.lark.platform.dispatcher.f;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c.InterfaceC4820c f414710a;

    @Override // com.ss.android.lark.platform.dispatcher.f
    public final void getPriority() {
    }

    @Override // com.ss.android.lark.platform.dispatcher.f
    public final boolean onBackPressed() {
        return this.f414710a.l1();
    }

    public b(FlowMessageSelectPlugin.h r100) {
        this.f414710a = r100;
    }
}

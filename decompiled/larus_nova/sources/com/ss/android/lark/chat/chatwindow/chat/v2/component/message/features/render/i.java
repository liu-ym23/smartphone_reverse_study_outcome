package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.larksuite.component.ui.layout.plus.PerMonitorRenderLKUIPlus;
import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements PerMonitorRenderLKUIPlus.a {
    public i() {
    }

    @Override // com.larksuite.component.ui.layout.plus.PerMonitorRenderLKUIPlus.a
    public final void a() {
        ChatCoreModule.a().getPerfEnterChatMonitor().r();
    }

    @Override // com.larksuite.component.ui.layout.plus.PerMonitorRenderLKUIPlus.a
    public final void b() {
        ChatCoreModule.a().getPerfEnterChatMonitor().k();
    }
}

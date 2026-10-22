package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.FirstMessagePaddingDecoration;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements FirstMessagePaddingDecoration.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListRendererFeature f413911a;

    public p(MessageListRendererFeature r100) {
        this.f413911a = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.FirstMessagePaddingDecoration.a
    public final boolean a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r100 = this.f413911a.G();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canLoadPre();
    }
}

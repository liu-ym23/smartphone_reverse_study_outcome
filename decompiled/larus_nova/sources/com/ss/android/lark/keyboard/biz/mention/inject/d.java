package com.ss.android.lark.keyboard.biz.mention.inject;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements com.ss.android.lark.biz.im.api.extension.chat_window.d<AtDoubaoTopPlugin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f428447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428448b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "at_doubao_top_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final AtDoubaoTopPlugin getPlugin() {
        return new AtDoubaoTopPlugin(this.f428448b);
    }

    public d(v r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f428447a = r100;
        this.f428448b = r101;
    }
}

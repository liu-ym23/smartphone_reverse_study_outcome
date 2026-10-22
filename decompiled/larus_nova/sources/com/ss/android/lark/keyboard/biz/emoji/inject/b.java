package com.ss.android.lark.keyboard.biz.emoji.inject;

import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements d<EmojiTopPlugin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f428330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428331b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "emoji_top_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final EmojiTopPlugin getPlugin() {
        return new EmojiTopPlugin(this.f428331b);
    }

    public b(v r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f428330a = r100;
        this.f428331b = r101;
    }
}

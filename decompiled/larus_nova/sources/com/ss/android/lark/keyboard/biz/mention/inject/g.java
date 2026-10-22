package com.ss.android.lark.keyboard.biz.mention.inject;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements com.ss.android.lark.biz.im.api.extension.chat_window.d<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f428457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428458b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "at_group_member_top_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final e getPlugin() {
        e r100 = new e(this.f428458b);
        r100.f428451b = this.f428458b.f410098c.isGroup();
        return r100;
    }

    public g(v r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f428457a = r100;
        this.f428458b = r101;
    }
}

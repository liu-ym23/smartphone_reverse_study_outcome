package com.ss.android.lark.keyboard.biz.mention.inject;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements com.ss.android.lark.biz.im.api.extension.chat_window.d<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f428463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428464b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "at_inner_top_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final h getPlugin() {
        return new h(this.f428464b.f410096a.requireContext());
    }

    public i(v r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f428463a = r100;
        this.f428464b = r101;
    }
}

package com.ss.android.lark.keyboard.biz.plus.inject;

import com.ss.android.lark.biz.im.api.extension.chat_window.b;
import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements d<PlusInnerEndPlugin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f428517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f428518b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "plus_inner_end_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final PlusInnerEndPlugin getPlugin() {
        return new PlusInnerEndPlugin(this.f428518b);
    }

    public a(v r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f428517a = r100;
        this.f428518b = r101;
    }
}

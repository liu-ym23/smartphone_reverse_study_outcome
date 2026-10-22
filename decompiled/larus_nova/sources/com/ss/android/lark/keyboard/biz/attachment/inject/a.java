package com.ss.android.lark.keyboard.biz.attachment.inject;

import com.ss.android.lark.biz.im.api.extension.chat_window.b;
import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements d<AttachmentInnerTopPlugin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f428292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f428293b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "attachment_inner_top_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final AttachmentInnerTopPlugin getPlugin() {
        return new AttachmentInnerTopPlugin(this.f428293b);
    }

    public a(v r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f428292a = r100;
        this.f428293b = r101;
    }
}

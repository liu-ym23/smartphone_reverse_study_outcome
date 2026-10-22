package ynb;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements com.ss.android.lark.biz.im.api.extension.chat_window.d<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f568598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f568599b;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "input_state_top_expand_view";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final a getPlugin() {
        return new a(this.f568599b);
    }

    public d(v r100, com.ss.android.lark.biz.im.api.extension.chat_window.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        Intrinsics.checkNotNullParameter(r101, "pluginContext");
        this.f568598a = r100;
        this.f568599b = r101;
    }
}

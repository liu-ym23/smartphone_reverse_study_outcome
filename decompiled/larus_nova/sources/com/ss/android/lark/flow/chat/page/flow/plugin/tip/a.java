package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f422879g = null;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.plugin.tip.a$a, reason: collision with other inner class name */
    public static final class C4989a {
    }

    public static final class b implements ChatWindowKeyboard.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f422880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c f422881b;

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void a() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void d() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void f() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void g(com.ss.android.lark.keyboard.b r100) {
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
            a r101 = this.f422880a;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r102 = this.f422881b;
            r101.getClass();
            r100.e().of(r101).c(znb.c.class, new FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1(r101, r102));
        }

        public b(a r100, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r101) {
            this.f422880a = r100;
            this.f422881b = r101;
        }
    }

    static {
        f422879g = new com.ss.android.lark.storage.a("IM");
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        ChatCoreModule.a().getDeviceId();
        ChatWindowKeyboard r102 = r100.n();
        if (r102 == null) goto L5;
        r102.m7(new b(this, r100));
    L5:
        if (r102 == null) goto L10;
        com.ss.android.lark.keyboard.b r103 = r102.n();
        if (r103 == null) goto L11;
        r103.e().of(this).c(znb.c.class, new FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1(this, r100));
        return;
    L11:
        return;
    }
}

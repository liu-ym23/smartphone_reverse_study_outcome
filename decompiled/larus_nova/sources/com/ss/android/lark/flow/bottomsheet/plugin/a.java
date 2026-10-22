package com.ss.android.lark.flow.bottomsheet.plugin;

import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements ChatWindowKeyboard.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowBottomSheetPlugin f422015a;

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
    public final void a() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
    public final void d() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
    public final void f() {
    }

    public a(FlowBottomSheetPlugin r100) {
        this.f422015a = r100;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
    public final void g(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        this.f422015a.G(r100);
    }
}

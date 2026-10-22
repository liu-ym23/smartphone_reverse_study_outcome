package com.ss.android.lark.inline.ai.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d0 implements InlineAIDragView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubPromptsPanelController f427491a;

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void a(int r100) {
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void b(boolean r100) {
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void c() {
        Intrinsics.checkNotNullParameter("swipe_down", "closeType");
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void d() {
        this.f427491a.a(false, true);
    }

    @Override // com.ss.android.lark.inline.ai.ui.InlineAIDragView.d
    public final void onClose() {
        Intrinsics.checkNotNullParameter("swipe_down", "closeType");
        this.f427491a.a(false, false);
    }

    public d0(SubPromptsPanelController r100) {
        this.f427491a = r100;
    }
}

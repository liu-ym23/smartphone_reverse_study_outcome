package com.ss.android.lark.flow.feed.cell.chat.chatdismiss;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowChatDismissBottomSheet f423282a;

    public a(FlowChatDismissBottomSheet r100) {
        this.f423282a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f423282a.a("click_mask");
    }
}

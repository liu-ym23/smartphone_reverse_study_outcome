package com.ss.android.lark.chatbase.view.post;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PostChatView f416954a;

    public a(PostChatView r100) {
        this.f416954a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        PostChatView.a r101 = this.f416954a.f416940m;
        if (r101 == null) goto L6;
        r101.onClick();
        return;
    }
}

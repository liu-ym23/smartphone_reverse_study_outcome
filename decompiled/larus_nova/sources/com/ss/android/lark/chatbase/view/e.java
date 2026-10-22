package com.ss.android.lark.chatbase.view;

import android.view.View;
import com.ss.android.lark.chat.core.view.TextChatView;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextChatView2 f416925a;

    public e(TextChatView2 r100) {
        this.f416925a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        TextChatView.a r101 = this.f416925a.f416917i;
        if (r101 == null) goto L6;
        r101.onClick();
        return;
    }
}

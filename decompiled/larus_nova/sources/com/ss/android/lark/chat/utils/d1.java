package com.ss.android.lark.chat.utils;

import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class d1 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1.a f416660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f416661b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        f1.a r101 = this.f416660a;
        if (r101 == null) goto L6;
        r101.a(this.f416661b);
        return;
    }

    public d1(com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.y r100, String r101) {
        this.f416660a = r100;
        this.f416661b = r101;
    }
}

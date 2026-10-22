package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class e1 extends h7b.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f1.a f416664c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        f1.a r101 = this.f416664c;
        if (r101 == null) goto L6;
        r101.o1();
        return;
    }

    public e1(Context r100, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.y r101) {
        this.f416664c = r101;
        super(r100);
    }
}

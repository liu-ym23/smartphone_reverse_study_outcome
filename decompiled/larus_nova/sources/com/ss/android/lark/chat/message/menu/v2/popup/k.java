package com.ss.android.lark.chat.message.menu.v2.popup;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenuMainContent f415892a;

    public k(PopupMenuMainContent r100) {
        this.f415892a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PopupMenuMainContent r101 = this.f415892a;
        if (r101.f415827e == false) goto L10;
        d r102 = r101.getMenuContext();
        if (r102 == null) goto L11;
        a r103 = r102.a();
        if (r103 == null) goto L12;
        r103.e();
        return;
    L12:
        return;
    L11:
        return;
    }
}

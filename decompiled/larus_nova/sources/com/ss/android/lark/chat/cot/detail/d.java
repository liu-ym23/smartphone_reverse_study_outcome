package com.ss.android.lark.chat.cot.detail;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f414967a;

    public d(c r100) {
        this.f414967a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.ss.android.lark.biz.im.extension.panel.drag.i r101 = this.f414967a.f414952f;
        if (r101 == null) goto L6;
        r101.dismiss();
        return;
    }
}

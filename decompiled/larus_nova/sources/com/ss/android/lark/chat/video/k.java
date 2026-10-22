package com.ss.android.lark.chat.video;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f416824a;

    public k(h r100) {
        this.f416824a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View.OnClickListener r101 = this.f416824a.f416810v;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }
}

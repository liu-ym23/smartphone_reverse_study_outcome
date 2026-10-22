package com.ss.android.lark.chat.video;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InnerVideoPreviewFragment f416789a;

    public c(InnerVideoPreviewFragment r100) {
        this.f416789a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = this.f416789a.f416757g;
        if (r101 == null) goto L5;
        r101.onClosed();
    L5:
        this.f416789a.onBackPressed();
    }
}

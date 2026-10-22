package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FontSizeAdapter f238593a;

    public a(FontSizeAdapter r100) {
        this.f238593a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        h r101 = this.f238593a.f238580b;
        if (r101 == null) goto L6;
        r101.onBackClick();
        return;
    }
}

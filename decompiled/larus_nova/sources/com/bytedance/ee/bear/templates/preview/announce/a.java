package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f239169a;

    public a(d r100) {
        this.f239169a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnnounceTemplateViewModel r101 = this.f239169a.f239178g;
        if (r101 == null) goto L6;
        r101.loadTemplateDataFromNet();
        return;
    }
}

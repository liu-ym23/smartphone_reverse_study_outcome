package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpaceCoverView f241559a;

    public e(SpaceCoverView r100) {
        this.f241559a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SpaceCoverView.b r101 = this.f241559a.getViewDelegate();
        if (r101 == null) goto L6;
        r101.p();
        return;
    }
}

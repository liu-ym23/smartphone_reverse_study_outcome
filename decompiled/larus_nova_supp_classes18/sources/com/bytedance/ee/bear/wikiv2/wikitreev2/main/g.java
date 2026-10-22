package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ SpaceCoverView a;

    public g(SpaceCoverView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        SpaceCoverView.b r2 = this.a.getViewDelegate();
        if (r2 == null) goto L6;
        r2.a();
        return;
    }
}

package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ SpaceCoverView a;

    public f(SpaceCoverView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SpaceCoverView.b r3 = this.a.getViewDelegate();
        if (r3 == null) goto L6;
        r3.b(!this.a.o);
        return;
    }
}

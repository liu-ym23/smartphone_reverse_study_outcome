package com.bytedance.ee.bear.bitable.card.view.table;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f208923a;

    public /* synthetic */ x(y r100) {
        this.f208923a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        m r101 = this.f208923a.f208925b;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}

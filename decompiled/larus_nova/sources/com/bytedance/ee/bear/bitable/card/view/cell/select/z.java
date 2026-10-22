package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class z implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f208189a = null;

    static {
        f208189a = new z();
    }

    public z() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == true) goto L5;
        rcb.c.d(r100);
        return;
    }
}

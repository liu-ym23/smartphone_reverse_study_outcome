package com.bytedance.ee.bear.bitable.itemview.cell.link;

import android.view.View;
import com.bytedance.ee.bear.bitable.itemview.util.i;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f213941a;

    public c(e r100) {
        this.f213941a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.bitable.itemview.b r101 = i.c(this.f213941a);
        if (r101 == null) goto L6;
        r101.onBackPressed();
        return;
    }
}

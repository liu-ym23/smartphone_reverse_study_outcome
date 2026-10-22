package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ClickFormGridRow;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormGridAdapter f207700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f207701b;

    public a(FormGridAdapter r100, int r101) {
        this.f207700a = r100;
        this.f207701b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f207700a.f207684c;
        if (r101 == null) goto L6;
        r101.a(new ClickFormGridRow(this.f207701b));
        return;
    }
}

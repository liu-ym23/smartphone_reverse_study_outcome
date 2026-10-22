package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f237868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilterValueAdapter f237869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FilterValueAdapter.ViewHolder f237870c;

    public r(int r100, FilterValueAdapter r101, FilterValueAdapter.ViewHolder r102) {
        this.f237868a = r100;
        this.f237869b = r101;
        this.f237870c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f237868a >= this.f237869b.f237713a.size()) goto L8;
        ((FilterData.FilterOptionItem) ListProtector.get(this.f237869b.f237713a, this.f237868a)).setSelect(this.f237870c.f237717c.isChecked());
        FilterValueAdapter.a r101 = this.f237869b.f237714b;
        if (r101 == null) goto L9;
        r101.c20();
        return;
    L9:
        return;
    }
}

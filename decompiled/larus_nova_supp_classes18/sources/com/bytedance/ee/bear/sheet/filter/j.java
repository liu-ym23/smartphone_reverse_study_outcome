package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ FilterConditionAdapter.BaseViewHolder a;
    public final /* synthetic */ FilterConditionAdapter b;
    public final /* synthetic */ int c;
    public final /* synthetic */ FilterData.FilterOptionItem d;

    public j(FilterConditionAdapter.BaseViewHolder r1, FilterConditionAdapter r2, int r3, FilterData.FilterOptionItem r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.a.b.isChecked() == true) goto L9;
        this.a.b.setChecked(true);
        FilterConditionAdapter r4 = this.b;
        r4.c = this.c;
        r4.notifyDataSetChanged();
        FilterConditionAdapter.b r5 = this.b.d;
        if (r5 == null) goto L7;
        r5.sK(this.d.getId(), new String[0]);
    L7:
        rcb.c.c(this.b.a);
        return;
    }
}

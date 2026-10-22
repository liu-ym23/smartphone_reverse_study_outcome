package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterConditionAdapter.BaseViewHolder f237855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilterConditionAdapter f237856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f237857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FilterData.FilterOptionItem f237858d;

    public j(FilterConditionAdapter.BaseViewHolder r100, FilterConditionAdapter r101, int r102, FilterData.FilterOptionItem r103) {
        this.f237855a = r100;
        this.f237856b = r101;
        this.f237857c = r102;
        this.f237858d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f237855a.f237676b.isChecked() == true) goto L9;
        this.f237855a.f237676b.setChecked(true);
        FilterConditionAdapter r101 = this.f237856b;
        r101.f237673c = this.f237857c;
        r101.notifyDataSetChanged();
        FilterConditionAdapter.b r102 = this.f237856b.f237674d;
        if (r102 == null) goto L7;
        r102.sK(this.f237858d.getId(), new String[0]);
    L7:
        rcb.c.c(this.f237856b.f237671a);
        return;
    }
}

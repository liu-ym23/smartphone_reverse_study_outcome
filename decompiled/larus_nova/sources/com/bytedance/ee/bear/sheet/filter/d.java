package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterConditionAdapter.RangeViewHolder f237844a;

    public d(FilterConditionAdapter.RangeViewHolder r100) {
        this.f237844a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f237844a.f237676b.isChecked() == true) goto L6;
        this.f237844a.f237676b.setChecked(true);
        return;
    }
}

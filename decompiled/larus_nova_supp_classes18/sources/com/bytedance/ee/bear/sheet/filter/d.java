package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ FilterConditionAdapter.RangeViewHolder a;

    public d(FilterConditionAdapter.RangeViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.b.isChecked() == true) goto L6;
        this.a.b.setChecked(true);
        return;
    }
}

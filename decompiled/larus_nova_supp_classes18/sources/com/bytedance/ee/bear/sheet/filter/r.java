package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ FilterValueAdapter b;
    public final /* synthetic */ FilterValueAdapter.ViewHolder c;

    public r(int r1, FilterValueAdapter r2, FilterValueAdapter.ViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a >= this.b.a.size()) goto L8;
        ((FilterData.FilterOptionItem) ListProtector.get(this.b.a, this.a)).setSelect(this.c.c.isChecked());
        FilterValueAdapter.a r3 = this.b.b;
        if (r3 == null) goto L9;
        r3.c20();
        return;
    L9:
        return;
    }
}

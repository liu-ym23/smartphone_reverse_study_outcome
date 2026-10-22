package com.bytedance.ee.bear.search.picker.filter.type;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ SearchSelectAdapter a;
    public final /* synthetic */ ViewHolder b;
    public final /* synthetic */ e c;

    public b(SearchSelectAdapter r1, ViewHolder r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        SearchSelectAdapter.y2(this.a, this.b, this.c, false);
    }
}

package com.bytedance.ee.bear.search.picker.filter.type;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SearchSelectAdapter a;
    public final /* synthetic */ ViewHolder b;
    public final /* synthetic */ e c;

    public a(SearchSelectAdapter r1, ViewHolder r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r3, boolean r4) {
        SearchSelectAdapter.y2(this.a, this.b, this.c, true);
    }
}

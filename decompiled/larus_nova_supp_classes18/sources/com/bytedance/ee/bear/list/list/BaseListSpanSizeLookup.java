package com.bytedance.ee.bear.list.list;

import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseListSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
    public final d a;
    public final GridLayoutManager b;

    public final int getSpanSize(int r2) {
        if (this.a.getItemViewType(r2) == 273) goto L7;
        return 1;
    L7:
        return this.b.getSpanCount();
    }

    public BaseListSpanSizeLookup(d r1, GridLayoutManager r2) {
        this.a = r1;
        this.b = r2;
    }
}

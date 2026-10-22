package com.bytedance.ee.bear.list.list;

import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: loaded from: classes18.dex */
public class BaseListSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f228453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GridLayoutManager f228454b;

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int r100) {
        if (this.f228453a.getItemViewType(r100) == 273) goto L7;
        return 1;
    L7:
        return this.f228454b.getSpanCount();
    }

    public BaseListSpanSizeLookup(d r100, GridLayoutManager r101) {
        this.f228453a = r100;
        this.f228454b = r101;
    }
}

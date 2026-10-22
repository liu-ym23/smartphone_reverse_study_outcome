package com.bytedance.ee.bear.list.share;

import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: loaded from: classes18.dex */
public class ShareFolderListSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.list.list.d f229433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GridLayoutManager f229434b;

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int r100) {
        if (this.f229433a.getItemViewType(r100) == 273) goto L11;
        if (this.f229433a.getItemViewType(r100) == 22) goto L11;
        if (this.f229433a.getItemViewType(r100) == 33) goto L11;
        return 1;
    L11:
        return this.f229434b.getSpanCount();
    }

    public ShareFolderListSpanSizeLookup(com.bytedance.ee.bear.list.list.d r100, GridLayoutManager r101) {
        this.f229433a = r100;
        this.f229434b = r101;
    }
}

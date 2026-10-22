package com.bytedance.ee.bear.list.share;

import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareFolderListSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
    public final com.bytedance.ee.bear.list.list.d a;
    public final GridLayoutManager b;

    public final int getSpanSize(int r3) {
        if (this.a.getItemViewType(r3) == 273) goto L11;
        if (this.a.getItemViewType(r3) == 22) goto L11;
        if (this.a.getItemViewType(r3) == 33) goto L11;
        return 1;
    L11:
        return this.b.getSpanCount();
    }

    public ShareFolderListSpanSizeLookup(com.bytedance.ee.bear.list.list.d r1, GridLayoutManager r2) {
        this.a = r1;
        this.b = r2;
    }
}

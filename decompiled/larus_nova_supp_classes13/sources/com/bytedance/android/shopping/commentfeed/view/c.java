package com.bytedance.android.shopping.commentfeed.view;

import bc3.d;
import com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements RecyclerViewPageChangeListener.a {
    public final /* synthetic */ CommentItemFragment a;

    @Override // com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener.a
    public final void c() {
    }

    public c(CommentItemFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener.a
    public final void a(int r3) {
        Iterator r0 = ((ArrayList) this.a.m).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).onItemSelected(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.RecyclerViewPageChangeListener.a
    public final void onPageSelected(int r3) {
        Iterator r0 = ((ArrayList) this.a.m).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).onItemSelected(r3);
        goto L4
    L6:
        this.a.t.add(Integer.valueOf(r3));
    }
}

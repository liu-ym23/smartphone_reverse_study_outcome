package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public static final List<WeakReference<RecyclerView>> a = null;
    public static Integer b;

    public p() {
    }

    static {
        a = new ArrayList();
    }

    public static final void a(RecyclerView r4, int r5) {
        if (r5 < 1) goto L19;
        RecyclerView.Adapter r0 = r4.getAdapter();
        if ((r0 instanceof ProductDetailInfoAdapter) == true) goto L8;
        r0 = null;
    L8:
        ProductDetailInfoAdapter r1 = (ProductDetailInfoAdapter) r0;
        if (r1 == null) goto L22;
        IntRange r2 = CollectionsKt.getIndices(r1.getCurrentList());
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        IntIterator r6 = r2.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        r3.add(Integer.valueOf(r1.getBasicItemViewType(r6.nextInt())));
        goto L13
    L15:
        Iterator r7 = CollectionsKt.distinct(r3).iterator();
    L17:
        if (r7.hasNext() == false) goto L23;
        int r8 = ((Number) r7.next()).intValue();
        r4.getRecycledViewPool().setMaxRecycledViews(r8, r5);
        goto L17
    L23:
        return;
    L22:
        return;
    }
}

package com.bytedance.commerce.base.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final List<View> a(View r100) {
        if ((r100 instanceof ViewGroup) == false) goto L10;
        ViewGroup r101 = (ViewGroup) r100;
        IntRange r102 = RangesKt.until(0, r101.getChildCount());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        r103.add(r101.getChildAt(((IntIterator) r104).nextInt()));
        goto L6
    L12:
        return CollectionsKt.toList(r103);
    L10:
        return CollectionsKt.emptyList();
    }
}

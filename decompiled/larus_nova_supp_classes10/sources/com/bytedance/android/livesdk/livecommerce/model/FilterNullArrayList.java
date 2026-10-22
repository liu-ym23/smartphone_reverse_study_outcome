package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class FilterNullArrayList<E> extends ArrayList<E> {
    public FilterNullArrayList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return super.add(r1);
    }
}

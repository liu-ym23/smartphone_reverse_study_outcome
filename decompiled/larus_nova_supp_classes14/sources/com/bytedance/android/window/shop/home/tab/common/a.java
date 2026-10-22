package com.bytedance.android.window.shop.home.tab.common;

import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<L> implements Iterable<L>, KMappedMarker {
    public final LinkedHashSet<L> a;

    @Override // java.lang.Iterable
    public final Iterator<L> iterator() {
        return this.a.iterator();
    }

    public a() {
        this.a = new LinkedHashSet();
    }
}

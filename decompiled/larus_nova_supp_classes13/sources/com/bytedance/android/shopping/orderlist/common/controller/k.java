package com.bytedance.android.shopping.orderlist.common.controller;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<T> implements Comparator<T> {
    public final /* synthetic */ Function1 a;

    public k(Function1 r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues((Comparable) this.a.invoke(r2), (Comparable) this.a.invoke(r3));
    }
}

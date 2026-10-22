package com.bytedance.android.shopping.sku.inner.tracker;

import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public boolean a;
    public final ArrayDeque<a> b;
    public final Function1<a, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        this.c = r2;
        this.b = new ArrayDeque();
    }
}

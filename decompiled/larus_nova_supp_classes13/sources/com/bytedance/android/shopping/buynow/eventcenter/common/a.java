package com.bytedance.android.shopping.buynow.eventcenter.common;

import com.bytedance.android.shopping.buynow.utils.n;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Comparator;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements Comparator<T> {
    public final /* synthetic */ String a;

    public a(String r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r9, T r10) {
        Object r11 = n.a(((c) r10).s(), CollectionsKt.listOf(new String[]{this.a, "validate_priority"}), 0);
        Double r5 = null;
        if ((r11 instanceof Number) == true) goto L5;
        r11 = null;
    L5:
        Number r12 = (Number) r11;
        if (r12 == null) goto L8;
        Double r13 = Double.valueOf(r12.doubleValue());
    L9:
        Object r14 = n.a(((c) r9).s(), CollectionsKt.listOf(new String[]{this.a, "validate_priority"}), 0);
        if ((r14 instanceof Number) == true) goto L12;
        r14 = null;
    L12:
        Number r15 = (Number) r14;
        if (r15 == null) goto L16;
        r5 = Double.valueOf(r15.doubleValue());
    L16:
        return ComparisonsKt.compareValues(r13, r5);
    L8:
        r13 = null;
        goto L9
    }
}

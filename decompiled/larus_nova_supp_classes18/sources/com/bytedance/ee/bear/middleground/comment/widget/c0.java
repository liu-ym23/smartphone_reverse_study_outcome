package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.Spanned;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0<T> implements Comparator {
    public final /* synthetic */ Spanned a;

    public c0(Spanned r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        Spanned r0 = this.a;
        Integer r4 = Integer.valueOf(r0.getSpanStart((un5.e) r2));
        Spanned r1 = this.a;
        return ComparisonsKt.compareValues(r4, Integer.valueOf(r1.getSpanStart((un5.e) r3)));
    }
}

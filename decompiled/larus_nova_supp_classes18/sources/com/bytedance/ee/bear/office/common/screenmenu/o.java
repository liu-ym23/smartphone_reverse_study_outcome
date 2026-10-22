package com.bytedance.ee.bear.office.common.screenmenu;

import android.graphics.Rect;
import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Comparator {
    public final /* synthetic */ ScreenMenuLayout a;
    public final /* synthetic */ Rect b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public o(ScreenMenuLayout r1, Rect r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.Comparator
    public final int compare(T r7, T r8) {
        Pair r9 = (Pair) r7;
        Pair r10 = (Pair) r8;
        return ComparisonsKt.compareValues(Integer.valueOf(ScreenMenuLayout.c(this.a, this.b, ((Number) r9.getFirst()).intValue(), ((Number) r9.getSecond()).intValue(), this.c, this.d)), Integer.valueOf(ScreenMenuLayout.c(this.a, this.b, ((Number) r10.getFirst()).intValue(), ((Number) r10.getSecond()).intValue(), this.c, this.d)));
    }
}

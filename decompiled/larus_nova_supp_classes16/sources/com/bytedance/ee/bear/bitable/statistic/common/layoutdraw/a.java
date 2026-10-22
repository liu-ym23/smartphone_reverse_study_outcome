package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a {
    public final Function3<int[], int[], Integer, Unit> a;
    public final int[] b;
    public final int[] c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.a$a, reason: collision with other inner class name */
    public static final class C0023a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function3<? super int[], ? super int[], ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onReportListener");
        this.a = r2;
        this.b = new int[]{0, 0, 0};
        this.c = new int[]{0, 0, 0};
    }

    public final void a(long r18) {
        int[] r1 = this.b;
        r1[2] = r1[2] + 1;
        int[] r2 = this.c;
        r2[2] = r2[2] + ((int) (System.currentTimeMillis() - r18));
        int[] r3 = this.c;
        int r4 = r3.length;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= r4) goto L5;
        r6 = r6 + r3[r5];
        r5 = r5 + 1;
        goto L3
    L5:
        this.a.invoke(this.c.clone(), this.b.clone(), Integer.valueOf(r6));
        ArraysKt.fill$default(this.b, 0, 0, 0, 6, null);
        ArraysKt.fill$default(this.c, 0, 0, 0, 6, null);
    }
}

package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<int[], int[], Integer, Unit> f215635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f215636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f215637c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.a$a, reason: collision with other inner class name */
    public static final class C3079a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function3<? super int[], ? super int[], ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onReportListener");
        this.f215635a = r100;
        this.f215636b = new int[]{0, 0, 0};
        this.f215637c = new int[]{0, 0, 0};
    }

    public final void a(long r110) {
        int[] r100 = this.f215636b;
        r100[2] = r100[2] + 1;
        int[] r101 = this.f215637c;
        r101[2] = r101[2] + ((int) (System.currentTimeMillis() - r110));
        int[] r102 = this.f215637c;
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r105 = r105 + r102[r104];
        r104 = r104 + 1;
        goto L3
    L5:
        Function3<int[], int[], Integer, Unit> r106 = this.f215635a;
        Object r107 = this.f215637c.clone();
        Object r108 = this.f215636b.clone();
        int[] r109 = (int[]) r107;
        int[] r111 = (int[]) r108;
        r106.invoke(r109, r111, Integer.valueOf(r105));
        ArraysKt.fill$default(this.f215636b, 0, 0, 0, 6, null);
        ArraysKt.fill$default(this.f215637c, 0, 0, 0, 6, null);
    }
}

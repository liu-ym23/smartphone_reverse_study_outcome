package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j2 {
    public static final List<Pair<IntRange, int[]>> a = null;
    public static final int[] b = null;

    static {
        a = CollectionsKt.listOf(new Pair[]{new Pair(new IntRange(0, 60), new int[]{(int) 4284500019L, (int) 4283905836L}), new Pair(new IntRange(61, 180), new int[]{(int) 4282206261L, (int) 4281220147L}), new Pair(new IntRange(181, 240), new int[]{(int) 4280828262L, (int) 4280627288L}), new Pair(new IntRange(241, 300), new int[]{(int) 4280952390L, (int) 4281873241L}), new Pair(new IntRange(301, 360), new int[]{(int) 4284427067L, (int) 4282851108L})});
        int r2 = (int) 4284374622L;
        b = new int[]{r2, r2};
    }

    public static int[] a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "rgbColor");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        float[] r1 = new float[3];
        Integer r5 = com.bytedance.android.ec.core.utils.s.b(r4);
        if (r5 == null) goto L31;
        Color.colorToHSV(r5.intValue(), r1);
        int r6 = (int) r1[0];
        float r2 = r1[1];
        float r3 = r1[2];
        float r7 = 100;
        float r8 = 10;
        if ((r2 * r7) <= r8) goto L29;
        if ((r3 * r7) <= r8) goto L29;
        Iterator<T> r9 = a.iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        if (((IntRange) ((Pair) r10).component1()).contains(r6) == false) goto L18;
    L23:
        Pair r11 = (Pair) r10;
        if (r11 == null) goto L36;
        int[] r12 = (int[]) r11.getSecond();
        if (r12 == null) goto L36;
        return r12;
    L36:
        return b;
    L22:
        r10 = null;
    L29:
        return b;
    L31:
        return b;
    L8:
        return b;
    L5:
        r0 = false;
        goto L6
    }
}

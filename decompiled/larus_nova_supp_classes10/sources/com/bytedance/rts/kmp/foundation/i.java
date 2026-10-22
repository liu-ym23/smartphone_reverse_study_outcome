package com.bytedance.rts.kmp.foundation;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public static final <T> int a(ArrayList<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    @RTSHiddenFromObjC
    public static final <T> ArrayList<T> b(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        if (r1.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return new ArrayList();
    L9:
        return CollectionsKt.arrayListOf(Arrays.copyOf(r1, r1.length));
    L5:
        r0 = false;
        goto L6
    }

    @RTSHiddenFromObjC
    public static final <T> T g(ArrayList<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (T) ListProtector.remove(r1, 0);
    }

    public static ArrayList h(ArrayList r3) {
        int r0 = r3.size();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r1 = r3.size();
        if (r0 >= 0) goto L5;
        r0 = r0 + r1;
    L5:
        ArrayList r2 = new ArrayList();
        r2.addAll(r3.subList(0, Math.min(r0, r3.size())));
        return r2;
    }

    @RTSHiddenFromObjC
    public static final <T> void c(ArrayList<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "callbackfn");
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.invoke(r3.next());
        goto L4
    }

    public static int d(ArrayList r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.size() <= 0) goto L10;
        int r4 = CollectionsKt.drop(r2, 0).indexOf(r3);
        if (r4 != (-1)) goto L9;
        return -1;
    L9:
        return r4 + 0;
    L10:
        return -1;
    }

    @RTSHiddenFromObjC
    public static final <T, R> ArrayList<R> e(ArrayList<T> r6, Function3<? super T, ? super Integer, ? super ArrayList<T>, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "transform");
        FilterNullArrayList r1 = (ArrayList<R>) new ArrayList();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r2 = r6.size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        Object r4 = r7.invoke(ListProtector.get(r6, r3), Integer.valueOf(r3), r6);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.add(r4);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @RTSHiddenFromObjC
    public static final void f(ArrayList r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.add(r2);
    }

    @RTSHiddenFromObjC
    public static final void i(ArrayList r4, int r5, Object... r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "items");
        int r1 = 0;
        if (r5 <= r4.size()) goto L6;
        b(new Object[0]);
        return;
    L6:
        int r0 = r4.size();
        if (r5 >= 0) goto L9;
        int r7 = Math.max(r0 + r5, 0);
    L10:
        int r2 = Math.min(Math.max(1, 0), r4.size() - r7);
        ArrayList r3 = new ArrayList();
    L11:
        if (r1 >= r2) goto L13;
        r3.add(ListProtector.get(r4, r7));
        ListProtector.remove(r4, r7);
        r1 = r1 + 1;
        goto L11
    L13:
        int r8 = r6.length - 1;
    L14:
        if ((-1) >= r8) goto L16;
        ListProtector.add(r4, r7, r6[r8]);
        r8 = r8 - 1;
        goto L14
    L16:
        return;
    L9:
        r7 = Math.min(r5, r0);
        goto L10
    }
}

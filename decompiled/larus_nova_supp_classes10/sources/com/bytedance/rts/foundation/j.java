package com.bytedance.rts.foundation;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public static final <T> int d(ArrayList<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public static final <T> int e(List<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public static final <T> T i(ArrayList<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (T) ListProtector.remove(r1, r1.size() - 1);
    }

    public static final <T> ArrayList<T> k(T... r1) {
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

    public static final <T> ArrayList<T> a(ArrayList<T> r3, ArrayList<T>... r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "arrays");
        ArrayList[] r5 = (ArrayList[]) Arrays.copyOf(r4, r4.length);
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "arrays");
        ArrayList<T> r0 = new ArrayList();
        r0.addAll(r3);
        int r6 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r0.addAll(r5[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final <T> ArrayList<T> b(ArrayList<T> r3, Function1<? super T, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        T r1 = r5.next();
        if (((Boolean) r4.invoke(r1)).booleanValue() == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return new ArrayList(r0);
    }

    public static final <T> int c(ArrayList<T> r2, Function1<? super T, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Iterator<T> r4 = r2.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (((Boolean) r3.invoke(r4.next())).booleanValue() == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        return r0;
    L9:
        return -1;
    }

    public static boolean f(ArrayList r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.size() <= 0) goto L7;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.size();
        return CollectionsKt.drop(r3, 0).contains(r4);
    L7:
        return false;
    }

    public static final <T> String g(ArrayList<T> r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "separator");
        return CollectionsKt.joinToString$default(r11, r12, null, null, 0, null, null, 62, null);
    }

    public static final <T, R> ArrayList<R> h(ArrayList<T> r6, Function3<? super T, ? super Integer, ? super ArrayList<T>, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "transform");
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

    public static final void j(ArrayList r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.add(r2);
    }

    public static final <T> boolean m(ArrayList<T> r2, Function1<? super T, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if (((Boolean) r3.invoke(r4.next())).booleanValue() == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        goto L7
    }

    public static final <T> boolean n(List<? extends T> r2, Function1<? super T, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        List<? extends T> r4 = r2;
        if ((r4 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        if (((Boolean) r3.invoke(r5.next())).booleanValue() == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r4.isEmpty() == false) goto L7;
        goto L7
    }

    public static final void o(ArrayList r2, final Function2 r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "compareFn");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "compareFn");
        CollectionsKt.sortWith(r2, new i(r3));
    }

    public static final <T> ArrayList<T> l(ArrayList<T> r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r0 = r2.size();
        if (r3 >= 0) goto L5;
        r3 = r3 + r0;
    L5:
        if (r4 >= 0) goto L7;
        r4 = r4 + r0;
    L7:
        ArrayList<T> r1 = new ArrayList();
        r1.addAll(r2.subList(r3, Math.min(r4, r2.size())));
        return r1;
    }
}

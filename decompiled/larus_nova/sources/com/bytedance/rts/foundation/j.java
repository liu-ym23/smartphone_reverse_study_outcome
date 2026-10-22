package com.bytedance.rts.foundation;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
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

/* JADX INFO: loaded from: classes10.dex */
public final class j {
    public static final <T> int d(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.size();
    }

    public static final <T> int e(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.size();
    }

    public static final <T> T i(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!r100.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (T) ListProtector.remove(r100, r100.size() - 1);
    }

    public static final <T> ArrayList<T> k(T... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return new ArrayList();
    L9:
        return CollectionsKt.arrayListOf(Arrays.copyOf(r100, r100.length));
    L5:
        r101 = false;
        goto L6
    }

    public static final <T> ArrayList<T> a(ArrayList<T> r100, ArrayList<T>... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "arrays");
        ArrayList[] r102 = (ArrayList[]) Arrays.copyOf(r101, r101.length);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "arrays");
        ArrayList<T> r103 = new ArrayList();
        r103.addAll(r100);
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.addAll(r102[r105]);
        r105 = r105 + 1;
        goto L3
    L5:
        return r103;
    }

    public static final <T> ArrayList<T> b(ArrayList<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        T r104 = r103.next();
        if (r101.invoke(r104).booleanValue() == false) goto L4;
        r102.add(r104);
        goto L4
    L9:
        return new ArrayList(r102);
    }

    public static final <T> int c(ArrayList<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r101.invoke(r102.next()).booleanValue() == true) goto L13;
        r103 = r103 + 1;
        goto L4
    L13:
        return r103;
    L9:
        return -1;
    }

    public static boolean f(ArrayList r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.size() <= 0) goto L7;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.size();
        return CollectionsKt.drop(r100, 0).contains(r101);
    L7:
        return false;
    }

    public static final <T> String g(ArrayList<T> r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "separator");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "separator");
        return CollectionsKt.joinToString$default(r110, r111, null, null, 0, null, null, 62, null);
    }

    public static final <T, R> ArrayList<R> h(ArrayList<T> r100, Function3<? super T, ? super Integer, ? super ArrayList<T>, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transform");
        ArrayList<R> r102 = new ArrayList();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        R r105 = r101.invoke((Object) ListProtector.get(r100, r104), Integer.valueOf(r104), r100);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.add(r105);
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final void j(ArrayList r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.add(r101);
    }

    public static final <T> boolean m(ArrayList<T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (r101.invoke(r102.next()).booleanValue() == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public static final <T> boolean n(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        List<? extends T> r102 = r100;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (r101.invoke(r103.next()).booleanValue() == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    public static final void o(ArrayList r100, final Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "compareFn");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "compareFn");
        CollectionsKt.sortWith(r100, new i(r101));
    }

    public static final <T> ArrayList<T> l(ArrayList<T> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.size();
        if (r101 >= 0) goto L5;
        r101 = r101 + r103;
    L5:
        if (r102 >= 0) goto L7;
        r102 = r102 + r103;
    L7:
        ArrayList<T> r104 = new ArrayList();
        r104.addAll(r100.subList(r101, Math.min(r102, r100.size())));
        return r104;
    }
}

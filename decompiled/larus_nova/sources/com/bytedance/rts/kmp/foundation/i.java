package com.bytedance.rts.kmp.foundation;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i {
    public static final <T> int a(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.size();
    }

    @RTSHiddenFromObjC
    public static final <T> ArrayList<T> b(T... r100) {
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

    @RTSHiddenFromObjC
    public static final <T> T g(ArrayList<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!r100.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (T) ListProtector.remove(r100, 0);
    }

    public static ArrayList h(ArrayList r100) {
        int r101 = r100.size();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = r100.size();
        if (r101 >= 0) goto L5;
        r101 = r101 + r102;
    L5:
        ArrayList r103 = new ArrayList();
        r103.addAll(r100.subList(0, Math.min(r101, r100.size())));
        return r103;
    }

    @RTSHiddenFromObjC
    public static final <T> void c(ArrayList<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "callbackfn");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.invoke(r102.next());
        goto L4
    }

    public static int d(ArrayList r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.size() <= 0) goto L10;
        int r102 = CollectionsKt.drop(r100, 0).indexOf(r101);
        if (r102 != (-1)) goto L9;
        return -1;
    L9:
        return r102 + 0;
    L10:
        return -1;
    }

    @RTSHiddenFromObjC
    public static final <T, R> ArrayList<R> e(ArrayList<T> r100, Function3<? super T, ? super Integer, ? super ArrayList<T>, ? extends R> r101) {
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

    @RTSHiddenFromObjC
    public static final void f(ArrayList r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.add(r101);
    }

    @RTSHiddenFromObjC
    public static final void i(ArrayList r100, int r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "items");
        int r103 = 0;
        if (r101 <= r100.size()) goto L6;
        b(new Object[0]);
        return;
    L6:
        int r104 = r100.size();
        if (r101 >= 0) goto L9;
        int r105 = Math.max(r104 + r101, 0);
    L10:
        int r106 = Math.min(Math.max(1, 0), r100.size() - r105);
        ArrayList r107 = new ArrayList();
    L11:
        if (r103 >= r106) goto L13;
        r107.add(ListProtector.get(r100, r105));
        ListProtector.remove(r100, r105);
        r103 = r103 + 1;
        goto L11
    L13:
        int r108 = r102.length - 1;
    L14:
        if ((-1) >= r108) goto L16;
        ListProtector.add(r100, r105, r102[r108]);
        r108 = r108 - 1;
        goto L14
    L16:
        return;
    L9:
        r105 = Math.min(r101, r104);
        goto L10
    }
}

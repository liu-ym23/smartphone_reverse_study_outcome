package com.larus.utils;

import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {
    public static final <E> List<E> d(List<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Collections.unmodifiableList(r100);
    }

    public static final <T> boolean a(List<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= 0) goto L5;
        return false;
    L5:
        if (r101 >= r100.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public static final <T> List<T> b(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        ArrayList r102 = new ArrayList();
        Iterator<? extends T> r103 = r100.iterator();
        boolean r104 = false;
    L4:
        if (r103.hasNext() == false) goto L11;
        T r105 = r103.next();
        if (r104 == true) goto L10;
        if (r101.invoke(r105).booleanValue() == false) goto L10;
        r104 = true;
    L10:
        r102.add(r105);
        goto L4
    L11:
        return r102;
    }

    public static final <K, V> Map<K, V> c(Map<K, V> r100, Pair<? extends K, ? extends V>... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "pairs");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(r100);
        MapsKt.putAll(r102, r101);
        return r102;
    }

    public static final <E> boolean e(Collection<E> r100, Function1<? super E, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "filter");
        Iterator<E> r102 = r100.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L8;
        if (r101.invoke(r102.next()).booleanValue() == false) goto L4;
        r102.remove();
        r103 = true;
        goto L4
    L8:
        return r103;
    }

    public static final <T> int f(List<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return r101;
    L10:
        if (r101 >= 0) goto L13;
        return 0;
    L13:
        return CollectionsKt.getLastIndex(r100);
    L5:
        if (r101 >= r100.size()) goto L7;
        r102 = true;
        goto L8
    }

    public static final <E> int g(Collection<E> r100, Function1<? super E, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "filter");
        monitor-enter(r100);
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L17
        int r103 = 0;
    L5:
        if (r102.hasNext() == false) goto L14;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r104 = (Object) r102.next();
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L17
    L11:
        if (r101.invoke(r104).booleanValue() == true) goto L15;
        r103 = r103 + 1;
    L15:
        monitor-exit(r100);
        return r103;
    L14:
        r103 = -1;
    L17:
        th = move-exception;
        throw th;
    }

    public static final <E> boolean h(Collection<E> r100, Function1<? super E, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "filter");
        monitor-enter(r100);
        boolean r102 = e(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static final <T> List<T> i(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "predicate");
        Iterator<? extends T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        T r103 = r102.next();
        if (r101.invoke(r103).booleanValue() == false) goto L4;
        return CollectionsKt.listOf(r103);
    L10:
        return CollectionsKt.emptyList();
    }
}

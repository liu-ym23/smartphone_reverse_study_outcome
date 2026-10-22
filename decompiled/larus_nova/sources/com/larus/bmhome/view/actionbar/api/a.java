package com.larus.bmhome.view.actionbar.api;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ss8.b;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<IActionBarFilter> f315663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Function0<Unit>> f315664b = null;

    static {
        f315663a = new CopyOnWriteArrayList();
        f315664b = new CopyOnWriteArrayList();
    }

    public static void a(final IActionBarFilter r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        CopyOnWriteArrayList<IActionBarFilter> r101 = f315663a;
        CollectionsKt.removeAll(r101, new b(r100));
        r101.add(r100);
        Iterator<Function0<Unit>> r102 = f315664b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().invoke();
        goto L4
    }

    public static void b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "filterId");
        CollectionsKt.removeAll(f315663a, new ss8.a(r100));
        Iterator<Function0<Unit>> r101 = f315664b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().invoke();
        goto L4
    }
}

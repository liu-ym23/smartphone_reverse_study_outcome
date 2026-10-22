package com.bytedance.ee.bear.wikiv2.wikitreev2.notification;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final Map<Class<? extends g>, CopyOnWriteArrayList<WeakReference<g>>> a;

    public static final class a {
    }

    static {
    }

    public h() {
        this.a = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(b.class, new CopyOnWriteArrayList()), TuplesKt.to(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new CopyOnWriteArrayList()), TuplesKt.to(f.class, new CopyOnWriteArrayList()), TuplesKt.to(d.class, new CopyOnWriteArrayList()), TuplesKt.to(e.class, new CopyOnWriteArrayList()), TuplesKt.to(c.class, new CopyOnWriteArrayList())});
    }

    public final <T extends g> void a(Class<? extends T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "item");
        CopyOnWriteArrayList<WeakReference<g>> r4 = this.a.get(r2);
        if ((r4 instanceof CopyOnWriteArrayList) == false) goto L5;
        CopyOnWriteArrayList<WeakReference<g>> r5 = r4;
    L6:
        if (r5 == null) goto L15;
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L23;
        WeakReference r0 = (WeakReference) r6.next();
        if (r0 == null) goto L9;
        g r1 = (g) r0.get();
        if (r1 == null) goto L9;
        r3.invoke(r1);
        goto L9
    L23:
        return;
    L15:
        return;
    L5:
        r5 = null;
        goto L6
    }
}

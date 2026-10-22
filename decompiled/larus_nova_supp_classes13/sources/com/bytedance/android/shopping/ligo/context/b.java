package com.bytedance.android.shopping.ligo.context;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w83.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T extends w83.c> implements w83.d<T> {
    public final CopyOnWriteArrayList<z83.a> a;
    public final Map<String, Pair<ViewGroup, View>> b;
    public final Map<String, a93.a<?>> c;
    public final c d;
    public final T e;

    public static final class a {
    }

    static {
    }

    @Override // w83.d
    public final w83.b<T> a() {
        return new com.bytedance.android.shopping.ligo.context.a(this, this.e);
    }

    public b(T r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.e = r2;
        CopyOnWriteArrayList<z83.a> r3 = new CopyOnWriteArrayList();
        this.a = r3;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        c r0 = new c();
        r3.add(r0);
        Unit r4 = Unit.INSTANCE;
        this.d = r0;
    }

    public final <T> T d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        a93.a r5 = (a93.a) ((LinkedHashMap) this.c).get(r4);
        if (r5 != null) goto L5;
    L8:
        T r6 = null;
    L10:
        if ((r6 instanceof Object) == true) goto L13;
        return null;
    L13:
        return (T) r6;
    L5:
        if (r5.a != 1) goto L8;
        r6 = r5.b;
        goto L10
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        dm.a.a("LigoContext").a("removeGlobalProperty: key=".concat(r3));
        if (this.c.containsKey(r3) == false) goto L6;
        this.c.remove(r3);
        return;
    }

    public final void g(z83.b r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        dm.a.a("LigoContext").i("send event: " + r4.a);
        Iterator r0 = CollectionsKt.toMutableList(this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((z83.a) r0.next()).onEvent(r4);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w83.d
    public final void b(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter("live_commerce", "bizName");
        dm.a.a("LigoContext").a("putGlobalProperty: key=" + r4 + ", value=" + r5 + ", bizName=live_commerce");
        if (this.c.containsKey(r4) == true) goto L5;
        this.c.put(r4, new a93.a());
    L5:
        a93.a r6 = (a93.a) ((LinkedHashMap) this.c).get(r4);
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.a == 2) goto L25;
        r6.a = 1;
        if ((r5 instanceof Object) == true) goto L13;
        T r1 = 0;
    L14:
        if (r1 == 0) goto L23;
        T r2 = r6.b;
        r6.b = r1;
        if ((!Intrinsics.areEqual(r2, r5)) == false) goto L24;
        Iterator r7 = ((ArrayList) r6.c).iterator();
    L19:
        if (r7.hasNext() == false) goto L26;
        ((a93.b) r7.next()).a(r6.b);
        goto L19
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r1 = r5;
        goto L14
    }

    public final void c(String r4, a93.b r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Intrinsics.checkNotNullParameter("live_commerce", "bizName");
        if (this.c.containsKey(r4) == true) goto L5;
        this.c.put(r4, new a93.a());
    L5:
        a93.a r6 = (a93.a) ((LinkedHashMap) this.c).get(r4);
        if (r6 == null) goto L15;
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (r6.a == 2) goto L18;
        if (r5 == null) goto L16;
        ((ArrayList) r6.c).add(r5);
        T r7 = r6.b;
        if (r7 == 0) goto L17;
        r5.a(r7);
        return;
    L17:
        return;
    L16:
        return;
    L18:
        return;
    }

    public final void e(String r3, ViewGroup r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        this.b.put(r3, new Pair(r4, r5));
    }
}

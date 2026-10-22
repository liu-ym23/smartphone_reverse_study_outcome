package com.bytedance.ee.bear.wikiv2.route;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import yq5.z;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiRouteTable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f241040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f241041b = null;

    static {
        f241040a = LazyKt.lazy(WikiRouteTable$routeEntryCache$2.INSTANCE);
        f241041b = LazyKt.lazy(WikiRouteTable$atomicInit$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) f241040a.getValue();
    }

    @JvmStatic
    public static final z a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        if (((up5.a) f241041b.getValue()).f551044a.get() == true) goto L5;
        Flowable.fromCallable(new g()).subscribeOn(fo5.d.c()).subscribe(Functions.emptyConsumer(), up5.d.f551050a);
        z r101 = null;
    L6:
        StringBuilder r102 = new StringBuilder("findRouteEntry: ");
        if (r101 == null) goto L9;
        boolean r103 = true;
    L10:
        r102.append(r103);
        tt5.a.h("WikiRouteTable", r102.toString());
        return r101;
    L9:
        r103 = false;
        goto L10
    L5:
        r101 = (z) b().get(r100);
        goto L6
    }

    @JvmStatic
    public static final void c(z r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "routeEntry");
        tt5.a.h("WikiRouteTable", "traceRouteEntry. record: " + r100);
        if (r100.a() == true) goto L6;
        return;
    L6:
        if (r100.f568855e == false) goto L8;
        String r102 = r100.f568852b;
    L9:
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "token");
        if (((up5.a) f241041b.getValue()).f551044a.get() == true) goto L12;
    L14:
        boolean r103 = false;
    L16:
        if (r100.a() == false) goto L19;
        tt5.a.h("WikiRouteTable", "addRouteEntry. objToken: " + du5.b.i(r100.f568853c) + ", wikiToken: " + du5.b.i(r100.f568852b) + ", inSpace: " + r100.f568855e);
        b().put(r100.f568852b, r100);
        b().put(r100.f568853c, r100);
        Flowable.fromCallable(new e(r100)).subscribeOn(fo5.d.c()).subscribe(Functions.emptyConsumer(), up5.d.f551050a);
    L19:
        if (r101 == false) goto L22;
        String r104 = "wrong_cache";
    L21:
        String r105 = r104;
        if (r100.f568855e == false) goto L28;
        String r106 = "space";
    L29:
        gq5.b.c(new gq5.b.a(r100.f568852b, r100.f568853c, Integer.valueOf(r100.f568854d), r106, r105, 32));
        return;
    L28:
        r106 = "wiki";
        goto L29
    L22:
        if (r103 == false) goto L24;
        r104 = "miss_cache";
        goto L21
    L24:
        r104 = "no_cache";
        goto L21
    L12:
        if (b().get(r102) == null) goto L14;
        r103 = true;
        goto L16
    L8:
        r102 = r100.f568853c;
        goto L9
    }
}

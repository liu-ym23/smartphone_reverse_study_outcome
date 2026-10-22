package com.bytedance.ee.bear.wikiv2.route;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import yq5.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiRouteTable {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(WikiRouteTable$routeEntryCache$2.INSTANCE);
        b = LazyKt.lazy(WikiRouteTable$atomicInit$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) a.getValue();
    }

    @JvmStatic
    public static final z a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        if (((up5.a) b.getValue()).a.get() == true) goto L5;
        Flowable.fromCallable(new g()).subscribeOn(fo5.d.c()).subscribe(Functions.emptyConsumer(), up5.d.a);
        z r3 = null;
    L6:
        StringBuilder r0 = new StringBuilder("findRouteEntry: ");
        if (r3 == null) goto L9;
        boolean r1 = true;
    L10:
        r0.append(r1);
        tt5.a.h("WikiRouteTable", r0.toString());
        return r3;
    L9:
        r1 = false;
        goto L10
    L5:
        r3 = (z) b().get(r2);
        goto L6
    }

    @JvmStatic
    public static final void c(z r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "routeEntry");
        tt5.a.h("WikiRouteTable", "traceRouteEntry. record: " + r7);
        if (r7.a() == true) goto L6;
        return;
    L6:
        if (r7.e == false) goto L8;
        String r0 = r7.b;
    L9:
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, ResourceData.KEY_TOKEN);
        if (((up5.a) b.getValue()).a.get() == true) goto L12;
    L14:
        boolean r1 = false;
    L16:
        if (r7.a() == false) goto L19;
        tt5.a.h("WikiRouteTable", "addRouteEntry. objToken: " + du5.b.i(r7.c) + ", wikiToken: " + du5.b.i(r7.b) + ", inSpace: " + r7.e);
        b().put(r7.b, r7);
        b().put(r7.c, r7);
        Flowable.fromCallable(new e(r7)).subscribeOn(fo5.d.c()).subscribe(Functions.emptyConsumer(), up5.d.a);
    L19:
        if (r8 == false) goto L22;
        String r9 = "wrong_cache";
    L21:
        String r5 = r9;
        if (r7.e == false) goto L28;
        String r10 = "space";
    L29:
        gq5.b.c(new gq5.b.a(r7.b, r7.c, Integer.valueOf(r7.d), r10, r5, 32));
        return;
    L28:
        r10 = DocumentType.WIKI_NAME;
        goto L29
    L22:
        if (r1 == false) goto L24;
        r9 = "miss_cache";
        goto L21
    L24:
        r9 = "no_cache";
        goto L21
    L12:
        if (b().get(r0) == null) goto L14;
        r1 = true;
        goto L16
    L8:
        r0 = r7.c;
        goto L9
    }
}

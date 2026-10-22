package com.obric.assistant.remote_card_container.cache;

import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f391239a;

    public /* synthetic */ e(String r100) {
        this.f391239a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f391239a;
        ConcurrentHashMap<String, rfa.c> r101 = rfa.b.f537648a;
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        rfa.b.f537648a.remove(r100);
        LinkedHashSet r102 = new LinkedHashSet();
        n r103 = n.f391253a;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r100, "pkgName");     // Catch: Throwable -> L23
        LinkedHashSet r104 = new LinkedHashSet();     // Catch: Throwable -> L23
        Set<String> r105 = n.f391254b.snapshot().keySet();     // Catch: Throwable -> L23
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L23
        Iterator<T> r107 = r105.iterator();     // Catch: Throwable -> L23
    L6:
        if (r107.hasNext() == false) goto L10;
        Object r108 = r107.next();     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(UriProtector.parse((String) r108).getHost(), r100) == false) goto L6;
        r106.add(r108);     // Catch: Throwable -> L23
        goto L6
    L10:
        Iterator r109 = r106.iterator();     // Catch: Throwable -> L23
    L11:
        if (r109.hasNext() == false) goto L15;
        String r110 = (String) r109.next();     // Catch: Throwable -> L23
        r104.add(r110);     // Catch: Throwable -> L23
        n.f391253a.b(r110);     // Catch: Throwable -> L23
        goto L11
    L15:
        monitor-exit(r103);
        r102.addAll(r104);
        i r111 = i.f391243a;
        r102.addAll(i.c(r100));
        if ((!r102.isEmpty()) == false) goto L22;
        p9a.e r112 = p9a.b.f528329a;
        p9a.b.a("CardCacheManager", "remove cache of app " + r100 + ", clearedUris = " + r102);
        Iterator r113 = r102.iterator();
    L20:
        if (r113.hasNext() == false) goto L35;
        com.obric.assistant.remote_card_container.manager.c.a((String) r113.next(), null, false);
        goto L20
    L35:
        return;
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }
}

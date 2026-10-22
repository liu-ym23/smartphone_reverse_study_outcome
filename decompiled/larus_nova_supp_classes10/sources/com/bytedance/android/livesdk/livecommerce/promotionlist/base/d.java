package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import android.view.View;
import com.bytedance.android.shopping.ligo.context.LigoViewManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements x83.a {
    public final ConcurrentHashMap<String, List<x83.b>> a;

    public final void clear() {
        dm.a.a("ItemCacheCenter").i("Clear list item view cache center");
        Iterator<Map.Entry<String, List<x83.b>>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator<T> r1 = r0.next().getValue().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        View r2 = ((x83.b) r1.next()).a;
        int r3 = LigoViewManager.l;
        LigoViewManager.a.a(r2);
        goto L7
    L9:
        this.a.clear();
    }

    public d() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r4) {
        if (r4 != null) goto L4;
    L18:
        Iterator<Map.Entry<String, List<x83.b>>> r5 = this.a.entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L25;
        Iterator<T> r0 = r5.next().getValue().iterator();
    L23:
        if (r0.hasNext() == false) goto L20;
        View r1 = ((x83.b) r0.next()).a;
        int r2 = LigoViewManager.l;
        LigoViewManager.a.a(r1);
        goto L23
    L25:
        this.a.clear();
        Unit r6 = Unit.INSTANCE;
        return;
    L4:
        if (r4.length() <= 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        String r7 = r4;
    L10:
        if (r7 == null) goto L18;
        List<x83.b> r8 = this.a.get(r4);
        if (r8 == null) goto L17;
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        View r10 = ((x83.b) r9.next()).a;
        int r11 = LigoViewManager.l;
        LigoViewManager.a.a(r10);
    L17:
        this.a.remove(r4);
        return;
    L9:
        r7 = null;
        goto L10
    L6:
        r3 = false;
        goto L7
    }

    public final List<x83.b> b(String r6) {
        dm.a.b r0 = dm.a.a("ItemCacheCenter");
        StringBuilder r1 = new StringBuilder("get view cache for ");
        r1.append(r6);
        r1.append(", has view = ");
        ConcurrentHashMap<String, List<x83.b>> r2 = this.a;
        if (r6 != null) goto L5;
        String r3 = "";
    L6:
        List<x83.b> r4 = r2.get(r3);
        boolean r5 = false;
        if (r4 == null) goto L9;
        boolean r7 = true;
    L10:
        r1.append(r7);
        r0.a(r1.toString());
        if (r6 != null) goto L13;
    L21:
        return null;
    L13:
        if (r6.length() <= 0) goto L15;
        r5 = true;
    L15:
        if (r5 == false) goto L17;
        String r8 = r6;
    L18:
        if (r8 == null) goto L21;
        return this.a.get(r6);
    L17:
        r8 = null;
        goto L18
    L9:
        r7 = false;
        goto L10
    L5:
        r3 = r6;
        goto L6
    }

    public final void c(String r4, List<x83.b> r5) {
        Intrinsics.checkNotNullParameter(r4, "uniqueKey");
        Intrinsics.checkNotNullParameter(r5, "viewsWrapper");
        dm.a.a("ItemCacheCenter").a("set view cache for " + r4);
        this.a.put(r4, r5);
    }
}

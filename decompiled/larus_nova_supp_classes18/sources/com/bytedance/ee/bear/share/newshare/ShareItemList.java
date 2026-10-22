package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.bear.share.export.ShareParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ShareItemList {
    public final List<z> a;
    public final Map<String, z> b;

    public final d0 a() {
        List<z> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        z r3 = (z) r2.next();
        e0 r4 = r3.a();
        if (r4 == null) goto L8;
        this.b.put(r4.a, r3);
    L8:
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L11:
        return new d0(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareItemList(List<? extends z> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    public static void b(List r2, Function1 r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        z r0 = (z) r4.next();
        r3.invoke(r0);
        ShareItemList r1 = r0.b();
        if (r1 == null) goto L8;
        List<z> r5 = r1.a;
    L9:
        if (r5 == null) goto L4;
        Iterator<z> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L4;
        r3.invoke(r6.next());
        goto L12
    L8:
        r5 = null;
        goto L9
    }

    public final void c(final c0 r3, final ShareParams r4) {
        Intrinsics.checkNotNullParameter(r3, "shareHostProvider");
        Intrinsics.checkNotNullParameter(r4, "params");
        b(this.a, new ShareItemList$init$1(r3, r4));
    }
}

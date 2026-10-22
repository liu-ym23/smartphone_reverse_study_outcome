package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.bear.share.export.ShareParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class ShareItemList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<z> f237180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, z> f237181b;

    public final d0 a() {
        List<z> r100 = this.f237180a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        z r103 = (z) r102.next();
        e0 r104 = r103.a();
        if (r104 == null) goto L8;
        this.f237181b.put(r104.f237211a, r103);
    L8:
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L11:
        return new d0(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareItemList(List<? extends z> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f237180a = r100;
        this.f237181b = new LinkedHashMap();
    }

    public static void b(List r100, Function1 r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        z r103 = (z) r102.next();
        r101.invoke(r103);
        ShareItemList r104 = r103.b();
        if (r104 == null) goto L8;
        List<z> r105 = r104.f237180a;
    L9:
        if (r105 == null) goto L4;
        Iterator<z> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L4;
        r101.invoke(r106.next());
        goto L12
    L8:
        r105 = null;
        goto L9
    }

    public final void c(final c0 r100, final ShareParams r101) {
        Intrinsics.checkNotNullParameter(r100, "shareHostProvider");
        Intrinsics.checkNotNullParameter(r101, "params");
        b(this.f237180a, new ShareItemList$init$1(r100, r101));
    }
}

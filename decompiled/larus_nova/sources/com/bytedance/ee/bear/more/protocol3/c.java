package com.bytedance.ee.bear.more.protocol3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f234777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b> f234778b;

    public final i a() {
        List<b> r100 = this.f234777a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        b r103 = (b) r102.next();
        k r104 = r103.buildUI();
        if (r104 == null) goto L8;
        this.f234778b.put(r104.f234901a, r103);
    L8:
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L11:
        return new i(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f234777a = r100;
        this.f234778b = new LinkedHashMap();
    }

    public static void b(List r100, Function1 r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        b r103 = (b) r102.next();
        r101.invoke(r103);
        if ((r103 instanceof g) == false) goto L4;
        c r104 = ((g) r103).b();
        if (r104 == null) goto L10;
        List<b> r105 = r104.f234777a;
    L11:
        if (r105 == null) goto L4;
        Iterator<b> r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L4;
        r101.invoke(r106.next());
        goto L14
    L10:
        r105 = null;
        goto L11
    }
}

package vu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ju1.l;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements a.InterfaceC8042a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f557349a;

    public h(g r100) {
        this.f557349a = r100;
    }

    @Override // vu1.a.InterfaceC8042a
    public final void a(List<ju1.c<Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "factorList");
        if (this.f557349a.f557336h == true) goto L9;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ju1.c r102 = (ju1.c) r101.next();
        ((ConcurrentHashMap) this.f557349a.f557329a).put(r102.f500406a, r102.f500407b);
        goto L6
    L8:
        return;
    L9:
        HashMap r103 = new HashMap();
        HashMap r104 = new HashMap();
        HashMap r105 = new HashMap();
        Iterator<T> r106 = r100.iterator();
    L11:
        if (r106.hasNext() == false) goto L24;
        ju1.c<? extends Object> r107 = (ju1.c) r106.next();
        if ((!((ConcurrentHashMap) this.f557349a.f557329a).containsKey(r107.f500406a)) == true) goto L15;
        r103.put(r107.f500406a, r107);
    L16:
        List<l> r108 = this.f557349a.f557338j.f(r107.f500406a);
        List<ju1.h> r109 = this.f557349a.a(r107, r108);
        Iterator<T> r110 = r108.iterator();
    L18:
        if (r110.hasNext() == false) goto L20;
        l r111 = (l) r110.next();
        r104.put(r111.b(), r111);
        goto L18
    L20:
        Iterator r112 = ((ArrayList) r109).iterator();
    L22:
        if (r112.hasNext() == false) goto L11;
        ju1.h r113 = (ju1.h) r112.next();
        r105.put(r113.b(), r113);
        goto L22
    L15:
        ((ConcurrentHashMap) this.f557349a.f557329a).put(r107.f500406a, r107.f500407b);
        goto L16
    L24:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r103.entrySet().iterator();
    L26:
        if (r115.hasNext() == false) goto L30;
        Map.Entry r116 = (Map.Entry) r115.next();
        g.a r117 = this.f557349a.b((ju1.c) r116.getValue(), ((ju1.c) r116.getValue()).f500407b);
        if (r117 == null) goto L26;
        r114.add(r117);
        goto L26
    L30:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r104.entrySet().iterator();
    L32:
        if (r119.hasNext() == false) goto L36;
        g.b r120 = this.f557349a.d((l) ((Map.Entry) r119.next()).getValue());
        if (r120 == null) goto L32;
        r118.add(r120);
        goto L32
    L36:
        List r121 = CollectionsKt.toList(r118);
        ArrayList r122 = new ArrayList();
        Iterator r123 = r105.entrySet().iterator();
    L38:
        if (r123.hasNext() == false) goto L42;
        g.c r124 = this.f557349a.e((ju1.h) ((Map.Entry) r123.next()).getValue());
        if (r124 == null) goto L38;
        r122.add(r124);
        goto L38
    L42:
        List r125 = CollectionsKt.toList(r122);
        b r126 = this.f557349a.f557333e;
        if (r126 == null) goto L56;
        Iterator r127 = r114.iterator();
    L46:
        if (r127.hasNext() == false) goto L48;
        g.a r128 = (g.a) r127.next();
        int r129 = k.f510820a;
        k.c(r128.f557339a, r128.f557340b, r128.f557341c);
        r126.d(r128.f557339a, r128.f557340b, r128.f557341c);
        goto L46
    L48:
        Iterator r130 = r121.iterator();
    L50:
        if (r130.hasNext() == false) goto L52;
        g.b r131 = (g.b) r130.next();
        int r132 = k.f510820a;
        k.d(r131.f557342a, r131.f557343b, r131.f557344c);
        r126.n(r131.f557342a);
        goto L50
    L52:
        Iterator r133 = r125.iterator();
    L54:
        if (r133.hasNext() == false) goto L79;
        g.c r134 = (g.c) r133.next();
        int r135 = k.f510820a;
        k.e(r134.f557345a, r134.f557346b, r134.f557347c, r134.f557348d);
        r126.l(r134.f557345a, r134.f557347c, r134.f557348d);
        goto L54
    L79:
        return;
    }
}

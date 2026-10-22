package com.bytedance.bdnavigationsdk.network.route;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class RoutePath {
    public static final a Companion = null;
    public static final juc.d<Object>[] h = null;
    public final String a;
    public final float b;
    public final e c;
    public final List<q> d;
    public final List<h> e;
    public final List<g> f;
    public final List<i> g;

    public static final class a {
        public a() {
        }

        public final juc.d<RoutePath> serializer() {
            return RoutePath$$serializer.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RoutePath) == true) goto L8;
        return false;
    L8:
        RoutePath r6 = (RoutePath) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + Float.floatToIntBits(this.b)) * 31;
        e r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<q> r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((r4 + r2) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    static {
        Companion = new a();
        h = new juc.d[]{null, null, null, new nuc.f(q.a.a), new nuc.f(kuc.a.d(h.a.a)), new nuc.f(g.a.a), new nuc.f(i.a.a)};
    }

    public final List<com.bytedance.bdnavigationsdk.pojo.a> a() {
        List<q> r0 = this.d;
        if (r0 == null) goto L32;
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        List<com.bytedance.bdnavigationsdk.pojo.a> r3 = ((q) r1.next()).g;
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();
    L10:
        CollectionsKt.addAll(r2, r3);
        goto L6
    L11:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L20;
        com.bytedance.bdnavigationsdk.pojo.a r6 = (com.bytedance.bdnavigationsdk.pojo.a) r5.next();
        if (r4.isEmpty() == true) goto L18;
        if (Intrinsics.areEqual(CollectionsKt.last(r4), r6) == true) goto L13;
    L18:
        r4.add(r6);
        goto L13
    L20:
        if ((!r4.isEmpty()) == true) goto L22;
        return null;
    L22:
        return r4;
    L32:
        return null;
    }

    public final String toString() {
        return "RoutePath{routeId='" + this.a + "', distance=" + this.b + ", cost=" + this.c + ", polyline=" + a() + ", steps=" + this.d + "}";
    }

    public RoutePath(int r4, String r5, float r6, e r7, List r8, List r9, List r10, List r11) {
        if (1 != (r4 & 1)) goto L29;
        this.a = r5;
        if ((r4 & 2) != 0) goto L7;
        this.b = 0.0f;
    L9:
        if ((r4 & 4) != 0) goto L11;
        this.c = null;
    L13:
        if ((r4 & 8) != 0) goto L15;
        this.d = null;
    L17:
        if ((r4 & 16) != 0) goto L19;
        this.e = new ArrayList();
    L21:
        if ((r4 & 32) != 0) goto L23;
        this.f = new ArrayList();
    L25:
        if ((r4 & 64) != 0) goto L27;
        this.g = new ArrayList();
        return;
    L27:
        this.g = r11;
        return;
    L23:
        this.f = r10;
        goto L25
    L19:
        this.e = r9;
        goto L21
    L15:
        this.d = r8;
        goto L17
    L11:
        this.c = r7;
        goto L13
    L7:
        this.b = r6;
        goto L9
    L29:
        b2.b(r4, 1, RoutePath$$serializer.b);
        throw null;
    }
}

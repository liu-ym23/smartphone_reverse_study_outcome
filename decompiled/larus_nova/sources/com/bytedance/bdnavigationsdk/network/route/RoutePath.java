package com.bytedance.bdnavigationsdk.network.route;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.b2;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class RoutePath {
    public static final a Companion = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final juc.d<Object>[] f200195h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f200197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f200198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<q> f200199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<h> f200200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<g> f200201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<i> f200202g;

    public static final class a {
        public a() {
        }

        public final juc.d<RoutePath> serializer() {
            return RoutePath$$serializer.f200203a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RoutePath) == true) goto L8;
        return false;
    L8:
        RoutePath r101 = (RoutePath) r100;
        if (Intrinsics.areEqual(this.f200196a, r101.f200196a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f200197b, r101.f200197b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200198c, r101.f200198c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200199d, r101.f200199d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f200200e, r101.f200200e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f200201f, r101.f200201f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f200202g, r101.f200202g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f200196a.hashCode() * 31) + Float.floatToIntBits(this.f200197b)) * 31;
        e r101 = this.f200198c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<q> r105 = this.f200199d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((((((r104 + r102) * 31) + this.f200200e.hashCode()) * 31) + this.f200201f.hashCode()) * 31) + this.f200202g.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    static {
        Companion = new a();
        f200195h = new juc.d[]{null, null, null, new nuc.f(q.a.f200271a), new nuc.f(kuc.a.d(h.a.f200231a)), new nuc.f(g.a.f200227a), new nuc.f(i.a.f200235a)};
    }

    public final List<com.bytedance.bdnavigationsdk.pojo.a> a() {
        List<q> r100 = this.f200199d;
        if (r100 == null) goto L32;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        List<com.bytedance.bdnavigationsdk.pojo.a> r103 = ((q) r102.next()).f200270g;
        if (r103 != null) goto L10;
        r103 = CollectionsKt.emptyList();
    L10:
        CollectionsKt.addAll(r101, r103);
        goto L6
    L11:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L13:
        if (r105.hasNext() == false) goto L20;
        com.bytedance.bdnavigationsdk.pojo.a r106 = (com.bytedance.bdnavigationsdk.pojo.a) r105.next();
        if (r104.isEmpty() == true) goto L18;
        if (Intrinsics.areEqual(CollectionsKt.last(r104), r106) == true) goto L13;
    L18:
        r104.add(r106);
        goto L13
    L20:
        if ((!r104.isEmpty()) == true) goto L22;
        return null;
    L22:
        return r104;
    L32:
        return null;
    }

    public final String toString() {
        return "RoutePath{routeId='" + this.f200196a + "', distance=" + this.f200197b + ", cost=" + this.f200198c + ", polyline=" + a() + ", steps=" + this.f200199d + com.alipay.sdk.m.u.i.f25855d;
    }

    public RoutePath(int r100, String r101, float r102, e r103, List r104, List r105, List r110, List r111) {
        if (1 != (r100 & 1)) goto L29;
        this.f200196a = r101;
        if ((r100 & 2) != 0) goto L7;
        this.f200197b = 0.0f;
    L9:
        if ((r100 & 4) != 0) goto L11;
        this.f200198c = null;
    L13:
        if ((r100 & 8) != 0) goto L15;
        this.f200199d = null;
    L17:
        if ((r100 & 16) != 0) goto L19;
        this.f200200e = new ArrayList();
    L21:
        if ((r100 & 32) != 0) goto L23;
        this.f200201f = new ArrayList();
    L25:
        if ((r100 & 64) != 0) goto L27;
        this.f200202g = new ArrayList();
        return;
    L27:
        this.f200202g = r111;
        return;
    L23:
        this.f200201f = r110;
        goto L25
    L19:
        this.f200200e = r105;
        goto L21
    L15:
        this.f200199d = r104;
        goto L17
    L11:
        this.f200198c = r103;
        goto L13
    L7:
        this.f200197b = r102;
        goto L9
    L29:
        b2.b(r100, 1, RoutePath$$serializer.f200204b);
        throw null;
    }
}

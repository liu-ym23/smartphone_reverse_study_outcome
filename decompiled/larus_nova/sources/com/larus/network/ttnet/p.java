package com.larus.network.ttnet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f360240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f360241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<com.larus.network.f> f360242c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f360243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static f f360244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f360245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f360246g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArrayDeque<b> f360247h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f360248i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f360249j = null;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f360250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f360251b;

        public a() {
            this(-1, -1);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f360250a == r101.f360250a) goto L12;
            return false;
        L12:
            if (this.f360251b == r101.f360251b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f360250a * 31) + this.f360251b;
        }

        public final String toString() {
            return "RttWindowSnapshot(avg=" + this.f360250a + ", max=" + this.f360251b + ')';
        }

        public a(int r100, int r101) {
            this.f360250a = r100;
            this.f360251b = r101;
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f360252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f360253b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f360252a == r101.f360252a) goto L12;
            return false;
        L12:
            if (this.f360253b == r101.f360253b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f360252a * 31;
            long r101 = this.f360253b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "TimedRttSample(value=" + this.f360252a + ", timeMs=" + this.f360253b + ')';
        }

        public b(int r100, long r101) {
            this.f360252a = r100;
            this.f360253b = r101;
        }
    }

    static {
        f360240a = new String[0];
        f360241b = MapsKt.emptyMap();
        f360242c = new ArrayList();
        f360243d = true;
        f360246g = new Object();
        f360247h = new ArrayDeque();
        f360248i = LazyKt.lazy(new j());
        f360249j = LazyKt.lazy(new k());
    }

    public static void b(long r100) {
        long r101 = r100 - 5000;
    L3:
        ArrayDeque<b> r102 = f360247h;
        if (r102.size() <= 1) goto L8;
        if (((b) CollectionsKt.elementAt(r102, 1)).f360253b > r101) goto L8;
        r102.removeFirst();
    L8:
        ArrayDeque<b> r103 = f360247h;
        if (r103.size() <= 64) goto L11;
        r103.removeFirst();
        goto L8
    }

    public static a a(ArrayDeque r110, long r111) {
        if (r110.isEmpty() == true) goto L5;
        long r100 = r111 - 5000;
        Iterator r101 = r110.iterator();
        b r102 = (b) r101.next();
        long r103 = Math.max(r100, r102.f360253b);
        long r112 = 0;
        long r113 = 0;
        int r114 = -1;
    L8:
        if (r101.hasNext() == false) goto L14;
        b r104 = (b) r101.next();
        long r105 = Math.min(r111, r104.f360253b);
        if (r105 <= r103) goto L12;
        long r106 = r105 - r103;
        int r107 = r102.f360252a;
        r112 = r112 + (((long) r107) * r106);
        r113 = r113 + r106;
        r114 = Math.max(r114, r107);
    L12:
        r103 = Math.max(r100, r104.f360253b);
        r102 = r104;
        goto L8
    L14:
        if (r111 <= r103) goto L17;
        long r108 = r111 - r103;
        int r109 = r102.f360252a;
        r112 = r112 + (((long) r109) * r108);
        r113 = r113 + r108;
        r114 = Math.max(r114, r109);
    L17:
        if (r113 > 0) goto L21;
        return new a(-1, -1);
    L21:
        return new a((int) (r112 / r113), r114);
    L5:
        return new a(-1, -1);
    }
}

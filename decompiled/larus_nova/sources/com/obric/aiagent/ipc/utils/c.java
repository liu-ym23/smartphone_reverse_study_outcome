package com.obric.aiagent.ipc.utils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f384725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f384726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f384727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f384728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f384729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, b>>> f384730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f384731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f384732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f384733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f384734j;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f384735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f384736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f384737c;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f384735a == r101.f384735a) goto L12;
            return false;
        L12:
            if (this.f384736b == r101.f384736b) goto L15;
            return false;
        L15:
            if (this.f384737c == r101.f384737c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f384735a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f384736b) * 31;
            if (this.f384737c == false) goto L5;
            int r102 = 1231;
        L7:
            return r101 + r102;
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "MethodState(windowIndex=" + this.f384735a + ", windowCount=" + this.f384736b + ", frequentReported=" + this.f384737c + ')';
        }

        public b(int r100) {
            this.f384735a = Long.MIN_VALUE;
            this.f384736b = 0;
            this.f384737c = false;
        }
    }

    static {
    }

    public final List<IPCAnomalyType> b(List<? extends IPCAnomalyType> r100, long r101) {
        if (r101 <= this.f384734j) goto L5;
        Object r102 = this.f384731g;
        monitor-enter(r102);
    L22:
        th = move-exception;
        throw th;
    L9:
        if (r101 > this.f384734j) goto L12;
        List<IPCAnomalyType> r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L22
    L20:
        monitor-exit(r102);
        return r103;
    L12:
        if (r101 <= this.f384732h) goto L14;
        this.f384732h = r101;     // Catch: Throwable -> L22
        this.f384733i = 0;     // Catch: Throwable -> L22
    L14:
        int r104 = RangesKt.coerceAtLeast(this.f384728d - this.f384733i, 0);     // Catch: Throwable -> L22
        if (r104 != 0) goto L17;
        r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L22
        goto L20
    L17:
        r103 = CollectionsKt.take(r100, r104);     // Catch: Throwable -> L22
        int r105 = this.f384733i + r103.size();     // Catch: Throwable -> L22
        this.f384733i = r105;     // Catch: Throwable -> L22
        if (r105 < this.f384728d) goto L20;
        this.f384734j = this.f384732h;     // Catch: Throwable -> L22
        goto L20
    L5:
        return CollectionsKt.emptyList();
    }

    public c(long r100, int r101, int r102) {
        this.f384725a = 60000;
        this.f384726b = r100;
        this.f384727c = r101;
        this.f384728d = r102;
        this.f384729e = 60000;
        this.f384730f = new ConcurrentHashMap();
        this.f384731g = new Object();
        this.f384732h = Long.MIN_VALUE;
        this.f384734j = Long.MIN_VALUE;
        boolean r103 = true;
        if (r100 < 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L22;
        if (r101 <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L20;
        if (r102 > 0) goto L15;
        r103 = false;
    L15:
        if (r103 == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        r105 = false;
        goto L11
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r104 = false;
        goto L7
    }

    public final com.obric.aiagent.ipc.utils.b a(String r100, String r101, String r102, long r103, boolean r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        long r104 = r111 / this.f384725a;
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> r105 = this.f384730f.get(r100);
        if (r105 != null) goto L8;
        r105 = new ConcurrentHashMap();
        ConcurrentHashMap<String, ConcurrentHashMap<String, b>> r106 = this.f384730f.putIfAbsent(r100, r105);
        if (r106 == null) goto L8;
        r105 = r106;
    L8:
        ConcurrentHashMap<String, b> r107 = r105.get(r101);
        if (r107 != null) goto L14;
        r107 = new ConcurrentHashMap();
        ConcurrentHashMap<String, b> r108 = r105.putIfAbsent(r101, r107);
        if (r108 == null) goto L14;
        r107 = r108;
    L14:
        b r109 = r107.get(r102);
        if (r109 != null) goto L20;
        r109 = new b(0);
        b r112 = r107.putIfAbsent(r102, r109);
        if (r112 == null) goto L20;
        r109 = r112;
    L20:
        monitor-enter(r109);
    L57:
        th = move-exception;
        throw th;
    L22:
        if (r104 <= r109.f384735a) goto L24;
        r109.f384735a = r104;     // Catch: Throwable -> L57
        r109.f384736b = 0;     // Catch: Throwable -> L57
        r109.f384737c = false;     // Catch: Throwable -> L57
    L24:
        int r113 = r109.f384736b;     // Catch: Throwable -> L57
        int r114 = this.f384727c;     // Catch: Throwable -> L57
        if (r113 >= r114) goto L27;
        r109.f384736b = r113 + 1;     // Catch: Throwable -> L57
    L27:
        com.obric.aiagent.ipc.utils.b r115 = null;
        if (r110 == false) goto L31;
        IPCAnomalyType r116 = IPCAnomalyType.FAILURE;     // Catch: Throwable -> L57
    L34:
        IPCAnomalyType r117 = IPCAnomalyType.FREQUENT;     // Catch: Throwable -> L57
        if (r109.f384736b >= r114) goto L37;
    L39:
        boolean r118 = false;
    L40:
        if (r118 == true) goto L43;
        r117 = null;
    L43:
        if (r117 == null) goto L45;
        r109.f384737c = true;     // Catch: Throwable -> L57
    L45:
        if (r116 != null) goto L48;
        if (r117 != null) goto L48;
    L55:
        monitor-exit(r109);
        return r115;
    L48:
        long r119 = r111 / this.f384729e;     // Catch: Throwable -> L57
        if (r119 <= this.f384734j) goto L55;
        List<IPCAnomalyType> r120 = b(CollectionsKt.listOfNotNull(new IPCAnomalyType[]{r116, r117}), r119);     // Catch: Throwable -> L57
        if (r120.isEmpty() == true) goto L55;
        r115 = new com.obric.aiagent.ipc.utils.b(r120, r109.f384736b);     // Catch: Throwable -> L57
        goto L55
    L37:
        if (r109.f384737c == true) goto L39;
        r118 = true;
        goto L40
    L31:
        if (r103 < this.f384726b) goto L33;
        r116 = IPCAnomalyType.SLOW;     // Catch: Throwable -> L57
        goto L34
    L33:
        r116 = null;
        goto L34
    }
}

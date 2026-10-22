package com.bytedance.helios.consumer;

import hz5.h;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<a> f245413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f245414b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static jz5.e f245415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f245416d = null;

    /* JADX INFO: loaded from: classes19.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f245417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f245418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f245419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Throwable f245420d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f245421e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f245417a, r101.f245417a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f245418b, r101.f245418b) == true) goto L10;
            return false;
        L10:
            if (this.f245419c == r101.f245419c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f245420d, r101.f245420d) == true) goto L14;
            return false;
        L14:
            if (this.f245421e == r101.f245421e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f245417a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f245418b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (((r103 + r105) * 31) + this.f245419c) * 31;
            Throwable r107 = this.f245420d;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            int r108 = (r106 + r101) * 31;
            long r109 = this.f245421e;
            return r108 + ((int) (r109 ^ (r109 >>> 32)));
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LogModel(tag=" + this.f245417a + ", msg=" + this.f245418b + ", level=" + this.f245419c + ", throwable=" + this.f245420d + ", timestamp=" + this.f245421e + ")";
        }

        public a(String r100, String r101, int r102, Throwable r103) {
            long r104 = System.currentTimeMillis();
            this.f245417a = r100;
            this.f245418b = r101;
            this.f245419c = r102;
            this.f245420d = r103;
            this.f245421e = r104;
        }
    }

    public c() {
    }

    static {
        f245416d = new c();
        f245413a = new ConcurrentLinkedQueue();
        f245414b = new AtomicBoolean(false);
    }

    public static boolean b() {
        jz5.e r100 = f245415c;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        return true;
    }

    public static void c(c r100) {
        r100.getClass();
        if ((!f245413a.isEmpty()) == true) goto L5;
        return;
    L5:
        if (f245414b.getAndSet(true) == true) goto L9;
        com.bytedance.helios.common.utils.g.e().post(d.f245422a);
        return;
    }

    @Override // hz5.h
    public final void e(Throwable r100) {
        if (b() == true) goto L5;
        a("Helios-Control-Api", "", r100, 4);
        return;
    L5:
        c(this);
        jz5.e r101 = f245415c;
        if (r101 == null) goto L10;
        r101.e("Helios-Control-Api", "", r100);
        return;
    }

    @Override // hz5.h
    public final void d(String r100, String r101, Throwable r102) {
        if (b() == true) goto L5;
        a(r100, r101, r102, 1);
        return;
    L5:
        c(this);
        jz5.e r103 = f245415c;
        if (r103 == null) goto L10;
        r103.d(r100, r101, r102);
        return;
    }

    @Override // hz5.h
    public final void i(String r100, String r101, Throwable r102) {
        if (b() == true) goto L5;
        a(r100, r101, r102, 2);
        return;
    L5:
        c(this);
        jz5.e r103 = f245415c;
        if (r103 == null) goto L10;
        r103.i(r100, r101, r102);
        return;
    }

    @Override // hz5.h
    public final void w(String r100, String r101, Throwable r102) {
        if (b() == true) goto L5;
        a(r100, r101, r102, 3);
        return;
    L5:
        c(this);
        jz5.e r103 = f245415c;
        if (r103 == null) goto L10;
        r103.w(r100, r101, r102);
        return;
    }

    public static void a(String r100, String r101, Throwable r102, int r103) {
        a r104 = new a(r100, r101, r103, r102);
        ConcurrentLinkedQueue<a> r105 = f245413a;
        if (r105.size() <= 1000) goto L5;
        r105.poll();
    L5:
        r105.offer(r104);
    }
}

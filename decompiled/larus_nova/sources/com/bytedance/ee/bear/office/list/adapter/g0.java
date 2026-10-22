package com.bytedance.ee.bear.office.list.adapter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class g0 {

    public static final class a extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f235767a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f235767a, ((a) r100).f235767a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f235767a.hashCode();
        }

        public final String toString() {
            return "Disabled(tips=" + this.f235767a + ')';
        }

        public a() {
            this(com.bytedance.ee.bear.more.office.f.c());
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f235767a = r100;
        }
    }

    public static final class b extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f235768a = null;

        static {
            f235768a = new b();
        }

        public b() {
        }
    }

    public static final class c extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f235769a = null;

        static {
            f235769a = new c();
        }

        public c() {
        }
    }

    public g0() {
    }
}

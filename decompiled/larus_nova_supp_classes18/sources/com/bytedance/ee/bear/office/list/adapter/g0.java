package com.bytedance.ee.bear.office.list.adapter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class g0 {

    public static final class a extends g0 {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Disabled(tips=" + this.a + ')';
        }

        public a() {
            this(com.bytedance.ee.bear.more.office.f.c());
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            this.a = r2;
        }
    }

    public static final class b extends g0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends g0 {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public g0() {
    }
}

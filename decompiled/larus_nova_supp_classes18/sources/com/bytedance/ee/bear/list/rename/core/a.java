package com.bytedance.ee.bear.list.rename.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.rename.core.a$a, reason: collision with other inner class name */
    public static final class C0033a extends a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0033a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0033a) r4).a) == true) goto L11;
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

        public C0033a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}

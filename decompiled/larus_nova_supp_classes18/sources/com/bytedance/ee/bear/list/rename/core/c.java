package com.bytedance.ee.bear.list.rename.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class c {

    public static final class a extends c {
        public final String a;
        public final Throwable b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Throwable r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failed(tips=" + this.a + ", error=" + this.b + ')';
        }

        public a(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends c {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public c() {
    }
}

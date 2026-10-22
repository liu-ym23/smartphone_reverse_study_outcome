package com.bytedance.android.livesdk.ktvimpl.base.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class c<L, R> {

    public static final class a<L> extends c {
        public final L a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            L r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Left(a=" + this.a + ")";
        }

        public a(L r1) {
            this.a = r1;
        }
    }

    public static final class b<R> extends c {
        public final R a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            R r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Right(b=" + this.a + ")";
        }

        public b(R r1) {
            this.a = r1;
        }
    }

    public c() {
    }
}

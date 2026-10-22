package com.bytedance.android.window.shop.innerflow.repo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class e<T> {

    public static final class a<T> extends e<T> {
        public a() {
        }
    }

    public static final class b<T> extends e<T> {
        public b() {
        }
    }

    public static final class c<T> extends e<T> {
        public c() {
        }
    }

    public static final class d<T> extends e<T> {
        public final T a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((d) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(vo=" + this.a + ")";
        }

        public d(T r1) {
            this.a = r1;
        }
    }

    public e() {
    }
}

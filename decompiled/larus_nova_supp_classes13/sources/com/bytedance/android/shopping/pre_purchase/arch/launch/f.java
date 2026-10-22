package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class f<T extends j> {

    public static final class a<T extends j> extends f<T> {
        public final Throwable a;
        public final T b;

        public a() {
            throw null;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Throwable r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Failure(error=" + this.a + ", fallbackData=" + this.b + ")";
        }

        public a(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
            this.b = null;
        }
    }

    public static final class b<T extends j> extends f<T> {
        public final T a;

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
            T r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.a + ")";
        }

        public b(T r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public f() {
    }
}

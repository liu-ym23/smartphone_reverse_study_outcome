package lx9;

import com.larus.suggest.impl.wcb.policy.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface a {

    /* JADX INFO: renamed from: lx9.a$a, reason: collision with other inner class name */
    public static final class C6749a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f511233a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6749a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f511233a, ((C6749a) r100).f511233a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f511233a.hashCode();
        }

        public final String toString() {
            return "Initial(current=" + this.f511233a + ')';
        }

        public C6749a(z r100) {
            Intrinsics.checkNotNullParameter(r100, "current");
            this.f511233a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f511234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z f511235b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f511234a, r101.f511234a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f511235b, r101.f511235b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f511234a.hashCode() * 31) + this.f511235b.hashCode();
        }

        public final String toString() {
            return "Switched(previous=" + this.f511234a + ", current=" + this.f511235b + ')';
        }

        public b(z r100, z r101) {
            Intrinsics.checkNotNullParameter(r100, "previous");
            Intrinsics.checkNotNullParameter(r101, "current");
            this.f511234a = r100;
            this.f511235b = r101;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f511236a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f511236a, ((c) r100).f511236a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f511236a.hashCode();
        }

        public final String toString() {
            return "Unchanged(current=" + this.f511236a + ')';
        }

        public c(z r100) {
            Intrinsics.checkNotNullParameter(r100, "current");
            this.f511236a = r100;
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lx9.d f511237a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f511237a, ((d) r100).f511237a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f511237a.hashCode();
        }

        public final String toString() {
            return "Unsupported(key=" + this.f511237a + ')';
        }

        public d(lx9.d r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f511237a = r100;
        }
    }
}

package za9;

import com.larus.gallery.api.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class a {

    /* JADX INFO: renamed from: za9.a$a, reason: collision with other inner class name */
    public static final class C8436a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<k> f571102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f571103b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8436a) == true) goto L8;
            return false;
        L8:
            C8436a r101 = (C8436a) r100;
            if (Intrinsics.areEqual(this.f571102a, r101.f571102a) == true) goto L12;
            return false;
        L12:
            if (this.f571103b == r101.f571103b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f571102a.hashCode() * 31) + this.f571103b;
        }

        public final String toString() {
            return "AppendRefresh(list=" + this.f571102a + ", initialPosition=" + this.f571103b + ')';
        }

        public C8436a(List<k> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.f571102a = r100;
            this.f571103b = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<k> f571104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f571105b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f571104a, r101.f571104a) == true) goto L12;
            return false;
        L12:
            if (this.f571105b == r101.f571105b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f571104a.hashCode() * 31) + this.f571105b;
        }

        public final String toString() {
            return "InitRefresh(list=" + this.f571104a + ", initialPosition=" + this.f571105b + ')';
        }

        public b(List<k> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.f571104a = r100;
            this.f571105b = r101;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<k> f571106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f571107b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f571106a, r101.f571106a) == true) goto L12;
            return false;
        L12:
            if (this.f571107b == r101.f571107b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f571106a.hashCode() * 31) + this.f571107b;
        }

        public final String toString() {
            return "PrependRefresh(list=" + this.f571106a + ", initialPosition=" + this.f571107b + ')';
        }

        public c(List<k> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.f571106a = r100;
            this.f571107b = r101;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<k> f571108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f571109b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f571108a, r101.f571108a) == true) goto L12;
            return false;
        L12:
            if (this.f571109b == r101.f571109b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f571108a.hashCode() * 31) + this.f571109b;
        }

        public final String toString() {
            return "RemoveRefresh(list=" + this.f571108a + ", currentPosition=" + this.f571109b + ')';
        }

        public d(List<k> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.f571108a = r100;
            this.f571109b = r101;
        }
    }

    public a() {
    }
}

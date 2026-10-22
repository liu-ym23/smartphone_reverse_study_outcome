package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class u {

    public static final class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cy8.c f465913a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f465913a, ((a) r100).f465913a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f465913a.hashCode();
        }

        public final String toString() {
            return "Block(snapshot=" + this.f465913a + ')';
        }

        public a(cy8.c r100) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            this.f465913a = r100;
        }
    }

    public static final class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f465914a = null;

        static {
            f465914a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return -512938871;
        }

        public final String toString() {
            return "Cancel";
        }

        public b() {
        }
    }

    public static final class c extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cy8.c f465915a;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f465915a, ((c) r100).f465915a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            cy8.c r100 = this.f465915a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Done(snapshot=" + this.f465915a + ')';
        }

        public c(cy8.c r100) {
            this.f465915a = r100;
        }
    }

    public static final class d extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f465916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f465917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final cy8.c f465918c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f465916a == r101.f465916a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f465917b, r101.f465917b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f465918c, r101.f465918c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f465916a * 31;
            String r101 = this.f465917b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            cy8.c r105 = this.f465918c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Error(code=" + this.f465916a + ", message=" + this.f465917b + ", snapshot=" + this.f465918c + ')';
        }

        public d(int r100, String r101, cy8.c r102) {
            this.f465916a = r100;
            this.f465917b = r101;
            this.f465918c = r102;
        }
    }

    public u() {
    }
}

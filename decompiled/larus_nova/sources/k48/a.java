package k48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: k48.a$a, reason: collision with other inner class name */
    public static final class C6507a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f501760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f501761b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6507a) == true) goto L8;
            return false;
        L8:
            C6507a r101 = (C6507a) r100;
            if (Intrinsics.areEqual(this.f501760a, r101.f501760a) == true) goto L12;
            return false;
        L12:
            if (this.f501761b == r101.f501761b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f501760a.hashCode() * 31) + this.f501761b;
        }

        public final String toString() {
            return "Fail(reason=" + this.f501760a + ", httpCode=" + this.f501761b + ')';
        }

        public C6507a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f501760a = r100;
            this.f501761b = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f501762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f501763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f501764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f501765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f501766e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f501762a, r101.f501762a) == true) goto L12;
            return false;
        L12:
            if (this.f501763b == r101.f501763b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f501764c, r101.f501764c) == true) goto L18;
            return false;
        L18:
            if (this.f501765d == r101.f501765d) goto L21;
            return false;
        L21:
            if (this.f501766e == r101.f501766e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f501762a.hashCode() * 31) + this.f501763b) * 31) + this.f501764c.hashCode()) * 31;
            if (this.f501765d == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f501766e;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Html(finalUrl=" + this.f501762a + ", redirectCount=" + this.f501763b + ", html=" + this.f501764c + ", limitReached=" + this.f501765d + ", httpCode=" + this.f501766e + ')';
        }

        public b(String r100, int r101, String r102, boolean r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "finalUrl");
            Intrinsics.checkNotNullParameter(r102, "html");
            this.f501762a = r100;
            this.f501763b = r101;
            this.f501764c = r102;
            this.f501765d = r103;
            this.f501766e = r104;
        }
    }

    public a() {
    }
}

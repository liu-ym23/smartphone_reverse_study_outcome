package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f466863a = null;

        static {
            f466863a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return -1252064813;
        }

        public final String toString() {
            return "Idle";
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f466864a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466864a, ((b) r100).f466864a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466864a.hashCode();
        }

        public final String toString() {
            return "LoadFailed(reason=" + this.f466864a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f466864a = r100;
        }
    }

    /* JADX INFO: renamed from: d49.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes27.dex */
    public static final class C5633c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z39.a f466865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f466866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f466867c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5633c) == true) goto L8;
            return false;
        L8:
            C5633c r101 = (C5633c) r100;
            if (Intrinsics.areEqual(this.f466865a, r101.f466865a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f466866b, r101.f466866b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f466867c, r101.f466867c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            z39.a r100 = this.f466865a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f466866b.hashCode()) * 31;
            String r104 = this.f466867c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "LoadSuccess(response=" + this.f466865a + ", deviceVersion=" + this.f466866b + ", newVersion=" + this.f466867c + ')';
        }

        public C5633c(z39.a r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "deviceVersion");
            this.f466865a = r100;
            this.f466866b = r101;
            this.f466867c = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f466868a = null;

        static {
            f466868a = new d();
        }

        public d() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            d r101 = (d) r100;
            return true;
        }

        public final int hashCode() {
            return 200501981;
        }

        public final String toString() {
            return "Loading";
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z39.a f466870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f466871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f466872d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f466869a == r101.f466869a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f466870b, r101.f466870b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f466871c, r101.f466871c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f466872d, r101.f466872d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f466869a * 31) + this.f466870b.hashCode()) * 31) + this.f466871c.hashCode()) * 31) + this.f466872d.hashCode();
        }

        public final String toString() {
            return "OTAFailed(otaTaskId=" + this.f466869a + ", response=" + this.f466870b + ", reason=" + this.f466871c + ", deviceVersion=" + this.f466872d + ')';
        }

        public e(int r100, z39.a r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "response");
            Intrinsics.checkNotNullParameter(r102, "reason");
            Intrinsics.checkNotNullParameter(r103, "deviceVersion");
            this.f466869a = r100;
            this.f466870b = r101;
            this.f466871c = r102;
            this.f466872d = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z39.a f466874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f466875c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (this.f466873a == r101.f466873a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f466874b, r101.f466874b) == true) goto L15;
            return false;
        L15:
            if (this.f466875c == r101.f466875c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f466873a * 31) + this.f466874b.hashCode()) * 31) + this.f466875c;
        }

        public final String toString() {
            return "OTAProgressing(otaTaskId=" + this.f466873a + ", response=" + this.f466874b + ", progress=" + this.f466875c + ')';
        }

        public f(int r100, z39.a r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "response");
            this.f466873a = r100;
            this.f466874b = r101;
            this.f466875c = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z39.a f466877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f466878c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f466876a == r101.f466876a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f466877b, r101.f466877b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f466878c, r101.f466878c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f466876a * 31) + this.f466877b.hashCode()) * 31) + this.f466878c.hashCode();
        }

        public final String toString() {
            return "OTASuccess(otaTaskId=" + this.f466876a + ", response=" + this.f466877b + ", version=" + this.f466878c + ')';
        }

        public g(int r100, z39.a r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "response");
            Intrinsics.checkNotNullParameter(r102, "version");
            this.f466876a = r100;
            this.f466877b = r101;
            this.f466878c = r102;
        }
    }
}

package x39;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562395a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f562396b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f562396b, ((a) r100).f562396b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f562396b.hashCode();
        }

        public final String toString() {
            return "Failed(reason=" + this.f562396b + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            super(r100);
            this.f562396b = r100;
        }
    }

    /* JADX INFO: renamed from: x39.b$b, reason: collision with other inner class name */
    public static final class C8192b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C8192b f562397b = null;

        static {
            f562397b = new C8192b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8192b) == true) goto L9;
            return false;
        L9:
            C8192b r101 = (C8192b) r100;
            return true;
        }

        public final int hashCode() {
            return 1582308414;
        }

        public final String toString() {
            return "GpsDisabled";
        }

        public C8192b() {
            super("GpsDisabled");
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f562398b = null;

        static {
            f562398b = new c();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return -1252797574;
        }

        public final String toString() {
            return "HotspotEnabled";
        }

        public c() {
            super("HotspotEnabled");
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f562399b = null;

        static {
            f562399b = new d();
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
            return -2038756313;
        }

        public final String toString() {
            return "LocationPermissionDenied";
        }

        public d() {
            super("LocationPermissionDenied");
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f562400b = null;

        static {
            f562400b = new e();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return -722852623;
        }

        public final String toString() {
            return "NearbyPermissionDenied";
        }

        public e() {
            super("NearbyPermissionDenied");
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f562401b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f562401b, ((f) r100).f562401b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f562401b.hashCode();
        }

        public final String toString() {
            return "Success(host=" + this.f562401b + ')';
        }

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            super("Success");
            this.f562401b = r100;
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f562402b = null;

        static {
            f562402b = new g();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            g r101 = (g) r100;
            return true;
        }

        public final int hashCode() {
            return 487139765;
        }

        public final String toString() {
            return "VpnEnabled";
        }

        public g() {
            super("VpnEnabled");
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f562403b = null;

        static {
            f562403b = new h();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            h r101 = (h) r100;
            return true;
        }

        public final int hashCode() {
            return -456060743;
        }

        public final String toString() {
            return "WifiDisabled";
        }

        public h() {
            super("WifiDisabled");
        }
    }

    public b(String r100) {
        this.f562395a = r100;
    }
}

package jd9;

import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes29.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f498752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f498753b;

    public static final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f498754c;

        public a() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f498754c == ((a) r100).f498754c) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f498754c == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Connected";
        }

        public a(boolean r100) {
            super(true);
            this.f498754c = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f498755c = null;

        static {
            f498755c = new b();
        }

        public b() {
            super(true);
        }

        public final String toString() {
            return "Connecting";
        }
    }

    /* JADX INFO: renamed from: jd9.c$c, reason: collision with other inner class name */
    public static final class C6421c {
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f498756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f498757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f498758e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f498759f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f498760g;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f498756c == r101.f498756c) goto L12;
            return false;
        L12:
            if (this.f498757d == r101.f498757d) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f498758e, r101.f498758e) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f498759f, r101.f498759f) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f498760g, r101.f498760g) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f498756c * 31) + this.f498757d) * 31) + this.f498758e.hashCode()) * 31) + this.f498759f.hashCode()) * 31;
            Integer r101 = this.f498760g;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "DISCONNECT";
        }

        public d(int r100, int r101, String r102, String r103, Integer r104) {
            Intrinsics.checkNotNullParameter(r102, "msg");
            Intrinsics.checkNotNullParameter(r103, "detailErrorMsg");
            super(true);
            this.f498756c = r100;
            this.f498757d = r101;
            this.f498758e = r102;
            this.f498759f = r103;
            this.f498760g = r104;
        }

        public static d a(d r100, int r101, int r102, String r103, String r110, Integer r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            r101 = r100.f498756c;
        L5:
            int r104 = r101;
            if ((r112 & 2) == 0) goto L8;
            r102 = r100.f498757d;
        L8:
            int r105 = r102;
            if ((r112 & 4) == 0) goto L11;
            r103 = r100.f498758e;
        L11:
            String r106 = r103;
            if ((r112 & 8) == 0) goto L14;
            r110 = r100.f498759f;
        L14:
            String r107 = r110;
            if ((r112 & 16) == 0) goto L17;
            r111 = r100.f498760g;
        L17:
            Intrinsics.checkNotNullParameter(r106, "msg");
            Intrinsics.checkNotNullParameter(r107, "detailErrorMsg");
            return new d(r104, r105, r106, r107, r111);
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f498761c = null;

        static {
            f498761c = new e();
        }

        public e() {
            super(false);
        }

        public final String toString() {
            return "IDLE";
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f498762c = null;

        static {
            f498762c = new f();
        }

        public f() {
            super(false);
        }

        public final String toString() {
            return "Init";
        }
    }

    static {
    }

    public c(boolean r100) {
        this.f498752a = r100;
    }
}

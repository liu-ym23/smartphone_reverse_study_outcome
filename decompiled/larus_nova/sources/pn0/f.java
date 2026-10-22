package pn0;

import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Triple<Integer, Integer, String> f529921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f529922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f529923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f529924d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f529925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f529926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f529927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f529928d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f529925a == r101.f529925a) goto L8;
            return false;
        L8:
            if (this.f529926b == r101.f529926b) goto L10;
            return false;
        L10:
            if (this.f529927c == r101.f529927c) goto L12;
            return false;
        L12:
            if (this.f529928d == r101.f529928d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f529925a * 31) + this.f529926b) * 31) + this.f529927c) * 31) + this.f529928d;
        }

        public final String toString() {
            return "CanvasUIContainerParams[" + this.f529925a + ", " + this.f529926b + ", " + this.f529927c + ", " + this.f529928d + ']';
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f529925a = r100;
            this.f529926b = r101;
            this.f529927c = r102;
            this.f529928d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f529929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f529930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f529931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f529932d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f529929a == r101.f529929a) goto L8;
            return false;
        L8:
            if (this.f529930b == r101.f529930b) goto L10;
            return false;
        L10:
            if (this.f529931c == r101.f529931c) goto L12;
            return false;
        L12:
            if (this.f529932d == r101.f529932d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f529929a * 31) + this.f529930b) * 31) + this.f529931c) * 31) + this.f529932d;
        }

        public final String toString() {
            return "ContentUIContainerParams[" + this.f529929a + ", " + this.f529930b + ", " + this.f529931c + ", " + this.f529932d + ']';
        }

        public b(int r100, int r101, int r102, int r103) {
            this.f529929a = r100;
            this.f529930b = r101;
            this.f529931c = r102;
            this.f529932d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f529933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f529934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f529935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f529936d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f529937e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f529938f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L18;
            c r101 = (c) r100;
            if (this.f529933a == r101.f529933a) goto L8;
            return false;
        L8:
            if (this.f529934b == r101.f529934b) goto L10;
            return false;
        L10:
            if (this.f529935c == r101.f529935c) goto L12;
            return false;
        L12:
            if (this.f529936d == r101.f529936d) goto L14;
            return false;
        L14:
            if (this.f529937e == r101.f529937e) goto L16;
            return false;
        L16:
            if (this.f529938f == r101.f529938f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            return (((((((((this.f529933a * 31) + this.f529934b) * 31) + this.f529935c) * 31) + this.f529936d) * 31) + this.f529937e) * 31) + this.f529938f;
        }

        public final String toString() {
            return "SeatItemUIContainerParams[" + this.f529933a + ", " + this.f529935c + ", " + this.f529936d + ", " + this.f529937e + ", " + this.f529938f + ']';
        }

        public c(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.f529933a = r100;
            this.f529934b = r101;
            this.f529935c = r102;
            this.f529936d = r103;
            this.f529937e = r104;
            this.f529938f = r105;
        }
    }

    public final String toString() {
        return "absContainerWHAndReason = " + this.f529921a + '\n' + this.f529922b + ", \n" + this.f529923c + ", ";
    }

    public f(Triple<Integer, Integer, String> r100, a r101, b r102, List<c> r103) {
        Intrinsics.checkNotNullParameter(r100, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r101, "canvasUIContainerParams");
        Intrinsics.checkNotNullParameter(r102, "contentUIContainerParams");
        Intrinsics.checkNotNullParameter(r103, "seatItemParams");
        this.f529921a = r100;
        this.f529922b = r101;
        this.f529923c = r102;
        this.f529924d = r103;
    }
}

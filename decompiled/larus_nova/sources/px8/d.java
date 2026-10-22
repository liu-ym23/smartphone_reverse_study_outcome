package px8;

/* JADX INFO: loaded from: classes26.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f530947a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f530947a == ((a) r100).f530947a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f530947a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Capturing(engineReady=" + this.f530947a + ')';
        }

        public a(boolean r100) {
            this.f530947a = r100;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f530948a = null;

        static {
            f530948a = new b();
        }

        public b() {
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f530949a = null;

        static {
            f530949a = new c();
        }

        public c() {
        }
    }

    /* JADX INFO: renamed from: px8.d$d, reason: collision with other inner class name */
    public static final class C7253d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7253d f530950a = null;

        static {
            f530950a = new C7253d();
        }

        public C7253d() {
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f530951a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f530951a, ((e) r100).f530951a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f530951a);
        }

        public final String toString() {
            return "HoldRecordingRatio(ratio=" + this.f530951a + ')';
        }

        public e(float r100) {
            this.f530951a = r100;
        }
    }

    public static final class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f530952a = null;

        static {
            f530952a = new f();
        }

        public f() {
        }
    }

    public d() {
    }
}

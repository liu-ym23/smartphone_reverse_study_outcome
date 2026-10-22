package z64;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f570471a = null;

        static {
            f570471a = new a();
        }

        public a() {
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f570472a = null;

        static {
            f570472a = new b();
        }

        public b() {
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f570473a = null;

        static {
            f570473a = new c();
        }

        public c() {
        }
    }

    public static final class d extends h {
        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L6;
            ((d) r100).getClass();
            return true;
        L6:
            return false;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "Timeout(timeoutMs=0)";
        }
    }

    public static final class e extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f570474a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L13:
            return true;
        L5:
            if ((r100 instanceof e) == true) goto L7;
        L12:
            return false;
        L7:
            if (this.f570474a != ((e) r100).f570474a) goto L9;
            boolean r101 = true;
        L10:
            if (r101 == false) goto L12;
        L9:
            r101 = false;
            goto L10
        }

        public final int hashCode() {
            return this.f570474a;
        }

        public final String toString() {
            return "TimeoutWithRetry(timeoutMs=" + this.f570474a + ")";
        }

        public e(int r100) {
            this.f570474a = r100;
            if (r100 <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("timeoutMs must be greater than 0".toString());
        L5:
            r101 = false;
            goto L6
        }
    }

    public h() {
    }
}

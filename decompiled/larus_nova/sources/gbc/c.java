package gbc;

/* JADX INFO: loaded from: classes38.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f480812a = null;

        static {
            f480812a = new a();
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
            return 1646159866;
        }

        public final String toString() {
            return "InputSent";
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f480813a = null;

        static {
            f480813a = new b();
        }

        public b() {
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
            return 1229468895;
        }

        public final String toString() {
            return "InputStarted";
        }
    }

    /* JADX INFO: renamed from: gbc.c$c, reason: collision with other inner class name */
    public static final class C6007c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6007c f480814a = null;

        static {
            f480814a = new C6007c();
        }

        public C6007c() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6007c) == true) goto L9;
            return false;
        L9:
            C6007c r101 = (C6007c) r100;
            return true;
        }

        public final int hashCode() {
            return -796841246;
        }

        public final String toString() {
            return "SlideCanceled";
        }
    }
}

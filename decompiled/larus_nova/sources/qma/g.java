package qma;

/* JADX INFO: loaded from: classes34.dex */
public abstract class g {

    public static final class a extends g {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "Count(count=0)";
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f533959a = null;

        static {
            f533959a = new b();
        }

        public b() {
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f533960a = null;

        static {
            f533960a = new c();
        }

        public c() {
        }
    }

    public g() {
    }
}

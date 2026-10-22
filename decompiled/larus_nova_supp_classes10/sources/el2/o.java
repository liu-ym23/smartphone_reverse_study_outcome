package el2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface o {
    public static final a a = null;

    public static final class a {
        public static final C0138a a = null;
        public static final /* synthetic */ a b = null;

        /* JADX INFO: renamed from: el2.o$a$a, reason: collision with other inner class name */
        public static final class C0138a implements o {
            public C0138a() {
            }

            @Override // el2.o
            public final String a() {
                return "";
            }

            @Override // el2.o
            public final String getBioType() {
                return "";
            }

            @Override // el2.o
            public final String getSdkVersion() {
                return "";
            }
        }

        public a() {
        }

        static {
            b = new a();
            a = new C0138a();
        }
    }

    static {
        a = a.b;
    }

    String a();

    String getBioType();

    String getSdkVersion();
}

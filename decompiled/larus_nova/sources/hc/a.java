package hc;

/* JADX INFO: loaded from: classes43.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6123a f484517a = null;

    /* JADX INFO: renamed from: hc.a$a, reason: collision with other inner class name */
    public static final class C6123a implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C6123a f484518b = null;

        public C6123a() {
        }

        static {
            f484518b = new C6123a();
        }

        @Override // hc.a
        public final b run() {
            return new b(Boolean.TRUE);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f484519a;

        public final String toString() {
            return "ExpressionResult(success=true, result=" + this.f484519a + ')';
        }

        public b(Object r100) {
            this.f484519a = r100;
        }
    }

    static {
        f484517a = C6123a.f484518b;
    }

    b run();
}

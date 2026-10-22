package wd9;

/* JADX INFO: loaded from: classes4.dex */
public interface a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C8097a f559312a = null;

    /* JADX INFO: renamed from: wd9.a$a, reason: collision with other inner class name */
    public static final class C8097a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C8097a f559313a = null;

        static {
            f559313a = new C8097a();
        }

        public C8097a() {
        }

        public static String a(String r100, Object r101) {
            if (r100 != null) goto L4;
        L7:
            boolean r102 = true;
        L8:
            if (r102 == true) goto L13;
            if (r101 != null) goto L12;
            return null;
        L12:
            return r100 + '_' + r101.hashCode();
        L13:
            return null;
        L4:
            if (r100.length() == 0) goto L7;
            r102 = false;
            goto L8
        }
    }

    static {
        f559312a = C8097a.f559313a;
    }
}

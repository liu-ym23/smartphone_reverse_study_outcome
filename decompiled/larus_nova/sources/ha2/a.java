package ha2;

/* JADX INFO: loaded from: classes9.dex */
public interface a {

    /* JADX INFO: renamed from: ha2.a$a, reason: collision with other inner class name */
    public static final class C6116a {
        public static /* synthetic */ void a(a r100, boolean r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            r102 = null;
        L5:
            r100.b(r101, r102, null, null);
        }
    }

    void a(boolean r100, String r101, boolean r102);

    void b(boolean r100, String r101, String r102, String r103);

    void c(boolean r100, String r101, boolean r102);

    boolean d();

    void e(boolean r100, String r101, boolean r102);

    void f(String r100, boolean r101);

    void g(String r100, String r101);

    fa2.c getMessageHandler();

    void onClear();

    void onEvent(o42.b r100);
}

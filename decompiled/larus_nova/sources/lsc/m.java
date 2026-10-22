package lsc;

/* JADX INFO: loaded from: classes41.dex */
public interface m extends uvc.c {

    /* JADX INFO: loaded from: classes5.dex */
    public interface a {
        void a(m r100, uvc.b r101);

        void b(m r100, uvc.b r101);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface b {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface c<N extends uvc.b> {
        void a(m r100, N r101);
    }

    h B();

    void C(uvc.b r100);

    <N extends uvc.b> void G(N r100, int r101);

    void a();

    void b();

    y builder();

    void c(uvc.b r100);

    c<uvc.b> i(uvc.b r100);

    int length();

    void o(int r100, Object r101);

    void q(uvc.b r100);

    t r();

    boolean s(uvc.b r100);

    <N extends uvc.b> void y(N r100, int r101);
}

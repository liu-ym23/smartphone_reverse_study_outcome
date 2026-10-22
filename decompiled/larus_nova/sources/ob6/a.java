package ob6;

import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager$startRtcEngine$1;
import lb6.d;

/* JADX INFO: loaded from: classes19.dex */
public interface a extends d {

    /* JADX INFO: renamed from: ob6.a$a, reason: collision with other inner class name */
    public interface InterfaceC7033a {
        void A(String r100, Boolean r101);

        void J(String[] r100, boolean[] r101, int[] r102);

        void c();

        void s();

        void t();
    }

    public interface b {
        void a();

        void b(String r100, String r101);

        void d(String r100);

        void g();

        void k(String r100, int r101);

        void l(String r100, int r101);

        void m();

        void onInitSuccess();

        void p(String r100);
    }

    ei6.a A();

    boolean C();

    void destroyEngine();

    void f(com.bytedance.android.live.livelink.guestlink.pipeline.b r100);

    ec6.a n();

    void p();

    void s(String r100);

    void u(GuestLinkPipeLineManager$startRtcEngine$1 r100);
}

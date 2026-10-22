package fr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public interface e extends xh6.c {

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final a f478498a2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f478499a = null;

        public a() {
        }

        static {
            f478499a = new a();
        }
    }

    static {
        f478498a2 = a.f478499a;
    }

    void A(String r100, String r101);

    void A1(boolean r100);

    void B1(IConfig.c r100);

    int D2(ArrayList<g> r100);

    void D4(boolean r100);

    void E3(z r100);

    void G3(IConfig.b r100);

    void H3();

    void J(String r100);

    void J0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104);

    int K3(ArrayList<g> r100, String r101);

    void N0(JSONObject r100);

    int T3(ArrayList<g> r100, String r101);

    u1 X();

    void b0(String r100, int r101, String r102);

    void c(String r100);

    void c4(String r100);

    void dispose();

    void f();

    void g(String r100);

    String getBusinessId();

    IConfig getConfig();

    gr2.h getRtcExtInfo();

    String getRtcRoomId();

    void h(String r100, boolean r101, String r102);

    void j();

    void k(String r100);

    void muteLocalVideo(boolean r100);

    void n();

    void n3(com.bytedance.android.live.revenuelink.rtc.s r100);

    void o();

    void o4(String r100, e0 r101, long r102);

    void p0(boolean r100, String r101);

    void q();

    void r1(String r100, boolean r101);

    void s1();

    void s2(String r100, boolean r101);

    void start();

    void stop(boolean r100);

    void t1();

    void t3(boolean r100, boolean r101);

    void u1(boolean r100);

    void w(String r100);

    void w1(String r100);

    void x1();

    void y(String r100);

    void z1();
}

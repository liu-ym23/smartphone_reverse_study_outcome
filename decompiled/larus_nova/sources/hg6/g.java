package hg6;

import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes19.dex */
public interface g extends eg6.b {

    public static final class a {
        public static /* synthetic */ void a(RtcManager r100, String r101) {
            r100.F0(r101, false);
        }
    }

    boolean A();

    void B(com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc.b r100);

    void D(int r100, String r101);

    void D1(String r100, ByteBuffer r101, int r102);

    void E(boolean r100, int r101);

    fg6.b F();

    void G(vb6.f r100);

    void I(int r100);

    void J(String r100);

    void K();

    int L();

    xi0.b O();

    void P(int r100);

    void Q(String r100);

    ec6.b R();

    @Deprecated(message = "replace by getStatusCenter().getVideoStatusController().muteLocalVideoStream()")
    void S();

    void T();

    void U();

    ei6.a V0();

    void W(LinkmicOnlineFloatWindowManager r100);

    void X(int r100, String r101);

    void Z(com.bytedance.android.live.liveinteract.plantform.core.k r100);

    void a(InteractMode r100);

    void a0(dg6.a r100, ti6.j r101);

    int b();

    void c(String r100);

    void c0(String r100);

    void d(int r100);

    void d0(boolean r100);

    dg6.a e();

    void e0(String r100);

    void f();

    pf6.a f0();

    void f4();

    void g(vb6.f r100);

    void g0(long r100);

    fi6.a getInteractConfig();

    MixStreamType getMixStreamType();

    void i(boolean r100);

    boolean isEngineOn();

    yb6.e j();

    Map<String, yb6.j> m();

    void n();

    ji6.c o();

    void onDestroy();

    void onPause();

    void onResume();

    void p(com.bytedance.android.live.liveinteract.plantform.core.k r100);

    dg6.a r();

    String t();

    String u();

    void v();

    void w(boolean r100);

    ig6.a x();

    int y();

    void z(com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a r100);
}

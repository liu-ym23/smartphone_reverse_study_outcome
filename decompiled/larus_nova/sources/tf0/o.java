package tf0;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.l2;
import com.bytedance.android.live.liveinteract.linkbase.SupportUpdatePlayMode;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import hh1.t0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: classes46.dex */
public interface o {

    public interface a {
        int Aa(SurfaceView r100);

        int Po(String r100);

        HashMap<String, Boolean> Y7();

        j1 Zb();

        z.a c3(String r100);

        void ca(String r100, String r101);

        void d0(p r100, Object r101);

        int dn();

        void f();

        d0 getLiveCore();

        void h(String r100, boolean r101, String r102);

        void kd(String r100, String r101);

        String l6();

        int mc();

        void mk(String r100);

        void n1(boolean r100);

        SurfaceView q1();

        void r1(String r100, boolean r101);

        void v4(String r100, boolean r101);
    }

    void A();

    void B(l2 r100);

    t0 C();

    int C0();

    FrameLayout D();

    j E();

    void F();

    void G();

    List<bd0.b> H(boolean r100);

    boolean J();

    void K();

    void L();

    void M(boolean r100, String r101, int r102);

    void N();

    void O();

    void P();

    void R();

    void S(String r100, int r101, int r102);

    void a(View r100, MotionEvent r101);

    void b(String r100);

    void c(String r100, boolean r101);

    List<e> e();

    void end();

    void exitRoom();

    void f();

    void g(d0 r100);

    ViewGroup getFirstSeatVHShadowContainer();

    ViewGroup getFirstSeatVHShadowFloatContainer();

    List<s0> getHeadPointList();

    j getLinkWindowLayoutConfig();

    sf0.b getLinkmicAreaFrameInfo();

    RecyclerView getMicSeatRecyclerView();

    sf0.c getTopLeftSeatFrameInfo();

    int getUserCount();

    int h(String r100);

    void i();

    boolean isDynamicAnimating();

    void j(int r100, int r101);

    int k(String r100);

    void l(boolean r100, Pair<Integer, Integer> r101, Pair<Integer, Integer> r102);

    void m(@SupportUpdatePlayMode int r100);

    int o();

    void o0();

    void onResume();

    void onSeiUpdated(SeiAppData r100);

    void onTalkStateUpdated(String[] r100, boolean[] r101);

    void p();

    int q0(List<ti6.f> r100, Map<String, Integer> r101);

    void r(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r100, Boolean r101);

    void s();

    void setDynamicAnimatorListener(Function0<Unit> r100);

    void t(String r100);

    void u(Boolean r100);

    FrameLayout v();

    void v3(Map<String, Long> r100);

    void w();

    void y(int r100, int r101);

    void z();

    void z0(boolean r100, String r101);
}

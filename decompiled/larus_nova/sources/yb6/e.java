package yb6;

import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager$mRtcInfoListener$1;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import uf2.b1;
import zf2.k0;

/* JADX INFO: loaded from: classes19.dex */
public interface e extends vb6.d {
    void A(LinkPipelineManager.e r100);

    void B(StreamType r100, String r101);

    void D(LinkPipelineManager$mRtcInfoListener$1 r100);

    void G();

    void H(g r100, LinkPipelineManager.h r101);

    void I(String r100);

    int J();

    n K();

    void L(String r100);

    boolean N();

    h O();

    void P(StreamType r100, String r101);

    void Q(ei6.a r100, String r101);

    void S(String r100);

    void T(LinkPipelineManager.d r100);

    j U(String r100);

    void V(LinkPipelineManager$mRtcInfoListener$1 r100);

    int W(List<ui6.a> r100);

    void X(String r100);

    void Y(String r100);

    void Z(StreamType r100, String r101, String r102);

    ei6.a Z0();

    void a(InteractMode r100);

    boolean a0(StreamType r100);

    void b(String r100);

    void b0(boolean r100, int r101, ArrayList<String> r102, String r103);

    void c(String r100);

    void c0(fi6.a r100, LinkPipelineManager.i r101);

    void d();

    void d0(StreamType r100, String r101);

    void disableRemoteOrientation();

    void e();

    void e0(LinkPipelineManager.e r100);

    void f(String r100);

    void g0(boolean r100, String r101);

    void i(boolean r100);

    void j();

    int k(String r100);

    void k0(LinkPipelineManager.d r100);

    int l(String r100);

    void l0();

    Map<String, j> m();

    boolean m0();

    void n();

    void n0(int r100);

    void o();

    void o0(Map<String, j> r100);

    boolean p();

    void q();

    void q0(boolean r100, boolean r101, boolean r102, boolean r103, String r104, LinkPipelineManager.l r105);

    void r(b1 r100);

    ec6.a r0();

    void s0(ec6.a r100, String r101);

    void t(StreamType r100, String r101, String r102);

    void u(k0 r100, int r101);

    void v();

    void w(String r100);

    MixStreamType x();

    void z(StreamType r100, String r101);

    void z0(int r100, int r101);
}

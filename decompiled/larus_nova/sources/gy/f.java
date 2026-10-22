package gy;

import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import hh1.v0;
import java.util.List;
import java.util.Map;
import nc0.s;
import uf2.d0;

/* JADX INFO: loaded from: classes45.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r100, String r101) {
            r100.T(r101, "");
        }
    }

    boolean F();

    boolean G();

    void J(String r100);

    void K();

    s L();

    List<ui6.a> L0();

    String O();

    com.bytedance.android.live.revenuelink.e P();

    void Q(String r100, String r101);

    void T(String r100, String r101);

    void a(InteractMode r100);

    Integer b(Map r100);

    void c(v0 r100, g r101, String r102, i r103);

    String c0();

    void d(f92.c r100);

    void d0(String r100, String r101, int r102, int r103, Map<String, ? extends Object> r104);

    void e(d r100);

    void f();

    String f0();

    Integer g(Map<Long, String> r100, String r101);

    boolean g0();

    d0 getLiveCore();

    void h(String r100, boolean r101, String r102);

    void i(String r100, RTCWaterMarkRegion r101, long r102);

    boolean isEngineOn();

    void j(String r100);

    void k(String r100);

    void l(long r100);

    void m(d r100);

    void muteLocalVideo(boolean r100);

    void n();

    void o();

    void onPause();

    void onResume();

    void u1(boolean r100);
}

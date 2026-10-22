package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.g0;
import com.bytedance.bdinstall.t0;
import com.bytedance.bdinstall.y;
import fx3.e;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import uw3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface g {
    void A(ow3.b r1);

    void A0(boolean r1);

    void A1(boolean r1);

    void B(boolean r1);

    void B0(boolean r1);

    void B1();

    i C();

    boolean C0();

    void C1(boolean r1);

    void D(String r1);

    void D0(long r1);

    void D1();

    void E(String r1);

    void E0(h r1);

    void E1(long r1, t0 r3);

    void F(boolean r1);

    void F0(int r1);

    void F1(int r1);

    void G(boolean r1);

    void G0();

    <T> T G1(String r1, T r2, Class<T> r3);

    void H(View r1, String r2, String r3, JSONObject r4);

    void H0(d0 r1);

    void H1(String r1);

    void I(boolean r1);

    void I0(boolean r1);

    String I1(Context r1, StringBuilder r2, boolean r3, Level r4);

    boolean J();

    void J0(boolean r1);

    void J1(f0 r1);

    void K(ow3.b r1);

    void K0(p r1);

    void K1(int r1, i r2);

    void L(n r1);

    void L0(boolean r1);

    e L1();

    void M(int r1);

    void M0(boolean r1);

    void M1(kx3.b r1);

    void N();

    void N0(boolean r1);

    void O(Context r1, q r2);

    void O0(boolean r1);

    void P(l r1);

    boolean P0();

    void Q(String r1, String r2, String r3, long r4, long r6, JSONObject r8);

    Integer Q0();

    mw3.a R();

    void R0(r r1);

    void S(boolean r1);

    void S0(String r1, String r2, int r3);

    void T();

    void T0(m r1);

    void U(f r1);

    boolean U0();

    y V();

    void V0(String r1, String r2, String r3, long r4, long r6);

    void W(boolean r1);

    void W0(String r1, Bundle r2, String r3, String r4, String r5);

    ex3.e X();

    boolean X0(String r1, JSONObject r2);

    uw3.a Y();

    boolean Y0();

    void Z(k r1);

    void Z0();

    void a(String r1, Object r2);

    void a0(j r1);

    void a1(int r1, j r2);

    void b(Account r1);

    void b0(String r1);

    void b1(boolean r1);

    boolean c();

    boolean c0();

    void c1(DataIsolateKey r1);

    Map<String, String> d();

    void d0(boolean r1);

    void d1(String r1, Throwable r2);

    boolean e();

    String e0();

    void e1();

    void f(boolean r1);

    void f0(boolean r1);

    void f1(long r1);

    void flush();

    void g();

    void g0(boolean r1);

    int g1();

    String getAbSdkVersion();

    String getAid();

    String getAppId();

    com.bytedance.applog.params.b getCommonParams();

    Context getContext();

    String getDid();

    boolean getEncryptAndCompress();

    JSONObject getHeader();

    String getIid();

    q getInitConfig();

    g0 getNetClient();

    String getOpenUdid();

    String getSessionId();

    String getSsid();

    void getSsidGroup(Map<String, String> r1);

    String getUserID();

    String getUserUniqueID();

    m h();

    void h0(String r1);

    void h1(int r1);

    boolean i();

    void i0(boolean r1);

    void i1(int r1);

    boolean isNewUser();

    void j(boolean r1);

    void j0(boolean r1);

    void j1(boolean r1);

    void k(boolean r1);

    boolean k0();

    void k1(h r1);

    void l();

    tw3.b l0();

    void l1(i r1);

    void m(String r1, String r2);

    void m0(Context r1, Map<String, String> r2, boolean r3, Level r4);

    void m1(boolean r1);

    void n(String r1);

    void n0();

    void n1(l r1);

    void o(boolean r1);

    void o0(boolean r1);

    void o1(String r1, String r2);

    void onActivityPause();

    void onActivityResumed(Activity r1);

    void onEvent(String r1);

    void onEvent(String r1, String r2);

    void onEventV3(String r1);

    void onEventV3(String r1, Bundle r2);

    void onEventV3(String r1, JSONObject r2);

    void onInternalEventV3(String r1, JSONObject r2, String r3, String r4, String r5);

    void onMiscEvent(String r1, JSONObject r2);

    void onPause(Context r1);

    void onResume(Context r1);

    void p(String r1, int r2);

    void p0(boolean r1);

    void p1(boolean r1, long r2, t0 r4);

    void q(Proxy r1);

    boolean q0();

    boolean q1();

    void r(JSONObject r1);

    void r0(int r1);

    void r1();

    boolean s(String r1);

    void s0(boolean r1, String r2);

    void s1(HashSet<String> r1, int r2, int r3);

    void setAppLanguageAndRegion(String r1, String r2);

    void setHeaderInfo(HashMap<String, Object> r1);

    void setPageName(String r1);

    void setUserUniqueID(String r1);

    void start();

    void stop();

    void t(long r1);

    void t0(String r1, int r2);

    void t1(boolean r1);

    k u();

    void u0(Context r1, JSONObject r2);

    void u1(boolean r1);

    IBDAccountCallback v();

    void v0(List<String> r1, boolean r2);

    void v1(IBDAccountCallback r1);

    String w(Context r1, String r2, boolean r3, Level r4);

    void w0(boolean r1);

    void w1();

    void x(boolean r1);

    void x0(j r1);

    void x1(String r1);

    void y();

    void y0(String r1, String r2, String r3, long r4, long r6, String r8);

    void y1(i r1);

    void z(boolean r1);

    void z0(p r1);

    boolean z1();
}

package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import com.obric.sva.sdk.applog.InteractorAppLogLogger;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface n {
    void A();

    void B();

    JSONObject C();

    void D();

    iqa.a E();

    void F(Context r100, boolean r101, m0 r102);

    void G();

    int H();

    void a(String r100);

    void b(eta.b r100);

    void c(boolean r100);

    void d(Bundle r100);

    AppLog e(Context r100);

    void f(boolean r100);

    void g(Map<String, String> r100);

    String getCurrentSessionId();

    String getInstallId();

    String getServerDeviceId();

    String getSessionKey();

    String getUserId();

    com.bytedance.applog.m h();

    void i(String r100, JSONObject r101);

    void j(boolean r100);

    void k();

    void l(a0.a r100);

    JSONObject m();

    void n(InteractorAppLogLogger r100);

    void o(com.obric.sva.sdk.applog.a r100);

    void onPause(Context r100);

    void onResume(Context r100);

    void p();

    void q();

    void r();

    void registerHeaderCustomCallback(iqa.a r100);

    void s(String r100, String r101, String r102, long r103, long r104, boolean r105, JSONObject r106);

    void setAnonymous(boolean r100);

    void setSessionKey(String r100);

    void setUserId(long r100);

    void t(String r100);

    void u(AppLog.f r100);

    void v(String r100);

    String w();

    void x(String r100);

    boolean y(String r100);

    void z(m r100);
}

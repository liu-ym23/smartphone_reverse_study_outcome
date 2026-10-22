package jta;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface l {
    void A();

    void a(Context r100);

    void b(eta.b r100);

    void c(boolean r100);

    void d(Context r100, boolean r101);

    void e();

    boolean f(Context r100, JSONObject r101, boolean r102);

    void g();

    int getAppId();

    String getChannel(Context r100);

    String getDeviceId();

    String getInstallId();

    String getRequestId();

    String getVersionName();

    void h(com.ss.android.common.applog.b r100);

    void i();

    void isLocalTest();

    void j(Context r100, String r101);

    boolean k(boolean r100);

    void l(Context r100);

    void m(boolean r100, long r101, n r102);

    void n(boolean r100);

    void o(boolean r100);

    void onPause();

    void onResume();

    void p(g.a r100);

    void q(boolean r100);

    boolean r(Context r100);

    void s(Bundle r100);

    void setAnonymous(boolean r100);

    void setChannel(String r100);

    boolean t();

    void u(int r100);

    void v(Context r100);

    void w(String r100);

    void x(Map<String, String> r100, Context r101);

    void y(String[] r100, String[] r101);

    void z();
}

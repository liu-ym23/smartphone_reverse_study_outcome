package fr2;

import android.content.Context;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;

/* JADX INFO: loaded from: classes11.dex */
public interface n extends IConfig, xh6.c, xh6.b {
    void E1(String r100);

    boolean F();

    void G4(IConfig.c r100);

    void N3();

    void P2(String r100);

    void R2();

    void R4(boolean r100);

    void S0(IConfig.e r100);

    void S2();

    void S4(IConfig.b r100);

    void U3();

    void V1(b0 r100);

    void V3(p0 r100);

    void W3(String r100);

    void X0(int r100);

    void Z2();

    void e1();

    void e3(IConfig.d r100);

    void e4(boolean r100);

    void f2(String r100);

    Context getContext();

    String getLinkerSessionId();

    gr2.j getMixStreamType();

    IConfig.d getType();

    gr2.g k3();

    void l4(IConfig.a r100);

    void setAppId(String r100);

    void setAppVersion(String r100);

    void setBackgroundColor(String r100);

    void setContext(Context r100);

    void setLinkerSessionId(String r100);

    void setProjectKey(String r100);

    void setRtcExtInfo(String r100);
}

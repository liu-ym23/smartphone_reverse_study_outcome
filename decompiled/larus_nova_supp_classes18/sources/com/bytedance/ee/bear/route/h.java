package com.bytedance.ee.bear.route;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.maintab.export.TabAppInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface h {

    public interface a {
        void onResult(boolean r1);
    }

    public interface b {
        Intent a();
    }

    boolean D4(String r1);

    void H6(String r1, String r2);

    void K8();

    void N9(String r1, String r2);

    void P3(String r1, String r2, String r3, Bundle r4, com.bytedance.ee.bear.basesdk.services.route.b.b r5);

    void Pb(String r1, com.ss.android.lark.maintab.export.a r2, boolean r3);

    com.ss.android.lark.maintab.export.a Pd(String r1);

    void R3(Context r1, String r2, RouteBean r3);

    void Td(d r1);

    Intent W0();

    void X8(Activity r1);

    boolean Xb(String r1);

    void Xc(String r1, String r2, TabAppInfo.CustomNavigationAppLogoType r3);

    void Y3(com.ss.android.lark.maintab.export.a r1);

    void d4(String r1, com.ss.android.lark.maintab.export.a r2);

    void g3(String r1, String r2);

    Activity getActivity();

    Activity getCurrentActivity();

    void m9(String r1, RouteBean r2);

    void pc(z05.h r1, Class r2, Class r3);

    void re(ra5.h r1);

    void s5(d r1);

    void setActivity(Activity r1);

    void u5(String r1);

    PostCard w2(String r1);

    PostCard yd(String r1, RouteBean r2);
}

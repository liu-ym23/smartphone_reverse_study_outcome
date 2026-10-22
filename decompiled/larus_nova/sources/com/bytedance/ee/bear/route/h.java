package com.bytedance.ee.bear.route;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.maintab.export.TabAppInfo;

/* JADX INFO: loaded from: classes18.dex */
public interface h {

    public interface a {
        void onResult(boolean r100);
    }

    public interface b {
        Intent a();
    }

    boolean D4(String r100);

    void H6(String r100, String r101);

    void K8();

    void N9(String r100, String r101);

    void P3(String r100, String r101, String r102, Bundle r103, com.bytedance.ee.bear.basesdk.services.route.b.C2981b r104);

    void Pb(String r100, com.ss.android.lark.maintab.export.a r101, boolean r102);

    com.ss.android.lark.maintab.export.a Pd(String r100);

    void R3(Context r100, String r101, RouteBean r102);

    void Td(d r100);

    Intent W0();

    void X8(Activity r100);

    boolean Xb(String r100);

    void Xc(String r100, String r101, TabAppInfo.CustomNavigationAppLogoType r102);

    void Y3(com.ss.android.lark.maintab.export.a r100);

    void d4(String r100, com.ss.android.lark.maintab.export.a r101);

    void g3(String r100, String r101);

    Activity getActivity();

    Activity getCurrentActivity();

    void m9(String r100, RouteBean r101);

    void pc(z05.h r100, Class r101, Class r102);

    void re(ra5.h r100);

    void s5(d r100);

    void setActivity(Activity r100);

    void u5(String r100);

    PostCard w2(String r100);

    PostCard yd(String r100, RouteBean r101);
}

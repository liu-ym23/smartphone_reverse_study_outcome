package com.bytedance.ee.bear.middleground.permission.email;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends com.bytedance.ee.bear.route.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/permission/invite/email/route/activity";
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        String r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.f222574o;
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L47;
        if (r101 == null) goto L10;
        String r105 = r101.f222561b;
    L12:
        if (TextUtils.isEmpty(r105) == true) goto L47;
        if (r102 == null) goto L21;
        Bundle r106 = r102.f236649n;
        if (r106 == null) goto L21;
        if (r106.getBoolean("key_has_auth") != true) goto L21;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L26;
        tt5.a.h("InviteEmailRouteInterceptor", "onIntercept()...has auth.");
        return false;
    L26:
        com.ss.android.lark.storage.kv.repo.a r108 = ay4.b.d("scene_invite_email", 6);
        if (r101 == null) goto L30;
        String r109 = r101.f222561b;
        if (r109 == null) goto L30;
    L31:
        String r110 = r108.getString(r109, null);
        if (r101 == null) goto L35;
        r103 = r101.f222574o;
    L35:
        if (TextUtils.equals(r110, r103) == false) goto L38;
        tt5.a.h("InviteEmailRouteInterceptor", "onIntercept()...cache auth.");
        return false;
    L38:
        tt5.a.h("InviteEmailRouteInterceptor", "route()...");
        if (r102 != null) goto L41;
        RouteBean r111 = new RouteBean();
    L43:
        if (r111.f236649n != null) goto L45;
        r111.f236649n = new Bundle();
    L45:
        r111.f236649n.putBoolean("key_has_auth", true);
        d(r101, r102).o("key_bear_url", r101).o("extra_intent_data", r102).e();
        return true;
    L41:
        r111 = r102;
    L30:
        r109 = "";
    L21:
        r107 = false;
        goto L23
    L10:
        r105 = null;
    L47:
        return false;
    L5:
        r104 = null;
        goto L7
    }
}

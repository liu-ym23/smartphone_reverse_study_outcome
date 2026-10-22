package com.bytedance.ee.bear.middleground.permission.email;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends com.bytedance.ee.bear.route.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/permission/invite/email/route/activity";
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r7, BearUrl r8, RouteBean r9) {
        String r10 = null;
        if (r8 == null) goto L5;
        String r0 = r8.o;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L47;
        if (r8 == null) goto L10;
        String r1 = r8.b;
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L47;
        if (r9 == null) goto L21;
        Bundle r3 = r9.n;
        if (r3 == null) goto L21;
        if (r3.getBoolean("key_has_auth") != true) goto L21;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L26;
        tt5.a.h("InviteEmailRouteInterceptor", "onIntercept()...has auth.");
        return false;
    L26:
        com.ss.android.lark.storage.kv.repo.a r5 = ay4.b.d("scene_invite_email", 6);
        if (r8 == null) goto L30;
        String r6 = r8.b;
        if (r6 == null) goto L30;
    L31:
        String r11 = r5.getString(r6, null);
        if (r8 == null) goto L35;
        r10 = r8.o;
    L35:
        if (TextUtils.equals(r11, r10) == false) goto L38;
        tt5.a.h("InviteEmailRouteInterceptor", "onIntercept()...cache auth.");
        return false;
    L38:
        tt5.a.h("InviteEmailRouteInterceptor", "route()...");
        if (r9 != null) goto L41;
        RouteBean r12 = new RouteBean();
    L43:
        if (r12.n != null) goto L45;
        r12.n = new Bundle();
    L45:
        r12.n.putBoolean("key_has_auth", true);
        d(r8, r9).o("key_bear_url", r8).o("extra_intent_data", r9).e();
        return true;
    L41:
        r12 = r9;
    L30:
        r6 = "";
    L21:
        r4 = false;
        goto L23
    L10:
        r1 = null;
    L47:
        return false;
    L5:
        r0 = null;
        goto L7
    }
}

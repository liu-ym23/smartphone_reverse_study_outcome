package com.bytedance.ee.bear.wikiv2.route;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends com.bytedance.ee.bear.route.b {
    public p() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/wikiv2/home/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r5, final BearUrl r6, final RouteBean r7) {
        if (r6 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L20;
        tt5.a.h("WikiTabRouteInterceptorV2", "dispatchUrl()..." + r6.a);
        if (AppInfoUtils.e().booleanValue() == false) goto L13;
        return false;
    L13:
        if (g(r5, r6, r7) == true) goto L19;
        tt5.a.h("WikiTabRouteInterceptorV2", "openWikiHomePage: ");
        if (TextUtils.equals(r6.h, "appcenter") == false) goto L17;
        String r8 = "app_center";
    L18:
        gq5.c.a(r8);
        final Bundle r9 = new Bundle();
        r9.putString("command", "check_wiki_tab_exit");
        Flowable.just("").subscribeOn(fo5.d.b()).map(new j()).map(new k(r9)).subscribe(new h(this, r6, r7), new i(this, r6, r7));
        goto L19
    L17:
        r8 = "home_link";
    L19:
        return true;
    L20:
        return false;
    L5:
        if (TextUtils.equals(r6.a, "wiki_home") == false) goto L7;
        r2 = true;
        goto L8
    }
}

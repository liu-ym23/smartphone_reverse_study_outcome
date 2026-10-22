package com.bytedance.ee.bear.basesdk.services.route;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends com.bytedance.ee.bear.route.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f206674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t45.c f206675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f206676c;

    public a(t45.c r100, h r101) {
        this.f206674a = (k) org.koin.java.a.a(k.class);
        this.f206675b = r100;
        this.f206676c = r101;
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        boolean r102 = this.f206675b.X(r100.f222564e);
        tt5.a.h("DefaultUrlRouter", "navigate to default route, isInBlackList = " + r102);
        if (r102 == true) goto L6;
        return "/doc/default/route";
    L6:
        return "/doc/simple_web";
    }

    public final void f(BearUrl r100, RouteBean r101) {
        tt5.a.h("DefaultUrlRouter", "onInterceptBySpaceKit()...");
        if (this.f206676c != null) goto L7;
        tt5.a.d("DefaultUrlRouter", "mRouteService is null!");
        return;
    L7:
        if (TextUtils.isEmpty(r100.f222564e) == false) goto L9;
        d(r100, r101).i("web_url", "https://docs.bytedance.net/app/upgrade/").e();
        return;
    L9:
        d(r100, r101).i("web_url", r100.f222564e).e();
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        tt5.a.h("DefaultUrlRouter", "onIntercept()...url = " + du5.b.g(r101.f222564e));
        if (this.f206676c != null) goto L7;
        tt5.a.d("DefaultUrlRouter", "mRouteService is null!");
        return false;
    L7:
        if (r102 == null) goto L11;
        Bundle r103 = r102.f236649n;
        if (r103 == null) goto L11;
        boolean r104 = r103.getBoolean("encodeValue", true);
    L12:
        k r105 = this.f206674a;
        String r106 = r101.f222564e;
        if (r102 == null) goto L15;
        Bundle r107 = r102.f236649n;
    L16:
        r105.b(r106, r104, r107);
        return true;
    L15:
        r107 = null;
    L11:
        r104 = true;
        goto L12
    }
}

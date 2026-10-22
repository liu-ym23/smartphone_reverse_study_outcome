package com.bytedance.ee.bear.lynx.impl.route;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.lynx.api.e;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends com.bytedance.ee.bear.route.a implements com.bytedance.ee.bear.lynx.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, e> f229902a;

    @Override // com.bytedance.ee.bear.lynx.api.d
    public final b a() {
        return this;
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return null;
    }

    public b() {
        this.f229902a = new HashMap();
    }

    @Override // com.bytedance.ee.bear.lynx.api.d
    public final void c(String r100, e r101) {
        ((HashMap) this.f229902a).put(r100, r101);
        tt5.a.b("LynxRouteInterceptor", "register:" + this);
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (r101 == null) goto L16;
        String r103 = r101.f222564e;
        if (r103 == null) goto L18;
        Uri r104 = UriProtector.parse(r103);
        tt5.a.b("LynxRouteInterceptor", "uri:" + r101.f222564e + " getPath:" + r104.getPath());
        e r105 = (e) ((HashMap) this.f229902a).get(r104.getPath());
        if (r105 == null) goto L19;
        if (r102 == null) goto L13;
        Map<String, String> r106 = r102.f236646k;
        if (r106 == null) goto L13;
        if (r106.size() <= 0) goto L13;
        Map<String, String> r107 = r102.f236646k;
    L14:
        r105.a(r107);
        return true;
    L13:
        r107 = r101.f222563d;
        goto L14
    L19:
        return false;
    L18:
        return false;
    L16:
        return false;
    }
}

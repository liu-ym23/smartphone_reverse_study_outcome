package com.bytedance.ee.bear.lynx.impl.route;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.lynx.api.e;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends com.bytedance.ee.bear.route.a implements com.bytedance.ee.bear.lynx.api.d {
    public final Map<String, e> a;

    @Override // com.bytedance.ee.bear.lynx.api.d
    public final b a() {
        return this;
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return null;
    }

    public b() {
        this.a = new HashMap();
    }

    @Override // com.bytedance.ee.bear.lynx.api.d
    public final void c(String r2, e r3) {
        ((HashMap) this.a).put(r2, r3);
        tt5.a.b("LynxRouteInterceptor", "register:" + this);
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r3, BearUrl r4, RouteBean r5) {
        if (r4 == null) goto L16;
        String r6 = r4.e;
        if (r6 == null) goto L18;
        Uri r7 = UriProtector.parse(r6);
        tt5.a.b("LynxRouteInterceptor", "uri:" + r4.e + " getPath:" + r7.getPath());
        e r8 = (e) ((HashMap) this.a).get(r7.getPath());
        if (r8 == null) goto L19;
        if (r5 == null) goto L13;
        Map<String, String> r0 = r5.k;
        if (r0 == null) goto L13;
        if (r0.size() <= 0) goto L13;
        Map<String, String> r9 = r5.k;
    L14:
        r8.a(r9);
        return true;
    L13:
        r9 = r4.d;
        goto L14
    L19:
        return false;
    L18:
        return false;
    L16:
        return false;
    }
}

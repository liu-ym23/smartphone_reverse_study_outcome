package com.bytedance.ee.bear.list.create;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 {
    public static final Map<String, String> d = null;
    public final NetService a;
    public final com.bytedance.ee.bear.contract.d b;
    public final com.bytedance.ee.bear.contract.b0 c;

    static {
        d = new HashMap();
    }

    public g0() {
        this.a = (NetService) org.koin.java.a.a(NetService.class);
        this.b = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.c = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        Map<String, String> r0 = d;
        ((HashMap) r0).put("lark_survey", "lark_survey");
        ((HashMap) r0).put("base_hp_create_form", "homepage_form");
        ((HashMap) r0).put("space_home_create_form", "space_form");
        ((HashMap) r0).put("wiki_home_create_form", "space_form");
    }

    public final Flowable<DocumentCreateInfo> a(final y0 r6) {
        er5.c r0 = r6.j;
        if (r0 == null) goto L5;
        Flowable r1 = ((er5.b) org.koin.java.a.a(er5.b.class)).k(new er5.a(r0.a, r0.b, null, null)).map(new f0());
    L38:
        return r1.observeOn(fo5.d.b()).map(new z0(r6.getType(), r6.b, r6.d)).observeOn(fo5.d.d()).map(new s()).map(new t(this, r6)).doOnError(new u(r6));
    L5:
        tt5.a.h("DocumentCreateHelper", "buildRequest called");
        int r2 = r6.getType();
        boolean r3 = r6.f;
        tt5.a.h("DocumentCreateHelper", "generateUrlFromFG called");
        if (r3 == true) goto L8;
        String r4 = "/api/explorer/create/";
    L12:
        NetService.f r5 = new NetService.f(r4);
        ((NetService.e) r5).c = 1;
        HashMap r7 = new HashMap();
        tt5.a.h("DocumentCreateHelper", "generateRequestParamFromFG called");
        if (TextUtils.isEmpty(r6.d) == true) goto L16;
        r7.put("parent_token", r6.d);
    L16:
        if (TextUtils.isEmpty(r6.b) == true) goto L18;
        r7.put("name", r6.b);
    L18:
        r7.put("source", String.valueOf(r6.g));
        r7.put(ResourceData.KEY_TYPE, String.valueOf(r6.getType()));
        if (TextUtils.isEmpty(r6.h) == true) goto L22;
        r7.put("scene", r6.h);
    L22:
        if (TextUtils.isEmpty(r6.i) == true) goto L24;
        r7.put("space_id", r6.i);
    L24:
        tt5.a.h("DocumentCreateHelper", "generateRequestParamFromFG: space_id:" + r6.i + " parent_token:" + r6.d);
        if (r6.getType() == sbb.e.f.b) goto L36;
        boolean r8 = r6.f;
        String r9 = r6.c;
        if (r8 == false) goto L33;
        if (TextUtils.isEmpty(r9) == true) goto L35;
        r7.put("content", r9);
    L35:
        r7.put("time_zone", zu5.b.c());
        goto L36
    L33:
        if (TextUtils.isEmpty(r9) == true) goto L35;
        r7.put("origin_content", r9);
    L36:
        r5.d(r7);
        r1 = this.a.Vc(new h0(r6.f)).a(r5);
        goto L38
    L8:
        if (r2 != sbb.e.f.b) goto L10;
        r4 = "/space/api/explorer/v2/create/folder/";
        goto L12
    L10:
        r4 = "/space/api/explorer/v2/create/object/";
        goto L12
    }

    public final Flowable<DocumentCreateInfo> b(final l r6) {
        if (com.bytedance.ee.bear.templates.h.a(r6.l) == true) goto L5;
    L7:
        final boolean r0 = false;
    L8:
        er5.c r1 = r6.p;
        if (r1 == null) goto L11;
        er5.a r2 = new er5.a(r1.a, r1.b, r6.a, r6.k);
        Flowable r3 = ((er5.b) org.koin.java.a.a(er5.b.class)).k(r2).map(new z());
    L13:
        return r3.map(new b0(r6)).map(new c1()).observeOn(fo5.d.b()).map(new z0(r6.c.intValue(), r6.m.c)).map(new c0()).observeOn(fo5.d.d()).map(new d0(this, r6)).doOnError(new e0(r6));
    L11:
        int r4 = com.bytedance.ee.bear.content.creation.location.a.a;
        r3 = com.bytedance.ee.bear.content.creation.location.a.c(r6.m).flatMap(new a0(this, r6, r0));
        goto L13
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.larkform.new.enable") == false) goto L7;
        r0 = true;
        goto L8
    }
}

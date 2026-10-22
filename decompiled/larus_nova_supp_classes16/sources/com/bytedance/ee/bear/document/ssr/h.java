package com.bytedance.ee.bear.document.ssr;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.collections.MapsKt;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ String a;

    public h(String r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        Boolean r16 = (Boolean) r14;
        BearUrl r17 = p.a().Z(this.a);
        if (lbb.a.a(r17.b) == true) goto L60;
        AccountService$Account r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r0 == null) goto L61;
        d25.d.i();
        int r1 = c.a;
        String r2 = r17.b;
        String r3 = r17.a;
        Map<String, String> r4 = r17.d;
        if (r4 != null) goto L11;
        r4 = MapsKt.emptyMap();
    L11:
        String r5 = c.b(r0, r2, r3, r4);
        boolean r6 = true;
        boolean r7 = false;
        if (r5 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == false) goto L23;
        String r9 = r17.b;
        String r10 = r17.a;
        Map<String, String> r11 = r17.d;
        if (r11 != null) goto L22;
        r11 = MapsKt.emptyMap();
    L22:
        r5 = c.a(r0, r9, r10, r11);
    L23:
        if (r5 != null) goto L25;
    L28:
        if (r6 == true) goto L30;
        return;
    L30:
        if (j.a(r17) == false) goto L59;
        tt5.a.h("SsrDataLoader", "fetch ssr before render");
        final OfflineDoc r12 = new OfflineDoc(r17.b, r17.e, r17.a(), "fetch_before_render");
        final n r18 = new n();
        final g r13 = new g();
        tt5.a.h("SsrHtmlRequestProcessor", du5.b.g(r12.getObj_token()) + " start to fetch ssr " + r12.getFrom_source());
        NetService.d r19 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new k());
        String r20 = p.t;
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L38;
        r20 = JSON.parseObject(DocOpenConfig.c()).getJSONObject("doubao").getString("internal_api");     // Catch: Exception -> L35
    L40:
        NetService.f r21 = new NetService.f("/ssr-mobile-app/docx/" + r12.getObj_token());
        r21.i = false;
        r21.a = r20;
        r21.c = 2;
        String r22 = swb.b.a(LarkContext.getApplication());
        if (TextUtils.isEmpty(r22) == false) goto L43;
        r22 = "1.0.0";
    L43:
        r21.b("version", r22);
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L56;
    L50:
        if (r7 == false) goto L52;
        r21.b("scene", "doubaoMiniApp");
    L52:
        tt5.a.h("SsrHtmlRequestProcessor", "host = " + r20 + " path = /ssr-mobile-app/docx/ version = " + r22);
        final long r110 = System.currentTimeMillis();
        r19.a(r21).blockingSubscribe(new l(r18, r110, r13, r12), new m(r18, r12, r110, r13));
        return;
    L56:
        r7 = ((etb.a) LarkContext.spiByDwarf(etb.a.class)).isEnable();     // Catch: Exception -> L48
    L48:
        e = move-exception;
        tt5.a.j("SsrHtmlRequestProcessor", e);
    L35:
        e = move-exception;
        tt5.a.j("SsrHtmlRequestProcessor", e);
        goto L40
    L38:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L40;
        r20 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).f9();
        goto L40
    L59:
        return;
    L25:
        if (r5.length() == 0) goto L28;
        r6 = false;
        goto L28
    L14:
        if (r5.length() == 0) goto L17;
        r8 = false;
        goto L18
    L61:
        return;
    }
}

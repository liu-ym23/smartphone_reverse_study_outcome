package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.x3;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.Flowable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0 extends x3 {
    public final BearUrl f() {
        BearUrl r0 = ((x3) this).b.a().getOriginBearUrl();
        BearUrl r1 = s45.p.a().Z(r0.e);
        WikiInfo r2 = (WikiInfo) g1.a(((x3) this).b).getWikiInfo().getValue();
        if (r2 == null) goto L7;
        String r3 = r2.getObjTypeString();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r1.a = r3;
    L7:
        r1.r = r0.r;
        return r1;
    }

    public final void load() {
        Flowable.fromCallable(new h0(this)).subscribe(new i0(this), new j0(this));
    }

    public k0(DocumentPluginHost r1) {
        super(r1);
        ((x3) this).a = "WikiLoaderV2";
    }

    public static void j(k0 r3) {
        WikiInfo r0 = (WikiInfo) g1.a(((x3) r3).b).getWikiInfo().getValue();
        int r1 = r0.getObjType();
        Map r2 = d25.d.a;
        d25.d.h = sbb.e.f(r1);
        r3.i().E("wikiInfo", r0);
        super.load();
    }

    public final k25.m0 b(BearUrl r6) {
        WikiInfo r0 = (WikiInfo) g1.a(((x3) this).b).getWikiInfo().getValue();
        k25.m0 r2 = null;
        if (r0 == null) goto L9;
        boolean r3 = s1.n;
        s1.B = r0.from_cache ? 1 : 0;
        String r4 = r0.getObjToken();
        AccountService.Account r5 = ((x3) this).h;
        String r1 = r0.getObjTypeString();
        Map r7 = r6.d;
        FetchClientVarExecutor r8 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.a;
        k25.m0 r9 = k25.e0.m().n(n35.a.a(r5, r1), r4);
        if (r9.b() == false) goto L8;
        tt5.a.h("WikiLoaderV2", "clientvar has paged, so return null");
        return null;
    L8:
        r2 = r9;
    L9:
        StringBuilder r10 = new StringBuilder("getClientVarCache success: ");
        if (r2 != null) goto L12;
    L14:
        boolean r11 = false;
    L15:
        r10.append(r11);
        tt5.a.h("WikiLoaderV2", r10.toString());
        return r2;
    L12:
        if (r2.c == null) goto L14;
        r11 = true;
        goto L15
    }

    public final k25.m0 e(BearUrl r5) {
        WikiInfo r0 = (WikiInfo) g1.a(((x3) this).b).getWikiInfo().getValue();
        if (r0 != null) goto L5;
    L17:
        return null;
    L5:
        if (r0.getObjType() == sbb.e.g.b) goto L17;
        k25.m0 r6 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.d(((x3) this).h, r5.a, r0.getObjToken(), r5.d);
        if (r6.b() == false) goto L11;
        tt5.a.h("WikiLoaderV2", "SSR has paged, so return null");
        return null;
    L11:
        StringBuilder r1 = new StringBuilder("getHtmlCache success: ");
        if (r6.c == null) goto L14;
        boolean r2 = true;
    L15:
        r1.append(r2);
        tt5.a.h("WikiLoaderV2", r1.toString());
        return r6;
    L14:
        r2 = false;
        goto L15
    }

    public final void k(Throwable r3, Map<String, String> r4) {
        if (((x3) this).b.a().getOpenSource() != DocsOpenSource.vc) goto L7;
        TitleBar r0 = ((x3) this).b.c().U90();
        if (r0 == null) goto L7;
        r0.setTitleVisibility(false);
        r0.setLeftIconVisibility(false);
        r0.h();
    L7:
        super.k(r3, r4);
    }
}

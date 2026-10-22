package com.bytedance.ee.bear.wikiv2.route;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetWikiObjInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.w;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import yq5.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.route.d {
    public c() {
    }

    public static void c(final z r3) {
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "Verify local record. objToken: " + du5.b.g(r3.c) + ", wikiToken: " + du5.b.g(r3.b));
        new GetWikiObjInfoPuller((NetService) org.koin.java.a.a(NetService.class)).c(new GetWikiObjInfoPuller.Params(r3.b)).map(new w()).subscribe(new a(r3), new b());
    }

    public static String a(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        tt5.a.k("WikiRouteCheckRedirectInterceptor", "concatUrlFragment, sourceUrl is null or empty.");
        return r4;
    L7:
        if (TextUtils.isEmpty(r5) == false) goto L11;
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "concatUrlFragment, uriFragment is null or empty.");
        return r4;
    L11:
        if (r4.contains(r5) == false) goto L30;
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "concatUrlFragment, sourceUrl already contains fragment.");
        return r4;
    L30:
        Uri r0 = UriProtector.parse(r4);     // Catch: Exception -> L16
    L18:
        if (r0 != null) goto L22;
        tt5.a.k("WikiRouteCheckRedirectInterceptor", "concatUrlFragment, parse uri failed.");
        return r4;
    L22:
        if (TextUtils.isEmpty(r0.getFragment()) == true) goto L26;
        tt5.a.k("WikiRouteCheckRedirectInterceptor", "concatUrlFragment, sourceUrl already contains other fragment: " + du5.b.h(r4));
        return r4;
    L26:
        if (r5.startsWith("#") == true) goto L28;
        r5 = "#".concat(r5);
    L28:
        String r6 = r4 + r5;
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "concatUrlFragment, resultUrl: " + du5.b.h(r6));
        return r6;
    L16:
        e = move-exception;
        tt5.a.e("WikiRouteCheckRedirectInterceptor", "concatUrlFragment, parse sourceUrl error:", e, false);
        r0 = null;
        goto L18
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r12, BearUrl r13, RouteBean r14) {
        if (r14 == null) goto L11;
        Bundle r2 = r14.n;
        if (r2 == null) goto L11;
        if (TextUtils.isEmpty(r2.getString("redirect")) == true) goto L11;
        tt5.a.b("WikiRouteCheckRedirectInterceptor", "The url has been redirected! return.");
        return false;
    L11:
        if (fx4.a.g(r13) == false) goto L41;
        z r3 = WikiRouteTable.a(r13.b);
        if (r3 != null) goto L15;
        return false;
    L15:
        if (r3.e == false) goto L71;
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "This wiki has been moved to space, redirect to space. objToken: " + du5.b.g(r3.c) + ", wikiToken: " + du5.b.g(r3.b));
        if (r3.d == 8) goto L68;
    L28:
        if (r14 != null) goto L30;
        RouteBean r1 = new RouteBean();
    L31:
        Bundle r5 = r1.n;
        if (r5 != null) goto L34;
        r5 = new Bundle();
    L34:
        r5.putString("redirect", "move_to_space");
        r1.n = r5;
        String r15 = s45.p.a().Fd(r13.e, sbb.e.f(r3.d), r3.c, r13.d);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.wiki.android.url_fragment_disabled") == false) goto L37;
        tt5.a.k("WikiRouteCheckRedirectInterceptor", "checkWikiMovToSpace, wiki url fragment disabled by FG.");
    L38:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r15, r14);
        gq5.b.c(new gq5.b.a(r3.b, r3.c, Integer.valueOf(r3.d), "space", "hit_cache", r3.g));
        c(r3);
        return true;
    L37:
        r15 = a(r15, r13.p);
        goto L38
    L30:
        r1 = r14;
        goto L31
    L68:
        bn4.a r6 = (bn4.a) org.koin.java.a.a(bn4.a.class);     // Catch: Throwable -> L20
    L22:
        if (r6 == null) goto L28;
        boolean r7 = r6.m();
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "checkWikiMovToSpace: wiki app mode native enabled=" + r7);
        if (r7 == false) goto L28;
        Boolean r8 = r6.d(r3.c);
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "syncCheckBitableAppByToken, isApp: " + r8);
        if (r8 != null) goto L28;
        return false;
    L20:
        th = move-exception;
        tt5.a.e("WikiRouteCheckRedirectInterceptor", "get IBitableAppService error", th, false);
        r6 = null;
        goto L22
    L71:
        return false;
    L41:
        if (((ArrayList) sbb.e.d).contains(r13.a) == true) goto L47;
        if (DocumentType.FILE_NAME.equals(r13.a) == true) goto L47;
        return false;
    L47:
        if ("template_preview".equals(r13.d.get("from")) == false) goto L50;
        return false;
    L50:
        if (TextUtils.equals((CharSequence) r13.d.get("view_doc_history"), String.valueOf(1)) == true) goto L76;
        z r4 = WikiRouteTable.a(r13.b);
        if (r4 != null) goto L55;
        return false;
    L55:
        if (r4.e == true) goto L74;
        tt5.a.h("WikiRouteCheckRedirectInterceptor", "This doc has been moved to wiki, redirect to wiki. objToken: " + du5.b.g(r4.c) + ", wikiToken: " + du5.b.g(r4.b));
        RouteBean r9 = new WikiRouteBean(r4.c, r4.d, r4.b, "", "");
        if (r14 == null) goto L59;
        r9.a = r14.a;
        r9.b = r14.b;
        r9.c = r14.c;
        r9.d = r14.d;
        r9.e = r14.e;
        r9.f = r14.f;
        r9.g = r14.g;
        r9.h = r14.h;
        r9.i = r14.i;
        r9.k = r14.k;
        r9.l = r14.l;
        r9.m = r14.getType();
        r9.n = r14.n;
        r9.j = r14.j;
    L59:
        Bundle r16 = r9.n;
        if (r16 != null) goto L62;
        r16 = new Bundle();
    L62:
        r16.putString("redirect", "move_to_wiki");
        r9.n = r16;
        String r17 = s45.p.a().Fd(r13.e, sbb.e.n.getType(), r4.b, r13.d);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.wiki.android.url_fragment_disabled") == false) goto L65;
        tt5.a.k("WikiRouteCheckRedirectInterceptor", "checkDocMovToWiki, wiki url fragment disabled by FG.");
    L66:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r17, r9);
        gq5.b.c(new gq5.b.a(r4.b, r4.c, Integer.valueOf(r4.d), DocumentType.WIKI_NAME, "hit_cache", r4.g));
        c(r4);
        return true;
    L65:
        r17 = a(r17, r13.p);
        goto L66
    L74:
        return false;
    L76:
        return false;
    }
}

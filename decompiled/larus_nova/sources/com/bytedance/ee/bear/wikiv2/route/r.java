package com.bytedance.ee.bear.wikiv2.route;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends com.bytedance.ee.bear.route.a {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/wikiv2/treehome/activity";
    }

    public r() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        int r103 = 0;
        if (r101 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f222571l) == true) goto L19;
        if (r101.f222571l.startsWith("/wiki/space") == false) goto L9;
    L10:
        String r104 = UriProtector.parse(r101.f222564e).getLastPathSegment();
        if (TextUtils.isEmpty(r104) == true) goto L19;
        r101.f222570k = r104;
        tt5.a.h("WikiTreeHomeRouteInterceptorV2", "route. ");
        WikiTreeActivityContract r105 = new WikiTreeActivityContract();
        r105.setSpaceId(r101.f222570k);
        String r106 = r101.f222563d.get("ccm_open_type");
        if (TextUtils.equals(r106, "lark_wiki_spaceLink") == false) goto L15;
    L16:
        r103 = 1;
    L17:
        r105.setFromShareLink(r103);
        d(r101, r102).o(WikiTreeActivityContract.class.getName(), r105).e();
        return true;
    L15:
        if (TextUtils.equals(r106, "wiki_spaceLink") == false) goto L17;
    L9:
        if (r101.f222571l.startsWith("/wiki/settings") == false) goto L19;
        goto L10
    }
}

package com.bytedance.ee.bear.wikiv2.route;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends com.bytedance.ee.bear.route.a {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/wikiv2/treehome/activity";
    }

    public r() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r5, BearUrl r6, RouteBean r7) {
        int r8 = 0;
        if (r6 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r6.l) == true) goto L19;
        if (r6.l.startsWith("/wiki/space") == false) goto L9;
    L10:
        String r0 = UriProtector.parse(r6.e).getLastPathSegment();
        if (TextUtils.isEmpty(r0) == true) goto L19;
        r6.k = r0;
        tt5.a.h("WikiTreeHomeRouteInterceptorV2", "route. ");
        WikiTreeActivityContract r1 = new WikiTreeActivityContract();
        r1.setSpaceId(r6.k);
        String r2 = (String) r6.d.get("ccm_open_type");
        if (TextUtils.equals(r2, "lark_wiki_spaceLink") == false) goto L15;
    L16:
        r8 = 1;
    L17:
        r1.setFromShareLink(r8);
        d(r6, r7).o(WikiTreeActivityContract.class.getName(), r1).e();
        return true;
    L15:
        if (TextUtils.equals(r2, "wiki_spaceLink") == false) goto L17;
    L9:
        if (r6.l.startsWith("/wiki/settings") == false) goto L19;
        goto L10
    }
}

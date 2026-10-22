package com.bytedance.ee.bear.middleground.record;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.more.pageview2.PageViewFragment;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements wi5.a {
    public b() {
    }

    @Override // wi5.a
    public final void b(String r3, String r4) {
        HashMap r0 = new HashMap();
        r0.put("click", r3);
        r0.put("target", r4);
        a.a("ccm_space_docs_details_click", r0);
    }

    @Override // wi5.a
    public final void c(String r3, int r4, PageViewFragment r5) {
        RouteBean r0 = new RouteBean();
        r0.a(r5);
        r0.q = RouteBean.DestStyle.FLOAT;
        ((h) org.koin.java.a.a(h.class)).yd("/doc/viewhistory/activity", r0).j("TYPE", r4).i("TOKEN", r3).e();
    }

    @Override // wi5.a
    public final void a(String r3, int r4, String r5, Fragment r6) {
        RouteBean r0 = new RouteBean();
        r0.a(r6);
        r0.q = RouteBean.DestStyle.FLOAT;
        ((h) org.koin.java.a.a(h.class)).yd("/doc/privacy/activity", r0).j("TYPE", r4).i("TOKEN", r3).i("FROM", r5).e();
    }
}

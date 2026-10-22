package com.bytedance.ee.bear.lark.sidebar;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReport;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ SidebarDocTabFragment a;

    public d(SidebarDocTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r14) {
        String r16 = ((CommonMorePanelItemData) r14).a;
        com.bytedance.ee.bear.route.h r1 = null;
        switch(r16.hashCode()) {
            case -1969449167: goto L34;
            case -830629437: goto L26;
            case -538919814: goto L18;
            case 2551198: goto L14;
            case 79242641: goto L10;
            case 2073804664: goto L6;
            default: goto L47;
        };
    L47:
        return;
    L6:
        if (r16.equals("FILTER") == false) goto L48;
        this.a.eF();
        return;
    L48:
        return;
    L10:
        if (r16.equals("STYLE") == false) goto L49;
        this.a.WU(!t3.a);
        return;
    L49:
        return;
    L14:
        if (r16.equals("SORT") == false) goto L50;
        this.a.Qi();
        return;
    L50:
        return;
    L18:
        if (r16.equals("TEMPLATE") == false) goto L51;
        TemplateReport.c("from_space_icon");
        com.bytedance.ee.bear.route.h r17 = this.a.N;
        if (r17 == null) goto L23;
        r1 = r17;
    L24:
        t0.x(r1);
        lc5.f.a r18 = lc5.f.a;
        this.a.getClass();
        p r0 = new p("home", this.a.m6(), "more_templates", "ccm_template_systemcenter_view", "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r0, "param");
        r18.I(r0);
        return;
    L23:
        Intrinsics.throwUninitializedPropertyAccessException("routeService");
        goto L24
    L51:
        return;
    L26:
        if (r16.equals("OFFLINE") == false) goto L52;
        com.bytedance.ee.bear.route.h r19 = this.a.N;
        if (r19 == null) goto L31;
        r1 = r19;
    L32:
        r1.w2("/list/space/activity").j("extra_destination", NavigationEnum.MANUAL_OFFLINE.id).e();
        lc5.f.a r110 = lc5.f.a;
        this.a.getClass();
        p r2 = new p("home", this.a.m6(), "offline", "ccm_space_offline_page_view", "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r2, "param");
        r110.I(r2);
        return;
    L31:
        Intrinsics.throwUninitializedPropertyAccessException("routeService");
        goto L32
    L52:
        return;
    L34:
        if (r16.equals("SHARE_WITH_ME") == false) goto L53;
        com.bytedance.ee.bear.route.h r111 = this.a.N;
        if (r111 == null) goto L39;
        r1 = r111;
    L40:
        RouteBean r112 = new RouteBean();
        r112.a(this.a);
        r1.yd("/list/space/activity", r112).j("extra_destination", NavigationEnum.SHARED_SPACE.id).e();
        lc5.f.a r113 = lc5.f.a;
        this.a.getClass();
        p r3 = new p("home", this.a.m6(), "more_share_with_me", "ccm_space_drive_page_view", "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r3, "param");
        r113.I(r3);
        return;
    L39:
        Intrinsics.throwUninitializedPropertyAccessException("routeService");
        goto L40
    }
}

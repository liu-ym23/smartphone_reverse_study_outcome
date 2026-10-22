package ac5;

import android.view.View;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.lark.route.SpaceRouteActivity;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.RouteBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SpaceRouteActivity c;

    public e(SpaceRouteActivity r1) {
        this.c = r1;
    }

    public final void a(View r22) {
        SpaceRouteActivity r1 = this.c;
        if (r1.e != NavigationEnum.WIKI.id) goto L5;
        com.bytedance.ee.bear.route.h r2 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        RouteBean r3 = new RouteBean();
        r3.l = "/search/sub_activity";
        r3.m = FileInfoPuller.CALLER_WIKI;
        r2.w2("/search/sub_activity").j("KEY_SEARCH_OBJ_TYPE", -1).j("KEY_SEARCH_SUB_PAGE_TYPE", 3).i("type", FileInfoPuller.CALLER_WIKI).e();
    L6:
        this.c.getSupportFragmentManager().findFragmentById(2131373275);
        com.bytedance.ee.bear.contract.d r4 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        String r5 = this.c.f;
        lc5.f.a r6 = lc5.f.a;
        lc5.f.a.B(r4, r5);
        SpaceRouteActivity r7 = this.c;
        r6.I(new lc5.p(r7.h, r7.f, r7.g, "search", "search_main_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null));
        return;
    L5:
        t0.B(r1.c.getTitleSnapshot());
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/search/space_search/activity").j("KEY_SEARCH_BAR_DY", this.c.c.getTitleBarHeight()).i("module", b.a(this.c.e)).g(2130772285, 2130772285).e();
        goto L6
    }
}

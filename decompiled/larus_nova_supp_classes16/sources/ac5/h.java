package ac5;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.lark.route.SpaceRouteFragment;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SpaceRouteFragment c;

    public h(SpaceRouteFragment r1) {
        this.c = r1;
    }

    public final void a(View r21) {
        Intrinsics.checkNotNullParameter(r21, "v");
        SpaceRouteFragment r1 = this.c;
        if (r1.h != NavigationEnum.WIKI.id) goto L5;
        com.bytedance.ee.bear.route.h r2 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        RouteBean r3 = new RouteBean();
        r3.l = "/search/sub_activity";
        r3.m = FileInfoPuller.CALLER_WIKI;
        r2.w2("/search/sub_activity").j("KEY_SEARCH_OBJ_TYPE", -1).j("KEY_SEARCH_SUB_PAGE_TYPE", 3).i("type", FileInfoPuller.CALLER_WIKI).e();
    L14:
        String r4 = this.c.i;
        if (r4 == null) goto L17;
        lc5.f.a r5 = lc5.f.a;
        lc5.f.a.B((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), r4);
    L17:
        lc5.f.a r6 = lc5.f.a;
        SpaceRouteFragment r7 = this.c;
        r6.I(new lc5.p(r7.k, r7.i, r7.j, "search", "search_main_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null));
        return;
    L5:
        HomeMainTitleBar r8 = r1.f;
        if (r8 == null) goto L8;
        Bitmap r9 = r8.getTitleSnapshot();
    L9:
        t0.B(r9);
        PostCard r10 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).w2("/search/space_search/activity");
        HomeMainTitleBar r11 = this.c.f;
        if (r11 == null) goto L12;
        int r12 = r11.getTitleBarHeight();
    L13:
        r10.j("KEY_SEARCH_BAR_DY", r12).i("module", b.a(this.c.h)).g(2130772285, 2130772285).e();
        goto L14
    L12:
        r12 = 0;
        goto L13
    L8:
        r9 = null;
        goto L9
    }
}

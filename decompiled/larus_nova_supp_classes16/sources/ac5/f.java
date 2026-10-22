package ac5;

import android.view.View;
import com.bytedance.ee.bear.lark.route.SpaceRouteActivity;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ String c;
    public final /* synthetic */ SpaceRouteActivity d;

    public final void a(View r22) {
        this.d.onMenuCreateClick(r22);
        SpaceRouteActivity r1 = this.d;
        if (r1.e == NavigationEnum.WIKI.id) goto L6;
        lc5.p r2 = new lc5.p(this.c, r1.f, r1.g, "create", "ccm_space_create_new_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r2);
        return;
    }

    public f(SpaceRouteActivity r1, String r2) {
        this.d = r1;
        this.c = r2;
    }
}

package ac5;

import android.view.View;
import com.bytedance.ee.bear.lark.route.SpaceRouteFragment;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SpaceRouteFragment c;
    public final /* synthetic */ String d;

    public final void a(View r22) {
        Intrinsics.checkNotNullParameter(r22, "v");
        this.c.onMenuCreateClick(r22);
        SpaceRouteFragment r1 = this.c;
        if (r1.h == NavigationEnum.WIKI.id) goto L6;
        lc5.f.a.I(new lc5.p(this.d, r1.i, r1.j, "create", "ccm_space_create_new_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null));
        return;
    }

    public g(SpaceRouteFragment r1, String r2) {
        this.c = r1;
        this.d = r2;
    }
}

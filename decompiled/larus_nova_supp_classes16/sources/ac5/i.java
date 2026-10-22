package ac5;

import android.view.View;
import com.bytedance.ee.bear.lark.route.SpaceRouteFragment;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ SpaceRouteFragment a;

    public i(SpaceRouteFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        SpaceRouteFragment r0 = this.a;
        int r1 = r0.h;
        if (r1 != NavigationEnum.WIKI.id) goto L5;
    L8:
        yp5.e.b(r0.requireActivity());
        return;
    L5:
        if (r1 == NavigationEnum.MY_LIBRARY.id) goto L8;
        r0.onMenuCreateClick(r4);
    }
}

package ac5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.lark.route.SpaceRouteFragment;
import com.bytedance.ee.bear.list.create.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ SpaceRouteFragment a;

    public j(SpaceRouteFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        int r0 = SpaceRouteFragment.m;
        tt5.a.h("SpaceRouteFragment", "on select creation type = " + r4);
        if (r4 == null) goto L10;
        SpaceRouteFragment r5 = this.a;
        r5.getClass();
        tt5.a.h("SpaceRouteFragment", "closePopupMenu()...");
        if (r5.g != null) goto L8;
        r5.g = new x0();
    L8:
        x0 r1 = r5.g;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.content.creation.ISelectCreationMenuManager");
        r1.a(r5.requireActivity());
        return;
    }
}

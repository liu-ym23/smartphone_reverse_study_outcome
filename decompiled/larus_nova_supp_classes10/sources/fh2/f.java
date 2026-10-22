package fh2;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Observer<View> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public f(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        View r4 = (View) r3;
        if (r4 == null) goto L6;
        LiveRoomCouponListFragment r0 = this.a;
        int r1 = LiveRoomCouponListFragment.x;
        r0.getClass();
        r4.post(new h(r0, r4));
        return;
    }
}

package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements Observer<Void> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public u(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Void r3 = (Void) r2;
        this.a.q.setVisibility(0);
    }
}

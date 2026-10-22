package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Observer<Integer> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public c(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L9;
        LiveRoomCouponListFragment r0 = this.a;
        int r6 = r5.intValue();
        if (r6 < 0) goto L7;
        r0.n.post(new j(r0, r6));
        return;
    L7:
        int r7 = LiveRoomCouponListFragment.x;
        r0.getClass();
        return;
    }
}

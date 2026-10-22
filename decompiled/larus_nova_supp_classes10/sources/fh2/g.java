package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Observer<xi2.p> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public g(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        xi2.p r2 = (xi2.p) r1;
        if (r2 != null) goto L5;
        return;
    L5:
        if (((com.bytedance.android.ec.model.g) r2).statusCode != 0) goto L9;
        this.a.getClass();
        return;
    }
}

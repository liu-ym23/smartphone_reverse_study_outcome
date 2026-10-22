package fh2;

import androidx.core.util.Pair;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements Observer<Pair<Integer, Integer>> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public s(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        if (r4 == null) goto L11;
        Object r0 = r4.first;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r4.second == null) goto L13;
        this.a.u.notifyItemRangeInserted(((Integer) r0).intValue(), ((Integer) r4.second).intValue());
        return;
    L13:
        return;
    }
}

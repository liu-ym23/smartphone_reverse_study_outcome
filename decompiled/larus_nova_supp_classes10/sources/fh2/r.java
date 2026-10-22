package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements Observer<Void> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public r(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Void r6 = (Void) r5;
        LiveRoomCouponListFragment r7 = this.a;
        if (r7.u.getItemCount() <= ((r7.u.d ? 1 : 0) + 0)) goto L5;
        r7.n.setVisibility(0);
        r7.p.setVisibility(8);
        r7.u.notifyDataSetChanged();
        r7.m.setVisibility(0);
        return;
    L5:
        r7.n.setVisibility(8);
        r7.p.setBindNotice(((LiveRoomCouponListViewModel) r7.g).getCouponBindNotice());
        r7.p.setVisibility(0);
        r7.m.setVisibility(8);
    }
}

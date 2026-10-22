package fh2;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public m(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        LiveRoomCouponListFragment r3 = this.a;
        int r4 = LiveRoomCouponListFragment.x;
        ((LiveRoomCouponListViewModel) r3.g).cancelDistributeCoupon();
    }
}

package fh2;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements DialogInterface.OnCancelListener {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public n(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        LiveRoomCouponListFragment r3 = this.a;
        int r0 = LiveRoomCouponListFragment.x;
        ((LiveRoomCouponListViewModel) r3.g).cancelDistributeCoupon();
    }
}

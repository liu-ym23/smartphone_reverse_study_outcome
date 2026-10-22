package fh2;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ si2.p a;
    public final /* synthetic */ LiveRoomCouponListFragment b;

    public k(LiveRoomCouponListFragment r1, si2.p r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        r2.dismiss();
        LiveRoomCouponListFragment r4 = this.b;
        int r5 = LiveRoomCouponListFragment.x;
        ((LiveRoomCouponListViewModel) r4.g).realDistributeCoupon(r4.getContext(), this.a);
        this.b.getClass();
    }
}

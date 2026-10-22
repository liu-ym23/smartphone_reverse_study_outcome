package fh2;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public l(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LiveRoomCouponListFragment r3 = this.a;
        int r0 = LiveRoomCouponListFragment.x;
        ((LiveRoomCouponListViewModel) r3.g).clickRetry();
    }
}

package fh2;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements Observer<si2.p> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public t(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        si2.p r10 = (si2.p) r9;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.l != 0) goto L10;
        LiveRoomCouponListFragment r0 = this.a;
        int r1 = LiveRoomCouponListFragment.x;
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L14;
        ECAlertDialog r11 = com.bytedance.android.livesdk.livecommerce.room.f.f(r2, 2131896441, 2131896440, 2131896444, new k(r0, r10), new m(r0));
        r0.s = r11;
        r11.setOnCancelListener(new n(r0));
        return;
    L14:
        return;
    L10:
        LiveRoomCouponListFragment r3 = this.a;
        int r4 = LiveRoomCouponListFragment.x;
        VM r5 = r3.g;
        if (r5 == 0) goto L16;
        ((LiveRoomCouponListViewModel) r5).endDistributeCoupon(r3.getContext(), r10);
        return;
    }
}

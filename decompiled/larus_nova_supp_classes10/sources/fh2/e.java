package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Observer<Void> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public e(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Void r3 = (Void) r2;
        ECFunctionGuideView r4 = this.a.k;
        if (r4 == null) goto L6;
        r4.setVisibility(8);
        return;
    }
}

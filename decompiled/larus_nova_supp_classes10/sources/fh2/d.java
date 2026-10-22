package fh2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Observer<String> {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public d(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        String r5 = (String) r4;
        LiveRoomCouponListFragment r0 = this.a;
        int r1 = LiveRoomCouponListFragment.x;
        r0.getClass();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r0.l.post(new i(r0, r5));
        return;
    }
}

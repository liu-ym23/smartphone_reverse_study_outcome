package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements Observer<xi2.p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476968a;

    public g(LiveRoomCouponListFragment r100) {
        this.f476968a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        xi2.p r101 = (xi2.p) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.statusCode != 0) goto L9;
        this.f476968a.getClass();
        return;
    }
}

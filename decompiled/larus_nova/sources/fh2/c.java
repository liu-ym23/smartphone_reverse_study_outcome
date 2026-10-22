package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Observer<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476964a;

    public c(LiveRoomCouponListFragment r100) {
        this.f476964a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 == null) goto L9;
        LiveRoomCouponListFragment r102 = this.f476964a;
        int r103 = r101.intValue();
        if (r103 < 0) goto L7;
        r102.f147686n.post(new j(r102, r103));
        return;
    L7:
        int r104 = LiveRoomCouponListFragment.f147680x;
        r102.getClass();
        return;
    }
}

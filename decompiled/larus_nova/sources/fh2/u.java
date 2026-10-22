package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class u implements Observer<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476989a;

    public u(LiveRoomCouponListFragment r100) {
        this.f476989a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Void r101 = (Void) r100;
        this.f476989a.f147689q.setVisibility(0);
    }
}

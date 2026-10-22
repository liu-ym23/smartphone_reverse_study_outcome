package fh2;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements Observer<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476967a;

    public f(LiveRoomCouponListFragment r100) {
        this.f476967a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        View r101 = (View) r100;
        if (r101 == null) goto L6;
        LiveRoomCouponListFragment r102 = this.f476967a;
        int r103 = LiveRoomCouponListFragment.f147680x;
        r102.getClass();
        r101.post(new h(r102, r101));
        return;
    }
}

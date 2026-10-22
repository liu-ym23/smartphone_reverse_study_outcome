package fh2;

import androidx.core.util.Pair;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class s implements Observer<Pair<Integer, Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476987a;

    public s(LiveRoomCouponListFragment r100) {
        this.f476987a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 == null) goto L11;
        F r102 = r101.first;
        if (r102 != 0) goto L7;
        return;
    L7:
        if (r101.second == 0) goto L13;
        this.f476987a.f147693u.notifyItemRangeInserted(((Integer) r102).intValue(), ((Integer) r101.second).intValue());
        return;
    L13:
        return;
    }
}

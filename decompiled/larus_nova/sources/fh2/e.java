package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements Observer<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476966a;

    public e(LiveRoomCouponListFragment r100) {
        this.f476966a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Void r101 = (Void) r100;
        ECFunctionGuideView r102 = this.f476966a.f147683k;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
        return;
    }
}

package fh2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476965a;

    public d(LiveRoomCouponListFragment r100) {
        this.f476965a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        LiveRoomCouponListFragment r102 = this.f476965a;
        int r103 = LiveRoomCouponListFragment.f147680x;
        r102.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r102.f147684l.post(new i(r102, r101));
        return;
    }
}

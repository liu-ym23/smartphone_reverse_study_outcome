package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ LiveRoomCouponListFragment b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.t.scrollToPositionWithOffset(this.a, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(LiveRoomCouponListFragment r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}

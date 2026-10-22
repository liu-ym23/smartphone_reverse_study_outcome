package fh2;

import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f476976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveRoomCouponListFragment f476977b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f476977b.f147692t.scrollToPositionWithOffset(this.f476976a, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(LiveRoomCouponListFragment r100, int r101) {
        this.f476977b = r100;
        this.f476976a = r101;
    }
}

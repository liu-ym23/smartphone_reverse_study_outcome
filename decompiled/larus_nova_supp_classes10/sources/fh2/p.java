package fh2;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.view.ECHostNetErrorLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements Runnable {
    public final /* synthetic */ LiveRoomCouponListFragment a;

    public final void a() {
        if (this.a.getContext() == null) goto L9;
        Context r0 = this.a.getContext();
        this.a.j.getMeasuredHeight();
        this.a.getClass();
        Handler r1 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        if (r0 == null) goto L7;
        ECDisplayUtils.b(r0);
    L7:
        LiveRoomCouponListFragment r2 = this.a;
        ECHostNetErrorLayout r3 = r2.o.d;
        r2.p.getClass();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public p(LiveRoomCouponListFragment r1) {
        this.a = r1;
    }
}

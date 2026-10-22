package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Runnable {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = ECSdk.a;     // Catch: Throwable -> L8
        IECUserTrackerService r1 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);     // Catch: Throwable -> L8
        if (r1 == null) goto L11;
        of.a r2 = r1.getMarketingService();     // Catch: Throwable -> L8
        if (r2 == null) goto L15;
        r2.a("live_visit_product_in_room", PostActionType.DO, "live");     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}

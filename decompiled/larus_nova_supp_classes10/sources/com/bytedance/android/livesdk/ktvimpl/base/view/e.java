package com.bytedance.android.livesdk.ktvimpl.base.view;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ long a;

    public e(KtvGroupListDialogFragment r1, long r2) {
        this.a = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        String r0 = "getKtvGroupUser error " + r8.getMessage();
        ALogger.i(bb0.b.b(), r0 + ", invoke class :KtvGroupListDialogFragment");
        mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiGetLinkmicGroupUser, System.currentTimeMillis() - this.a, r8);
    }
}

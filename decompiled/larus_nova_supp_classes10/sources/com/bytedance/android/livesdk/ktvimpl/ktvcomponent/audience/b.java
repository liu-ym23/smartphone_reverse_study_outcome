package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ KtvComponentAudienceLogicWidget a;
    public final /* synthetic */ long b;

    public b(KtvComponentAudienceLogicWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        this.a.d = false;
        ALogger.w("KtvComponent_MergeMode", "KtvComponentAudienceLogicWidget: fetchKtvComponentSetting, failure, logId=" + ke2.a.c(r8));
        mb0.c.a.a(pd2.d.n, LinkMonitorData.APIGetKtvComponentSetting, System.currentTimeMillis() - this.b, r8);
    }
}

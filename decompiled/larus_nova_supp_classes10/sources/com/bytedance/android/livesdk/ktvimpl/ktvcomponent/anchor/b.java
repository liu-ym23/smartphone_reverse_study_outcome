package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ long a;

    public b(long r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        ALogger.w("KtvComponent_MergeMode", "KtvComponentAnchorLogicWidget: fetchKtvComponentSetting, failure, logId=" + ke2.a.c(r8));
        mb0.c.a.a(pd2.d.n, LinkMonitorData.APIGetKtvComponentSetting, System.currentTimeMillis() - this.a, r8);
    }
}

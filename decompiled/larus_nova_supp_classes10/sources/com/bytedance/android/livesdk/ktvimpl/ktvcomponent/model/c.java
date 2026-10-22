package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ Function1 b;

    public c(long r1, Function1 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        mb0.c.a.b(pd2.d.n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.a, ((ExtraResponse) r8).logId);
        this.b.invoke(r8);
    }
}

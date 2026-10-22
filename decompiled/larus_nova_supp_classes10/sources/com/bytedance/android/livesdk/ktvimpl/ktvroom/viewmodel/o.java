package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ long a;

    public o(long r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        pd2.d r0 = pd2.d.n;
        LinkMonitorData r1 = LinkMonitorData.ApiAddSongStatusForRebroadcast;
        long r2 = System.currentTimeMillis() - this.a;
        mb0.c.a.a(r0, r1, r2, (Throwable) r7);
    }
}

package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ long a;

    public n(long r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiAddSongStatusForRebroadcast, System.currentTimeMillis() - this.a, ((ExtraResponse) ((com.bytedance.android.live.network.response.a) r7)).logId);
    }
}

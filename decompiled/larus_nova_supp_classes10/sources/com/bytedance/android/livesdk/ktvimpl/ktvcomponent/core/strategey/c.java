package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ KtvComponentSingleBroadcastStrategy a;
    public final /* synthetic */ long b;

    public c(KtvComponentSingleBroadcastStrategy r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        m r0 = o3.d().A();
        if (r0 == null) goto L5;
        r0.setValue(Boolean.TRUE);
    L5:
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: add_song_prepare_apply, success, logId=" + ((ExtraResponse) r8).logId);
        this.a.b = true;
        tc0.c.h().J = 114;
        mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiAddSongPrepareApply, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
    }
}

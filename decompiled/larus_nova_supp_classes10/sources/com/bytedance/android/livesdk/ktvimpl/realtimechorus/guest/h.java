package com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ ye0.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public h(ye0.a r1, long r2) {
        this.a = r1;
        this.b = 1;
        this.c = r2;
    }

    public final void accept(Object r5) {
        this.a.onSuccess();
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        int r1 = this.b;
        long r2 = this.c;
        String r6 = ((ExtraResponse) ((com.bytedance.android.live.network.response.a) r5)).logId;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.c(r1, r2, null, r6);
    }
}

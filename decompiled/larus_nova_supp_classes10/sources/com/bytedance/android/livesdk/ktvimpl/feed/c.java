package com.bytedance.android.livesdk.ktvimpl.feed;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ KtvComponentMidiFeedViewModel a;

    public c(KtvComponentMidiFeedViewModel r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        KtvComponentFeedViewModel r4 = this.a.p;
        if (r4 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r5 = (KtvRoomLyricsStateMachineConfig.d) r4.b.b();
    L7:
        if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L9;
        this.a.g.setValue(Boolean.TRUE);
        return;
    L9:
        this.a.l = true;
        return;
    L5:
        r5 = null;
        goto L7
    }
}

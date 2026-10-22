package com.bytedance.android.livesdk.live.listprovider;

import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.livesdkapi.feed.ILoadMore;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ DrawRoomListProvider a;

    public h(DrawRoomListProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        DrawRoomListProvider r0 = this.a;
        ILoadMore.ILoadMoreCallback r1 = r0.p0;
        if (r1 == null) goto L5;
        r1.onError(r5, r0.n(r0.l));
    L5:
        this.a.w = false;
        r5.printStackTrace();
        this.a.v().o(r5, BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE);
    }
}

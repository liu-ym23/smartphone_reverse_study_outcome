package com.bytedance.android.livesdk.live.listprovider;

import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.feed.ILoadMore;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ DrawRoomListProvider a;
    public final /* synthetic */ int b;

    public g(DrawRoomListProvider r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r12) {
        Pair r13 = (Pair) r12;
        this.a.v().p(BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE);
        if (r13 != null) goto L8;
        DrawRoomListProvider r14 = this.a;
        ILoadMore.ILoadMoreCallback r1 = r14.p0;
        if (r1 == null) goto L7;
        r1.onSuccess(0, r14.n(r14.l), false);
    L7:
        this.a.w = false;
        return;
    L8:
        this.a.O((FeedExtra) r13.second);
        Object r2 = r13.first;
        if (r2 != null) goto L11;
    L24:
        DrawRoomListProvider r3 = this.a;
        FeedExtra r4 = r3.l;
        if (r4 != null) goto L27;
    L38:
        ILoadMore.ILoadMoreCallback r5 = this.a.p0;
        if (r5 == null) goto L47;
        List r15 = (List) r13.first;
        if (r15 == null) goto L43;
        int r16 = r15.size();
    L44:
        DrawRoomListProvider r6 = this.a;
        r5.onSuccess(r16, r6.n(r6.l), false);
        return;
    L43:
        r16 = 0;
        goto L44
    L47:
        return;
    L27:
        if (((Extra) r4).hasMore == true) goto L38;
        MergeDrawerViewModel r7 = r3.L1;
        if (r7 == null) goto L38;
        if (r7.isMergePull() != true) goto L38;
        DrawRoomListProvider r8 = this.a;
        FeedExtra r9 = r8.l;
        if (r9 == null) goto L35;
        ((Extra) r9).hasMore = true;
    L35:
        MergeDrawerViewModel r10 = r8.L1;
        if (r10 == null) goto L38;
        r10.setMergePull(false);
        goto L38
    L11:
        if (((List) r2).isEmpty() == true) goto L24;
        DrawRoomListProvider.J(this.a, (List) r13.first, (FeedExtra) r13.second, true, 0, false, false, 56);
        this.a.dispatchChange();
        MergeDrawerViewModel r11 = this.a.L1;
        if (r11 != null) goto L15;
    L21:
        DrawRoomListProvider r17 = this.a;
        r17.w = false;
        r17.C++;
        jg2.a r18 = r17.J;
        if (r18 == null) goto L24;
        r18.b++;
        goto L24
    L15:
        if (r11.isMergePull() != true) goto L21;
        MergeDrawerViewModel r19 = this.a.L1;
        if (r19 == null) goto L21;
        MutableLiveData r20 = r19.getUpdataRoom();
        if (r20 == null) goto L21;
        r20.setValue(new com.bytedance.android.livesdk.viewmodel.h(this.a.b, this.b, false));
        goto L21
    }
}

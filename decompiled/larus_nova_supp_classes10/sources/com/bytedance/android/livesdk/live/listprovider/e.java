package com.bytedance.android.livesdk.live.listprovider;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.core.setting.g2;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.model.a0;
import com.bytedance.android.livesdkapi.depend.log.LiveFeedMainMonitor;
import com.bytedance.android.livesdkapi.feed.ILoadMore;
import com.bytedance.android.livesdkapi.feed.LoadMoreRetryConfig;
import com.bytedance.android.livesdkapi.feed.SOURCE;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ DrawRoomListProvider a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public e(DrawRoomListProvider r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r11) {
        Pair<List<FeedItem>, FeedExtra> r12 = (Pair) r11;
        long r0 = SystemClock.elapsedRealtime() - this.b;
        LiveFeedMainMonitor.printFeedLog("inder_draw", "doLoadmoreInner callback", String.valueOf(this.a.n), "", this.a.s(), "doLoadmoreInner,costTime=" + r0);
        com.bytedance.android.livesdk.live.f r2 = this.a.P1;
        boolean r3 = false;
        Integer r4 = null;
        if (r2 == null) goto L5;
        r2.d.removeMessages(10086);
        r2.a = 0;
        r2.c = null;
        r2.b = false;
    L5:
        this.a.v().p(BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE);
        int r5 = com.bytedance.android.live.network.impl.utils.b.c;
        StringBuilder r6 = new StringBuilder("isRetry: ");
        boolean r7 = this.a.k0;
        Handler r8 = UtilityKotlinExtentionsKt.a;
        r6.append(r7 ? 1 : 0);
        r6.append(", /webcast/feed/ request success .... ");
        com.bytedance.android.live.network.impl.utils.b.a.a(r6.toString());
        com.bytedance.android.live.network.impl.utils.b r9 = (com.bytedance.android.live.network.impl.utils.b) this.a.N.getValue();
        DrawRoomListProvider r10 = this.a;
        boolean r13 = r10.k0;
        if (r13 == false) goto L8;
        LoadMoreRetryConfig r14 = r10.H0;
    L9:
        r9.getClass();
        LinkedHashMap r15 = new LinkedHashMap();
        String r16 = "1";
        r15.put("status", "1");
        if (r13 == true) goto L13;
        r16 = BDLocationException.ERROR_TIMEOUT;
    L13:
        r15.put("is_retry", r16);
        if (r13 == false) goto L18;
        if (r14 == null) goto L17;
        r4 = Integer.valueOf(r14.getErrorCode());
    L17:
        r15.put(LocationMonitorConst.ERROR_CODE, String.valueOf(r4));
    L18:
        r15.put("path", r9.b.getPath());
        r15.put("request_scene", r9.a.getScene());
        if (r14 == null) goto L24;
        SOURCE r17 = r14.getSource();
        if (r17 == null) goto L24;
        String r18 = r17.getSource();
        if (r18 == null) goto L24;
    L25:
        r15.put("trigger_type", r18);
        r15.put("cost_time", String.valueOf(r0));
        u.l().sendLog("livesdk_live_api", r15, new Object[0]);
        boolean r1 = true;
        if (r12 != null) goto L31;
        DrawRoomListProvider r19 = this.a;
        ILoadMore.ILoadMoreCallback r20 = r19.p0;
        if (r20 == null) goto L30;
        r20.onSuccess(0, r19.n(r19.l), false);
    L30:
        DrawRoomListProvider r110 = this.a;
        r110.w = false;
        r110.U = true;
        return;
    L31:
        this.a.O((FeedExtra) r12.second);
        Object r21 = r12.first;
        if (r21 != null) goto L34;
    L60:
        DrawRoomListProvider r111 = this.a;
        ILoadMore.ILoadMoreCallback r22 = r111.p0;
        if (r22 == null) goto L63;
        r22.onSuccess(0, r111.n(r111.l), false);
    L63:
        DrawRoomListProvider r112 = this.a;
        r112.w = false;
        r112.U = true;
        int r23 = this.c;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.g("followEmptyRecRetry is called. curIndex = " + r23 + ", hasRecTry = " + r112.K);
        pg2.d r24 = r112.L;
        if (r24 == null) goto L66;
        r3 = r24.b();
    L66:
        if (r23 == 0) goto L68;
        return;
    L68:
        if (r112.K == true) goto L76;
        if (r3 == false) goto L77;
        xs2.b.a().post(new com.bytedance.android.livesdk.chatroom.followrecommendguide.b(r23, r112.l));
        r112.K = true;
        return;
    L77:
        return;
    L76:
        return;
    L34:
        if (((List) r21).isEmpty() == true) goto L60;
        DrawRoomListProvider r25 = this.a;
        if (r25.v1 == false) goto L39;
        r25.x1 = false;
    L39:
        int r26 = a0.a;
        if (((Number) g2.a.getValue()).intValue() > 0) goto L43;
        r1 = false;
    L43:
        if (r1 == true) goto L45;
    L52:
        a0.e("NormalCallBack");
        this.a.H(r12);
    L53:
        ILoadMore.ILoadMoreCallback r27 = this.a.p0;
        if (r27 == null) goto L73;
        List r113 = (List) r12.first;
        if (r113 == null) goto L58;
        int r114 = r113.size();
    L59:
        DrawRoomListProvider r28 = this.a;
        r27.onSuccess(r114, r28.n(r28.l), false);
        return;
    L58:
        r114 = 0;
        goto L59
    L73:
        return;
    L45:
        if (this.c != 0) goto L52;
        if (this.a.shouldInterceptCallBack() == false) goto L52;
        if (this.a.U == true) goto L52;
        a0.e("InterceptCallBack");
        this.a.O = r12;
    L24:
        r18 = "";
        goto L25
    L8:
        r14 = null;
        goto L9
    }
}

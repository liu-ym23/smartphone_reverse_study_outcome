package com.bytedance.android.livesdk.live.listprovider;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.ge;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.model.q;
import com.bytedance.android.livesdkapi.depend.log.LiveFeedMainMonitor;
import com.bytedance.android.livesdkapi.feed.ILoadMore;
import com.bytedance.android.livesdkapi.feed.LoadMoreRetryConfig;
import com.bytedance.android.livesdkapi.feed.SOURCE;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ DrawRoomListProvider a;

    public f(DrawRoomListProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        Throwable r13 = (Throwable) r12;
        DrawRoomListProvider r0 = this.a;
        ILoadMore.ILoadMoreCallback r1 = r0.p0;
        if (r1 == null) goto L5;
        r1.onError(r13, r0.n(r0.l));
    L5:
        DrawRoomListProvider r2 = this.a;
        boolean r3 = false;
        r2.w = false;
        r2.U = true;
        com.bytedance.android.live.network.impl.utils.b r4 = (com.bytedance.android.live.network.impl.utils.b) r2.N.getValue();
        DrawRoomListProvider r5 = this.a;
        boolean r6 = r5.k0;
        Long r7 = null;
        if (r6 == false) goto L8;
        LoadMoreRetryConfig r8 = r5.H0;
    L9:
        r4.getClass();
        LinkedHashMap r9 = new LinkedHashMap();
        String r10 = BDLocationException.ERROR_TIMEOUT;
        r9.put("status", BDLocationException.ERROR_TIMEOUT);
        if (r6 == false) goto L12;
        r10 = "1";
    L12:
        r9.put("is_retry", r10);
        if (r6 == false) goto L18;
        if (r8 == null) goto L16;
        Integer r11 = Integer.valueOf(r8.getErrorCode());
    L17:
        r9.put(LocationMonitorConst.ERROR_CODE, String.valueOf(r11));
        goto L18
    L16:
        r11 = null;
    L18:
        r9.put("path", r4.b.getPath());
        r9.put("request_scene", r4.a.getScene());
        if (r8 == null) goto L24;
        SOURCE r14 = r8.getSource();
        if (r14 == null) goto L24;
        String r15 = r14.getSource();
        if (r15 == null) goto L24;
    L25:
        r9.put("trigger_type", r15);
        u.l().sendLog("livesdk_live_api", r9, new Object[0]);
        if (this.a.P1 != null) goto L28;
    L49:
        String r16 = String.valueOf(this.a.n);
        String r17 = this.a.s();
        StringBuilder r18 = new StringBuilder("trace:");
        r18.append(r13.getMessage());
        r18.append(",isRetry: ");
        boolean r19 = this.a.k0;
        Handler r20 = UtilityKotlinExtentionsKt.a;
        r18.append(r19 ? 1 : 0);
        LiveFeedMainMonitor.errorFeedLog("inder_draw", "doLoadmoreInner_failed", r16, "", r17, r18.toString());
        this.a.v().o(r13, BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE);
        return;
    L28:
        if (com.bytedance.android.livesdk.live.f.a() != true) goto L49;
        com.bytedance.android.livesdk.live.f r21 = this.a.P1;
        if (r21 == null) goto L49;
        if (r13 == null) goto L49;
        q r22 = ((com.bytedance.android.livesdk.model.i) ge.a.getValue()).b();
        if (r22 == null) goto L49;
        if (r22.c(r21.a) == false) goto L39;
        int r23 = com.bytedance.android.live.network.impl.utils.b.c;
        com.bytedance.android.live.network.impl.utils.b.a.a("retry fail: over max limit ");
        goto L49
    L39:
        Integer r24 = Integer.valueOf(com.bytedance.android.live.network.impl.utils.c.a(r13));
        r21.c = r24;
        if (r22.a(r24) == true) goto L42;
        int r25 = com.bytedance.android.live.network.impl.utils.b.c;
        com.bytedance.android.live.network.impl.utils.b.a.a("retry fail: invalid error code ");
        goto L49
    L42:
        r21.d.removeMessages(10086);
        Message r26 = Message.obtain(r21.d, 10086);
        r26.arg1 = 1;
        Long r27 = Long.valueOf(r22.b(r21.a));
        if (r27.longValue() <= 0) goto L45;
        r3 = true;
    L45:
        if (r3 == false) goto L47;
        r7 = r27;
    L47:
        if (r7 == null) goto L49;
        r21.d.sendMessageDelayed(r26, r7.longValue() * ((long) 1000));
    L24:
        r15 = "";
        goto L25
    L8:
        r8 = null;
        goto L9
    }
}

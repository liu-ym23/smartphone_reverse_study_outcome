package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.model.EndTimeRefreshInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends a {
    public d() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r13) {
        Intrinsics.checkNotNullParameter(r13, "message");
        boolean r1 = false;
        if ((r13 instanceof si2.a) == true) goto L5;
        return false;
    L5:
        si2.a r14 = (si2.a) r13;
        int r0 = r14.actionType;
        Long r8 = null;
        Long r9 = null;
        r9 = null;
        String r10 = null;
        Long r11 = null;
        r11 = null;
        r8 = null;
        if (r0 != 1) goto L8;
        String r2 = r14.priceRefreshInfo;
        if (r2 == null) goto L110;
        JSONObject r3 = z1.g(r2);
        if (r3 == null) goto L110;
        JSONObject r4 = new JSONObject();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L107
        sg2.b r15 = r14.getCommon();     // Catch: Throwable -> L107
        if (r15 == null) goto L93;
        Long r16 = Long.valueOf(r15.g);     // Catch: Throwable -> L107
    L94:
        r4.putOpt("client_recv_timestamp", r16);     // Catch: Throwable -> L107
        r4.putOpt("client_send_timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L107
        sg2.b r6 = r14.getCommon();     // Catch: Throwable -> L107
        if (r6 == null) goto L99;
        TraceTimeMetricV2 r7 = r6.d;     // Catch: Throwable -> L107
        if (r7 == null) goto L99;
        Long r17 = Long.valueOf(r7.getOpTimestamp());     // Catch: Throwable -> L107
    L100:
        r4.putOpt("op_timestamp", r17);     // Catch: Throwable -> L107
        sg2.b r18 = r14.getCommon();     // Catch: Throwable -> L107
        if (r18 == null) goto L105;
        TraceTimeMetricV2 r19 = r18.d;     // Catch: Throwable -> L107
        if (r19 == null) goto L105;
        r8 = Long.valueOf(r19.getMsgSendTimestamp());     // Catch: Throwable -> L107
    L105:
        r4.putOpt("msg_send_timestamp", r8);     // Catch: Throwable -> L107
        Result.constructor-impl(r3.put("msg_trace_info", r4));     // Catch: Throwable -> L107
    L109:
        ECLiveHybridUtil.f("ecom.live.auction.update", r3);
    L99:
        r17 = null;
        goto L100
    L93:
        r16 = null;
    L107:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L110:
        return true;
    L8:
        if (r0 != 2) goto L10;
        EndTimeRefreshInfo r20 = r14.endTimeRefreshInfo;
        if (r20 == null) goto L110;
        String r21 = r20.toast;
        if (r21 != null) goto L55;
    L64:
        JSONObject r22 = new JSONObject();
        JSONObject r23 = new JSONObject();
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L82
        sg2.b r111 = r14.getCommon();     // Catch: Throwable -> L82
        if (r111 == null) goto L68;
        Long r112 = Long.valueOf(r111.g);     // Catch: Throwable -> L82
    L69:
        r23.putOpt("client_recv_timestamp", r112);     // Catch: Throwable -> L82
        r23.putOpt("client_send_timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L82
        sg2.b r24 = r14.getCommon();     // Catch: Throwable -> L82
        if (r24 == null) goto L74;
        TraceTimeMetricV2 r25 = r24.d;     // Catch: Throwable -> L82
        if (r25 == null) goto L74;
        Long r26 = Long.valueOf(r25.getOpTimestamp());     // Catch: Throwable -> L82
    L75:
        r23.putOpt("op_timestamp", r26);     // Catch: Throwable -> L82
        sg2.b r113 = r14.getCommon();     // Catch: Throwable -> L82
        if (r113 == null) goto L80;
        TraceTimeMetricV2 r114 = r113.d;     // Catch: Throwable -> L82
        if (r114 == null) goto L80;
        r11 = Long.valueOf(r114.getMsgSendTimestamp());     // Catch: Throwable -> L82
    L80:
        r23.putOpt("msg_send_timestamp", r11);     // Catch: Throwable -> L82
        Result.constructor-impl(r22.putOpt("msg_trace_info", r23));     // Catch: Throwable -> L82
    L84:
        r22.putOpt("end_time", Long.valueOf(r20.endTime));
        Unit r115 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.live.auction.update.endtime", r22);
    L74:
        r26 = null;
        goto L75
    L68:
        r112 = null;
    L82:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L84
    L55:
        if (r21.length() <= 0) goto L57;
        r1 = true;
    L57:
        if (r1 == true) goto L60;
        r21 = null;
    L60:
        if (r21 == null) goto L64;
        Context r28 = getContext();
        if (r28 == null) goto L64;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r28, r21);
        goto L64
    L10:
        if (r0 != 3) goto L12;
        String r116 = r14.jumpSchema;
        if (r116 == null) goto L110;
        if (r116.length() <= 0) goto L44;
        r1 = true;
    L44:
        if (r1 == false) goto L46;
        r10 = r116;
    L46:
        if (r10 == null) goto L110;
        Context r117 = getContext();
        if (r117 == null) goto L110;
        Handler r29 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r117, r10);
        goto L110
    L12:
        if (r0 != 4) goto L110;
        String r30 = r14.preBidRefreshInfo;
        if (r30 == null) goto L110;
        JSONObject r31 = z1.g(r30);
        if (r31 == null) goto L110;
        JSONObject r32 = new JSONObject();
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L36
        sg2.b r34 = r14.getCommon();     // Catch: Throwable -> L36
        if (r34 == null) goto L22;
        Long r35 = Long.valueOf(r34.g);     // Catch: Throwable -> L36
    L23:
        r32.putOpt("client_recv_timestamp", r35);     // Catch: Throwable -> L36
        r32.putOpt("client_send_timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L36
        sg2.b r36 = r14.getCommon();     // Catch: Throwable -> L36
        if (r36 == null) goto L28;
        TraceTimeMetricV2 r37 = r36.d;     // Catch: Throwable -> L36
        if (r37 == null) goto L28;
        Long r38 = Long.valueOf(r37.getOpTimestamp());     // Catch: Throwable -> L36
    L29:
        r32.putOpt("op_timestamp", r38);     // Catch: Throwable -> L36
        sg2.b r118 = r14.getCommon();     // Catch: Throwable -> L36
        if (r118 == null) goto L34;
        TraceTimeMetricV2 r119 = r118.d;     // Catch: Throwable -> L36
        if (r119 == null) goto L34;
        r9 = Long.valueOf(r119.getMsgSendTimestamp());     // Catch: Throwable -> L36
    L34:
        r32.putOpt("msg_send_timestamp", r9);     // Catch: Throwable -> L36
        Result.constructor-impl(r31.put("msg_trace_info", r32));     // Catch: Throwable -> L36
    L38:
        ECLiveHybridUtil.f("ecom.live.auction.update.prebid", r31);
    L28:
        r38 = null;
        goto L29
    L22:
        r35 = null;
    L36:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    }
}

package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livesdk.gift.model.Prop;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.alog.middleware.ALogService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w0 extends a<am2.f0> {
    public w0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r12, Object r13) {
        am2.f0 r14 = (am2.f0) r13;
        super.u(r12, r14);
        if (r14 == null) goto L66;
        h2 r0 = r14.c;
        Prop r1 = (Prop) com.bytedance.android.live.base.model.m.b(r14.d, Prop.class);
        if (r0 != null) goto L9;
    L24:
        String r2 = "single_gift";
    L26:
        if (r12.containsKey("gift_source") == true) goto L28;
        r12.put("gift_source", "gift_tab");
    L28:
        J("gift_cnt", r12, r14.f);
        J("combo_cnt", r12, r14.e);
        J("money", r12, r14.h * r14.f);
        if (r12.containsKey("request_page") == true) goto L31;
        r12.put("request_page", "normal");
    L31:
        long r3 = r14.b;
        if (r3 <= 0) goto L34;
        String r4 = "prop_type";
    L35:
        if (r3 <= 0) goto L37;
        String r5 = "prop_id";
    L38:
        r12.put(r4, r2);
        long r6 = r14.b;
        if (r6 > 0) goto L42;
        r6 = r14.a;
    L42:
        r12.put(r5, String.valueOf(r6));
        if (r14.b > 0) goto L45;
        r12.put("gift_cnt", String.valueOf(r14.f));
    L46:
        r12.put("group_cnt", String.valueOf(r14.g));
        r12.put("combo_cnt", String.valueOf(r14.e));
        long r7 = r14.b;
        if (r7 > 0) goto L50;
        if (r0 == null) goto L50;
        r12.put("money", String.valueOf((r14.e * r14.g) * ((long) r0.getDiamondCount())));
    L63:
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L59
        long r9 = r14.b;     // Catch: Exception -> L59
        if (r9 > 0) goto L57;
        r8.put(String.valueOf(r14.a), String.valueOf(r14.f));     // Catch: Exception -> L59
        r12.put("gift_info", r8.toString());     // Catch: Exception -> L59
    L62:
        return;
    L57:
        r8.put(String.valueOf(r9), String.valueOf(r14.f));     // Catch: Exception -> L59
        r12.put("prop_info", r8.toString());     // Catch: Exception -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
        return;
    L50:
        if (r7 <= 0) goto L63;
        if (r1 == null) goto L63;
        if (r0 == null) goto L63;
        r12.put("income", String.valueOf((r14.e * r14.g) * ((long) r0.getDiamondCount())));
        r12.put("money", String.valueOf((r14.e * r14.g) * ((long) r0.getDiamondCount())));
        goto L63
    L45:
        r12.put("prop_cnt", String.valueOf(r14.f));
        goto L46
    L37:
        r5 = "gift_id";
        goto L38
    L34:
        r4 = "gift_type";
        goto L35
    L9:
        if (r0.getType() != 10) goto L12;
        r2 = "coin_gift";
        goto L26
    L12:
        if (r14.f == 1) goto L24;
        long r10 = r14.e;
        if (r10 <= 1) goto L20;
        if (r14.g <= 1) goto L20;
        r2 = "bunchrunning_gift";
    L20:
        if (r14.g <= 1) goto L22;
        r2 = "bunching_gift";
        goto L26
    L22:
        if (r10 <= 1) goto L24;
        r2 = "running_gift";
        goto L26
    }

    public static void J(String r3, Map r4, long r5) {
        if (r4.containsKey(r3) == true) goto L5;
    L13:
        int r0 = 0;
    L15:
        if (r0 >= r5) goto L20;
        r4.put(r3, String.valueOf(r5));
        return;
    L20:
        return;
    L5:
        if (r4.get(r3) == null) goto L13;
        r0 = CastIntegerProtector.parseInt((String) r4.get(r3));     // Catch: NumberFormatException -> L9
    L9:
        String r1 = "parse " + r3 + " error";
        int r2 = ww2.a.a;
        Intrinsics.checkNotNullParameter("SendGiftResultFilter", LocationMonitorConst.TAG);
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        Intrinsics.checkNotNullParameter("SendGiftResultFilter", LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogService.dSafely("SendGiftResultFilter", r1);
        goto L13
    }
}

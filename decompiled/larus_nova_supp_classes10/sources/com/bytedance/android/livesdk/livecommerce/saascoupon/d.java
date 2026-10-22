package com.bytedance.android.livesdk.livecommerce.saascoupon;

import android.content.Context;
import android.net.Uri;
import bl2.g;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ el.a a;
    public final /* synthetic */ SaasCouponService.b b;

    public d(el.a r1, SaasCouponService.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        SaasCouponService r0 = this.b.a;
        el.a r1 = this.a;
        g r2 = r0.c;
        if (r0.f() == false) goto L36;
        ECLiveHybridUtil.m("LIVEROOM_SHOW_SHOT_REDPACK", (j) r0.z.getValue());
        ECLiveHybridUtil.m("LIVEROOM_OPEN_PRODUCT_LIST", (j) r0.A.getValue());
        WeakReference<Context> r3 = r0.j;
        if (r3 == null) goto L34;
        Context r4 = r3.get();
        if (r4 == null) goto L35;
        Uri.Builder r5 = UriProtector.parse(r1.b()).buildUpon();     // Catch: Exception -> L26
        String r6 = r1.a();     // Catch: Exception -> L26
        if (r6 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L26
    L19:
        r8.put("reqid", r2.f);     // Catch: Exception -> L26
        r8.put("token", r2.g);     // Catch: Exception -> L26
        r8.put("cid", String.valueOf(r2.h));     // Catch: Exception -> L26
        r8.put("ad_id", String.valueOf(r2.i));     // Catch: Exception -> L26
        r8.put("biz_tag", r2.j);     // Catch: Exception -> L26
        r8.put("is_inner", String.valueOf(r2.q));     // Catch: Exception -> L26
        r8.put("anchor_id", r2.e);     // Catch: Exception -> L26
        Function0<LiveRoomParams> r9 = r0.o;     // Catch: Exception -> L26
        if (r9 == null) goto L24;
        LiveRoomParams r10 = (LiveRoomParams) r9.invoke();     // Catch: Exception -> L26
        if (r10 == null) goto L24;
        r8.put("enter_from", r10.getEnterFromMerge());     // Catch: Exception -> L26
        r8.put("enter_from_merge", r10.getEnterFromMerge());     // Catch: Exception -> L26
        r8.put("enter_method", r10.getEnterMethod());     // Catch: Exception -> L26
        r8.put("room_id", r10.getRoomId());     // Catch: Exception -> L26
        r8.put("action_type", r10.getActionType());     // Catch: Exception -> L26
        r8.put("request_id", r10.getRequestId());     // Catch: Exception -> L26
        r8.put("is_other_channel", r10.isOtherChannel());     // Catch: Exception -> L26
        r8.put("creative_id", r10.getCreativeId());     // Catch: Exception -> L26
        r8.put("log_extra", r10.getLogExtra());     // Catch: Exception -> L26
    L24:
        Unit r11 = Unit.INSTANCE;     // Catch: Exception -> L26
        ECLiveHybridUtil.k(r4, r5.appendQueryParameter("coupon_all_data", r8.toString()).build().toString(), false, false, false, null, 252);     // Catch: Exception -> L26
        return;
    L18:
        r8 = new JSONObject(r1.a());     // Catch: Exception -> L26
        goto L19
    L12:
        if (r6.length() == 0) goto L15;
        r7 = false;
    L26:
        e = move-exception;
        String r12 = e.getMessage();
        if (r12 != null) goto L30;
        r12 = "SaasCouponService open schema error";
    L30:
        ECExceptionMonitor.c(r12);
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

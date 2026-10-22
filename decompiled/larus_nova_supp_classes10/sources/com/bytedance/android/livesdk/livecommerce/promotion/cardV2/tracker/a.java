package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d f;

    public a(g r1, String r2, String r3, List r4, boolean r5, com.bytedance.android.btm.api.model.d r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        com.bytedance.android.ec.common.api.jump.model.b r1 = this.a;
        if (r1 != null) goto L5;
        r1 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L5:
        v r0 = new v("ecom_live_action_quality_track", r1);
        r0.c("page_name", this.b);
        r0.c("track_type", "click");
        r0.c("uuid", this.c);
        int r2 = b.a;
        r0.c("module_name", b.a(this.d, "module_name"));
        r0.c("click_area", b.a(this.d, "click_area"));
        r0.c("button_title", b.a(this.d, "button_title"));
        g r3 = this.a;
        String r4 = null;
        if (r3 == null) goto L10;
        LiveRoomParams r5 = r3.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r5 == null) goto L10;
        String r6 = r5.getRoomId();
    L11:
        r0.c("room_id", r6);
        g r7 = this.a;
        if (r7 == null) goto L16;
        ql.a r8 = r7.a;
        if (r8 == null) goto L16;
        String r9 = r8.getPromotionId();
    L17:
        r0.c("promotion_id", r9);
        r0.c("action_names", CollectionsKt.joinToString$default(this.d, ",", null, null, 0, null, LiveActionReportUtil$getActionNames$1.INSTANCE, 30, null));
        List r10 = this.d;
        int r11 = m0.a;
        Gson r12 = m0.a.a;
        r0.c("all_actions", GsonProtectorUtils.toJson(r12, r10));
        LiveSingleAction r13 = (LiveSingleAction) CollectionsKt.lastOrNull(this.d);
        String r14 = "-1";
        if (r13 != null) goto L20;
    L22:
        String r15 = "-1";
    L23:
        r0.c("success", r15);
        if (this.e == false) goto L26;
        String r16 = PromotionCategory.CATEGORY_TYPE_SECOND;
    L27:
        r0.c("action_process_end", r16);
        r0.c("schema", b.a(this.d, "schema"));
        r0.a("action_count", this.d.size());
        LiveSingleAction r17 = (LiveSingleAction) CollectionsKt.lastOrNull(this.d);
        if (r17 == null) goto L30;
        String r18 = r17.getActionName();
    L31:
        r0.c("last_action_name", r18);
        LiveSingleAction r19 = (LiveSingleAction) CollectionsKt.lastOrNull(this.d);
        if (r19 != null) goto L34;
    L36:
        r0.c("last_action_success", r14);
        LiveSingleAction r20 = (LiveSingleAction) CollectionsKt.lastOrNull(this.d);
        if (r20 == null) goto L39;
        String r21 = r20.getError();
    L40:
        r0.c("last_action_error", r21);
        LiveSingleAction r22 = (LiveSingleAction) CollectionsKt.lastOrNull(this.d);
        if (r22 == null) goto L43;
        Map<String, Object> r23 = r22.getInfo();
    L44:
        if (r23 == null) goto L46;
        String r24 = GsonProtectorUtils.toJson(r12, r23);
    L47:
        r0.c("last_action_info", r24);
        com.bytedance.android.btm.api.model.d r25 = this.f;
        if (r25 == null) goto L50;
        r4 = r25.a;
    L50:
        r0.i(r4);
        return;
    L46:
        r24 = null;
        goto L47
    L43:
        r23 = null;
        goto L44
    L39:
        r21 = null;
        goto L40
    L34:
        if (r19.getSuccess() != true) goto L36;
        r14 = "1";
        goto L36
    L30:
        r18 = null;
        goto L31
    L26:
        r16 = "1";
        goto L27
    L20:
        if (r13.getSuccess() != true) goto L22;
        r15 = "1";
    L16:
        r9 = null;
    L10:
        r6 = null;
        goto L11
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

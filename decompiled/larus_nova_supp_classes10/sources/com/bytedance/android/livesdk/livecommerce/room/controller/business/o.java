package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFloatWindowDetail;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFloatWindowDetailExtraParams;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFloatWindowDetailResponse;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ ExtraController a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ com.bytedance.android.ec.adapter.api.state.a e;
    public final /* synthetic */ String f;
    public final /* synthetic */ JSONObject g;
    public final /* synthetic */ Context h;

    public o(ExtraController r1, String r2, String r3, String r4, com.bytedance.android.ec.adapter.api.state.a r5, String r6, JSONObject r7, Context r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final void accept(Object r7) {
        ECFloatWindowDetailResponse r8 = (ECFloatWindowDetailResponse) r7;
        if (((com.bytedance.android.ec.model.g) r8).statusCode != 0) goto L37;
        ECFloatWindowDetail r9 = r8.a();
        dk2.a r0 = dk2.a.b;
        String r1 = null;
        if (r0 == null) goto L10;
        if (r9 == null) goto L8;
        String r2 = r9.c();
    L9:
        r0.a = r2;
        goto L10
    L8:
        r2 = null;
    L10:
        JSONObject r3 = new JSONObject();
        r3.put("taskEnterFrom", this.b);
        r3.put("taskType", this.c);
        if (r9 == null) goto L13;
        String r4 = r9.c();
    L14:
        r3.put("uniqueID", r4);
        JSONObject r5 = new JSONObject();
        if (r9 == null) goto L17;
        Integer r6 = r9.a();
    L18:
        r5.put("duration", r6);
        if (r9 == null) goto L23;
        ECFloatWindowDetailExtraParams r10 = r9.b();
        if (r10 == null) goto L23;
        String r11 = r10.a();
    L24:
        r5.put("successMsg", r11);
        Unit r12 = Unit.INSTANCE;
        r3.put("extra", r5);
        JSONObject r13 = new JSONObject();
        r13.put("room_id", this.d);
        r13.put("anchor_id", l0.i("anchor_id"));
        r13.put("enter_method", l0.i("enter_method"));
        r13.put("enter_from", "live");
        r13.put("enter_from_merge", l0.d());
        if (com.bytedance.android.livesdk.livecommerce.room.model.h.a(this.e) == false) goto L27;
        String r14 = "click";
    L28:
        r13.put("action_type", r14);
        r3.put("logExtra", r13);
        if (r9 == null) goto L31;
        r1 = r9.c();
    L31:
        r3.put("uniqueID", r1);
        r3.put("extra_params", this.f);
        r3.put("taskRequestParams", this.g);
        int r15 = m0.a;     // Catch: Exception -> L34
        r3.put("data", tv5.a.a(m0.a.b, r9));     // Catch: Exception -> L34
    L36:
        HashMap r16 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.h("live_ecom_task", r3);
        this.a.f = true;
        return;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L27:
        r14 = "draw";
    L23:
        r11 = null;
        goto L24
    L17:
        r6 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L37:
        Context r17 = this.h;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r17, th.a.g(r17, 2131896655));
    }
}

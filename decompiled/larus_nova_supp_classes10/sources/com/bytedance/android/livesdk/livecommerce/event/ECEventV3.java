package com.bytedance.android.livesdk.livecommerce.event;

import android.text.TextUtils;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(message = "废弃，请使用ECParamEvent")
public abstract class ECEventV3 {
    public String a;
    public final boolean b;
    public k0 c;

    public @interface NoticeTypeDef {
    }

    public void k() {
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        return;
    L5:
        oh.a.a(new n0(this));
    }

    public ECEventV3(String r2) {
        this.b = true;
        j(r2);
    }

    public final ECEventV3 a(long r3) {
        this.c.b("is_from_ug", r3);
        return this;
    }

    public ECEventV3 g(Map<String, String> r5) {
        if (r5 == null) goto L11;
        Iterator<String> r0 = r5.keySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        String r2 = r5.get(r1);
        if (TextUtils.isEmpty(r1) == true) goto L5;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        f(r1, r2);
    L11:
        return this;
    }

    public final String i(String r2) {
        k0 r0 = this.c;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.f(r2);
    }

    public final void j(String r6) {
        this.a = r6;
        this.c = new k0();
        if (this.b == false) goto L20;
        HashMap<String, String> r7 = l0.g();
        HashMap r0 = new HashMap();
        r0.putAll(r7);
        String r1 = (String) r0.get("live_tracker_params");
        if (TextUtils.isEmpty(r1) == false) goto L31;
    L14:
        HashMap<String, String> r8 = l0.o();
        if (r8.isEmpty() == true) goto L17;
        this.c.d(r8);
    L17:
        h(null, null);
        this.c.d(r0);
        Map r9 = Collections.unmodifiableMap(f2.b.a);
        if (r9 == null) goto L20;
        this.c.d(r9);
        goto L20
    L31:
        JSONObject r2 = new JSONObject(r1);     // Catch: JSONException -> L12
        Iterator<String> r3 = r2.keys();     // Catch: JSONException -> L12
    L8:
        if (r3.hasNext() == false) goto L10;
        String r4 = r3.next();     // Catch: JSONException -> L12
        r0.put(r4, r2.get(r4).toString());     // Catch: JSONException -> L12
        goto L8
    L10:
        r0.remove("live_tracker_params");     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L20:
        this.c.c("EVENT_ORIGIN_FEATURE", "TEMAI");
        this.c.c("enter_from", "live");
        this.c.c("ecom_group_type", "live");
        this.c.c("_param_live_platform", "live");
        int r10 = RoomContextController.h;
        if (RoomContextController.a.a().x() == false) goto L27;
        RoomContextController r11 = RoomContextController.a.a();
        this.c.c("display_room_id", r11.B());
        this.c.c("display_anchor_id", r11.y());
        this.c.c("display_sec_anchor_id", r11.z());
        this.c.c("display_follow_status", r11.K().get("follow_status"));
        com.bytedance.android.ec.model.response.n1 r12 = r11.f;
        if (r12 == null) goto L27;
        if (r12.a() == null) goto L27;
        k0 r5 = this.c;
        int r13 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        r5.c("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r12.a()));
    L27:
        int r14 = ECSdk.a;
        IAdapterService r15 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r15 == null) goto L34;
        r15.getStrategyService();
        return;
    }

    public final void m(Map r4) {
        if (r4 == null) goto L15;
        Map r0 = (Map) r4.get(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        if (r0 == null) goto L9;
        Iterator r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r1.next();
        f((String) r2.getKey(), (String) r2.getValue());
    L9:
        Map r5 = (Map) r4.get(this.a);
        if (r5 == null) goto L18;
        Iterator r6 = r5.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L19;
        Map.Entry r3 = (Map.Entry) r6.next();
        f((String) r3.getKey(), (String) r3.getValue());
        goto L13
    L19:
        return;
    L18:
        return;
    }

    public ECEventV3(RoomContextController r6, String r7) {
        this.b = true;
        if (r6 != null) goto L5;
    L40:
        j(r7);
        return;
    L5:
        if (com.bytedance.android.ec.core.opt.ab.c.q() != 1) goto L40;
        this.a = r7;
        this.c = new k0();
        HashMap<String, String> r8 = l0.h(r6);
        HashMap r0 = new HashMap();
        r0.putAll(r8);
        String r1 = (String) r0.get("live_tracker_params");
        if (TextUtils.isEmpty(r1) == true) goto L17;
        JSONObject r2 = new JSONObject(r1);     // Catch: JSONException -> L14
        Iterator<String> r3 = r2.keys();     // Catch: JSONException -> L14
    L10:
        if (r3.hasNext() == false) goto L12;
        String r4 = r3.next();     // Catch: JSONException -> L14
        r0.put(r4, r2.get(r4).toString());     // Catch: JSONException -> L14
        goto L10
    L12:
        r0.remove("live_tracker_params");     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L17:
        if (r6.x() == false) goto L19;
        ECContext r9 = r6.r();
    L20:
        if (r9 != null) goto L22;
        HashMap r5 = new HashMap();
    L27:
        if (r5.isEmpty() == true) goto L29;
        this.c.d(r5);
    L29:
        h(r6.B(), r6.D());
        this.c.d(r0);
        Map r10 = Collections.unmodifiableMap(f2.b.a);
        if (r10 == null) goto L32;
        this.c.d(r10);
    L32:
        this.c.c("EVENT_ORIGIN_FEATURE", "TEMAI");
        this.c.c("enter_from", "live");
        this.c.c("ecom_group_type", "live");
        this.c.c("_param_live_platform", "live");
        this.c.c("display_room_id", r6.B());
        this.c.c("display_anchor_id", r6.y());
        this.c.c("display_sec_anchor_id", r6.z());
        this.c.c("display_follow_status", r6.K().get("follow_status"));
        com.bytedance.android.ec.model.response.n1 r11 = r6.f;
        if (r11 != null) goto L35;
    L37:
        int r12 = ECSdk.a;
        IAdapterService r13 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r13 == null) goto L45;
        r13.getStrategyService();
        return;
    L45:
        return;
    L35:
        if (r11.a() == null) goto L37;
        k0 r14 = this.c;
        int r15 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        r14.c("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r11.a()));
        goto L37
    L22:
        if (((Map) r9.getEnterRoomParams().getValue()).containsKey("jump_schema") == false) goto L24;
        r5 = new HashMap((Map) r9.getEnterRoomParams().getValue());
        r5.remove("jump_schema");
        goto L27
    L24:
        r5 = (HashMap) r9.getEnterRoomParams().getValue();
        goto L27
    L19:
        r9 = null;
        goto L20
    }

    public final ECEventV3 b(String r2, int r3) {
        this.c.a(r2, r3);
        return this;
    }

    public final ECEventV3 c(String r2, String r3) {
        this.c.c(r2, r3);
        return this;
    }

    public final void d(String r2, int r3) {
        this.c.a(r2, r3);
    }

    public final void e(String r2, long r3) {
        this.c.b(r2, r3);
    }

    public final void f(String r2, String r3) {
        this.c.c(r2, r3);
    }

    public final void h(String r4, String r5) {
        Lazy r0 = ExtraController.l;     // Catch: Exception -> L11
        ExtraController r6 = ControllerCenter.c(r4, r5).u;     // Catch: Exception -> L11
        Objects.toString(r6);     // Catch: Exception -> L11
        if (r6.x() == false) goto L13;
        JSONObject r7 = r6.H();     // Catch: Exception -> L11
        if (r7 == null) goto L13;
        Iterator<String> r8 = r7.keys();     // Catch: Exception -> L11
    L8:
        if (r8.hasNext() == false) goto L13;
        String r1 = r8.next();     // Catch: Exception -> L11
        this.c.c(r1, r7.optString(r1, ""));     // Catch: Exception -> L11
    L13:
        Map<String, String> r9 = this.c.a;
        if (r9 == null) goto L21;
        HashMap r10 = (HashMap) r9;
        r10.remove("pass_through_log_data");
        r10.remove("multi_room_data");
        r10.remove("single_room_data");
        return;
    L21:
        return;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L13
    }

    public final void l(final String r2, final String r3) {
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        return;
    L5:
        oh.a.a(new m0(this, r2, r3));
    }

    public ECEventV3(String r1, int r2) {
        this.b = true;
        this.b = false;
        j(r1);
    }
}

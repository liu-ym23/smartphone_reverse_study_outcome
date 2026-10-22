package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.os.Bundle;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.event.h0;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECBasicLogDataMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBasicLogDataMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECBasicLogDataMethod() {
        this.e = "ecBasicLogData";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r9, ECBaseBridgeMethod.a r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "iReturn");
        Map<String, String> r0 = new h0().c.a;
        String r2 = "";
        String r3 = r9.optString("room_id", "");
        String r11 = r9.optString("room_unique_key", "");
        if (r3.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
    L11:
        JSONObject r1 = new JSONObject();
        HashMap r5 = (HashMap) r0;
        Iterator r6 = r5.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        Map.Entry r7 = (Map.Entry) r6.next();
        r1.put((String) r7.getKey(), r7.getValue());
        goto L13
    L15:
        JSONObject r8 = new JSONObject();
        Iterator r12 = r5.entrySet().iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        Map.Entry r13 = (Map.Entry) r12.next();
        r8.put((String) r13.getKey(), r13.getValue());
        goto L17
    L19:
        r8.put("screen_type", l0.m(r3, r11));
        JSONObject r14 = new JSONObject();
        Iterator r15 = r5.entrySet().iterator();
    L21:
        if (r15.hasNext() == false) goto L23;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.put((String) r16.getKey(), r16.getValue());
        goto L21
    L23:
        int r17 = w.h;
        r14.put("ecom_scene_id", w.a.b());
        JSONObject r18 = new JSONObject();
        int r19 = RoomContextController.h;
        com.bytedance.android.ec.adapter.api.state.a r20 = RoomContextController.a.a().L();
        Bundle r21 = null;
        if (r20 == null) goto L26;
        String r22 = r20.h;
    L27:
        if (r22 == null) goto L30;
        r2 = r22;
    L30:
        r18.put("sec_author_id", r2);
        xk2.a.C0189a r23 = xk2.a.h;
        com.bytedance.android.ec.adapter.api.state.a r24 = RoomContextController.a.a().L();
        if (r24 == null) goto L33;
        r23.getClass();
        r21 = r24.n;
    L33:
        r23.getClass();
        JSONObject r25 = xk2.a.C0189a.a(r21);
        if (r25 == null) goto L36;
        r18.put("ecp_red_pack", r25.toString());
    L36:
        JSONObject r26 = new JSONObject();
        r26.put("native", r1);
        r26.put("order", r8);
        r26.put("entrance_info", r14.toString());
        r26.put("extra", r18.toString());
        Unit r27 = Unit.INSTANCE;
        r10.onSuccess(r26);
        return;
    L26:
        r22 = null;
        goto L27
    L8:
        if ((!Intrinsics.areEqual(r3, (String) ((HashMap) r0).get("room_id"))) == false) goto L11;
        r10.onFailed(0, "wrong room_id");
        return;
    L5:
        r4 = false;
        goto L6
    }
}

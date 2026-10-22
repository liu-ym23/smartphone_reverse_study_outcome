package com.bytedance.android.livesdk.log;

import android.os.Bundle;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static void a(Bundle r6, String r7, String r8, HashMap<String, String> r9) {
        if (r6 == null) goto L24;
        if (r6.getBoolean("enter_from_effect_ad") == false) goto L24;
        JSONObject r2 = new JSONObject();
        if (r9.isEmpty() == false) goto L57;
    L14:
        Serializable r3 = r6.getSerializable("live_effect_ad_log_extra_map");
        if ((r3 instanceof HashMap) == false) goto L24;
        HashMap r4 = (HashMap) r3;
        ILiveDouPlusService r5 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r10 = new HashMap();
        r10.put("ad_extra_data", r2.toString());
        if (r4 != null) goto L19;
    L22:
        r5.logEvent(true, r7, r8, r10);
        goto L24
    L19:
        if (r4.isEmpty() == true) goto L22;
        r10.putAll(r4);
        goto L22
    L57:
        Iterator<String> r11 = r9.keySet().iterator();     // Catch: Exception -> L13
    L10:
        if (r11.hasNext() == false) goto L14;
        String r12 = r11.next();     // Catch: Exception -> L13
        r2.put(r12, r9.get(r12));     // Catch: Exception -> L13
    L24:
        if ("exit".equals(r8) == false) goto L26;
    L34:
        boolean r13 = false;
    L35:
        if (r13 == true) goto L65;
        if (r6 != null) goto L38;
        return;
    L38:
        if (r6.getBoolean("enter_from_hybrid_ad") == false) goto L67;
        JSONObject r14 = new JSONObject();
        if (r9.isEmpty() == false) goto L59;
    L47:
        Serializable r15 = r6.getSerializable("live_hybrid_ad_log_extra_map");
        if ((r15 instanceof HashMap) == false) goto L68;
        HashMap r16 = (HashMap) r15;
        ILiveDouPlusService r17 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r18 = new HashMap();
        r18.put("ad_extra_data", r14.toString());
        if (r16 != null) goto L52;
    L55:
        r17.logEvent(true, r7, r8, r18);
        return;
    L52:
        if (r16.isEmpty() == true) goto L55;
        r18.putAll(r16);
        goto L55
    L68:
        return;
    L59:
        Iterator<String> r19 = r9.keySet().iterator();     // Catch: Exception -> L46
    L43:
        if (r19.hasNext() == false) goto L47;
        String r20 = r19.next();     // Catch: Exception -> L46
        r14.put(r20, r9.get(r20));     // Catch: Exception -> L46
    L67:
        return;
    L65:
        return;
    L26:
        if ("show_over".equals(r8) == true) goto L34;
        if ("show".equals(r8) == true) goto L34;
        if ("live_play".equals(r8) == true) goto L34;
        if ("enter".equals(r8) == true) goto L34;
        r13 = true;
        goto L35
    }

    public static void c(DataCenter r4, String r5, String r6, HashMap<String, String> r7) {
        if (c1.c(r4) == false) goto L22;
        JSONObject r0 = new JSONObject();
        if (r7.isEmpty() == false) goto L18;
    L12:
        ILiveDouPlusService r8 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r1 = new HashMap();
        r1.put("ad_extra_data", r0.toString());
        Map r9 = c1.f(r4);
        if (r9.isEmpty() == true) goto L16;
        r1.putAll(r9);
    L16:
        r8.logEvent(true, r5, r6, r1);
        return;
    L18:
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: Exception -> L11
    L8:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();     // Catch: Exception -> L11
        r0.put(r3, r7.get(r3));     // Catch: Exception -> L11
    }

    public static void b(DataCenter r2, String r3, String r4, String r5, String r6) {
        HashMap r0 = new HashMap();
        r0.put("anchor_id", r5);
        r0.put("room_id", String.valueOf(r6));
        c(r2, r3, r4, r0);
    }
}

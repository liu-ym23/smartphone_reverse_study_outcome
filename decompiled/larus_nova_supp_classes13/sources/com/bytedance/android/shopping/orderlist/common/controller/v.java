package com.bytedance.android.shopping.orderlist.common.controller;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v {
    public final String a;
    public final String b;
    public final Map<?, ?> c;

    public final void a() {
        Object r0 = this.c.get("preload_url");
        JSONObject r2 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        Object r3 = this.c.get("render_type");
        if (r3 == null) goto L85;
        Integer r4 = com.bytedance.kmp.ec.yata.common.utils.d.d(r3);
        if (r4 == null) goto L86;
        int r5 = r4.intValue();
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        PreloadType r6 = null;
    L18:
        if (r6 != null) goto L20;
        return;
    L20:
        Object r7 = this.c.get("sub_preload_resource");
        if ((r7 instanceof Map) == true) goto L23;
        r7 = null;
    L23:
        Map r8 = (Map) r7;
        int r9 = com.bytedance.android.shopping.yata.init.a.a;
        Object r10 = ECSettingKeys.f0().get("fix_self_add_preload_task");
        if ((r10 instanceof Boolean) == true) goto L26;
        r10 = null;
    L26:
        Boolean r11 = (Boolean) r10;
        if (r11 == null) goto L29;
        boolean r12 = r11.booleanValue();
    L30:
        if (r12 == false) goto L51;
        JSONObject r13 = new JSONObject();
        if (r8 == null) goto L45;
        Iterator r14 = r8.entrySet().iterator();
    L35:
        if (r14.hasNext() == false) goto L45;
        Map.Entry r15 = (Map.Entry) r14.next();
        JSONArray r16 = new JSONArray();
        List r17 = (List) r15.getValue();
        if (r17 == null) goto L44;
        Iterator r18 = r17.iterator();
    L40:
        if (r18.hasNext() == false) goto L44;
        if (((String) r18.next()) == null) goto L40;
        JSONObject r19 = new JSONObject();
        r19.put("url", r15);
        r19.put("enableMemory", true);
        r19.put("processType", "templateBundle");
        Unit r110 = Unit.INSTANCE;
        r16.put(r19);
    L44:
        r13.put((String) r15.getKey(), r16);
    L45:
        PreloadType r20 = PreloadType.LYNX;
        if (r6 != r20) goto L48;
        com.bytedance.ies.bullet.forest.f r21 = ForestLoader.a;
        ForestLoader.m(null, r1, r13, BuyNowUrlType.ORDER_LIST, null, r20, new v26.l(), new com.bytedance.ies.bullet.forest.w(ib.e.a(UriProtector.parse(r1)), 2), true, 1);
    L48:
        PreloadType r22 = PreloadType.WEB;
        if (r6 != r22) goto L87;
        com.bytedance.ies.bullet.forest.f r23 = ForestLoader.a;
        ForestLoader.j(null, r1, r13, BuyNowUrlType.ORDER_LIST, null, r22, new v26.l(), true, 1);
        return;
    L87:
        return;
    L51:
        if (r8 == null) goto L68;
        r2 = new JSONObject();
        Iterator r24 = r8.entrySet().iterator();
    L54:
        if (r24.hasNext() == false) goto L68;
        Map.Entry r25 = (Map.Entry) r24.next();
        JSONArray r26 = new JSONArray();
        List r27 = (List) r25.getValue();
        if (r27 == null) goto L67;
        ArrayList r28 = new ArrayList();
        Iterator r29 = r27.iterator();
    L59:
        if (r29.hasNext() == false) goto L63;
        Object r30 = r29.next();
        if ((r30 instanceof String) == false) goto L59;
        r28.add(r30);
        goto L59
    L63:
        Iterator r31 = r28.iterator();
    L65:
        if (r31.hasNext() == false) goto L67;
        r26.put((String) r31.next());
    L67:
        r2.put((String) r25.getKey(), r26);
    L68:
        JSONObject r32 = r2;
        com.bytedance.ies.bullet.forest.f r33 = ForestLoader.a;
        ForestLoader.j(ForestLoader.d(), r1, r32, BuyNowUrlType.ORDER_LIST, null, r6, null, true, 64);
        return;
    L29:
        r12 = true;
        goto L30
    L16:
        r6 = PreloadType.WEB;
        goto L18
    L17:
        r6 = PreloadType.LYNX;
        goto L18
    L86:
        return;
    }

    public v(Map<?, ?> r4) {
        Intrinsics.checkNotNullParameter(r4, "originMap");
        this.c = r4;
        Object r0 = r4.get("preload_biz_scene");
        Object r2 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        this.a = (String) r0;
        Object r5 = r4.get("bundle_id");
        if ((r5 instanceof String) == false) goto L9;
        r2 = r5;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        this.b = r3;
    }
}

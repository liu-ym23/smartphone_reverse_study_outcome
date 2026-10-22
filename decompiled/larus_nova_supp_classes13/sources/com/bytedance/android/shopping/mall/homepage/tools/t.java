package com.bytedance.android.shopping.mall.homepage.tools;

import android.net.Uri;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t {
    public static final void a(ef3.a r17, OpenSchemaParams r18, String r19, Object r20, String r21) {
        Intrinsics.checkNotNullParameter(r17, "mallContext");
        Intrinsics.checkNotNullParameter(r18, "openSchemaParams");
        Intrinsics.checkNotNullParameter(r21, "scene");
        String r6 = r18.getSchema();
        EcomSceneIdParams r7 = new EcomSceneIdParams(r18.getEntranceInfo(), r18.getCurrentEcomSceneId(), r18.getType(), r18.getAddEcomSceneId());
        Intrinsics.checkNotNullParameter(r6, "schema");
        Intrinsics.checkNotNullParameter(r7, "opts");
        String r8 = r7.getEntranceInfo();
        String r9 = r7.getCurrentEcomSceneId();
        String r10 = r7.getAddEcomSceneId();
        r7.getType();
        StringBuilder r11 = new StringBuilder();
        boolean r12 = true;
        if (r8 != null) goto L92;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == true) goto L15;
        JSONObject r13 = com.bytedance.android.ec.hybrid.list.util.k.c(r8);     // Catch: Exception -> L18
        if (r13 == null) goto L15;
        String r14 = r13.optString("ecom_scene_id", "");     // Catch: Exception -> L18
        if (r14 == null) goto L15;
    L16:
        String r16 = a.c(r14, r9);     // Catch: Exception -> L18
    L19:
        r11.append(r16);
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        r11.append(r10);
        String r22 = r11.toString();
        if (r22.length() != 0) goto L25;
        boolean r23 = true;
    L27:
        if (r23 == true) goto L73;
        Intrinsics.checkNotNullParameter(r6, "link");
        if (r22.length() != 0) goto L32;
        boolean r110 = true;
    L33:
        if (r110 == true) goto L73;
        if (StringsKt.startsWith$default(r6, "http", false, 2, null) == false) goto L94;
        r6 = a.b(r6, r22);
        goto L73
    L94:
        Uri r111 = UriProtector.parse(r6);     // Catch: Exception -> L72
        String r112 = com.bytedance.android.shopping.api.mall.common.tools.v.g(r111, "url");     // Catch: Exception -> L72
        if (r112 != null) goto L41;
    L44:
        boolean r113 = true;
    L45:
        if (r113 == true) goto L47;
        r6 = a.a(r6, MapsKt.mapOf(TuplesKt.to("url", a.b(r112, r22))));     // Catch: Exception -> L72
        goto L73
    L47:
        String r114 = com.bytedance.android.shopping.api.mall.common.tools.v.g(r111, "surl");     // Catch: Exception -> L72
        if (r114 != null) goto L50;
    L53:
        boolean r115 = true;
    L54:
        if (r115 == true) goto L56;
        r6 = a.a(r6, MapsKt.mapOf(TuplesKt.to("surl", a.b(r114, r22))));     // Catch: Exception -> L72
        goto L73
    L56:
        if (r112 != null) goto L58;
    L61:
        boolean r24 = true;
    L62:
        if (r24 == false) goto L73;
        if (r114 != null) goto L65;
    L68:
        boolean r25 = true;
    L69:
        if (r25 == false) goto L73;
        r6 = a.a(a.b(r6, r22), MapsKt.mapOf(TuplesKt.to("ecom_scene_id", r22)));     // Catch: Exception -> L72
        goto L73
    L65:
        if (r114.length() == 0) goto L68;
        r25 = false;
        goto L69
    L58:
        if (r112.length() == 0) goto L61;
        r24 = false;
        goto L62
    L50:
        if (r114.length() == 0) goto L53;
        r115 = false;
        goto L54
    L41:
        if (r112.length() == 0) goto L44;
        r113 = false;
        goto L45
    L32:
        r110 = false;
    L73:
        ECHybridListEngine r26 = r17.h.J;
        if (r26 == null) goto L76;
        ECHybridRecyclerView r27 = r26.b;
    L77:
        if (r27 != null) goto L80;
        com.bytedance.android.shopping.api.mall.common.tools.b0.l("schema depend view is null", null);
        return;
    L80:
        LinkedHashMap r28 = new LinkedHashMap();
        if (r19 != null) goto L83;
    L86:
        if (r12 == true) goto L88;
        r28.put("btm", r19);
    L88:
        if (r20 == null) goto L90;
        r28.put("bcm", r20);
    L90:
        r28.put("schema", r6);
        r28.put("scene", r21);
        int r1 = com.bytedance.android.shopping.api.mall.common.tools.b.a;
        String r2 = com.bytedance.android.shopping.api.mall.common.tools.b.a(r6, r28, PageFinder.via(r27), r17.getContext(), false);
        Map<String, Object> r3 = MapsKt.toMutableMap(r28);
        r3.putAll(r17.h.A1.getGlobalProps());
        com.bytedance.android.shopping.api.mall.common.tools.k.b.d(r17.getContext(), r2, r3);
        com.bytedance.android.shopping.mall.feed.jsb.c0.b(r17.h, r2, r21);
        return;
    L83:
        if (r19.length() == 0) goto L86;
        r12 = false;
        goto L86
    L76:
        r27 = null;
        goto L77
    L25:
        r23 = false;
    L18:
        r16 = a.c("", r9);
    L15:
        r14 = "";
        goto L16
    L92:
        if (r8.length() == 0) goto L8;
        r15 = false;
        goto L9
    }
}

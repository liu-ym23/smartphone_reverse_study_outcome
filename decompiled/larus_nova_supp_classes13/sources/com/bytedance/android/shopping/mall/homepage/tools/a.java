package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final String a(String r1, Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r1, "link");
        Intrinsics.checkNotNullParameter(r2, "params");
        return com.bytedance.android.shopping.api.mall.common.tools.v.c(r1, r2);
    L8:
        return r1;
    }

    public static final String b(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "url");
        Intrinsics.checkNotNullParameter(r9, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r8, "link");
        Map<String, String> r0 = com.bytedance.android.shopping.api.mall.common.tools.v.f(UriProtector.parse(r8));     // Catch: Exception -> L5
    L6:
        String r1 = r0.get("entrance_info");
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = r1;
        Map r10 = MapsKt.mapOf(TuplesKt.to("ecom_scene_id", r9));
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r2 != null) goto L13;
        String r11 = com.bytedance.android.ec.hybrid.list.util.k.d(r10);
    L34:
        return a(r8, MapsKt.mapOf(TuplesKt.to("entrance_info", r11)));
    L13:
        if (r2.length() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L36;
        r2 = com.bytedance.android.ec.hybrid.list.util.k.d(r10);
    L32:
        r11 = r2;
        goto L34
    L36:
        JSONObject r4 = com.bytedance.android.ec.hybrid.list.util.k.c(r2);     // Catch: Exception -> L35
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L35
        if (r4 == null) goto L31;
        Iterator<String> r6 = r4.keys();     // Catch: Exception -> L35
        if (r6 == null) goto L31;
    L23:
        if (r6.hasNext() == false) goto L31;
        String r7 = r6.next();     // Catch: Exception -> L35
        Object r12 = r4.opt(r7);     // Catch: Exception -> L35
        if (r12 == null) goto L27;
        String r13 = r12.toString();     // Catch: Exception -> L35
    L28:
        if (r13 == null) goto L23;
        if (r7 == null) goto L23;
        r5.put(r7, r13);     // Catch: Exception -> L35
        goto L23
    L27:
        r13 = null;
    L31:
        r5.putAll(r10);     // Catch: Exception -> L35
        r2 = com.bytedance.android.ec.hybrid.list.util.k.d(r5);     // Catch: Exception -> L35
        goto L32
    L15:
        r3 = false;
    L5:
        r0 = MapsKt.emptyMap();
        goto L6
    }

    public static final String c(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "ecomSceneId");
        if (r10 == null) goto L24;
        List r11 = StringsKt.split$default(r9, new String[]{","}, false, 0, 6, null);
        ArrayList r0 = new ArrayList();
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L18;
        Object r1 = r12.next();
        String r2 = (String) r1;
        boolean r4 = false;
        if (r2.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
    L15:
        if (r4 == false) goto L6;
        r0.add(r1);
        goto L6
    L13:
        if ((!Intrinsics.areEqual(r2, r10)) == false) goto L15;
        r4 = true;
        goto L15
    L10:
        r3 = false;
        goto L11
    L18:
        return CollectionsKt.joinToString$default(CollectionsKt.plus(CollectionsKt.toMutableList(r0), r10), ",", null, null, 0, null, null, 62, null);
    L24:
        return r9;
    }
}

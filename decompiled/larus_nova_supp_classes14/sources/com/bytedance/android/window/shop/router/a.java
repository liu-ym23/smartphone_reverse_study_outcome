package com.bytedance.android.window.shop.router;

import android.net.Uri;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final boolean a;
    public final Map<String, String> b;
    public final Uri c;

    public a(Uri r12) {
        Intrinsics.checkNotNullParameter(r12, "uri");
        this.c = r12;
        int r13 = yq3.a.a;
        int r14 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = d.c.get("window_opt_uri_parse");     // Catch: Throwable -> L54
        if (r5 != null) goto L9;
    L51:
        Object r6 = null;
    L52:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L54
    L56:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L160
        if (r8 == null) goto L60;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r7) == false) goto L63;
        r7 = null;
    L63:
        if ((r7 instanceof Integer) == true) goto L65;
        r7 = null;
    L65:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L160
        if (r9 != null) goto L72;
        Object r10 = d.a.get("window_opt_uri_parse");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L169;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r15 = d.c.get("window_opt_uri_parse");     // Catch: Throwable -> L124
        if (r15 != null) goto L79;
    L121:
        Object r16 = null;
    L122:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L124
    L126:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L150
        if (r18 == null) goto L130;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r17) == false) goto L133;
        r17 = null;
    L133:
        if ((r17 instanceof Integer) == true) goto L135;
        r17 = null;
    L135:
        r9 = (Integer) r17;     // Catch: Throwable -> L150
        if (r9 != null) goto L158;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r19 == null) goto L141;
        Object r20 = r19.getHostABValue("window_opt_uri_parse", r1);     // Catch: Throwable -> L150
    L142:
        if (r20 != null) goto L144;
    L149:
        r9 = r1;
        goto L158
    L144:
        if ((r20 instanceof Integer) == false) goto L147;
        r4 = r20;
    L147:
        Object r21 = (Integer) r4;     // Catch: Throwable -> L150
        if (r21 == null) goto L149;
    L157:
        r9 = r21;
        goto L158
    L141:
        r20 = null;
    L158:
        d.d("window_opt_uri_parse", r9);     // Catch: Throwable -> L160
        goto L169
    L79:
        if ((r15 instanceof Integer) == true) goto L81;
        Object r22 = null;
    L82:
        r16 = (Integer) r22;     // Catch: Throwable -> L124
        if (r16 != null) goto L122;
        if ((r15 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r23 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L124
        if ((r23 instanceof Integer) == true) goto L92;
        r23 = null;
    L92:
        r16 = (Integer) r23;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r24 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L124
        if ((r24 instanceof Integer) == true) goto L98;
        r24 = null;
    L98:
        r16 = (Integer) r24;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r25 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L124
        if ((r25 instanceof Integer) == true) goto L107;
        r25 = null;
    L107:
        r16 = (Integer) r25;     // Catch: Throwable -> L124
    L109:
        if ((r15 instanceof JSONObject) == false) goto L111;
    L205:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r26 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r26 instanceof Integer) == true) goto L115;
        r26 = null;
    L115:
        Object r27 = Result.constructor-impl((Integer) r26);     // Catch: Throwable -> L117
    L119:
        r16 = r27;
        if (Result.isFailure-impl(r16) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L124
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r15 instanceof JSONArray) == false) goto L121;
    L81:
        r22 = r15;
    L150:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L160
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r30 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L160
        if (r30 == null) goto L155;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r21) == false) goto L157;
        r21 = r1;
    L124:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L150
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L169:
        boolean r32 = true;
        if (((Number) r9).intValue() == 1) goto L173;
        r32 = false;
    L173:
        this.a = r32;
        if (r32 == false) goto L192;
        Uri r110 = this.c;
        Intrinsics.checkNotNullParameter(r110, "$this$quickGetQueryMap");
        String r33 = r110.getEncodedQuery();     // Catch: Exception -> L190
        if (r33 != null) goto L179;
        Map<String, String> r111 = new HashMap();     // Catch: Exception -> L190
    L193:
        this.b = r111;
        return;
    L179:
        r111 = new LinkedHashMap();     // Catch: Exception -> L190
        Object[] r34 = StringsKt.split$default(r33, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);     // Catch: Exception -> L190
        if (r34 == null) goto L189;
        String[] r35 = (String[]) r34;     // Catch: Exception -> L190
        int r36 = r35.length;     // Catch: Exception -> L190
        int r37 = 0;
    L182:
        if (r37 >= r36) goto L193;
        String r112 = r35[r37];     // Catch: Exception -> L190
        int r38 = StringsKt.indexOf$default(r112, "=", 0, false, 6, null);     // Catch: Exception -> L190
        if (r112 == null) goto L187;
        r111.put(Uri.decode(r112.substring(0, r38)), Uri.decode(r112.substring(r38 + 1)));     // Catch: Exception -> L190
        r37 = r37 + 1;     // Catch: Exception -> L190
        goto L182
    L187:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L190
    L189:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L190
    L190:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e.toString());
        r111 = new HashMap();
        goto L193
    L192:
        r111 = new LinkedHashMap();
        goto L193
    L9:
        if ((r5 instanceof Integer) == true) goto L11;
        Object r39 = null;
    L12:
        r6 = (Integer) r39;     // Catch: Throwable -> L54
        if (r6 != null) goto L52;
        if ((r5 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r40 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L22;
        r40 = null;
    L22:
        r6 = (Integer) r40;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r41 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L54
        if ((r41 instanceof Integer) == true) goto L28;
        r41 = null;
    L28:
        r6 = (Integer) r41;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r6 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r42 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L54
        if ((r42 instanceof Integer) == true) goto L37;
        r42 = null;
    L37:
        r6 = (Integer) r42;     // Catch: Throwable -> L54
    L39:
        if ((r5 instanceof JSONObject) == false) goto L41;
    L203:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r43 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r43 instanceof Integer) == true) goto L45;
        r43 = null;
    L45:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L47
    L49:
        r6 = r44;
        if (Result.isFailure-impl(r6) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L54
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r5 instanceof JSONArray) == false) goto L51;
    L11:
        r39 = r5;
    L54:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L160
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r113 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r113);
        if (r48 == null) goto L165;
        EnsureManager.ensureNotReachHere(r48);
    L165:
        if (Result.isFailure-impl(r113) == true) goto L168;
        r1 = r113;
    L168:
        r9 = r1;
        goto L169
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.a == false) goto L9;
        if ((!this.b.isEmpty()) == false) goto L9;
        return this.b.get(r2);
    L9:
        return UriProtector.getQueryParameter(this.c, r2);
    }
}

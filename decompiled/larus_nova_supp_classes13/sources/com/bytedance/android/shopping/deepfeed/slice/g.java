package com.bytedance.android.shopping.deepfeed.slice;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/g;", "", "", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "preloadNum", "I", "b", "()I", "name", "a", "version", "getVersion", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {
    public static final Map<String, LinkedTreeMap<String, Object>> a = null;

    @SerializedName("name")
    private final String name;

    @SerializedName("preload_num")
    private final int preloadNum;

    @SerializedName("url")
    private final String url;

    @SerializedName("version")
    private final String version;

    public static final class a {
        public static Map a() {
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<T> r1 = g.a.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L34;
            String r2 = (String) r1.next();
            Map<String, LinkedTreeMap<String, Object>> r4 = g.a;
            LinkedTreeMap<String, Object> r5 = r4.get(r2);
            String r6 = null;
            if (r5 == null) goto L10;
            Object r7 = r5.get("url");
            if (r7 == null) goto L10;
            String r8 = r7.toString();
        L11:
            LinkedTreeMap<String, Object> r9 = r4.get(r2);
            if (r9 == null) goto L14;
            Object r10 = r9.get("preload_num");
        L16:
            if ((r10 instanceof Number) == true) goto L18;
            r10 = null;
        L18:
            Number r11 = (Number) r10;
            if (r11 == null) goto L21;
            int r12 = r11.intValue();
        L22:
            LinkedTreeMap<String, Object> r13 = r4.get(r2);
            if (r13 == null) goto L27;
            Object r14 = r13.get("name");
            if (r14 == null) goto L27;
            String r15 = r14.toString();
        L28:
            LinkedTreeMap<String, Object> r16 = r4.get(r2);
            if (r16 == null) goto L33;
            Object r17 = r16.get("version");
            if (r17 == null) goto L33;
            r6 = r17.toString();
        L33:
            r0.put(r2, new g(r8, r12, r15, r6));
        L27:
            r15 = null;
            goto L28
        L21:
            r12 = 1;
            goto L22
        L14:
            r10 = null;
        L10:
            r8 = null;
            goto L11
        L34:
            return r0;
        }
    }

    public g() {
        this(null, 1, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L14;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
        return false;
    L8:
        if (this.preloadNum == r4.preloadNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r4.version) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.preloadNum) * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.version;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedSliceSetting(url=" + this.url + ", preloadNum=" + this.preloadNum + ", name=" + this.name + ", version=" + this.version + ")";
    }

    static {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = new LinkedHashMap();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L170
        Object r3 = null;
        Object r4 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_slice_config");     // Catch: Throwable -> L57
        if (r4 != null) goto L9;
    L54:
        Object r5 = null;
    L55:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L57
    L59:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L170
        if (r7 == null) goto L63;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L170
    L63:
        if (Result.isFailure-impl(r6) == false) goto L66;
        r6 = null;
    L66:
        if (TypeIntrinsics.isMutableMap(r6) == true) goto L68;
        r6 = null;
    L68:
        Object r8 = (Map) r6;     // Catch: Throwable -> L170
        if (r8 != null) goto L71;
    L73:
        Object r9 = com.bytedance.android.ec.base.settings.d.a.get("mall_deep_feed_slice_config");     // Catch: Throwable -> L170
        if (TypeIntrinsics.isMutableMap(r9) == true) goto L76;
        r9 = null;
    L76:
        r8 = (Map) r9;     // Catch: Throwable -> L170
    L77:
        if (r8 != null) goto L179;
        int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L170
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_slice_config");     // Catch: Throwable -> L132
        if (r11 != null) goto L84;
    L129:
        Object r12 = null;
    L130:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L132
    L134:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L160
        if (r14 == null) goto L138;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L160
    L138:
        if (Result.isFailure-impl(r13) == false) goto L141;
        r13 = null;
    L141:
        if (TypeIntrinsics.isMutableMap(r13) == true) goto L143;
        r13 = null;
    L143:
        r8 = (Map) r13;     // Catch: Throwable -> L160
        if (r8 != null) goto L146;
    L148:
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L160
        if (r15 == null) goto L151;
        Object r16 = r15.getHostABValue("mall_deep_feed_slice_config", r1);     // Catch: Throwable -> L160
    L152:
        if (r16 != null) goto L154;
    L159:
        r8 = r1;
    L168:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_slice_config", r8);     // Catch: Throwable -> L170
        goto L179
    L154:
        if (TypeIntrinsics.isMutableMap(r16) == false) goto L157;
        r3 = r16;
    L157:
        Object r17 = (Map) r3;     // Catch: Throwable -> L160
        if (r17 == null) goto L159;
    L167:
        r8 = r17;
        goto L168
    L151:
        r16 = null;
        goto L152
    L146:
        if (TypeIntrinsics.isMutableMap(r8) == false) goto L148;
    L84:
        if (TypeIntrinsics.isMutableMap(r11) == true) goto L86;
        Object r18 = null;
    L87:
        r12 = (Map) r18;     // Catch: Throwable -> L132
        if (r12 != null) goto L130;
        if ((r11 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r19) == true) goto L97;
        r19 = null;
    L97:
        r12 = (Map) r19;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r20) == true) goto L103;
        r20 = null;
    L103:
        r12 = (Map) r20;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r21 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r21) == true) goto L109;
        r21 = null;
    L109:
        r12 = (Map) r21;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r22 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L132
        if (TypeIntrinsics.isMutableMap(r22) == true) goto L115;
        r22 = null;
    L115:
        r12 = (Map) r22;     // Catch: Throwable -> L132
    L117:
        if ((r11 instanceof JSONObject) == false) goto L119;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L125
        Object r23 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Map.class);     // Catch: Throwable -> L125
        if (TypeIntrinsics.isMutableMap(r23) == true) goto L123;
        r23 = null;
    L123:
        Object r24 = Result.constructor-impl((Map) r23);     // Catch: Throwable -> L125
    L127:
        r12 = r24;
        if (Result.isFailure-impl(r12) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L132
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r11 instanceof JSONArray) == false) goto L129;
    L86:
        r18 = r11;
    L160:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L170
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L170
        if (r27 == null) goto L165;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L170
    L165:
        if (Result.isFailure-impl(r17) == false) goto L167;
        r17 = r1;
    L132:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L160
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L179:
        a = (Map) r8;
        return;
    L71:
        if (TypeIntrinsics.isMutableMap(r8) == false) goto L73;
    L9:
        if (TypeIntrinsics.isMutableMap(r4) == true) goto L11;
        Object r29 = null;
    L12:
        r5 = (Map) r29;     // Catch: Throwable -> L57
        if (r5 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r30) == true) goto L22;
        r30 = null;
    L22:
        r5 = (Map) r30;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r31) == true) goto L28;
        r31 = null;
    L28:
        r5 = (Map) r31;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r32 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r32) == true) goto L34;
        r32 = null;
    L34:
        r5 = (Map) r32;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if (TypeIntrinsics.isMutableMap(r33) == true) goto L40;
        r33 = null;
    L40:
        r5 = (Map) r33;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L187:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r4.toString(), Map.class);     // Catch: Throwable -> L50
        if (TypeIntrinsics.isMutableMap(r34) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((Map) r34);     // Catch: Throwable -> L50
    L52:
        r5 = r35;
        if (Result.isFailure-impl(r5) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L57
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L11:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L170
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L175;
        EnsureManager.ensureNotReachHere(r40);
    L175:
        if (Result.isFailure-impl(r39) == true) goto L178;
        r1 = r39;
    L178:
        r8 = r1;
        goto L179
    }

    public final String a() {
        return this.name;
    }

    public final int b() {
        return this.preloadNum;
    }

    public final String c() {
        return this.url;
    }

    public g(String r1, int r2, String r3, String r4) {
        this.url = r1;
        this.preloadNum = r2;
        this.name = r3;
        this.version = r4;
    }
}

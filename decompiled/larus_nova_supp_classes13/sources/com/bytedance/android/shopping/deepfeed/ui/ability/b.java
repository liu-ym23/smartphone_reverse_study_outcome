package com.bytedance.android.shopping.deepfeed.ui.ability;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/ability/b;", "", "", "couponAlways", "Z", "a", "()Z", "", "popupSchemaAndroid", "Ljava/lang/String;", "getPopupSchemaAndroid", "()Ljava/lang/String;", "", "popupPriority", "Ljava/util/List;", "getPopupPriority", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {
    public static final b a = null;

    @SerializedName("mall_deep_feed_coupon_always")
    private final boolean couponAlways;

    @SerializedName("mall_deep_feed_popup_priority")
    private final List<String> popupPriority;

    @SerializedName("mall_deep_feed_popup_schema_android")
    private final String popupSchemaAndroid;

    public static final class a {
    }

    public b() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (this.couponAlways == r4.couponAlways) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.popupSchemaAndroid, r4.popupSchemaAndroid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.popupPriority, r4.popupPriority) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r0 = this.couponAlways;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.popupSchemaAndroid;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        List<String> r7 = this.popupPriority;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "DeepFeedSetting(couponAlways=" + this.couponAlways + ", popupSchemaAndroid=" + this.popupSchemaAndroid + ", popupPriority=" + this.popupPriority + ")";
    }

    static {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r2 = null;
        Object r1 = new b(null);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L165
        Object r4 = d.c.get("deep_feed_config");     // Catch: Throwable -> L56
        if (r4 != null) goto L8;
    L53:
        Object r5 = null;
    L54:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L56
    L58:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L165
        if (r7 == null) goto L62;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L165
    L62:
        if (Result.isFailure-impl(r6) == false) goto L65;
        r6 = null;
    L65:
        if ((r6 instanceof b) == true) goto L67;
        r6 = null;
    L67:
        Object r8 = (b) r6;     // Catch: Throwable -> L165
        if (r8 != null) goto L74;
        Object r9 = d.a.get("deep_feed_config");     // Catch: Throwable -> L165
        if ((r9 instanceof b) == true) goto L73;
        r9 = null;
    L73:
        r8 = (b) r9;     // Catch: Throwable -> L165
    L74:
        if (r8 != null) goto L174;
        int r10 = c.a;     // Catch: Throwable -> L165
        Object r11 = d.c.get("deep_feed_config");     // Catch: Throwable -> L129
        if (r11 != null) goto L81;
    L126:
        Object r12 = null;
    L127:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L129
    L131:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L155
        if (r14 == null) goto L135;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L155
    L135:
        if (Result.isFailure-impl(r13) == false) goto L138;
        r13 = null;
    L138:
        if ((r13 instanceof b) == true) goto L140;
        r13 = null;
    L140:
        r8 = (b) r13;     // Catch: Throwable -> L155
        if (r8 != null) goto L163;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L155
        if (r15 == null) goto L146;
        Object r16 = r15.getHostABValue("deep_feed_config", r1);     // Catch: Throwable -> L155
    L147:
        if (r16 != null) goto L149;
    L154:
        r8 = r1;
        goto L163
    L149:
        if ((r16 instanceof b) == false) goto L152;
        r2 = r16;
    L152:
        Object r17 = (b) r2;     // Catch: Throwable -> L155
        if (r17 == null) goto L154;
    L162:
        r8 = r17;
        goto L163
    L146:
        r16 = null;
    L163:
        d.d("deep_feed_config", r8);     // Catch: Throwable -> L165
        goto L174
    L81:
        if ((r11 instanceof b) == true) goto L83;
        Object r18 = null;
    L84:
        r12 = (b) r18;     // Catch: Throwable -> L129
        if (r12 != null) goto L127;
        if ((r11 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L129
        if ((r19 instanceof b) == true) goto L94;
        r19 = null;
    L94:
        r12 = (b) r19;     // Catch: Throwable -> L129
        goto L127
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L129
        if ((r20 instanceof b) == true) goto L100;
        r20 = null;
    L100:
        r12 = (b) r20;     // Catch: Throwable -> L129
        goto L127
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        Integer r21 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L129
        if ((r21 instanceof b) == true) goto L106;
        r21 = null;
    L106:
        r12 = (b) r21;     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r22 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L129
        if ((r22 instanceof b) == true) goto L112;
        r22 = null;
    L112:
        r12 = (b) r22;     // Catch: Throwable -> L129
    L114:
        if ((r11 instanceof JSONObject) == false) goto L116;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r23 = SDKSettingsCacheManager.a().fromJson(r11.toString(), b.class);     // Catch: Throwable -> L122
        if ((r23 instanceof b) == true) goto L120;
        r23 = null;
    L120:
        Object r24 = Result.constructor-impl((b) r23);     // Catch: Throwable -> L122
    L124:
        r12 = r24;
        if (Result.isFailure-impl(r12) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L129
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r11 instanceof JSONArray) == false) goto L126;
    L83:
        r18 = r11;
    L155:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L165
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L165
        if (r27 == null) goto L160;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L165
    L160:
        if (Result.isFailure-impl(r17) == false) goto L162;
        r17 = r1;
    L129:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L155
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L155
    L174:
        a = (b) r8;
        return;
    L8:
        if ((r4 instanceof b) == true) goto L10;
        Object r29 = null;
    L11:
        r5 = (b) r29;     // Catch: Throwable -> L56
        if (r5 != null) goto L54;
        if ((r4 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L56
        if ((r30 instanceof b) == true) goto L21;
        r30 = null;
    L21:
        r5 = (b) r30;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L56
        if ((r31 instanceof b) == true) goto L27;
        r31 = null;
    L27:
        r5 = (b) r31;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r32 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L56
        if ((r32 instanceof b) == true) goto L33;
        r32 = null;
    L33:
        r5 = (b) r32;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r33 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L56
        if ((r33 instanceof b) == true) goto L39;
        r33 = null;
    L39:
        r5 = (b) r33;     // Catch: Throwable -> L56
    L41:
        if ((r4 instanceof JSONObject) == false) goto L43;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
        Object r34 = SDKSettingsCacheManager.a().fromJson(r4.toString(), b.class);     // Catch: Throwable -> L49
        if ((r34 instanceof b) == true) goto L47;
        r34 = null;
    L47:
        Object r35 = Result.constructor-impl((b) r34);     // Catch: Throwable -> L49
    L51:
        r5 = r35;
        if (Result.isFailure-impl(r5) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L56
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r4 instanceof JSONArray) == false) goto L53;
    L10:
        r29 = r4;
    L56:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L165
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L170;
        EnsureManager.ensureNotReachHere(r40);
    L170:
        if (Result.isFailure-impl(r39) == true) goto L173;
        r1 = r39;
    L173:
        r8 = r1;
        goto L174
    }

    public final boolean a() {
        return this.couponAlways;
    }

    public b(Object r3) {
        List<String> r4 = CollectionsKt.listOf(new String[]{"coupon", "feedback_popup", "screen_shot"});
        Intrinsics.checkNotNullParameter(r4, "popupPriority");
        this.couponAlways = false;
        this.popupSchemaAndroid = null;
        this.popupPriority = r4;
    }
}

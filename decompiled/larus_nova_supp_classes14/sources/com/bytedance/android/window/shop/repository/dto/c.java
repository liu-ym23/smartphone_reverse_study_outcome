package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R4\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/c;", "", "", "itemType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "Lcom/google/gson/JsonObject;", "insertParams", "Lcom/google/gson/JsonObject;", "getInsertParams", "()Lcom/google/gson/JsonObject;", "", "uniqueId", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "", "uiElementParams", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "bstIndex", "a", "Lcom/google/gson/JsonElement;", "data", "Lcom/google/gson/JsonElement;", "lynxExtensionData", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("item_index")
    private final Integer bstIndex;

    @SerializedName(alternate = {"product", "recommend_mall", "recommend_store", "video", "live_product", "hot_title", "appointment", "mix_livehot_product", "sync_products", "lynx_common_card", "livehot_latest_info", "livehot_recommend_title", "live_product_list", "coupon_collect", "video_product_card", "author", "follow_buy", "fans_comments", "bubbles", "anchor_bottom_item", "hint_bar", "vertical_margin", "replay_collection"}, value = "")
    private final JsonElement data;

    @SerializedName("dynamic_insert_card_info")
    private final JsonObject insertParams;

    @SerializedName("item_type")
    private final Integer itemType;

    @SerializedName("lynx_extension_card")
    private final JsonElement lynxExtensionData;

    @SerializedName("ui_log_extra")
    private final Map<String, Map<String, String>> uiElementParams;

    @SerializedName("unique_id")
    private final String uniqueId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L20;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.itemType, r4.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.insertParams, r4.insertParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uniqueId, r4.uniqueId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uiElementParams, r4.uiElementParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bstIndex, r4.bstIndex) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxExtensionData, r4.lynxExtensionData) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.itemType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        JsonObject r4 = this.insertParams;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.uniqueId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Map<String, String>> r10 = this.uiElementParams;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.bstIndex;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        JsonElement r16 = this.data;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        JsonElement r19 = this.lynxExtensionData;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final v0 d() {
        JsonElement r0 = this.lynxExtensionData;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (v0) d.a(r0, v0.class);
    }

    public final Map<String, String> e() {
        JsonObject r0 = this.insertParams;
        if (r0 != null) goto L7;
        return MapsKt.emptyMap();
    L7:
        if (r0.keySet().isEmpty() == true) goto L9;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = this.insertParams.keySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L20;
        String r3 = (String) r2.next();
        JsonElement r4 = this.insertParams.get(r3);
        if (r4.isJsonPrimitive() == true) goto L15;
        if (r4.isJsonObject() == true) goto L18;
        r1.put(r3, r4.toString());
        goto L12
    L18:
        r1.put(r3, r4.getAsJsonObject().toString());
        goto L12
    L15:
        r1.put(r3, r4.getAsJsonPrimitive().getAsString());
        goto L12
    L20:
        return r1;
    L9:
        return MapsKt.emptyMap();
    }

    public final boolean h() {
        if (this.itemType != null) goto L5;
    L8:
        return true;
    L5:
        if (this.data == null) goto L8;
        return false;
    }

    public final String toString() {
        int r0 = com.bytedance.android.ec.core.opt.ab.c.a;
        int r1 = com.bytedance.android.ec.core.opt.ab.m.a;
        Object r2 = 0;
        boolean r3 = ECServiceManager.a;
        s83.g r4 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r4 == null) goto L8;
        s83.a r5 = r4.q();
        if (r5 == null) goto L8;
        Object r6 = r5.e("ec_gson_adapter_opt");
        if (r6 == null) goto L8;
    L175:
        if (((Number) r6).intValue() != 1) goto L178;
        return "MixFullItem@" + super.hashCode();
    L178:
        return "MixFullItem(itemType=" + this.itemType + ", data=" + this.data + ')';
    L8:
        int r7 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r8 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L165
        Object r10 = null;
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("ec_gson_adapter_opt");     // Catch: Throwable -> L60
        if (r11 != null) goto L15;
    L57:
        Object r12 = null;
    L58:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L60
    L62:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r14 == null) goto L66;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r13) == false) goto L69;
        r13 = null;
    L69:
        if ((r13 instanceof Integer) == true) goto L71;
        r13 = null;
    L71:
        Integer r15 = (Integer) r13;     // Catch: Throwable -> L165
        if (r15 != null) goto L78;
        Object r16 = com.bytedance.android.ec.base.settings.d.a.get("ec_gson_adapter_opt");     // Catch: Throwable -> L165
        if ((r16 instanceof Integer) == true) goto L77;
        r16 = null;
    L77:
        r15 = (Integer) r16;     // Catch: Throwable -> L165
    L78:
        if (r15 == null) goto L80;
        r6 = r15;
        goto L175
    L80:
        int r17 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("ec_gson_adapter_opt");     // Catch: Throwable -> L130
        if (r18 != null) goto L85;
    L127:
        Object r19 = null;
    L128:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L130
    L132:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L156
        if (r21 == null) goto L136;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r20) == false) goto L139;
        r20 = null;
    L139:
        if ((r20 instanceof Integer) == true) goto L141;
        r20 = null;
    L141:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L156
        if (r22 == null) goto L144;
        r6 = r22;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_gson_adapter_opt", r6);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r23 == null) goto L147;
        Object r24 = r23.getHostABValue("ec_gson_adapter_opt", r2);     // Catch: Throwable -> L156
    L148:
        if (r24 != null) goto L150;
    L162:
        r6 = r2;
        goto L163
    L150:
        if ((r24 instanceof Integer) == false) goto L153;
        r10 = r24;
    L153:
        r6 = (Integer) r10;     // Catch: Throwable -> L156
        if (r6 != null) goto L163;
    L156:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L165
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r26 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L165
        if (r26 == null) goto L161;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r6) == false) goto L163;
    L147:
        r24 = null;
        goto L148
    L85:
        if ((r18 instanceof Integer) == true) goto L87;
        Object r27 = null;
    L88:
        r19 = (Integer) r27;     // Catch: Throwable -> L130
        if (r19 != null) goto L128;
        if ((r18 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r28 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L130
        if ((r28 instanceof Integer) == true) goto L98;
        r28 = null;
    L98:
        r19 = (Integer) r28;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r29 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L130
        if ((r29 instanceof Integer) == true) goto L104;
        r29 = null;
    L104:
        r19 = (Integer) r29;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r30 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L130
        if ((r30 instanceof Integer) == true) goto L113;
        r30 = null;
    L113:
        r19 = (Integer) r30;     // Catch: Throwable -> L130
    L115:
        if ((r18 instanceof JSONObject) == false) goto L117;
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r31 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r31 instanceof Integer) == true) goto L121;
        r31 = null;
    L121:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L123
    L125:
        r19 = r32;
        if (Result.isFailure-impl(r19) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L130
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r18 instanceof JSONArray) == false) goto L127;
    L87:
        r27 = r18;
    L130:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L156
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r11 instanceof Integer) == true) goto L17;
        Object r35 = null;
    L18:
        r12 = (Integer) r35;     // Catch: Throwable -> L60
        if (r12 != null) goto L58;
        if ((r11 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r36 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L60
        if ((r36 instanceof Integer) == true) goto L28;
        r36 = null;
    L28:
        r12 = (Integer) r36;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r37 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L60
        if ((r37 instanceof Integer) == true) goto L34;
        r37 = null;
    L34:
        r12 = (Integer) r37;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r12 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r38 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L60
        if ((r38 instanceof Integer) == true) goto L43;
        r38 = null;
    L43:
        r12 = (Integer) r38;     // Catch: Throwable -> L60
    L45:
        if ((r11 instanceof JSONObject) == false) goto L47;
    L187:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r39 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r39 instanceof Integer) == true) goto L51;
        r39 = null;
    L51:
        Object r40 = Result.constructor-impl((Integer) r39);     // Catch: Throwable -> L53
    L55:
        r12 = r40;
        if (Result.isFailure-impl(r12) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L60
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r11 instanceof JSONArray) == false) goto L57;
    L17:
        r35 = r11;
    L60:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Object r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r45 = Result.exceptionOrNull-impl(r44);
        if (r45 == null) goto L170;
        EnsureManager.ensureNotReachHere(r45);
    L170:
        if (Result.isFailure-impl(r44) == true) goto L173;
        r2 = r44;
    L173:
        r6 = r2;
        goto L175
    }

    public c() {
        this.itemType = null;
        this.insertParams = null;
        this.uniqueId = null;
        this.uiElementParams = null;
        this.bstIndex = null;
        this.data = null;
        this.lynxExtensionData = null;
    }

    public final Integer a() {
        return this.bstIndex;
    }

    public final Integer c() {
        return this.itemType;
    }

    public final Map<String, Map<String, String>> f() {
        return this.uiElementParams;
    }

    public final String g() {
        return this.uniqueId;
    }

    public final <T> T b(Class<T> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        JsonElement r1 = this.data;
        if (r1 != null) goto L9;
        return null;
    L9:
        return (T) d.a(r1, r3);
    }
}

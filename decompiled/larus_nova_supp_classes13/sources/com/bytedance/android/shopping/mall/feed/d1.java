package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedSplitRenderConfig;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d1 {
    public static final ECMallFeedSplitRenderConfig a = null;

    static {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = new ECMallFeedSplitRenderConfig();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L166
        Object r3 = null;
        Object r4 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_feed_split_render_config");     // Catch: Throwable -> L57
        if (r4 != null) goto L9;
    L54:
        Object r5 = null;
    L55:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L57
    L59:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L166
        if (r7 == null) goto L63;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r6) == false) goto L66;
        r6 = null;
    L66:
        if ((r6 instanceof ECMallFeedSplitRenderConfig) == true) goto L68;
        r6 = null;
    L68:
        Object r8 = (ECMallFeedSplitRenderConfig) r6;     // Catch: Throwable -> L166
        if (r8 != null) goto L75;
        Object r9 = com.bytedance.android.ec.base.settings.d.a.get("ec_mall_feed_split_render_config");     // Catch: Throwable -> L166
        if ((r9 instanceof ECMallFeedSplitRenderConfig) == true) goto L74;
        r9 = null;
    L74:
        r8 = (ECMallFeedSplitRenderConfig) r9;     // Catch: Throwable -> L166
    L75:
        if (r8 != null) goto L175;
        int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_feed_split_render_config");     // Catch: Throwable -> L130
        if (r11 != null) goto L82;
    L127:
        Object r12 = null;
    L128:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L130
    L132:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L156
        if (r14 == null) goto L136;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r13) == false) goto L139;
        r13 = null;
    L139:
        if ((r13 instanceof ECMallFeedSplitRenderConfig) == true) goto L141;
        r13 = null;
    L141:
        r8 = (ECMallFeedSplitRenderConfig) r13;     // Catch: Throwable -> L156
        if (r8 != null) goto L164;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r15 == null) goto L147;
        Object r16 = r15.getHostABValue("ec_mall_feed_split_render_config", r1);     // Catch: Throwable -> L156
    L148:
        if (r16 != null) goto L150;
    L155:
        r8 = r1;
        goto L164
    L150:
        if ((r16 instanceof ECMallFeedSplitRenderConfig) == false) goto L153;
        r3 = r16;
    L153:
        Object r17 = (ECMallFeedSplitRenderConfig) r3;     // Catch: Throwable -> L156
        if (r17 == null) goto L155;
    L163:
        r8 = r17;
        goto L164
    L147:
        r16 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_mall_feed_split_render_config", r8);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r11 instanceof ECMallFeedSplitRenderConfig) == true) goto L84;
        Object r18 = null;
    L85:
        r12 = (ECMallFeedSplitRenderConfig) r18;     // Catch: Throwable -> L130
        if (r12 != null) goto L128;
        if ((r11 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L130
        if ((r19 instanceof ECMallFeedSplitRenderConfig) == true) goto L95;
        r19 = null;
    L95:
        r12 = (ECMallFeedSplitRenderConfig) r19;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L130
        if ((r20 instanceof ECMallFeedSplitRenderConfig) == true) goto L101;
        r20 = null;
    L101:
        r12 = (ECMallFeedSplitRenderConfig) r20;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r21 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L130
        if ((r21 instanceof ECMallFeedSplitRenderConfig) == true) goto L107;
        r21 = null;
    L107:
        r12 = (ECMallFeedSplitRenderConfig) r21;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r22 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L130
        if ((r22 instanceof ECMallFeedSplitRenderConfig) == true) goto L113;
        r22 = null;
    L113:
        r12 = (ECMallFeedSplitRenderConfig) r22;     // Catch: Throwable -> L130
    L115:
        if ((r11 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r23 = SDKSettingsCacheManager.a().fromJson(r11.toString(), ECMallFeedSplitRenderConfig.class);     // Catch: Throwable -> L123
        if ((r23 instanceof ECMallFeedSplitRenderConfig) == true) goto L121;
        r23 = null;
    L121:
        Object r24 = Result.constructor-impl((ECMallFeedSplitRenderConfig) r23);     // Catch: Throwable -> L123
    L125:
        r12 = r24;
        if (Result.isFailure-impl(r12) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L130
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r11 instanceof JSONArray) == false) goto L127;
    L84:
        r18 = r11;
    L156:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r27 == null) goto L161;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r17) == false) goto L163;
        r17 = r1;
    L130:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L156
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        a = (ECMallFeedSplitRenderConfig) r8;
        return;
    L9:
        if ((r4 instanceof ECMallFeedSplitRenderConfig) == true) goto L11;
        Object r29 = null;
    L12:
        r5 = (ECMallFeedSplitRenderConfig) r29;     // Catch: Throwable -> L57
        if (r5 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof ECMallFeedSplitRenderConfig) == true) goto L22;
        r30 = null;
    L22:
        r5 = (ECMallFeedSplitRenderConfig) r30;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof ECMallFeedSplitRenderConfig) == true) goto L28;
        r31 = null;
    L28:
        r5 = (ECMallFeedSplitRenderConfig) r31;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r32 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        if ((r32 instanceof ECMallFeedSplitRenderConfig) == true) goto L34;
        r32 = null;
    L34:
        r5 = (ECMallFeedSplitRenderConfig) r32;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(ECMallFeedSplitRenderConfig.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r33 instanceof ECMallFeedSplitRenderConfig) == true) goto L40;
        r33 = null;
    L40:
        r5 = (ECMallFeedSplitRenderConfig) r33;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r4.toString(), ECMallFeedSplitRenderConfig.class);     // Catch: Throwable -> L50
        if ((r34 instanceof ECMallFeedSplitRenderConfig) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((ECMallFeedSplitRenderConfig) r34);     // Catch: Throwable -> L50
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
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L166
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L171;
        EnsureManager.ensureNotReachHere(r40);
    L171:
        if (Result.isFailure-impl(r39) == true) goto L174;
        r1 = r39;
    L174:
        r8 = r1;
        goto L175
    }

    public static Pair a(String r9, com.bytedance.android.ec.hybrid.list.entity.k r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "listVO");
        Integer r12 = a.sizeOf(r9, r11);
        if (r12 == null) goto L5;
        int r13 = r12.intValue();
    L6:
        com.bytedance.android.ec.hybrid.list.entity.i r0 = null;
        Object r1 = null;
        if (r13 > 0) goto L9;
        return null;
    L9:
        ArrayList r2 = r10.c;
        if (r2 == null) goto L105;
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r4).a, "favorite_section") == false) goto L13;
    L18:
        com.bytedance.android.ec.hybrid.list.entity.i r5 = (com.bytedance.android.ec.hybrid.list.entity.i) r4;
        if (r5 == null) goto L105;
        ArrayList r6 = r5.i;
        if (r6 == null) goto L105;
        if ((!r6.isEmpty()) == true) goto L27;
        r6 = null;
    L27:
        if (r6 == null) goto L105;
        Iterator r7 = r6.iterator();
    L31:
        if (r7.hasNext() == false) goto L41;
        Object r8 = r7.next();
        Integer r14 = ((ECHybridListItemVO) r8).c;
        int r15 = a.getCombinedCardType();
        if (r14 != null) goto L36;
    L38:
        boolean r16 = false;
    L39:
        if (r16 == false) goto L31;
    L42:
        ECHybridListItemVO r17 = (ECHybridListItemVO) r8;
        if (r17 == null) goto L50;
        Integer r18 = Integer.valueOf(r6.indexOf(r17));
        if (r18.intValue() < 0) goto L47;
        boolean r19 = true;
    L48:
        if (r19 == false) goto L50;
    L51:
        if (r18 == null) goto L56;
        if (r18.intValue() >= r13) goto L56;
        r13 = r13 + 1;
    L56:
        if (r6.size() <= r13) goto L58;
        boolean r20 = true;
    L59:
        if (r20 == true) goto L62;
        r6 = null;
    L62:
        if (r6 != null) goto L65;
        return null;
    L65:
        if (a.pendingRenderEnable(r11) == false) goto L78;
        int r110 = r6.size();
    L67:
        if (r13 >= r110) goto L77;
        ECHybridListItemVO r111 = (ECHybridListItemVO) CollectionsKt.getOrNull(r6, r13);
        if (r111 == null) goto L76;
        if (a.isPendingRenderCardTypeMatch(r111.c) == true) goto L74;
        r111 = null;
    L74:
        if (r111 == null) goto L76;
        r111.Z = true;
    L76:
        r13 = r13 + 1;
        goto L67
    L77:
        return null;
    L78:
        List r112 = r6.subList(0, r13);
        List r21 = r6.subList(r13, r6.size());
        ArrayList r22 = r10.c;
        if (r22 == null) goto L90;
        Iterator r23 = r22.iterator();
    L82:
        if (r23.hasNext() == false) goto L86;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r24).a, "favorite_section") == false) goto L82;
    L87:
        com.bytedance.android.ec.hybrid.list.entity.i r25 = (com.bytedance.android.ec.hybrid.list.entity.i) r24;
        if (r25 == null) goto L90;
        r25.i = new ArrayList(r112);
        goto L90
    L86:
        r24 = null;
    L90:
        com.bytedance.android.ec.hybrid.list.entity.k r113 = r10.a();
        ArrayList r26 = r113.c;
        if (r26 == null) goto L99;
        Iterator r27 = r26.iterator();
    L94:
        if (r27.hasNext() == false) goto L98;
        Object r28 = r27.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r28).a, "favorite_section") == false) goto L94;
        r1 = r28;
    L98:
        r0 = (com.bytedance.android.ec.hybrid.list.entity.i) r1;
    L99:
        if (r0 == null) goto L101;
        r0.i = new ArrayList(r21);
    L101:
        if (r0 == null) goto L104;
        ArrayList r29 = new ArrayList();
        r29.add(r0);
        Unit r30 = Unit.INSTANCE;
        r113.c = r29;
    L104:
        return TuplesKt.to(r10, r113);
    L58:
        r20 = false;
        goto L59
    L47:
        r19 = false;
    L50:
        r18 = null;
        goto L51
    L36:
        if (r14.intValue() != r15) goto L38;
        r16 = true;
        goto L39
    L41:
        r8 = null;
        goto L42
    L17:
        r4 = null;
    L105:
        return null;
    L5:
        r13 = -1;
        goto L6
    }
}

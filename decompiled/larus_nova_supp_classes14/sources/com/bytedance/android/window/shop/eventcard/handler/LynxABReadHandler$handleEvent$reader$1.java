package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "hostABKey", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LynxABReadHandler$handleEvent$reader$1 extends FunctionReferenceImpl implements Function1<String, Object> {
    public LynxABReadHandler$handleEvent$reader$1(dp3.a r8) {
        super(1, r8, dp3.a.class, "readHostAB", "readHostAB(Ljava/lang/String;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ((dp3.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r6, "hostABKey");
        int r0 = n.a;
        Object r1 = "";
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get(r6);     // Catch: Throwable -> L57
        if (r5 != null) goto L9;
    L54:
        Object r7 = null;
    L55:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L57
    L59:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L166
        if (r9 == null) goto L63;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r8) == false) goto L66;
        r8 = null;
    L66:
        if ((r8 instanceof String) == true) goto L68;
        r8 = null;
    L68:
        String r10 = (String) r8;     // Catch: Throwable -> L166
        if (r10 != null) goto L75;
        Object r11 = com.bytedance.android.ec.base.settings.d.a.get(r6);     // Catch: Throwable -> L166
        if ((r11 instanceof String) == true) goto L74;
        r11 = null;
    L74:
        r10 = (String) r11;     // Catch: Throwable -> L166
    L75:
        if (r10 != null) goto L187;
        int r12 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get(r6);     // Catch: Throwable -> L130
        if (r13 != null) goto L82;
    L127:
        Object r14 = null;
    L128:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L130
    L132:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L156
        if (r16 == null) goto L136;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r15) == false) goto L139;
        r15 = null;
    L139:
        if ((r15 instanceof String) == true) goto L141;
        r15 = null;
    L141:
        Object r17 = (String) r15;     // Catch: Throwable -> L156
        if (r17 != null) goto L164;
        IHybridHostService r18 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r18 == null) goto L147;
        Object r19 = r18.getHostABValue(r6, "");     // Catch: Throwable -> L156
    L148:
        if (r19 != null) goto L150;
    L155:
        r17 = "";
        goto L164
    L150:
        if ((r19 instanceof String) == false) goto L153;
        r4 = r19;
    L153:
        Object r20 = (String) r4;     // Catch: Throwable -> L156
        if (r20 == null) goto L155;
    L163:
        r17 = r20;
        goto L164
    L147:
        r19 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d(r6, r17);     // Catch: Throwable -> L166
        return r17;
    L82:
        if ((r13 instanceof String) == true) goto L84;
        Object r21 = null;
    L85:
        r14 = (String) r21;     // Catch: Throwable -> L130
        if (r14 != null) goto L128;
        if ((r13 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r22 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L130
        if ((r22 instanceof String) == true) goto L95;
        r22 = null;
    L95:
        r14 = (String) r22;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r23 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L130
        if ((r23 instanceof String) == true) goto L101;
        r23 = null;
    L101:
        r14 = (String) r23;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r24 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L130
        if ((r24 instanceof String) == true) goto L107;
        r24 = null;
    L107:
        r14 = (String) r24;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r25 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L130
        if ((r25 instanceof String) == true) goto L113;
        r25 = null;
    L113:
        r14 = (String) r25;     // Catch: Throwable -> L130
    L115:
        if ((r13 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r26 = SDKSettingsCacheManager.a().fromJson(r13.toString(), String.class);     // Catch: Throwable -> L123
        if ((r26 instanceof String) == true) goto L121;
        r26 = null;
    L121:
        Object r27 = Result.constructor-impl((String) r26);     // Catch: Throwable -> L123
    L125:
        r14 = r27;
        if (Result.isFailure-impl(r14) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L130
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r13 instanceof JSONArray) == false) goto L127;
    L84:
        r21 = r13;
    L156:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L166
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r30 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L166
        if (r30 == null) goto L161;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r20) == false) goto L163;
        r20 = "";
    L130:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L156
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L187:
        return r10;
    L9:
        if ((r5 instanceof String) == true) goto L11;
        Object r32 = null;
    L12:
        r7 = (String) r32;     // Catch: Throwable -> L57
        if (r7 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r33 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r33 instanceof String) == true) goto L22;
        r33 = null;
    L22:
        r7 = (String) r33;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r34 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r34 instanceof String) == true) goto L28;
        r34 = null;
    L28:
        r7 = (String) r34;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r35 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r35 instanceof String) == true) goto L34;
        r35 = null;
    L34:
        r7 = (String) r35;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r36 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r36 instanceof String) == true) goto L40;
        r36 = null;
    L40:
        r7 = (String) r36;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r37 = SDKSettingsCacheManager.a().fromJson(r5.toString(), String.class);     // Catch: Throwable -> L50
        if ((r37 instanceof String) == true) goto L48;
        r37 = null;
    L48:
        Object r38 = Result.constructor-impl((String) r37);     // Catch: Throwable -> L50
    L52:
        r7 = r38;
        if (Result.isFailure-impl(r7) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L57
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r5 instanceof JSONArray) == false) goto L54;
    L11:
        r32 = r5;
    L57:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L166
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L171;
        EnsureManager.ensureNotReachHere(r43);
    L171:
        if (Result.isFailure-impl(r42) == true) goto L175;
        r1 = r42;
    L175:
        return r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}

package com.bytedance.android.shopping.feed.utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.FallbackPage;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Dialog r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$dismissSafely");
        Activity r0 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r3.getContext());
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return;
    L12:
        if (r3.isShowing() == false) goto L34;
        Handler r2 = DialogLancet.resolveDialogHandler(r3);
        if (r2 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r4 == null) goto L27;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
        goto L27
    L16:
        if (Looper.myLooper() == r2.getLooper()) goto L18;
        r2.post(DialogLancet.createDismissRunnable(r3));
        return;
    L34:
        return;
    L5:
        if (r0.isFinishing() == true) goto L9;
        if (r0.isDestroyed() == true) goto L9;
        r1 = true;
        goto L10
    }

    public static boolean b(FallbackPage r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$isValid");
        if (r6.getShow() == false) goto L190;
        ECUrlModel r0 = r6.getIcon();
        if (r0 == null) goto L190;
        List r1 = r0.getUrlList();
        if (r1 == null) goto L190;
        if ((!r1.isEmpty()) != true) goto L190;
        String r7 = r6.getText();
        if (r7 == null) goto L190;
        if (cg4.a.a(r7) != true) goto L190;
        int r8 = ld3.c.a;
        int r9 = com.bytedance.android.ec.core.opt.ab.n.a;
        Object r2 = Boolean.TRUE;
        int r3 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L178
        Object r5 = null;
        Object r10 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_deleted_product_card_opt");     // Catch: Throwable -> L69
        if (r10 != null) goto L21;
    L66:
        Object r11 = null;
    L67:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L69
    L71:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L178
        if (r13 == null) goto L75;
        EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L178
    L75:
        if (Result.isFailure-impl(r12) == false) goto L78;
        r12 = null;
    L78:
        if ((r12 instanceof Boolean) == true) goto L80;
        r12 = null;
    L80:
        Object r14 = (Boolean) r12;     // Catch: Throwable -> L178
        if (r14 != null) goto L87;
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_deleted_product_card_opt");     // Catch: Throwable -> L178
        if ((r15 instanceof Boolean) == true) goto L86;
        r15 = null;
    L86:
        r14 = (Boolean) r15;     // Catch: Throwable -> L178
    L87:
        if (r14 != null) goto L188;
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L178
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_deleted_product_card_opt");     // Catch: Throwable -> L142
        if (r17 != null) goto L94;
    L139:
        Object r18 = null;
    L140:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L142
    L144:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L168
        if (r20 == null) goto L148;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L168
    L148:
        if (Result.isFailure-impl(r19) == false) goto L151;
        r19 = null;
    L151:
        if ((r19 instanceof Boolean) == true) goto L153;
        r19 = null;
    L153:
        r14 = (Boolean) r19;     // Catch: Throwable -> L168
        if (r14 != null) goto L176;
        IHybridHostService r21 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L168
        if (r21 == null) goto L159;
        Object r22 = r21.getHostABValue("ec_inflow_deleted_product_card_opt", r2);     // Catch: Throwable -> L168
    L160:
        if (r22 != null) goto L162;
    L167:
        r14 = r2;
        goto L176
    L162:
        if ((r22 instanceof Boolean) == false) goto L165;
        r5 = r22;
    L165:
        Object r23 = (Boolean) r5;     // Catch: Throwable -> L168
        if (r23 == null) goto L167;
    L175:
        r14 = r23;
        goto L176
    L159:
        r22 = null;
    L176:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_deleted_product_card_opt", r14);     // Catch: Throwable -> L178
        goto L188
    L94:
        if ((r17 instanceof Boolean) == true) goto L96;
        Object r24 = null;
    L97:
        r18 = (Boolean) r24;     // Catch: Throwable -> L142
        if (r18 != null) goto L140;
        if ((r17 instanceof Number) == false) goto L127;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L109;
        Float r25 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L142
        if ((r25 instanceof Boolean) == true) goto L107;
        r25 = null;
    L107:
        r18 = (Boolean) r25;     // Catch: Throwable -> L142
        goto L140
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L115;
        Double r26 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L142
        if ((r26 instanceof Boolean) == true) goto L113;
        r26 = null;
    L113:
        r18 = (Boolean) r26;     // Catch: Throwable -> L142
        goto L140
    L115:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L121;
        Integer r27 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L142
        if ((r27 instanceof Boolean) == true) goto L119;
        r27 = null;
    L119:
        r18 = (Boolean) r27;     // Catch: Throwable -> L142
        goto L140
    L121:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L127;
        Long r28 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L142
        if ((r28 instanceof Boolean) == true) goto L125;
        r28 = null;
    L125:
        r18 = (Boolean) r28;     // Catch: Throwable -> L142
    L127:
        if ((r17 instanceof JSONObject) == false) goto L129;
    L199:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L135
        Object r29 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Boolean.class);     // Catch: Throwable -> L135
        if ((r29 instanceof Boolean) == true) goto L133;
        r29 = null;
    L133:
        Object r30 = Result.constructor-impl((Boolean) r29);     // Catch: Throwable -> L135
    L137:
        r18 = r30;
        if (Result.isFailure-impl(r18) == false) goto L140;
    L135:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L142
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L142
        goto L137
    L129:
        if ((r17 instanceof JSONArray) == false) goto L139;
    L96:
        r24 = r17;
    L168:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L178
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
        Throwable r33 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L178
        if (r33 == null) goto L173;
        EnsureManager.ensureNotReachHere(r33);     // Catch: Throwable -> L178
    L173:
        if (Result.isFailure-impl(r23) == false) goto L175;
        r23 = r2;
    L142:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L168
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L168
    L188:
        if (((Boolean) r14).booleanValue() == false) goto L190;
        return true;
    L21:
        if ((r10 instanceof Boolean) == true) goto L23;
        Object r35 = null;
    L24:
        r11 = (Boolean) r35;     // Catch: Throwable -> L69
        if (r11 != null) goto L67;
        if ((r10 instanceof Number) == false) goto L54;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L36;
        Float r36 = Float.valueOf(((Number) r10).floatValue());     // Catch: Throwable -> L69
        if ((r36 instanceof Boolean) == true) goto L34;
        r36 = null;
    L34:
        r11 = (Boolean) r36;     // Catch: Throwable -> L69
        goto L67
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L42;
        Double r37 = Double.valueOf(((Number) r10).doubleValue());     // Catch: Throwable -> L69
        if ((r37 instanceof Boolean) == true) goto L40;
        r37 = null;
    L40:
        r11 = (Boolean) r37;     // Catch: Throwable -> L69
        goto L67
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L48;
        Integer r38 = Integer.valueOf(((Number) r10).intValue());     // Catch: Throwable -> L69
        if ((r38 instanceof Boolean) == true) goto L46;
        r38 = null;
    L46:
        r11 = (Boolean) r38;     // Catch: Throwable -> L69
        goto L67
    L48:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L54;
        Long r39 = Long.valueOf(((Number) r10).longValue());     // Catch: Throwable -> L69
        if ((r39 instanceof Boolean) == true) goto L52;
        r39 = null;
    L52:
        r11 = (Boolean) r39;     // Catch: Throwable -> L69
    L54:
        if ((r10 instanceof JSONObject) == false) goto L56;
    L196:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L62
        Object r40 = SDKSettingsCacheManager.a().fromJson(r10.toString(), Boolean.class);     // Catch: Throwable -> L62
        if ((r40 instanceof Boolean) == true) goto L60;
        r40 = null;
    L60:
        Object r41 = Result.constructor-impl((Boolean) r40);     // Catch: Throwable -> L62
    L64:
        r11 = r41;
        if (Result.isFailure-impl(r11) == false) goto L67;
    L62:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L69
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
        goto L64
    L56:
        if ((r10 instanceof JSONArray) == false) goto L66;
    L23:
        r35 = r10;
    L69:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L178
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
    L178:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r46 = Result.exceptionOrNull-impl(r45);
        if (r46 == null) goto L183;
        EnsureManager.ensureNotReachHere(r46);
    L183:
        if (Result.isFailure-impl(r45) == true) goto L186;
        r2 = r45;
    L186:
        r14 = r2;
    L190:
        return false;
    }
}

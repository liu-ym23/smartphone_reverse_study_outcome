package com.bytedance.android.shopping.deepfeed.slice;

import android.view.View;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.deepfeed.slice.action.h;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements wc3.c {
    public r a;
    public boolean b;
    public final wc3.b c;
    public final String d;

    public final void a(b r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        boolean r1 = false;
        if (r6.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        r r2 = this.a;
        if (r2 == null) goto L19;
        View r3 = r2.c;
        if (r3 == null) goto L19;
        if (r6.d.indexOfChild(r3) == (-1)) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L17;
        return;
    L17:
        r6.d.removeAllViews();
        r6.d.addView(r3);
        return;
    L19:
        r r4 = this.c.c(r6.a, r6.b, r6.c);
        r4.b(new h(r6.e));
        r6.d.addView(r4.c);
        this.a = r4;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final View b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sliceKey");
        r r0 = this.a;
        if (r0 == null) goto L12;
        View r1 = r0.c;
        if (r1 == null) goto L12;
        SlcTemplateContext r2 = r0.b;
        if (r2 == null) goto L12;
        if (r2.w == null) goto L12;
        return SlcRenderContext.f(r1, r3);
    L12:
        return null;
    }

    public final void c(int r3) {
        r r0 = this.a;
        if (r0 == null) goto L13;
        SlcTemplateContext r1 = r0.b;
        if (r1 == null) goto L14;
        Object r2 = r1.o(com.bytedance.android.shopping.deepfeed.slice.service.c.class);
        if ((r2 instanceof com.bytedance.android.shopping.deepfeed.slice.service.c) == true) goto L9;
        r2 = null;
    L9:
        com.bytedance.android.shopping.deepfeed.slice.service.c r4 = (com.bytedance.android.shopping.deepfeed.slice.service.c) r2;
        if (r4 == null) goto L15;
        r4.m(r3);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // wc3.c
    public final void updateData(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        Map r9 = SliceRender.a(r8);
        r r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r9, this.d);
    L6:
        if (this.b == true) goto L391;
        r r10 = this.a;
        if (r10 == null) goto L386;
        SlcTemplateContext r11 = r10.b;
        if (r11 == null) goto L387;
        Object r12 = r11.o(com.bytedance.android.shopping.deepfeed.slice.service.d.class);
        Object r1 = null;
        if ((r12 instanceof com.bytedance.android.shopping.deepfeed.slice.service.d) == true) goto L15;
        r12 = null;
    L15:
        com.bytedance.android.shopping.deepfeed.slice.service.d r13 = (com.bytedance.android.shopping.deepfeed.slice.service.d) r12;
        if (r13 != null) goto L19;
        return;
    L19:
        if (r13.j() == false) goto L393;
        int r2 = h33.a.a;
        int r3 = n.a;
        Object r4 = 0;
        int r5 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L176
        Object r7 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_video_preload_strategy_v2");     // Catch: Throwable -> L72
        if (r7 != null) goto L27;
    L69:
        Object r14 = null;
    L70:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L72
    L74:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L176
        if (r16 == null) goto L78;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L176
    L78:
        if (Result.isFailure-impl(r15) == false) goto L81;
        r15 = null;
    L81:
        if ((r15 instanceof Integer) == true) goto L83;
        r15 = null;
    L83:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L176
        if (r17 != null) goto L90;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("mall_deep_feed_video_preload_strategy_v2");     // Catch: Throwable -> L176
        if ((r18 instanceof Integer) == true) goto L89;
        r18 = null;
    L89:
        r17 = (Integer) r18;     // Catch: Throwable -> L176
    L90:
        if (r17 != null) goto L185;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L176
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_video_preload_strategy_v2");     // Catch: Throwable -> L142
        if (r20 != null) goto L97;
    L139:
        Object r21 = null;
    L140:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L142
    L144:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L167
        if (r23 == null) goto L148;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L167
    L148:
        if (Result.isFailure-impl(r22) == false) goto L151;
        r22 = null;
    L151:
        if ((r22 instanceof Integer) == true) goto L153;
        r22 = null;
    L153:
        r17 = (Integer) r22;     // Catch: Throwable -> L167
        if (r17 != null) goto L174;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L167
        if (r24 == null) goto L159;
        Object r25 = r24.getHostABValue("mall_deep_feed_video_preload_strategy_v2", r4);     // Catch: Throwable -> L167
    L160:
        if (r25 != null) goto L162;
    L173:
        r17 = r4;
        goto L174
    L162:
        if ((r25 instanceof Integer) == true) goto L164;
        r25 = null;
    L164:
        r17 = (Integer) r25;     // Catch: Throwable -> L167
        if (r17 != null) goto L174;
    L167:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L176
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L176
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L176
        if (r27 == null) goto L172;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L176
    L172:
        if (Result.isFailure-impl(r17) == false) goto L174;
    L159:
        r25 = null;
    L174:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_video_preload_strategy_v2", r17);     // Catch: Throwable -> L176
        goto L185
    L97:
        if ((r20 instanceof Integer) == true) goto L99;
        Object r28 = null;
    L100:
        r21 = (Integer) r28;     // Catch: Throwable -> L142
        if (r21 != null) goto L140;
        if ((r20 instanceof Number) == false) goto L127;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L112;
        Float r29 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L142
        if ((r29 instanceof Integer) == true) goto L110;
        r29 = null;
    L110:
        r21 = (Integer) r29;     // Catch: Throwable -> L142
        goto L140
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L118;
        Double r30 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L142
        if ((r30 instanceof Integer) == true) goto L116;
        r30 = null;
    L116:
        r21 = (Integer) r30;     // Catch: Throwable -> L142
        goto L140
    L118:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L121;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L142
        goto L140
    L121:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L127;
        Long r31 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L142
        if ((r31 instanceof Integer) == true) goto L125;
        r31 = null;
    L125:
        r21 = (Integer) r31;     // Catch: Throwable -> L142
    L127:
        if ((r20 instanceof JSONObject) == false) goto L129;
    L376:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L135
        Object r32 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L135
        if ((r32 instanceof Integer) == true) goto L133;
        r32 = null;
    L133:
        Object r33 = Result.constructor-impl((Integer) r32);     // Catch: Throwable -> L135
    L137:
        r21 = r33;
        if (Result.isFailure-impl(r21) == false) goto L140;
    L135:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L142
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L142
        goto L137
    L129:
        if ((r20 instanceof JSONArray) == false) goto L139;
    L99:
        r28 = r20;
    L142:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L167
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L185:
        int r36 = ((Number) r17).intValue();
        if (r36 == 1) goto L360;
        if (r36 == 2) goto L191;
        return;
    L191:
        if (r13.q() == false) goto L193;
        this.b = true;
        return;
    L193:
        int r37 = n.a;
        Object r38 = 200;
        int r39 = com.bytedance.android.ec.base.settings.a.a;
        Object r40 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_video_preload_size_v2");     // Catch: Throwable -> L243
        if (r40 != null) goto L198;
    L240:
        Object r41 = null;
    L241:
        Object r42 = Result.constructor-impl(r41);     // Catch: Throwable -> L243
    L245:
        Throwable r43 = Result.exceptionOrNull-impl(r42);     // Catch: Throwable -> L349
        if (r43 == null) goto L249;
        EnsureManager.ensureNotReachHere(r43);     // Catch: Throwable -> L349
    L249:
        if (Result.isFailure-impl(r42) == false) goto L252;
        r42 = null;
    L252:
        if ((r42 instanceof Integer) == true) goto L254;
        r42 = null;
    L254:
        Object r44 = (Integer) r42;     // Catch: Throwable -> L349
        if (r44 != null) goto L261;
        Object r45 = com.bytedance.android.ec.base.settings.d.a.get("mall_deep_feed_video_preload_size_v2");     // Catch: Throwable -> L349
        if ((r45 instanceof Integer) == true) goto L260;
        r45 = null;
    L260:
        r44 = (Integer) r45;     // Catch: Throwable -> L349
    L261:
        if (r44 != null) goto L358;
        int r46 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L349
        Object r47 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_video_preload_size_v2");     // Catch: Throwable -> L313
        if (r47 != null) goto L268;
    L310:
        Object r48 = null;
    L311:
        Object r49 = Result.constructor-impl(r48);     // Catch: Throwable -> L313
    L315:
        Throwable r50 = Result.exceptionOrNull-impl(r49);     // Catch: Throwable -> L339
        if (r50 == null) goto L319;
        EnsureManager.ensureNotReachHere(r50);     // Catch: Throwable -> L339
    L319:
        if (Result.isFailure-impl(r49) == false) goto L322;
        r49 = null;
    L322:
        if ((r49 instanceof Integer) == true) goto L324;
        r49 = null;
    L324:
        r44 = (Integer) r49;     // Catch: Throwable -> L339
        if (r44 != null) goto L347;
        IHybridHostService r51 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L339
        if (r51 == null) goto L330;
        Object r52 = r51.getHostABValue("mall_deep_feed_video_preload_size_v2", r38);     // Catch: Throwable -> L339
    L331:
        if (r52 != null) goto L333;
    L338:
        r44 = r38;
        goto L347
    L333:
        if ((r52 instanceof Integer) == false) goto L336;
        r1 = r52;
    L336:
        Object r53 = (Integer) r1;     // Catch: Throwable -> L339
        if (r53 == null) goto L338;
    L346:
        r44 = r53;
        goto L347
    L330:
        r52 = null;
    L347:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_video_preload_size_v2", r44);     // Catch: Throwable -> L349
        goto L358
    L268:
        if ((r47 instanceof Integer) == true) goto L270;
        Object r54 = null;
    L271:
        r48 = (Integer) r54;     // Catch: Throwable -> L313
        if (r48 != null) goto L311;
        if ((r47 instanceof Number) == false) goto L298;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L283;
        Float r55 = Float.valueOf(((Number) r47).floatValue());     // Catch: Throwable -> L313
        if ((r55 instanceof Integer) == true) goto L281;
        r55 = null;
    L281:
        r48 = (Integer) r55;     // Catch: Throwable -> L313
        goto L311
    L283:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L289;
        Double r56 = Double.valueOf(((Number) r47).doubleValue());     // Catch: Throwable -> L313
        if ((r56 instanceof Integer) == true) goto L287;
        r56 = null;
    L287:
        r48 = (Integer) r56;     // Catch: Throwable -> L313
        goto L311
    L289:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L292;
        r48 = Integer.valueOf(((Number) r47).intValue());     // Catch: Throwable -> L313
        goto L311
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L298;
        Long r57 = Long.valueOf(((Number) r47).longValue());     // Catch: Throwable -> L313
        if ((r57 instanceof Integer) == true) goto L296;
        r57 = null;
    L296:
        r48 = (Integer) r57;     // Catch: Throwable -> L313
    L298:
        if ((r47 instanceof JSONObject) == false) goto L300;
    L384:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L306
        Object r58 = SDKSettingsCacheManager.a().fromJson(r47.toString(), Integer.class);     // Catch: Throwable -> L306
        if ((r58 instanceof Integer) == true) goto L304;
        r58 = null;
    L304:
        Object r59 = Result.constructor-impl((Integer) r58);     // Catch: Throwable -> L306
    L308:
        r48 = r59;
        if (Result.isFailure-impl(r48) == false) goto L311;
    L306:
        th = move-exception;
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L313
        r59 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L313
        goto L308
    L300:
        if ((r47 instanceof JSONArray) == false) goto L310;
    L270:
        r54 = r47;
    L339:
        th = move-exception;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L349
        r53 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
        Throwable r62 = Result.exceptionOrNull-impl(r53);     // Catch: Throwable -> L349
        if (r62 == null) goto L344;
        EnsureManager.ensureNotReachHere(r62);     // Catch: Throwable -> L349
    L344:
        if (Result.isFailure-impl(r53) == false) goto L346;
        r53 = r38;
    L313:
        th = move-exception;
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L339
        r49 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L339
    L358:
        r13.f(((Number) r44).intValue());
        this.b = true;
        return;
    L198:
        if ((r40 instanceof Integer) == true) goto L200;
        Object r64 = null;
    L201:
        r41 = (Integer) r64;     // Catch: Throwable -> L243
        if (r41 != null) goto L241;
        if ((r40 instanceof Number) == false) goto L228;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L213;
        Float r65 = Float.valueOf(((Number) r40).floatValue());     // Catch: Throwable -> L243
        if ((r65 instanceof Integer) == true) goto L211;
        r65 = null;
    L211:
        r41 = (Integer) r65;     // Catch: Throwable -> L243
        goto L241
    L213:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L219;
        Double r66 = Double.valueOf(((Number) r40).doubleValue());     // Catch: Throwable -> L243
        if ((r66 instanceof Integer) == true) goto L217;
        r66 = null;
    L217:
        r41 = (Integer) r66;     // Catch: Throwable -> L243
        goto L241
    L219:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L222;
        r41 = Integer.valueOf(((Number) r40).intValue());     // Catch: Throwable -> L243
        goto L241
    L222:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L228;
        Long r67 = Long.valueOf(((Number) r40).longValue());     // Catch: Throwable -> L243
        if ((r67 instanceof Integer) == true) goto L226;
        r67 = null;
    L226:
        r41 = (Integer) r67;     // Catch: Throwable -> L243
    L228:
        if ((r40 instanceof JSONObject) == false) goto L230;
    L382:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L236
        Object r68 = SDKSettingsCacheManager.a().fromJson(r40.toString(), Integer.class);     // Catch: Throwable -> L236
        if ((r68 instanceof Integer) == true) goto L234;
        r68 = null;
    L234:
        Object r69 = Result.constructor-impl((Integer) r68);     // Catch: Throwable -> L236
    L238:
        r41 = r69;
        if (Result.isFailure-impl(r41) == false) goto L241;
    L236:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L243
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L243
        goto L238
    L230:
        if ((r40 instanceof JSONArray) == false) goto L240;
    L200:
        r64 = r40;
    L349:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        Object r72 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r73 = Result.exceptionOrNull-impl(r72);
        if (r73 == null) goto L354;
        EnsureManager.ensureNotReachHere(r73);
    L354:
        if (Result.isFailure-impl(r72) == true) goto L357;
        r38 = r72;
    L357:
        r44 = r38;
    L243:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L349
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L349
        goto L245
    L360:
        if (r13.h() == false) goto L362;
        this.b = true;
        return;
    L362:
        r13.p();
        this.b = true;
        return;
    L27:
        if ((r7 instanceof Integer) == true) goto L29;
        Object r75 = null;
    L30:
        r14 = (Integer) r75;     // Catch: Throwable -> L72
        if (r14 != null) goto L70;
        if ((r7 instanceof Number) == false) goto L57;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L42;
        Float r76 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L72
        if ((r76 instanceof Integer) == true) goto L40;
        r76 = null;
    L40:
        r14 = (Integer) r76;     // Catch: Throwable -> L72
        goto L70
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L48;
        Double r77 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L72
        if ((r77 instanceof Integer) == true) goto L46;
        r77 = null;
    L46:
        r14 = (Integer) r77;     // Catch: Throwable -> L72
        goto L70
    L48:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L51;
        r14 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L72
        goto L70
    L51:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L57;
        Long r78 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L72
        if ((r78 instanceof Integer) == true) goto L55;
        r78 = null;
    L55:
        r14 = (Integer) r78;     // Catch: Throwable -> L72
    L57:
        if ((r7 instanceof JSONObject) == false) goto L59;
    L374:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L65
        Object r79 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L65
        if ((r79 instanceof Integer) == true) goto L63;
        r79 = null;
    L63:
        Object r80 = Result.constructor-impl((Integer) r79);     // Catch: Throwable -> L65
    L67:
        r14 = r80;
        if (Result.isFailure-impl(r14) == false) goto L70;
    L65:
        th = move-exception;
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L72
        r80 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L72
        goto L67
    L59:
        if ((r7 instanceof JSONArray) == false) goto L69;
    L29:
        r75 = r7;
    L72:
        th = move-exception;
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L176
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L176
    L176:
        th = move-exception;
        Result.Companion r84 = Result.Companion;
        Object r85 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r86 = Result.exceptionOrNull-impl(r85);
        if (r86 == null) goto L181;
        EnsureManager.ensureNotReachHere(r86);
    L181:
        if (Result.isFailure-impl(r85) == true) goto L184;
        r4 = r85;
    L184:
        r17 = r4;
        goto L185
    L393:
        return;
    L387:
        return;
    L386:
        return;
    }

    public a(wc3.b r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "slcManager");
        Intrinsics.checkNotNullParameter(r3, "unitKey");
        this.c = r2;
        this.d = r3;
    }
}

package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/widget/g;", "invoke", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/widget/g;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class GalleryFragment$tabIndicator$2 extends Lambda implements Function0<com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g> {
    final /* synthetic */ GalleryFragment this$0;

    public GalleryFragment$tabIndicator$2(GalleryFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g invoke() {
        Function0<Unit> r1 = new GalleryFragment$tabIndicator$2$onClose$1(this);
        Function1<Integer, Unit> r2 = new GalleryFragment$tabIndicator$2$trySelectPage$1(this);
        ECSettingKeys.j.getClass();
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r3 = Boolean.TRUE;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L172
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r6 = null;
        r5.getClass();     // Catch: Throwable -> L59
        Object r7 = SDKSettingsCacheManager.b.get("ec_pdp_gallery_tab_indicator_v2");     // Catch: Throwable -> L59
        if (r7 != null) goto L11;
    L56:
        Object r8 = null;
    L57:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L59
    L61:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L172
        if (r10 == null) goto L65;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r9) == false) goto L68;
        r9 = null;
    L68:
        if ((r9 instanceof Boolean) == true) goto L70;
        r9 = null;
    L70:
        Object r11 = (Boolean) r9;     // Catch: Throwable -> L172
        if (r11 != null) goto L77;
        r5.getClass();     // Catch: Throwable -> L172
        Object r12 = SDKSettingsCacheManager.a.get("ec_pdp_gallery_tab_indicator_v2");     // Catch: Throwable -> L172
        if ((r12 instanceof Boolean) == true) goto L76;
        r12 = null;
    L76:
        r11 = (Boolean) r12;     // Catch: Throwable -> L172
    L77:
        if (r11 != null) goto L182;
        int r13 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L172
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r15) != null) goto L196;
    L169:
        r11 = r15;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_pdp_gallery_tab_indicator_v2", r11);     // Catch: Throwable -> L172
        goto L182
    L196:
        r15 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_gallery_tab_indicator_v2", Boolean.class, r3);     // Catch: Throwable -> L166
    L167:
        if (r15 != null) goto L169;
        r11 = r3;
    L166:
        r15 = r3;
        goto L167
    L188:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r16 = SDKSettingsCacheManager.b.get("ec_pdp_gallery_tab_indicator_v2");     // Catch: Throwable -> L133
        if (r16 != null) goto L85;
    L130:
        Object r17 = null;
    L131:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L133
    L135:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L159
        if (r19 == null) goto L139;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r18) == false) goto L142;
        r18 = null;
    L142:
        if ((r18 instanceof Boolean) == true) goto L144;
        r18 = null;
    L144:
        r15 = (Boolean) r18;     // Catch: Throwable -> L159
        if (r15 != null) goto L169;
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L159
        Object r21 = jj4.a.a("ec_pdp_gallery_tab_indicator_v2", Boolean.class, r3, false);     // Catch: Throwable -> L159
        if (r21 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r21 instanceof Boolean) == false) goto L154;
        r6 = r21;
    L154:
        Object r22 = (Boolean) r6;     // Catch: Throwable -> L159
        if (r22 != null) goto L157;
        r22 = r3;
    L157:
        r15 = Result.constructor-impl(r22);     // Catch: Throwable -> L159
    L85:
        if ((r16 instanceof Boolean) == true) goto L87;
        Object r23 = null;
    L88:
        r17 = (Boolean) r23;     // Catch: Throwable -> L133
        if (r17 != null) goto L131;
        if ((r16 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r24 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L133
        if ((r24 instanceof Boolean) == true) goto L98;
        r24 = null;
    L98:
        r17 = (Boolean) r24;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r25 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L133
        if ((r25 instanceof Boolean) == true) goto L104;
        r25 = null;
    L104:
        r17 = (Boolean) r25;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r26 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L133
        if ((r26 instanceof Boolean) == true) goto L110;
        r26 = null;
    L110:
        r17 = (Boolean) r26;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r27 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L133
        if ((r27 instanceof Boolean) == true) goto L116;
        r27 = null;
    L116:
        r17 = (Boolean) r27;     // Catch: Throwable -> L133
    L118:
        if ((r16 instanceof JSONObject) == false) goto L120;
    L194:
        Object r28 = SDKSettingsCacheManager.a().fromJson(r16.toString(), Boolean.class);     // Catch: Throwable -> L126
        if ((r28 instanceof Boolean) == true) goto L124;
        r28 = null;
    L124:
        Object r29 = Result.constructor-impl((Boolean) r28);     // Catch: Throwable -> L126
    L128:
        r17 = r29;
        if (Result.isFailure-impl(r17) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L133
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r16 instanceof JSONArray) == false) goto L130;
    L87:
        r23 = r16;
    L133:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L159
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L182:
        if (((Boolean) r11).booleanValue() == false) goto L184;
        GalleryFragment r32 = this.this$0;
        return new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.o(r1, r2, r32.s, r32.K, r32);
    L184:
        GalleryFragment r33 = this.this$0;
        return new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.m(r1, r2, r33.s, r33.K, r33);
    L11:
        if ((r7 instanceof Boolean) == true) goto L13;
        Object r34 = null;
    L14:
        r8 = (Boolean) r34;     // Catch: Throwable -> L59
        if (r8 != null) goto L57;
        if ((r7 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r35 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L59
        if ((r35 instanceof Boolean) == true) goto L24;
        r35 = null;
    L24:
        r8 = (Boolean) r35;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r36 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L59
        if ((r36 instanceof Boolean) == true) goto L30;
        r36 = null;
    L30:
        r8 = (Boolean) r36;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r37 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L59
        if ((r37 instanceof Boolean) == true) goto L36;
        r37 = null;
    L36:
        r8 = (Boolean) r37;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r38 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L59
        if ((r38 instanceof Boolean) == true) goto L42;
        r38 = null;
    L42:
        r8 = (Boolean) r38;     // Catch: Throwable -> L59
    L44:
        if ((r7 instanceof JSONObject) == false) goto L46;
    L186:
        Object r39 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Boolean.class);     // Catch: Throwable -> L52
        if ((r39 instanceof Boolean) == true) goto L50;
        r39 = null;
    L50:
        Object r40 = Result.constructor-impl((Boolean) r39);     // Catch: Throwable -> L52
    L54:
        r8 = r40;
        if (Result.isFailure-impl(r8) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L59
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r7 instanceof JSONArray) == false) goto L56;
    L13:
        r34 = r7;
    L59:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L172
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Object r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r45 = Result.exceptionOrNull-impl(r44);
        if (r45 == null) goto L177;
        EnsureManager.ensureNotReachHere(r45);
    L177:
        if (Result.isFailure-impl(r44) == true) goto L180;
        r3 = r44;
    L180:
        r11 = r3;
        goto L182
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m124invoke() {
        return invoke();
    }
}

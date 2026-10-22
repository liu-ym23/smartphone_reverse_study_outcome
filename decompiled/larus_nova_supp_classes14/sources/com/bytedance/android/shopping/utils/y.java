package com.bytedance.android.shopping.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    public static final class a extends com.bytedance.android.ec.core.event.a {
        public final /* synthetic */ Ref.BooleanRef a;

        public final void buildParams() {
            if (this.a.element == false) goto L5;
            String r0 = CommentScene.COMMENTSCENE_NO_AWEME;
        L6:
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            appendParam("live_plugin_has_init", r0, com.bytedance.android.ec.core.event.a.b.a.a);
            return;
        L5:
            r0 = "0";
            goto L6
        }

        public a(Ref.BooleanRef r1) {
            this.a = r1;
            super("saas_anchorv4_create_event");
        }
    }

    public y() {
    }

    public static boolean a() {
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        Lazy r2 = ECAppInfoService.a;     // Catch: Throwable -> L14
        boolean r3 = true;
        if (we.a.a == true) goto L6;
        return true;
    L6:
        int r4 = ECSdk.a;     // Catch: Throwable -> L14
        IAdapterService r5 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Throwable -> L14
        if (r5 != null) goto L9;
    L11:
        r3 = false;
    L12:
        r0.element = r3;     // Catch: Throwable -> L14
        new a(r0).post(null, null);     // Catch: Throwable -> L14
    L16:
        return r0.element;
    L9:
        if (r5.isLiveServiceReady() != true) goto L11;
    L14:
        r0.element = false;
        goto L16
    }

    public static int c() {
        return UIUtils.getScreenHeight(ECAppInfoService.e.getApplicationContext());
    }

    static {
    }

    public static String g(String r4) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r4, "url");
        if (StringsKt.contains$default(r4, "client_handle_mega_object=1", false, 2, null) == true) goto L6;
        return r4;
    L6:
        return com.bytedance.android.ec.core.hybrid.utils.j.c(r4, false, 4);
    }

    public static FragmentManager b(j73.d r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "anchorV4VM");
        Lazy r0 = ECSettingKeys.a;
        int r1 = com.bytedance.android.ec.base.settings.b.a;
        Object r2 = Boolean.TRUE;
        FragmentManager r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L170
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L170
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L170
        r5.getClass();     // Catch: Throwable -> L58
        Object r6 = SDKSettingsCacheManager.b.get("ec_fix_pdp_event_sku_layer");     // Catch: Throwable -> L58
        if (r6 != null) goto L10;
    L55:
        Object r9 = null;
    L56:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L58
    L60:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L170
        if (r11 == null) goto L64;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L170
    L64:
        if (Result.isFailure-impl(r10) == false) goto L67;
        r10 = null;
    L67:
        if ((r10 instanceof Boolean) == true) goto L69;
        r10 = null;
    L69:
        Object r12 = (Boolean) r10;     // Catch: Throwable -> L170
        if (r12 != null) goto L76;
        r5.getClass();     // Catch: Throwable -> L170
        Object r13 = SDKSettingsCacheManager.a.get("ec_fix_pdp_event_sku_layer");     // Catch: Throwable -> L170
        if ((r13 instanceof Boolean) == true) goto L75;
        r13 = null;
    L75:
        r12 = (Boolean) r13;     // Catch: Throwable -> L170
    L76:
        if (r12 != null) goto L180;
        int r14 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L170
    L157:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L170
        Object r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L160:
        if (Result.exceptionOrNull-impl(r16) != null) goto L195;
    L167:
        r12 = r16;
    L168:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L170
        SDKSettingsCacheManager.e("ec_fix_pdp_event_sku_layer", r12);     // Catch: Throwable -> L170
        goto L180
    L195:
        r16 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_fix_pdp_event_sku_layer", Boolean.class, r2);     // Catch: Throwable -> L164
    L165:
        if (r16 != null) goto L167;
        r12 = r2;
    L164:
        r16 = r2;
        goto L165
    L203:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r17 = SDKSettingsCacheManager.b.get("ec_fix_pdp_event_sku_layer");     // Catch: Throwable -> L132
        if (r17 != null) goto L84;
    L129:
        Object r18 = null;
    L130:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L132
    L134:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L157
        if (r20 == null) goto L138;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L157
    L138:
        if (Result.isFailure-impl(r19) == false) goto L141;
        r19 = null;
    L141:
        if ((r19 instanceof Boolean) == true) goto L143;
        r19 = null;
    L143:
        r16 = (Boolean) r19;     // Catch: Throwable -> L157
        if (r16 != null) goto L167;
        jj4.b r21 = jj4.b.b;     // Catch: Throwable -> L157
        Object r22 = jj4.a.a("ec_fix_pdp_event_sku_layer", Boolean.class, r2, false);     // Catch: Throwable -> L157
        if (r22 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L157
    L150:
        if ((r22 instanceof Boolean) == true) goto L152;
        r22 = null;
    L152:
        Object r23 = (Boolean) r22;     // Catch: Throwable -> L157
        if (r23 != null) goto L155;
        r23 = r2;
    L155:
        r16 = Result.constructor-impl(r23);     // Catch: Throwable -> L157
    L84:
        if ((r17 instanceof Boolean) == true) goto L86;
        Object r24 = null;
    L87:
        r18 = (Boolean) r24;     // Catch: Throwable -> L132
        if (r18 != null) goto L130;
        if ((r17 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r25 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L132
        if ((r25 instanceof Boolean) == true) goto L97;
        r25 = null;
    L97:
        r18 = (Boolean) r25;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r26 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L132
        if ((r26 instanceof Boolean) == true) goto L103;
        r26 = null;
    L103:
        r18 = (Boolean) r26;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r27 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L132
        if ((r27 instanceof Boolean) == true) goto L109;
        r27 = null;
    L109:
        r18 = (Boolean) r27;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r28 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L132
        if ((r28 instanceof Boolean) == true) goto L115;
        r28 = null;
    L115:
        r18 = (Boolean) r28;     // Catch: Throwable -> L132
    L117:
        if ((r17 instanceof JSONObject) == false) goto L119;
    L199:
        Object r29 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Boolean.class);     // Catch: Throwable -> L125
        if ((r29 instanceof Boolean) == true) goto L123;
        r29 = null;
    L123:
        Object r30 = Result.constructor-impl((Boolean) r29);     // Catch: Throwable -> L125
    L127:
        r18 = r30;
        if (Result.isFailure-impl(r18) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L132
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r17 instanceof JSONArray) == false) goto L129;
    L86:
        r24 = r17;
    L132:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L157
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L180:
        if (((Boolean) r12).booleanValue() == false) goto L190;
        Activity r33 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r8);
        if ((r33 instanceof FragmentActivity) == true) goto L184;
        r33 = null;
    L184:
        FragmentActivity r34 = (FragmentActivity) r33;
        if (r34 == null) goto L187;
        r3 = r34.getSupportFragmentManager();
    L187:
        if (r3 == null) goto L190;
        return r3;
    L190:
        return r7.getFragmentManager();
    L10:
        if ((r6 instanceof Boolean) == true) goto L12;
        Object r35 = null;
    L13:
        r9 = (Boolean) r35;     // Catch: Throwable -> L58
        if (r9 != null) goto L56;
        if ((r6 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r36 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L58
        if ((r36 instanceof Boolean) == true) goto L23;
        r36 = null;
    L23:
        r9 = (Boolean) r36;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r37 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L58
        if ((r37 instanceof Boolean) == true) goto L29;
        r37 = null;
    L29:
        r9 = (Boolean) r37;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r38 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L58
        if ((r38 instanceof Boolean) == true) goto L35;
        r38 = null;
    L35:
        r9 = (Boolean) r38;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r39 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L58
        if ((r39 instanceof Boolean) == true) goto L41;
        r39 = null;
    L41:
        r9 = (Boolean) r39;     // Catch: Throwable -> L58
    L43:
        if ((r6 instanceof JSONObject) == false) goto L45;
    L201:
        Object r40 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Boolean.class);     // Catch: Throwable -> L51
        if ((r40 instanceof Boolean) == true) goto L49;
        r40 = null;
    L49:
        Object r41 = Result.constructor-impl((Boolean) r40);     // Catch: Throwable -> L51
    L53:
        r9 = r41;
        if (Result.isFailure-impl(r9) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L58
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r6 instanceof JSONArray) == false) goto L55;
    L12:
        r35 = r6;
    L58:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L170
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r46 = Result.exceptionOrNull-impl(r45);
        if (r46 == null) goto L175;
        EnsureManager.ensureNotReachHere(r46);
    L175:
        if (Result.isFailure-impl(r45) == true) goto L178;
        r2 = r45;
    L178:
        r12 = r2;
        goto L180
    }

    public static int d(Context r1, Boolean r2) {
        if (r2 != null) goto L10;
        if (r1 != null) goto L6;
        r1 = ECAppInfoService.e.getCurrentActivity();
    L6:
        if (r1 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.helper.w.b.getClass();
        com.bytedance.android.shopping.anchorv4.helper.w.a.c(r1);
    L8:
        r2 = false;
    L10:
        if (r2.booleanValue() == false) goto L20;
        nj.d r3 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r3 == null) goto L14;
        r3.getSpiltWidth();
        Integer r4 = 0;
    L15:
        if (r4 == null) goto L18;
        return r4.intValue();
    L18:
        return UIUtils.getScreenWidth(ECAppInfoService.e.getApplicationContext());
    L14:
        r4 = null;
        goto L15
    L20:
        return UIUtils.getScreenWidth(ECAppInfoService.e.getApplicationContext());
    }

    public static Object f(Map r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "path");
        if (r8 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r9, "*") == false) goto L8;
        return r8;
    L8:
        Iterator r10 = StringsKt.split$default(r9, new String[]{"."}, false, 0, 6, null).iterator();
        Object r11 = r8;
    L10:
        if (r10.hasNext() == false) goto L15;
        String r1 = (String) r10.next();
        if ((r11 instanceof Map) == false) goto L13;
        r11 = ((Map) r11).get(r1);
        goto L10
    L13:
        return null;
    L15:
        return r11;
    }

    public static boolean h(com.bytedance.android.ecom.arch.slice.g r4, com.bytedance.android.ecom.arch.slice.g r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$isSameTemplate");
        Intrinsics.checkNotNullParameter(r5, "slice");
        boolean r1 = false;
        if ((r5 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == true) goto L5;
    L40:
        return false;
    L5:
        if (((com.bytedance.android.ecom.arch.slice.slices.template.d) r5).b() == null) goto L40;
        if ((r4 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L40;
        if (r5.getViewType().length() <= 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == true) goto L41;
        com.bytedance.android.ecom.arch.slice.slices.template.d r6 = (com.bytedance.android.ecom.arch.slice.slices.template.d) r5;
        com.bytedance.android.ecom.arch.slice.slices.template.c r2 = r6.b();
        String r3 = null;
        if (r2 == null) goto L31;
        String r7 = r2.a();
        if (r7 == null) goto L31;
        if (r7.length() <= 0) goto L22;
        r1 = true;
    L22:
        if (r1 != true) goto L31;
        com.bytedance.android.ecom.arch.slice.slices.template.c r8 = r6.b();
        if (r8 == null) goto L26;
        String r9 = r8.a();
    L27:
        com.bytedance.android.ecom.arch.slice.slices.template.c r10 = ((com.bytedance.android.ecom.arch.slice.slices.template.d) r4).b();
        if (r10 == null) goto L42;
        r3 = r10.a();
    L42:
        return Intrinsics.areEqual(r9, r3);
    L26:
        r9 = null;
    L31:
        com.bytedance.android.ecom.arch.slice.slices.template.c r11 = r6.b();
        if (r11 == null) goto L34;
        String r12 = r11.d();
    L35:
        com.bytedance.android.ecom.arch.slice.slices.template.c r13 = ((com.bytedance.android.ecom.arch.slice.slices.template.d) r4).b();
        if (r13 == null) goto L39;
        r3 = r13.d();
    L39:
        return Intrinsics.areEqual(r12, r3);
    L34:
        r12 = null;
        goto L35
    L41:
        return Intrinsics.areEqual(r5.getViewType(), r4.getViewType());
    L12:
        r0 = false;
        goto L13
    }

    public static /* synthetic */ int e(Context r2, Boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        return d(r2, r3);
    }
}

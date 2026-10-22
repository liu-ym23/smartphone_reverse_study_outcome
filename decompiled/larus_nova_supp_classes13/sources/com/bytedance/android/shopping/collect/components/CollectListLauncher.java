package com.bytedance.android.shopping.collect.components;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.b;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.card_list.components.CardListQueryFetchComponent;
import com.bytedance.android.shopping.card_list.components.k;
import com.bytedance.android.shopping.card_list.container.CardListTemplateMgr;
import com.bytedance.android.shopping.card_list.container.init.BaseCartListLauncher;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.container.init.c;
import com.bytedance.android.shopping.card_list.container.init.f;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CollectPassThroughData;
import com.bytedance.android.shopping.collect.container.CardListCollectCustomWidget;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import nj.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectListLauncher extends BaseCartListLauncher {
    public static final /* synthetic */ int c = 0;
    public final Map<String, Integer> b;

    public static final class Companion {
        public static void a() {
            f.a r0 = f.a;
            LauncherBizType r1 = LauncherBizType.COLLECT;
            CollectListLauncher$Companion$register$1 r2 = CollectListLauncher$Companion$register$1.INSTANCE;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "lambda");
            c.a.put(r1, r2);
        }
    }

    static {
    }

    public CollectListLauncher() {
        ECSettingKeys.j.getClass();
        int r0 = b.a;
        Object r1 = qg.b.b;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L174
        h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r3 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r4 = null;
        r3.getClass();     // Catch: Throwable -> L59
        Object r5 = SDKSettingsCacheManager.b.get("iesec_collect_slice_templates_V2");     // Catch: Throwable -> L59
        if (r5 != null) goto L11;
    L56:
        Object r6 = null;
    L57:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L59
    L61:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L174
        if (r8 == null) goto L65;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r7) == false) goto L68;
        r7 = null;
    L68:
        if ((r7 instanceof Map) == true) goto L70;
        r7 = null;
    L70:
        Object r9 = (Map) r7;     // Catch: Throwable -> L174
        if (r9 != null) goto L77;
        r3.getClass();     // Catch: Throwable -> L174
        Object r10 = SDKSettingsCacheManager.a.get("iesec_collect_slice_templates_V2");     // Catch: Throwable -> L174
        if ((r10 instanceof Map) == true) goto L76;
        r10 = null;
    L76:
        r9 = (Map) r10;     // Catch: Throwable -> L174
    L77:
        if (r9 != null) goto L183;
        int r11 = g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L174
        Object r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r13) != null) goto L195;
    L171:
        r9 = r13;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_collect_slice_templates_V2", r9);     // Catch: Throwable -> L174
        goto L183
    L195:
        r13 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_collect_slice_templates_V2", Map.class, r1);     // Catch: Throwable -> L168
    L169:
        if (r13 != null) goto L171;
        r9 = r1;
    L168:
        r13 = r1;
        goto L169
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r14 = SDKSettingsCacheManager.b.get("iesec_collect_slice_templates_V2");     // Catch: Throwable -> L133
        if (r14 != null) goto L85;
    L130:
        Object r15 = null;
    L131:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L133
    L135:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L161
        if (r17 == null) goto L139;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r16) == false) goto L142;
        r16 = null;
    L142:
        if ((r16 instanceof Map) == true) goto L144;
        r16 = null;
    L144:
        r13 = (Map) r16;     // Catch: Throwable -> L161
        if (r13 != null) goto L147;
    L149:
        jj4.b r18 = jj4.b.b;     // Catch: Throwable -> L161
        Object r19 = jj4.a.a("iesec_collect_slice_templates_V2", Map.class, r1, false);     // Catch: Throwable -> L161
        if (r19 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r19 instanceof Map) == false) goto L156;
        r4 = r19;
    L156:
        Object r20 = (Map) r4;     // Catch: Throwable -> L161
        if (r20 != null) goto L159;
        r20 = r1;
    L159:
        r13 = Result.constructor-impl(r20);     // Catch: Throwable -> L161
    L147:
        if ((r13 instanceof Map) == false) goto L149;
    L85:
        if ((r14 instanceof Map) == true) goto L87;
        Object r21 = null;
    L88:
        r15 = (Map) r21;     // Catch: Throwable -> L133
        if (r15 != null) goto L131;
        if ((r14 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r22 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L133
        if ((r22 instanceof Map) == true) goto L98;
        r22 = null;
    L98:
        r15 = (Map) r22;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r23 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L133
        if ((r23 instanceof Map) == true) goto L104;
        r23 = null;
    L104:
        r15 = (Map) r23;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r24 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L133
        if ((r24 instanceof Map) == true) goto L110;
        r24 = null;
    L110:
        r15 = (Map) r24;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r25 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L133
        if ((r25 instanceof Map) == true) goto L116;
        r25 = null;
    L116:
        r15 = (Map) r25;     // Catch: Throwable -> L133
    L118:
        if ((r14 instanceof JSONObject) == false) goto L120;
    L191:
        Object r26 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Map.class);     // Catch: Throwable -> L126
        if ((r26 instanceof Map) == true) goto L124;
        r26 = null;
    L124:
        Object r27 = Result.constructor-impl((Map) r26);     // Catch: Throwable -> L126
    L128:
        r15 = r27;
        if (Result.isFailure-impl(r15) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L133
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r14 instanceof JSONArray) == false) goto L130;
    L87:
        r21 = r14;
    L133:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L161
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L183:
        this.b = (Map) r9;
        return;
    L11:
        if ((r5 instanceof Map) == true) goto L13;
        Object r30 = null;
    L14:
        r6 = (Map) r30;     // Catch: Throwable -> L59
        if (r6 != null) goto L57;
        if ((r5 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L59
        if ((r31 instanceof Map) == true) goto L24;
        r31 = null;
    L24:
        r6 = (Map) r31;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L59
        if ((r32 instanceof Map) == true) goto L30;
        r32 = null;
    L30:
        r6 = (Map) r32;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L59
        if ((r33 instanceof Map) == true) goto L36;
        r33 = null;
    L36:
        r6 = (Map) r33;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Map.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L59
        if ((r34 instanceof Map) == true) goto L42;
        r34 = null;
    L42:
        r6 = (Map) r34;     // Catch: Throwable -> L59
    L44:
        if ((r5 instanceof JSONObject) == false) goto L46;
    L193:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Map.class);     // Catch: Throwable -> L52
        if ((r35 instanceof Map) == true) goto L50;
        r35 = null;
    L50:
        Object r36 = Result.constructor-impl((Map) r35);     // Catch: Throwable -> L52
    L54:
        r6 = r36;
        if (Result.isFailure-impl(r6) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L59
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r5 instanceof JSONArray) == false) goto L56;
    L13:
        r30 = r5;
    L59:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L174
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L179;
        EnsureManager.ensureNotReachHere(r41);
    L179:
        if (Result.isFailure-impl(r40) == true) goto L182;
        r1 = r40;
    L182:
        r9 = r1;
        goto L183
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.f
    public final void d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        CardListTemplateMgr.INSTANCE.preload(r5, "ecom_collect_card_template", "yata_collects", this.b);
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.BaseCartListLauncher, com.bytedance.android.shopping.card_list.container.init.f
    public final void a(final CardListObjectContainer r4, final View r5) {
        Intrinsics.checkNotNullParameter(r4, "objectContainer");
        Intrinsics.checkNotNullParameter(r5, "rootContainerView");
        super.a(r4, r5);
        r4.e(Reflection.getOrCreateKotlinClass(CardListQueryFetchComponent.class), Boolean.TRUE, new CollectListLauncher$onLaunch$$inlined$apply$lambda$1(r4, r4, r5));
        KClass<? extends com.bytedance.android.shopping.card_list.components.a> r0 = Reflection.getOrCreateKotlinClass(k.class);
        Function0<KitCollectLoadingComponent> r1 = new CollectListLauncher$onLaunch$$inlined$apply$lambda$2(r4, r4, r5);
        Boolean r2 = Boolean.FALSE;
        r4.e(r0, r2, r1);
        r4.e(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.card_list.components.f.class), r2, new CollectListLauncher$onLaunch$$inlined$apply$lambda$3(r4, r4, r5));
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.BaseCartListLauncher, com.bytedance.android.shopping.card_list.container.init.f
    public final void c(CardListObjectContainer r12, f.b r13, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r14, Function2<? super f.b, ? super com.bytedance.kmp.ec.yata.view.render.delegate.v2.a, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "objectContainer");
        Intrinsics.checkNotNullParameter(r13, "sdkParams");
        Intrinsics.checkNotNullParameter(r15, "cb");
        AtomicBoolean r16 = CardListCollectCustomWidget.a;
        CardListCollectCustomWidget.a(ECSettingKeys.t().c(), ECSettingKeys.t().b(), ECSettingKeys.t().d());
        Integer r2 = null;
        if (r12.getContext() == null) goto L22;
        int r17 = com.bytedance.android.shopping.card_list.utils.h.a;
        CardPassThroughData r18 = r12.e.a;
        if (r18 == null) goto L7;
        String r19 = r18.getSplitActivityScene();
    L8:
        boolean r110 = com.bytedance.android.shopping.card_list.utils.h.a(r19);
        if (ECAppInfoService.e.isNightMode() == false) goto L11;
        String r3 = "dark";
    L12:
        Context r4 = r12.getContext();
        if (r4 == null) goto L22;
        int r5 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.e;
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r6 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.a.a(r4, "yata_collects");
        SlcRenderContext r7 = r6.b;
        r7.p(MapsKt.mapOf(TuplesKt.to("app_theme", r3)));
        r7.j = false;
        int r8 = com.bytedance.android.shopping.collect.container.c.a;
        r7.k = ECSettingKeys.t().a();
        r7.g = true;
        com.bytedance.android.ecom.arch.slice.render.context.b.a r9 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        if (r110 == false) goto L20;
        d r111 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r111 == null) goto L19;
        r111.getSpiltWidth();
        int r112 = 0;
    L21:
        r9.getClass();
        r7.f = com.bytedance.android.ecom.arch.slice.render.context.b.a.b(375.0f, 1.0f, 1.0f, r112);
    L23:
        Map<String, Integer> r10 = this.b;
        Pair[] r11 = new Pair[3];
        r11[0] = TuplesKt.to("net_host", "https://ecom.snssdk.com/");
        r11[1] = TuplesKt.to("update_api", "aweme/v2/collects/yata/update");
        Pair[] r20 = new Pair[5];
        CardPassThroughData r21 = r12.e.a;
        if (r21 == null) goto L28;
        CollectPassThroughData r22 = r21.getCollectSchemaData();
        if (r22 == null) goto L28;
        String r23 = r22.getGuestUid();
    L29:
        r20[0] = TuplesKt.to("guest_uid", r23);
        CardPassThroughData r1 = r12.e.a;
        if (r1 == null) goto L32;
        String r24 = r1.getEcomSceneId();
    L33:
        r20[1] = TuplesKt.to("ecom_scene_id", r24);
        CardPassThroughData r0 = r12.e.a;
        if (r0 == null) goto L38;
        CollectPassThroughData r25 = r0.getCollectSchemaData();
        if (r25 == null) goto L38;
        String r26 = r25.getPreviousPage();
    L39:
        r20[2] = TuplesKt.to("previous_page", r26);
        CardPassThroughData r27 = r12.e.a;
        if (r27 == null) goto L44;
        CollectPassThroughData r28 = r27.getCollectSchemaData();
        if (r28 == null) goto L44;
        Boolean r29 = Boolean.valueOf(r28.isFromPersonal());
    L45:
        r20[3] = TuplesKt.to("is_from_personal", r29);
        CardPassThroughData r113 = r12.e.a;
        if (r113 == null) goto L50;
        CollectPassThroughData r114 = r113.getCollectSchemaData();
        if (r114 == null) goto L50;
        r2 = Integer.valueOf(r114.getCollectExperimentValue());
    L50:
        r20[4] = TuplesKt.to("collect_experiment_value", r2);
        r11[2] = TuplesKt.to("extra_map", MapsKt.mapOf(r20));
        Map r115 = MapsKt.mapOf(r11);
        String r30 = r13.a;
        Intrinsics.checkNotNullParameter("yata_collects", "bizCode");
        Intrinsics.checkNotNullParameter("ecom_collect_card_template", "sliceTemplateChannel");
        Intrinsics.checkNotNullParameter(r115, "abilityParams");
        super.c(r12, new f.b(r30, "yata_collects", "ecom_collect_card_template", r10, r115), r6, r15);
        return;
    L44:
        r29 = null;
    L38:
        r26 = null;
        goto L39
    L32:
        r24 = null;
    L28:
        r23 = null;
        goto L29
    L19:
        r112 = 360;
        goto L21
    L20:
        r112 = -1;
        goto L21
    L11:
        r3 = "light";
        goto L12
    L7:
        r19 = null;
    L22:
        r6 = null;
        goto L23
    }
}

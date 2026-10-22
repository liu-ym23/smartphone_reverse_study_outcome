package qh3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.btm.api.model.q;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyOrderExParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataOpenSkuChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataPageShowChain;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.container.SkuEmptyContainerActivity;
import com.bytedance.android.shopping.sku.inner.container.g0;
import com.bytedance.android.shopping.sku.inner.ultimate.g;
import com.bytedance.android.shopping.sku.inner.ultimate.j;
import com.bytedance.android.shopping.sku.outer.business.ultimate.UltimateBuyOrderSchemaParser;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaRouterHandler;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import nl.f;
import org.json.JSONArray;
import org.json.JSONObject;
import sc3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements i {
    public a() {
    }

    @Override // sc3.i
    public final void m(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
    }

    @Override // sc3.i
    public final void n(SkuParams r2) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
    }

    @Override // sc3.i
    public final boolean b(int r9) {
        cl.d r0 = k.a();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        ECAppInfoService r1 = ECAppInfoService.e;
        r1.i();
        r1.i();
        String r2 = r1.getAppId();
        if (Intrinsics.areEqual(r2, "1128") == false) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r2, "2329") == false) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r2, "561124") == true) goto L232;
        Lazy r3 = ECSettingKeys.a;
        int r4 = n.a;
        Object r5 = 0;
        int r6 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L170
        Object r8 = null;
        Object r10 = com.bytedance.android.ec.base.settings.d.c.get("iesec_enable_yata_sku");     // Catch: Throwable -> L64
        if (r10 != null) goto L19;
    L61:
        Object r11 = null;
    L62:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L64
    L66:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L170
        if (r13 == null) goto L70;
        EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L170
    L70:
        if (Result.isFailure-impl(r12) == false) goto L73;
        r12 = null;
    L73:
        if ((r12 instanceof Integer) == true) goto L75;
        r12 = null;
    L75:
        Object r14 = (Integer) r12;     // Catch: Throwable -> L170
        if (r14 != null) goto L82;
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("iesec_enable_yata_sku");     // Catch: Throwable -> L170
        if ((r15 instanceof Integer) == true) goto L81;
        r15 = null;
    L81:
        r14 = (Integer) r15;     // Catch: Throwable -> L170
    L82:
        if (r14 != null) goto L180;
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L170
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("iesec_enable_yata_sku");     // Catch: Throwable -> L134
        if (r17 != null) goto L89;
    L131:
        Object r18 = null;
    L132:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L134
    L136:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L160
        if (r20 == null) goto L140;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L160
    L140:
        if (Result.isFailure-impl(r19) == false) goto L143;
        r19 = null;
    L143:
        if ((r19 instanceof Integer) == true) goto L145;
        r19 = null;
    L145:
        r14 = (Integer) r19;     // Catch: Throwable -> L160
        if (r14 != null) goto L168;
        IHybridHostService r21 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L160
        if (r21 == null) goto L151;
        Object r22 = r21.getHostABValue("iesec_enable_yata_sku", r5);     // Catch: Throwable -> L160
    L152:
        if (r22 != null) goto L154;
    L159:
        r14 = r5;
        goto L168
    L154:
        if ((r22 instanceof Integer) == false) goto L157;
        r8 = r22;
    L157:
        Object r23 = (Integer) r8;     // Catch: Throwable -> L160
        if (r23 == null) goto L159;
    L167:
        r14 = r23;
        goto L168
    L151:
        r22 = null;
    L168:
        com.bytedance.android.ec.base.settings.d.d("iesec_enable_yata_sku", r14);     // Catch: Throwable -> L170
        goto L180
    L89:
        if ((r17 instanceof Integer) == true) goto L91;
        Object r24 = null;
    L92:
        r18 = (Integer) r24;     // Catch: Throwable -> L134
        if (r18 != null) goto L132;
        if ((r17 instanceof Number) == false) goto L119;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L104;
        Float r25 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L134
        if ((r25 instanceof Integer) == true) goto L102;
        r25 = null;
    L102:
        r18 = (Integer) r25;     // Catch: Throwable -> L134
        goto L132
    L104:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L110;
        Double r26 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L134
        if ((r26 instanceof Integer) == true) goto L108;
        r26 = null;
    L108:
        r18 = (Integer) r26;     // Catch: Throwable -> L134
        goto L132
    L110:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L113;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L134
        goto L132
    L113:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L119;
        Long r27 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L134
        if ((r27 instanceof Integer) == true) goto L117;
        r27 = null;
    L117:
        r18 = (Integer) r27;     // Catch: Throwable -> L134
    L119:
        if ((r17 instanceof JSONObject) == false) goto L121;
    L216:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r28 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L127
        if ((r28 instanceof Integer) == true) goto L125;
        r28 = null;
    L125:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L127
    L129:
        r18 = r29;
        if (Result.isFailure-impl(r18) == false) goto L132;
    L127:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L134
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L134
        goto L129
    L121:
        if ((r17 instanceof JSONArray) == false) goto L131;
    L91:
        r24 = r17;
    L160:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L170
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        Throwable r32 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L170
        if (r32 == null) goto L165;
        EnsureManager.ensureNotReachHere(r32);     // Catch: Throwable -> L170
    L165:
        if (Result.isFailure-impl(r23) == false) goto L167;
        r23 = r5;
    L134:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L160
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L180:
        if (((Number) r14).intValue() == 1) goto L194;
        int r34 = p.a;
        Object r35 = Boolean.FALSE;
        jj4.b r36 = jj4.b.b;     // Catch: Throwable -> L186
        Object r37 = jj4.a.a("iesec_yata_sku", Boolean.class, r35, false);     // Catch: Throwable -> L186
        if (r37 != null) goto L193;
        Intrinsics.throwNpe();     // Catch: Throwable -> L186
    L193:
        if (((Boolean) r37).booleanValue() == true) goto L194;
    L212:
        return false;
    L186:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r39) == true) goto L191;
        r35 = r39;
    L191:
        r37 = r35;
    L194:
        int r40 = g0.a;
        com.bytedance.android.ec.core.abtest.d r41 = com.bytedance.android.ec.core.abtest.d.a;
        jj4.b r42 = jj4.b.b;
        Object r43 = jj4.a.a("iesec_yata_sku_blacklist", List.class, new ArrayList(), false);
        if (r43 != null) goto L198;
        Intrinsics.throwNpe();
    L198:
        if (((List) r43).isEmpty() == true) goto L209;
        Object r44 = jj4.a.a("iesec_yata_sku_blacklist", List.class, new ArrayList(), false);
        if (r44 != null) goto L203;
        Intrinsics.throwNpe();
    L203:
        Iterator r45 = ((List) r44).iterator();
    L205:
        if (r45.hasNext() == false) goto L209;
        if (((Number) r45.next()).intValue() != r9) goto L205;
        boolean r46 = true;
    L210:
        if (r46 == true) goto L212;
        return true;
    L209:
        r46 = false;
        goto L210
    L19:
        if ((r10 instanceof Integer) == true) goto L21;
        Object r47 = null;
    L22:
        r11 = (Integer) r47;     // Catch: Throwable -> L64
        if (r11 != null) goto L62;
        if ((r10 instanceof Number) == false) goto L49;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L34;
        Float r48 = Float.valueOf(((Number) r10).floatValue());     // Catch: Throwable -> L64
        if ((r48 instanceof Integer) == true) goto L32;
        r48 = null;
    L32:
        r11 = (Integer) r48;     // Catch: Throwable -> L64
        goto L62
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L40;
        Double r49 = Double.valueOf(((Number) r10).doubleValue());     // Catch: Throwable -> L64
        if ((r49 instanceof Integer) == true) goto L38;
        r49 = null;
    L38:
        r11 = (Integer) r49;     // Catch: Throwable -> L64
        goto L62
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L43;
        r11 = Integer.valueOf(((Number) r10).intValue());     // Catch: Throwable -> L64
        goto L62
    L43:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L49;
        Long r50 = Long.valueOf(((Number) r10).longValue());     // Catch: Throwable -> L64
        if ((r50 instanceof Integer) == true) goto L47;
        r50 = null;
    L47:
        r11 = (Integer) r50;     // Catch: Throwable -> L64
    L49:
        if ((r10 instanceof JSONObject) == false) goto L51;
    L214:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L57
        Object r51 = SDKSettingsCacheManager.a().fromJson(r10.toString(), Integer.class);     // Catch: Throwable -> L57
        if ((r51 instanceof Integer) == true) goto L55;
        r51 = null;
    L55:
        Object r52 = Result.constructor-impl((Integer) r51);     // Catch: Throwable -> L57
    L59:
        r11 = r52;
        if (Result.isFailure-impl(r11) == false) goto L62;
    L57:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L64
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
        goto L59
    L51:
        if ((r10 instanceof JSONArray) == false) goto L61;
    L21:
        r47 = r10;
    L64:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L170
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        Object r56 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r57 = Result.exceptionOrNull-impl(r56);
        if (r57 == null) goto L175;
        EnsureManager.ensureNotReachHere(r57);
    L175:
        if (Result.isFailure-impl(r56) == true) goto L178;
        r5 = r56;
    L178:
        r14 = r5;
        goto L180
    L232:
        return true;
    }

    @Override // sc3.i
    public final xh3.a h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return new xh3.a(r2);
    }

    @Override // sc3.i
    public final boolean l(String r6) {
        Intrinsics.checkNotNullParameter(r6, "bizIdentifier");
        if (Intrinsics.areEqual("foodtakeout", r6) == false) goto L5;
        return true;
    L5:
        Lazy r0 = ECSettingKeys.a;
        int r1 = p.a;
        Object r2 = new com.bytedance.android.ec.core.sku.d(null);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L10
        Object r3 = jj4.a.a("ies_ec_sku_force_switch_yata", com.bytedance.android.ec.core.sku.d.class, r2, false);     // Catch: Throwable -> L10
        if (r3 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L10
    L16:
        List r7 = ((com.bytedance.android.ec.core.sku.d) r3).a();
        if (r7 != null) goto L19;
    L21:
        return false;
    L19:
        if (r7.contains(r6) != true) goto L21;
        return true;
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Object r9 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r9) == true) goto L15;
        r2 = r9;
    L15:
        r3 = r2;
        goto L16
    }

    @Override // sc3.i
    public final String f(SkuParams r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        return com.bytedance.android.shopping.sku.inner.ultimate.d.a(r2, r3);
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    @Override // sc3.i
    public final boolean c(int r1, int r2, int r3) {
        return g.a(r1, r2, r3);
    }

    @Override // sc3.i
    public final void e(IOrderSchema r3, f r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "orderSchema");
        Intrinsics.checkNotNullParameter(r4, "ultimateBuySingleSkuParams");
        String r0 = r3.getQueryParam("ultimate_buy_ab");
        if (r0 != null) goto L6;
        r0 = "0";
    L6:
        if (com.bytedance.android.shopping.extensions.k.r(r0, 0) <= 0) goto L11;
        r3.Y0(r4);
        if (r5 == null) goto L12;
        Unit r6 = (Unit) r5.invoke();
        return;
    L12:
        return;
    }

    @Override // sc3.i
    public final String g(String r12, f r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r13, "ultimateBuySingleSkuParams");
        int r2 = com.bytedance.android.shopping.sku.inner.ultimate.f.a;
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r13, "ultimateBuySingleSkuParams");
        Uri r0 = UriProtector.parse(r12);     // Catch: Exception -> L55
        String r1 = UriProtector.getQueryParameter(r0, "ultimate_buy_ab");     // Catch: Exception -> L55
        if (r1 != null) goto L7;
        r1 = "0";
    L7:
        if (com.bytedance.android.shopping.extensions.k.r(r1, 0) <= 0) goto L66;
        String[] r3 = r13.d;     // Catch: Exception -> L55
        Long r4 = r13.e;     // Catch: Exception -> L55
        String r5 = r13.a;     // Catch: Exception -> L55
        List r6 = r13.f;     // Catch: Exception -> L55
        ArrayList r7 = null;
        if (r6 == null) goto L25;
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L55
        Iterator r9 = r6.iterator();     // Catch: Exception -> L55
    L13:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();     // Catch: Exception -> L55
        Map r11 = ((PromotionBenefitLabel) r10).getExtra();     // Catch: Exception -> L55
        if (r11 == null) goto L17;
        String r15 = (String) r11.get("pass_through");     // Catch: Exception -> L55
    L19:
        if (Intrinsics.areEqual(r15, "1") == false) goto L13;
        r8.add(r10);     // Catch: Exception -> L55
        goto L13
    L17:
        r15 = null;
        goto L19
    L21:
        r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));     // Catch: Exception -> L55
        Iterator r16 = r8.iterator();     // Catch: Exception -> L55
    L23:
        if (r16.hasNext() == false) goto L25;
        r7.add(((PromotionBenefitLabel) r16.next()).createClone());     // Catch: Exception -> L55
    L25:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L55
        if (r3 == null) goto L28;
        r17.put("default_spec_id", u0.d(r3));     // Catch: Exception -> L55
    L28:
        if (r4 == null) goto L30;
        r17.put("default_count", String.valueOf(r4.longValue()));     // Catch: Exception -> L55
    L30:
        r17.put("scene_type", r13.c);     // Catch: Exception -> L55
        r17.put("action_type", "1");     // Catch: Exception -> L55
        if (r5 == null) goto L33;
        r17.put("live_product_raw_data", r5);     // Catch: Exception -> L55
    L33:
        if (r7 == null) goto L35;
        r17.put("coupon_tags", com.bytedance.android.shopping.extensions.k.x(r7));     // Catch: Exception -> L55
    L35:
        String r18 = r13.g;     // Catch: Exception -> L55
        if (r18 == null) goto L38;
        r17.put("detail_url", r18);     // Catch: Exception -> L55
    L38:
        Boolean r19 = r13.j;     // Catch: Exception -> L55
        if (r19 == null) goto L41;
        r17.put("disable_server_specs_default_select", String.valueOf(r19.booleanValue()));     // Catch: Exception -> L55
    L41:
        String r20 = r13.h;     // Catch: Exception -> L55
        if (r20 == null) goto L44;
        r17.put(SimilarProductParam.ENTER_FROM, r20);     // Catch: Exception -> L55
    L44:
        String r21 = r13.i;     // Catch: Exception -> L55
        if (r21 == null) goto L47;
        r17.put("event_session_id", r21);     // Catch: Exception -> L55
    L47:
        Float r22 = r13.k;     // Catch: Exception -> L55
        if (r22 == null) goto L50;
        r17.put("mask_alpha", String.valueOf(r22.floatValue()));     // Catch: Exception -> L55
    L50:
        r17.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r13.b);     // Catch: Exception -> L55
        int r110 = p0.a;     // Catch: Exception -> L55
        Uri r111 = p0.e(r0, "sku_params_ultimate", r17.toString());     // Catch: Exception -> L55
        if (r14 == null) goto L53;
        Unit r112 = (Unit) r14.invoke();     // Catch: Exception -> L55
    L53:
        return r111.toString();
    L66:
        return r12;
    L55:
        e = move-exception;
        ECExceptionMonitor.e(e);
        Lazy r113 = SkuCommonLog.a;
        SkuCommonLog.c("UltimateBuySingleSkuParamsGenerator", "url error:" + e.getMessage());
        return r12;
    }

    @Override // sc3.i
    public final void a(Context r2, Uri r3, boolean r4, ea3.b r5) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        new SkuSchemaRouterHandler(r3, r5).b(r2, r4);
    }

    @Override // sc3.i
    public final void d(Uri r4, ea3.b r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L7;
        sc3.c r2 = r1.getBuyNowService();
        if (r2 == null) goto L7;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r3 = r2.o();
    L8:
        if (r3 == null) goto L10;
        r3.c(ChainPoint.PARSE_SCHEMA_START, null);
    L10:
        new com.bytedance.android.shopping.sku.inner.ultimate.e(r4, r5, r6, r7).a(false);
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // sc3.i
    public final boolean j(FragmentManager r132, Uri r133, int r134, int r135, String r136) {
        Intrinsics.checkNotNullParameter(r132, "fragmentManager");
        Intrinsics.checkNotNullParameter(r133, "uri");
        if (ECAppInfoService.e.i() == false) goto L7;
        cl.d r4 = k.a();
        if (r4 == null) goto L7;
        r4.b();
    L7:
        Intrinsics.checkNotNullParameter(r132, "fragmentManager");
        Intrinsics.checkNotNullParameter(r133, "uri");
        int r1 = ECSdk.a;
        IEShoppingService r2 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r2 == null) goto L10;
        sc3.c r3 = r2.getBuyNowService();
    L11:
        if (r3 == null) goto L13;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r5 = r3.o();
    L14:
        if (r5 == null) goto L16;
        r5.c(ChainPoint.SKU_PARAM_START, null);
    L16:
        UltimateBuyOrderExParams r7 = UltimateBuyOrderSchemaParser.a(r133);
        Intrinsics.checkNotNullParameter(r133, "uri");
        String r6 = j1.c(r133, "sku_params_ultimate");
        if (r6 == null) goto L19;
        JSONObject r8 = z1.g(r6);
    L21:
        if (r8 == null) goto L27;
        String r9 = r8.optString("action_type", "1");
        if (r9 == null) goto L27;
        Integer r10 = StringsKt.toIntOrNull(r9);
        if (r10 == null) goto L27;
        int r11 = r10.intValue();
    L29:
        if (r8 == null) goto L35;
        String r12 = r8.optString("scene_type", "0");
        if (r12 == null) goto L35;
        Integer r13 = StringsKt.toIntOrNull(r12);
        if (r13 == null) goto L35;
        int r14 = r13.intValue();
    L37:
        if (r8 == null) goto L39;
        String r15 = r8.optString("live_product_raw_data", "");
    L40:
        if (r8 == null) goto L45;
        String r16 = r8.optString(PdpOpenThirdParam.KEY_PROMOTION_ID, "");
        if (r16 == null) goto L45;
        String r32 = r16;
    L46:
        if (r8 == null) goto L51;
        String r17 = r8.optString("event_session_id", "");
        if (r17 == null) goto L51;
        String r113 = r17;
    L53:
        if (r8 == null) goto L58;
        String r18 = r8.optString("detail_url", "");
        if (r18 == null) goto L58;
        String r48 = r18;
    L60:
        if (r8 == null) goto L62;
        String r54 = r8.optString(SimilarProductParam.ENTER_FROM, "");
    L64:
        if (r8 == null) goto L66;
        String r124 = r8.optString("default_spec_id", "");
    L68:
        if (r8 == null) goto L70;
        String r19 = r8.optString("default_count", "");
    L71:
        long r110 = com.bytedance.android.shopping.extensions.k.y(r19, 1);
        if (r8 == null) goto L74;
        String r20 = r8.optString("disable_server_specs_default_select", "false");
    L75:
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r128 = r5;
        boolean r21 = com.bytedance.android.shopping.extensions.k.n(r20, false);
        if (r8 == null) goto L80;
        String r22 = r8.optString("mask_alpha", "");
        if (r22 == null) goto L80;
        Float r23 = StringsKt.toFloatOrNull(r22);
    L81:
        String r24 = j1.c(r133, "height_percent");
        if (r24 == null) goto L86;
        Integer r25 = StringsKt.toIntOrNull(r24);
        if (r25 == null) goto L86;
        int r26 = r25.intValue();
    L88:
        if (r8 != null) goto L148;
        String r27 = null;
    L91:
        List r28 = u0.e(r27, PromotionBenefitLabel[].class);     // Catch: Exception -> L93
    L94:
        List r49 = r28;
        String r31 = j1.c(r133, "id");
        if (r23 == null) goto L97;
        float r75 = r23.floatValue();
    L98:
        SkuParams r29 = new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, r31, r32, null, false, null, null, null, null, null, null, null, false, r11, r14, null, null, 0, r48, r49, null, null, null, null, r54, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, Integer.valueOf(r26), null, null, r75, null, null, null, null, null, null, null, null, null, null, null, null, 0, "UltimateBuySkuParamForSingle.generateSkuParams", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, null, r113, null, null, null, null, null, 1946107903, -75497506, 2147483391, 31, null);
        if (g.a(r134, r14, r11) == false) goto L145;
        Map<String, mh3.a> r30 = mh3.a.m;
        SkuAbilityType r33 = SkuAbilityType.BUYNOW;
        mh3.a.C0219a.a(r33, r29, true);
        new com.bytedance.android.shopping.sku.common.controller.d(r33, r29, true).a();
        Pair[] r34 = new Pair[1];
        Pair[] r35 = new Pair[3];
        Pair[] r36 = new Pair[5];
        String r111 = String.valueOf(r29.getActionType());
        if (r111 == null) goto L143;
        r36[0] = TuplesKt.to("action_type", r111);
        String r37 = String.valueOf(r29.getSceneType());
        if (r37 == null) goto L141;
        r36[1] = TuplesKt.to("scene_type", r37);
        List r38 = r29.getBenefitLabels();
        if ((r38 instanceof List) == true) goto L107;
        r38 = null;
    L107:
        r36[2] = TuplesKt.to("coupon_tags", r38);
        r36[3] = TuplesKt.to("live_product_raw_data", r15);
        if (BuyNowPerformanceOpt.a() == false) goto L110;
        String r39 = null;
    L111:
        r36[4] = TuplesKt.to("detail_url", r39);
        r35[0] = TuplesKt.to("biz_context", MapsKt.mapOf(r36));
        Pair[] r40 = new Pair[8];
        r40[0] = TuplesKt.to("default_spec_id", r124);
        r40[1] = TuplesKt.to("default_count", Long.valueOf(r110));
        r40[2] = TuplesKt.to("disable_server_specs_default_select", Boolean.valueOf(r21));
        Integer r41 = r29.getSpecMode();
        if ((r41 instanceof Integer) == true) goto L114;
        r41 = null;
    L114:
        r40[3] = TuplesKt.to("spec_mode", r41);
        Long r42 = r29.getSpecModeTime();
        if (r42 == null) goto L117;
        String r43 = String.valueOf(r42.longValue());
    L119:
        if ((r43 instanceof String) == true) goto L121;
        r43 = null;
    L121:
        r40[4] = TuplesKt.to("spec_mode_time", r43);
        r40[5] = TuplesKt.to("panel_width", Integer.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.b(false)));
        r40[6] = TuplesKt.to("panel_height", Integer.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.a()));
        if (BuyNowPerformanceOpt.a() == false) goto L124;
        Boolean r44 = Boolean.valueOf(a2.b(r29.getDetailUrl()));
    L125:
        r40[7] = TuplesKt.to("show_detail_entrance", r44);
        r35[1] = TuplesKt.to("client_params", MapsKt.mapOf(r40));
        String r45 = r29.getEnterFrom();
        if ((r45 instanceof String) == true) goto L129;
        r45 = null;
    L129:
        r35[2] = TuplesKt.to("chain_info", MapsKt.mapOf(TuplesKt.to(SimilarProductParam.ENTER_FROM, r45)));
        r34[0] = TuplesKt.to("sku_schema_param", MapsKt.mutableMapOf(r35));
        Map r46 = MapsKt.mutableMapOf(r34);
        r46.putAll(MapsKt.emptyMap());
        if (r128 == null) goto L132;
        r128.c(ChainPoint.SKU_PARAM_END, null);
    L132:
        IEShoppingService r47 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r47 == null) goto L137;
        sc3.c r50 = r47.getBuyNowService();
        if (r50 == null) goto L137;
        UltimateBuyParams r51 = new UltimateBuyParams(r7, r46, r134, r135, r29, null, 32, null);
        Lazy r0 = SkuBuyNowPanelHeightHelper.a;
        String r52 = sc3.c.a.a(r50, null, r132, r51, new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(String.valueOf(r29.getSceneType()), r29.getHeightPercent()), Float.valueOf(r29.getMaskAlpha())), r136, null, null, null, null, 513);
    L138:
        if (r52 == null) goto L150;
        return true;
    L150:
        return false;
    L137:
        r52 = null;
        goto L138
    L124:
        r44 = null;
        goto L125
    L117:
        r43 = null;
        goto L119
    L110:
        r39 = r29.getDetailUrl();
        goto L111
    L141:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L143:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L145:
        if (r128 == null) goto L152;
        r128.c(ChainPoint.PARSE_SCHEMA_END, null);
        return false;
    L152:
        return false;
    L97:
        r75 = 0.5f;
    L93:
        r28 = CollectionsKt.emptyList();
        goto L94
    L148:
        r27 = r8.optString("coupon_tags", "");     // Catch: Exception -> L93
    L86:
        r26 = 73;
    L80:
        r23 = null;
        goto L81
    L74:
        r20 = null;
        goto L75
    L70:
        r19 = null;
        goto L71
    L66:
        r124 = null;
        goto L68
    L62:
        r54 = null;
    L58:
        r48 = "";
    L51:
        r113 = "";
    L45:
        r32 = "";
        goto L46
    L39:
        r15 = null;
    L35:
        r14 = 0;
    L27:
        r11 = 0;
        goto L29
    L19:
        r8 = null;
        goto L21
    L13:
        r5 = null;
        goto L14
    L10:
        r3 = null;
        goto L11
    }

    @Override // sc3.i
    public final boolean o(FragmentManager r17, IOrderSchema r18, int r19, int r20, String r21) {
        Intrinsics.checkNotNullParameter(r17, "fragmentManager");
        Intrinsics.checkNotNullParameter(r18, "orderSchema");
        if (ECAppInfoService.e.i() == false) goto L7;
        cl.d r4 = k.a();
        if (r4 == null) goto L7;
        r4.b();
    L7:
        Intrinsics.checkNotNullParameter(r17, "fragmentManager");
        Intrinsics.checkNotNullParameter(r18, "orderSchema");
        int r1 = ECSdk.a;
        IEShoppingService r2 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        String r3 = null;
        if (r2 == null) goto L10;
        sc3.c r5 = r2.getBuyNowService();
    L11:
        if (r5 == null) goto L13;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r6 = r5.o();
    L14:
        if (r6 == null) goto L16;
        r6.c(ChainPoint.PARSE_SCHEMA_START, null);
    L16:
        f r7 = r18.i1();
        if (r7 == null) goto L33;
        UltimateBuyOrderExParams r8 = UltimateBuyOrderSchemaParser.b(r18);
        j r14 = new j(r18, r7);
        List<Integer> r0 = g.a;
        if (g.a(r19, r14.d, r14.c) == false) goto L31;
        SkuParams r9 = r14.h;
        Map<String, mh3.a> r10 = mh3.a.m;
        SkuAbilityType r11 = SkuAbilityType.BUYNOW;
        mh3.a.C0219a.a(r11, r9, true);
        new com.bytedance.android.shopping.sku.common.controller.d(r11, r9, true).a();
        Map<String, Object> r12 = r14.a();
        if (r6 == null) goto L24;
        r6.c(ChainPoint.PARSE_SCHEMA_END, null);
    L24:
        IEShoppingService r13 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r13 == null) goto L29;
        sc3.c r15 = r13.getBuyNowService();
        if (r15 == null) goto L29;
        UltimateBuyParams r16 = new UltimateBuyParams(r8, r12, r19, r20, r14.h, null, 32, null);
        SkuParams r22 = r14.h;
        Lazy r23 = SkuBuyNowPanelHeightHelper.a;
        r3 = sc3.c.a.a(r15, null, r17, r16, new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(String.valueOf(r22.getSceneType()), r22.getHeightPercent()), Float.valueOf(r14.h.getMaskAlpha())), r21, null, null, null, null, 513);
    L29:
        if (r3 == null) goto L33;
        return true;
    L31:
        if (r6 == null) goto L33;
        r6.c(ChainPoint.PARSE_SCHEMA_END, null);
    L33:
        return false;
    L13:
        r6 = null;
        goto L14
    L10:
        r5 = null;
        goto L11
    }

    @Override // sc3.i
    public final com.bytedance.android.shopping.sku.inner.ultimate.c k(FragmentManager r24, SkuParams r25, l r26, Object r27, Function1 r28, Function1 r29, Function1 r30, int r31) {
        Intrinsics.checkNotNullParameter(r25, "skuParams");
        if (ECAppInfoService.e.i() == false) goto L7;
        cl.d r2 = k.a();
        if (r2 == null) goto L7;
        r2.b();
    L7:
        Intrinsics.checkNotNullParameter(r25, "skuParams");
        int r1 = ECSdk.a;
        IEShoppingService r3 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        String r10 = null;
        if (r3 == null) goto L10;
        sc3.c r4 = r3.getBuyNowService();
    L11:
        if (r4 == null) goto L13;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r5 = r4.o();
    L15:
        if (com.bytedance.android.shopping.sku.inner.ultimate.a.a(r25) == false) goto L17;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r11 = null;
    L18:
        if (r11 == null) goto L20;
        r11.c(ChainPoint.SKU_PARAM_START, null);
    L20:
        Map<String, mh3.a> r6 = mh3.a.m;
        SkuAbilityType r7 = SkuAbilityType.BUYNOW;
        mh3.a.C0219a.a(r7, r25, false);
        new com.bytedance.android.shopping.sku.common.controller.d(r7, r25, false).a();
        Map<String, Object> r8 = new com.bytedance.android.shopping.sku.inner.ultimate.i(r25, false).a();
        if ((r26 instanceof com.bytedance.android.btm.api.model.d) == false) goto L24;
        String r0 = BtmSDK.INSTANCE.createJumpSourceBtmToken((com.bytedance.android.btm.api.model.d) r26);
        String r9 = "BtmModel";
    L26:
        String r15 = r0;
    L28:
        if (r15 != null) goto L34;
        mh3.a r12 = mh3.a.C0219a.c(r25.getMonitorId());
        if (r12 == null) goto L34;
        com.bytedance.android.shopping.sku.common.monitor.error.a r13 = r12.c;
        if (r13 == null) goto L34;
        r13.a(SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR, "sourceBtmToken is null btmModelTag:".concat(r9), null);
    L34:
        UltimateBuyParams r14 = new UltimateBuyParams(null, r8, r31, 0, r25, null, 32, null);
        if (r11 == null) goto L38;
        r11.c(ChainPoint.SKU_PARAM_END, null);
    L38:
        if (com.bytedance.android.shopping.sku.inner.ultimate.a.a(r25) == false) goto L47;
        IEShoppingService r16 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r16 == null) goto L44;
        sc3.c r17 = r16.getBuyNowService();
        if (r17 == null) goto L44;
        Lazy r18 = SkuBuyNowPanelHeightHelper.a;
        r10 = r17.h(null, r14, new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(String.valueOf(r25.getSceneType()), r25.getHeightPercent()), Float.valueOf(ul.g.a(r25.getMaskAlpha()))), r15);
    L44:
        if (r10 != null) goto L46;
        r10 = "";
    L46:
        com.bytedance.android.shopping.sku.inner.ultimate.a.b(r25, r10);
    L53:
        return new com.bytedance.android.shopping.sku.inner.ultimate.c();
    L47:
        IEShoppingService r19 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r19 == null) goto L53;
        sc3.c r110 = r19.getBuyNowService();
        if (r110 == null) goto L53;
        Lazy r20 = SkuBuyNowPanelHeightHelper.a;
        sc3.c.a.a(r110, null, r24, r14, new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(String.valueOf(r25.getSceneType()), r25.getHeightPercent()), Float.valueOf(ul.g.a(r25.getMaskAlpha()))), r15, r27, r28, r29, r30, 513);
        goto L53
    L24:
        if ((r26 instanceof q) == false) goto L27;
        r0 = ((q) r26).a;
        r9 = "TokenModel";
        goto L26
    L27:
        r9 = "null";
        r15 = null;
        goto L28
    L17:
        r11 = r5;
        goto L18
    L13:
        r5 = null;
        goto L15
    L10:
        r4 = null;
        goto L11
    }

    @Override // sc3.i
    public final d i(FragmentManager r16, SkuParams r17, l r18, Object r19, Function2 r20, Function1 r21, Function1 r22, Function1 r23, Function1 r24, Function1 r25, ul.i r26, Function0 r27, Context r28) {
        Intrinsics.checkNotNullParameter(r17, "skuParams");
        e r0 = new e(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        if (r0.a == null) goto L27;
        Lazy r1 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L8;
        TrackCatcher.a("sku");
    L8:
        Map<String, mh3.a> r2 = mh3.a.m;
        SkuAbilityType r3 = SkuAbilityType.SKU;
        mh3.a.C0219a.a(r3, r0.b, false);
        mh3.a r4 = mh3.a.C0219a.c(r0.b.getMonitorId());
        if (r4 != null) goto L11;
    L16:
        new com.bytedance.android.shopping.sku.common.controller.d(r3, r0.b, false).a();
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = null;
        if (Intrinsics.areEqual(r0.b.getCreateNewActivity(), Boolean.TRUE) == false) goto L21;
        Map<String, com.bytedance.android.shopping.sku.inner.container.a> r6 = SkuEmptyContainerActivity.k;
        Activity r7 = ECAppInfoService.e.getCurrentActivity();
        c r8 = new c(r0, r5);
        Intrinsics.checkNotNullParameter(r8, "activityCallback");
        String r9 = UUID.randomUUID().toString();
        SkuEmptyContainerActivity.k.put(r9, r8);
        if (r7 == null) goto L26;
        Intent r10 = new Intent(r7, SkuEmptyContainerActivity.class);
        Bundle r11 = new Bundle();
        r11.putString("key_activity_callback_id", r9);
        Unit r12 = Unit.INSTANCE;
        r10.putExtras(r11);
        r7.startActivity(r10);
    L26:
        return new d();
    L21:
        nj.d r13 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r13 == null) goto L24;
        r13.l();
    L24:
        r5.element = r0.a(r0.a);
        goto L26
    L11:
        if (r4.h == null) goto L13;
        SkuYataOpenSkuChain.b();
    L13:
        SkuYataPageShowChain r14 = r4.g;
        if (r14 == null) goto L16;
        r14.a();
        goto L16
    L27:
        return null;
    }
}

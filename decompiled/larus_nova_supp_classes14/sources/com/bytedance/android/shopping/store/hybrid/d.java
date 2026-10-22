package com.bytedance.android.shopping.store.hybrid;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.entity.ComponentsWrapper;
import com.bytedance.android.shopping.store.hybrid.entity.ECStoreHybridTabInitialDataResponseVO;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.StoreLynxJsbChecker;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.StorePreviewPerfChecker;
import com.bytedance.android.shopping.store.hybrid.viewmodel.ECStoreHybridTabViewModel;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ ECStoreHybridTabPresenter a;

    public d(ECStoreHybridTabPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r20) {
        ECStoreHybridTabInitialDataResponseVO r0 = (ECStoreHybridTabInitialDataResponseVO) r20;
        if (r0 == null) goto L250;
        ((StoreLynxJsbChecker) this.a.p.getValue()).b = r0.getComponentsWrapper();
        ECStoreHybridTabPresenter r2 = this.a;
        r2.getClass();
        r2.j = r0.getComponentsWrapper();
        Integer r3 = r2.B.getContainerType();
        if (r3 != null) goto L9;
    L15:
        if (r3 != null) goto L18;
    L29:
        r2.k = r0.getRaw();
        final ECStoreHybridTabPresenter r4 = this.a;
        ViewGroup r10 = r4.g;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L32:
        String r1 = r0.getBundleUrl();
        if (r1 != null) goto L35;
        r1 = "";
    L35:
        ti.l r5 = r4.l;
        if (r5 == null) goto L38;
        r5.release();
    L38:
        Map<Long, m> r6 = com.bytedance.android.shopping.store.lifecycle.a.a;
        ECStoreHybridTabViewModel r7 = r4.f;
        if (r7 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        m r8 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r7.getStoreParam().getLifecycleMonitorId()));
        if (r8 == null) goto L44;
        r8.e(r4.B);
    L44:
        int r9 = ECSdk.a;
        s83.g r11 = (s83.g) ECSdk.a(s83.g.class);
        if (r11 == null) goto L47;
        r11.g();
    L47:
        boolean r12 = false;
        if (r4.n0() == false) goto L54;
        Pair[] r13 = new Pair[4];
        r13[0] = TuplesKt.to("components", r4.i);
        r13[1] = TuplesKt.to("metaInfo", (JSONObject) r4.r.getValue());
        r13[2] = TuplesKt.to("rawData", r4.k);
        ComponentsWrapper r14 = r4.j;
        if (r14 == null) goto L52;
        JSONObject r15 = r14.blockJSONObject();
    L53:
        r13[3] = TuplesKt.to("block", r15);
        Map<String, Object> r16 = MapsKt.mapOf(r13);
    L55:
        final Map<String, Object> r17 = r16;
        if (r4.n0() == false) goto L58;
        ti.k r18 = (ti.k) r4.t.getValue();
    L59:
        ti.k r19 = r18;
        if (ECAppInfoService.e.isLocalTest() == false) goto L74;
        int r21 = r4.B.getTabType();
        ECStoreViewModel r22 = r4.C;
        if (r22 == null) goto L66;
        ECStoreParam r23 = r22.getStoreParam();
        if (r23 == null) goto L66;
        Integer r24 = r23.getTabId();
    L67:
        if (r24 == null) goto L74;
        if (r21 != r24.intValue()) goto L74;
        if (a2.b(r4.C.getStoreParam().getDebugUrl()) == false) goto L74;
        r1 = r4.C.getStoreParam().getDebugUrl();
        Intrinsics.checkNotNull(r1);
    L66:
        r24 = null;
    L74:
        String r25 = r1;
        ECStoreViewModel r26 = r4.C;
        if (r26 == null) goto L81;
        ECStoreParam r27 = r26.getStoreParam();
        if (r27 == null) goto L81;
        String r28 = r27.getSecShopId();
        if (r28 == null) goto L81;
        final String r29 = a2.d(r28);
    L83:
        if (r4.n0() == true) goto L85;
    L107:
        Integer r30 = r4.B.getContainerType();
        if (r30 != null) goto L111;
    L113:
        boolean r31 = false;
    L114:
        if (r31 == true) goto L233;
    L160:
        String r32 = r25;
    L161:
        Context r33 = r4.Y().c();
        if (r4.n0() == false) goto L164;
        ECLiveHybridUtil.HybridType r34 = ECLiveHybridUtil.HybridType.LYNX;
    L165:
        ECLiveHybridUtil.HybridType r110 = r34;
        Context r35 = r4.Y().c();
        if ((r35 instanceof FragmentActivity) == true) goto L168;
        r35 = null;
    L168:
        FragmentActivity r36 = (FragmentActivity) r35;
        if (r36 == null) goto L171;
        Lifecycle r111 = r36.getLifecycle();
    L172:
        ti.l r37 = ECLiveHybridUtil.b(r33, r32, r17, r10, r19, r110, r111, true, ((QFragmentPresenter) r4).e, new ECStoreHybridTabPresenter$createComponent$1(r4, r29), false, 2048);
        r4.l = r37;
        boolean r38 = ECServiceManager.a;
        IAdapterService r39 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r39 == null) goto L179;
        pd.e r40 = r39.getIExternaHybridService();
        if (r40 == null) goto L179;
        pd.f r41 = r40.getExternalJsBridgeMethodInjectorAdapter();
        if (r41 == null) goto L179;
        com.bytedance.android.ec.adapter.impl.adapters.browser.c r42 = r41.d(new ECStoreHybridTabPresenter$registerJsbSaveData$method$1());
    L180:
        if (r37 == null) goto L182;
        r37.registerMethod("ecom.shop.handle_native_for_remote_data", new i(r42));
    L182:
        ti.l r43 = r4.l;
        IAdapterService r44 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r44 == null) goto L189;
        pd.e r45 = r44.getIExternaHybridService();
        if (r45 == null) goto L189;
        pd.f r46 = r45.getExternalJsBridgeMethodInjectorAdapter();
        if (r46 == null) goto L189;
        com.bytedance.android.ec.adapter.impl.adapters.browser.c r47 = r46.d(new ECStoreHybridTabPresenter$registerJsbDataCallback$method$1(r17));
    L190:
        if (r43 == null) goto L192;
        r43.registerMethod("ecShopGetComponentsData", new g(r47));
    L192:
        ti.l r48 = r4.l;
        IAdapterService r49 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r49 == null) goto L199;
        pd.e r50 = r49.getIExternaHybridService();
        if (r50 == null) goto L199;
        pd.f r51 = r50.getExternalJsBridgeMethodInjectorAdapter();
        if (r51 == null) goto L199;
        com.bytedance.android.ec.adapter.impl.adapters.browser.c r52 = r51.d(new ECStoreHybridTabPresenter$registerJsbPerfTabShow$method$1(r4));
    L200:
        if (r48 == null) goto L202;
        r48.registerMethod("ecShopPerfTabPageFinish", new h(r52));
    L202:
        ti.l r53 = r4.l;
        IAdapterService r54 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r54 == null) goto L209;
        pd.e r55 = r54.getIExternaHybridService();
        if (r55 == null) goto L209;
        pd.f r56 = r55.getExternalJsBridgeMethodInjectorAdapter();
        if (r56 == null) goto L209;
        com.bytedance.android.ec.adapter.impl.adapters.browser.c r57 = r56.d(new ECStoreHybridTabPresenter$registerJsbBizEvent$method$1(r4));
    L210:
        if (r53 == null) goto L212;
        r53.registerMethod("ec_shop_biz_event", new f(r57));
    L212:
        ti.l r58 = r4.l;
        if (r58 == null) goto L215;
        r58.registerMethod("ecom.shop.get_preview_status", new ECStoreHybridTabPresenter$registerLiveStatusJsb$1(r4));
    L215:
        ti.l r59 = r4.l;
        if (r59 == null) goto L218;
        r59.registerMethod("ecom.shop.open", new ECStoreHybridTabPresenter$registerShopOpenJsb$1(r4));
    L218:
        ti.l r60 = r4.l;
        if (r60 == null) goto L225;
        Iterator<Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>>> r61 = r4.w.entrySet().iterator();
    L223:
        if (r61.hasNext() == false) goto L225;
        Map.Entry<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> r62 = r61.next();
        r60.registerMethod(r62.getKey(), r62.getValue());
    L225:
        ECStoreViewModel r63 = r4.C;
        if (r63 == null) goto L247;
        ECStoreParam r64 = r63.getStoreParam();
        if (r64 != null) goto L230;
        return;
    L230:
        if (r64.isPreview() != true) goto L249;
        StorePreviewPerfChecker r65 = new StorePreviewPerfChecker(r4.C.getStoreParam().getSecShopId(), r4.l, String.valueOf(r4.B.getTabType()));
        r4.q = r65;
        r65.b(r4.C.getStoreParam());
        return;
    L249:
        return;
    L247:
        return;
    L209:
        r57 = null;
    L199:
        r52 = null;
    L189:
        r47 = null;
    L179:
        r42 = null;
        goto L180
    L171:
        r111 = null;
        goto L172
    L164:
        r34 = ECLiveHybridUtil.HybridType.WEB;
        goto L165
    L233:
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L117
        Object r67 = Result.constructor-impl(UriProtector.parse(r25).buildUpon().appendQueryParameter("disable_host_jsb_method", CommentScene.COMMENTSCENE_NO_AWEME).toString());     // Catch: Throwable -> L117
    L120:
        if (Result.isFailure-impl(r67) == false) goto L122;
        r67 = null;
    L122:
        String r68 = (String) r67;
        if (r68 == null) goto L126;
        r25 = r68;
    L126:
        int r69 = cj3.a.a;
        int r70 = r4.B.getTabType();
        Intrinsics.checkNotNullParameter(r25, "url");
        int r71 = p.a;
        Object r72 = new HashMap();
        jj4.b r112 = jj4.b.b;     // Catch: Throwable -> L131
        Object r73 = jj4.a.a("ec_shop_sec_link_config", HashMap.class, r72, false);     // Catch: Throwable -> L131
        if (r73 != null) goto L137;
        Intrinsics.throwNpe();     // Catch: Throwable -> L131
    L137:
        Object r74 = ((HashMap) r73).get(String.valueOf(r70));
        if ((r74 instanceof String) == true) goto L140;
        r74 = null;
    L140:
        String r75 = (String) r74;
        if (r75 != null) goto L143;
    L146:
        boolean r76 = true;
    L147:
        if (r76 == true) goto L160;
        int r77 = p0.a;     // Catch: Throwable -> L151
        Object r78 = Result.constructor-impl(p0.f(UriProtector.parse(r25), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_out_url", "is_from_out_scene"), TuplesKt.to("is_out_scene", r75)})).toString());     // Catch: Throwable -> L151
    L154:
        if (Result.isFailure-impl(r78) == false) goto L156;
        r78 = null;
    L156:
        String r79 = (String) r78;
        if (r79 == null) goto L160;
    L159:
        r32 = r79;
    L151:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r78 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L154
    L143:
        if (StringsKt.isBlank(r75) == true) goto L146;
        r76 = false;
    L131:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Object r81 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r81) == true) goto L136;
        r72 = r81;
    L136:
        r73 = r72;
    L117:
        th = move-exception;
        Result.Companion r82 = Result.Companion;
        r67 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L120
    L111:
        if (r30.intValue() != 3) goto L113;
        r31 = true;
        goto L114
    L85:
        if (((Boolean) ImageSettings.h.getValue()).booleanValue() == false) goto L107;
        Result.Companion r83 = Result.Companion;     // Catch: Throwable -> L99
        if (r29 == null) goto L89;
        int r84 = t0.a;     // Catch: Throwable -> L99
        String r85 = t0.a.a.toJson(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sec_shop_id", r29)}));     // Catch: Throwable -> L99
    L90:
        Uri.Builder r86 = UriProtector.parse(r25).buildUpon().appendQueryParameter("use_ecom_image", CommentScene.COMMENTSCENE_NO_AWEME).appendQueryParameter("biz_tag", "ec_shop").appendQueryParameter("scene_tag", "ec_shop.store_lynx_tab.tab_type_" + r4.B.getTabType());     // Catch: Throwable -> L99
        if (r85 != null) goto L93;
    L94:
        r12 = true;
    L95:
        if (r12 == true) goto L97;
        r86.appendQueryParameter("ecom_image_log_extra", r85);     // Catch: Throwable -> L99
    L97:
        Object r87 = Result.constructor-impl(r86.toString());     // Catch: Throwable -> L99
    L102:
        if (Result.isFailure-impl(r87) == false) goto L104;
        r87 = null;
    L104:
        r79 = (String) r87;
        if (r79 != null) goto L159;
    L93:
        if (StringsKt.isBlank(r85) == false) goto L95;
    L89:
        r85 = null;
    L99:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        r87 = Result.constructor-impl(ResultKt.createFailure(th));
    L81:
        r29 = null;
        goto L83
    L58:
        r18 = (ti.k) r4.v.getValue();
        goto L59
    L52:
        r15 = null;
        goto L53
    L54:
        r16 = r4.q0();
        goto L55
    L18:
        if (r3.intValue() != 2) goto L29;
        r2.i = new JSONArray();
        ComponentsWrapper r89 = r0.getComponentsWrapper();
        if (r89 == null) goto L29;
        List<HashMap<String, Object>> r90 = r89.getComponents();
        if (r90 == null) goto L29;
        Iterator<T> r91 = r90.iterator();
    L25:
        if (r91.hasNext() == false) goto L29;
        HashMap r92 = (HashMap) r91.next();
        JSONArray r93 = r2.i;
        if (r93 == null) goto L25;
        r93.put(new JSONObject(r92));
        goto L25
    L9:
        if (r3.intValue() != 3) goto L15;
        ComponentsWrapper r94 = r0.getComponentsWrapper();
        if (r94 == null) goto L13;
        List<HashMap<String, Object>> r95 = r94.getComponents();
    L14:
        r2.h = r95;
        goto L29
    L13:
        r95 = null;
        goto L14
    }
}

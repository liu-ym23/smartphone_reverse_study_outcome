package com.bytedance.locallife.pdp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.pendant.LifeGoldPendantManager;
import com.bytedance.locallife.biz.pendant.datacenter.PendantViewModel;
import com.bytedance.locallife.pdp.biz.common.cache.DefaultCacheManager;
import com.bytedance.locallife.pdp.container.GoodsDetailFragmentInstanceUtil;
import com.bytedance.locallife.pdp.view.GoodsDetailDialogFragment;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.poi.bean.DetailEnterPage;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import com.ss.android.ugc.aweme.poi.listener.IPoiTradeGoodsDialogCloseListener;
import com.ss.android.ugc.aweme.poi.listener.OnLifePanelShowHeightChangeListener;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ww6.j;

/* JADX INFO: loaded from: classes21.dex */
public class e implements d {
    @Override // com.bytedance.locallife.pdp.d
    public void a(xu6.d r100) {
    }

    public e() {
    }

    @Override // com.bytedance.locallife.pdp.d
    public final void e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ww6.c.f561630a.a(null).a30().f(r100);
        int r101 = DefaultCacheManager.f261013a;
        com.bytedance.locallife.pdp.biz.common.cache.e.f261021b.clear();
        com.bytedance.locallife.pdp.biz.common.cache.e.f261020a.clear();
    }

    @Override // com.bytedance.locallife.pdp.d
    public final boolean c(PoiBizCode r100, DetailEnterPage r101) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "detailEnterPage");
        return DefaultCacheManager.a(r100, r101);
    }

    @Override // com.bytedance.locallife.pdp.d
    public final void d(Activity r100, DetailEnterPage r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ww6.c.f561630a.a(null).a30().h(r100, r101);
    }

    @Override // com.bytedance.locallife.pdp.d
    public final boolean b(PoiBizCode r100, String r101, DetailEnterPage r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "activityId");
        Intrinsics.checkNotNullParameter(r102, "detailEnterPage");
        Intrinsics.checkNotNullParameter(r103, "params");
        int r104 = DefaultCacheManager.f261013a;
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "activityId");
        Intrinsics.checkNotNullParameter(r102, "detailEnterPage");
        Intrinsics.checkNotNullParameter(r103, "params");
        j r105 = ww6.c.f561630a.a(r100.bizCode).Kt();
        if (DefaultCacheManager.a(r100, r102) == true) goto L6;
    L8:
        return false;
    L6:
        if (r105.e(r101, r102, r103) == null) goto L8;
        return true;
    }

    @Override // com.bytedance.locallife.pdp.d
    public final void g(PoiBizCode r100, String r101, DetailEnterPage r102, Map<String, String> r103, boolean r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "activityId");
        Intrinsics.checkNotNullParameter(r102, "detailEnterPage");
        Intrinsics.checkNotNullParameter(r103, "params");
        DefaultCacheManager.b(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.locallife.pdp.d
    public final GoodsDetailDialogFragment h(Uri r110, Long r111, Object r112, String r210, Object r211, String r212) {
        Uri r100 = r110;
        String r101 = "";
        LifeGoldPendantManager.f256767a.getClass();
        boolean r102 = false;
        String r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L30
        if (r100 == null) goto L7;
        String r105 = UriProtector.getQueryParameter(r100, "growth_biz_data");     // Catch: Throwable -> L30
        if (r105 == null) goto L7;
    L8:
        if (r100 == null) goto L11;
        String r106 = UriProtector.getQueryParameter(r100, "card_id");     // Catch: Throwable -> L30
        if (r106 == null) goto L11;
    L12:
        if (r100 == null) goto L15;
        String r107 = UriProtector.getQueryParameter(r100, SimilarProductParam.AWEME_ID);     // Catch: Throwable -> L30
        if (r107 == null) goto L15;
    L17:
        if (Intrinsics.areEqual(((bo6.b) com.bytedance.locallife.common.utils.d.a(r105, bo6.b.class)).a(), "life_lite_golden_widget") == true) goto L19;
    L28:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        boolean r108 = false;
    L34:
        if (r108 == false) goto L43;
        LifeGoldPendantManager.f256767a.getClass();
        if (r100 == null) goto L38;
        Uri r109 = w36.a.b(r100, "show_growth_coin_pendant");
    L39:
        if (r109 == null) goto L41;
        Uri r113 = w36.a.b(r109, "growth_biz_data");
    L42:
        r100 = r113;
    L133:
        com.bytedance.locallife.pdp.container.c<GoodsDetailDialogFragment> r114 = GoodsDetailFragmentInstanceUtil.f261106a;
        if ((r211 instanceof OnLifePanelShowHeightChangeListener) == false) goto L136;
        OnLifePanelShowHeightChangeListener r115 = (OnLifePanelShowHeightChangeListener) r211;
    L137:
        Object r116 = GoodsDetailFragmentInstanceUtil.f261106a.f261135c.invoke();
        GoodsDetailDialogFragment r117 = (GoodsDetailDialogFragment) r116;
        Bundle r118 = new Bundle();
        if (r100 == null) goto L140;
        r103 = r100.toString();
    L140:
        r118.putString("router_uri", r103);
        if (r111 == null) goto L143;
        long r119 = r111.longValue();
    L144:
        r118.putLong("launch_timestamps", r119);
        r118.putString("dito_trace_session_id", r210);
        r118.putString("extra_json_str", r212);
        r117.setArguments(r118);
        r117.f261757f = true;
        r117.f261758g = r112;
        r117.f261774w = r115;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type T of com.bytedance.locallife.pdp.container.GoodsDetailFragmentInstanceUtil.newInstance");
        return r117;
    L143:
        r119 = SystemClock.elapsedRealtime();
        goto L144
    L136:
        r115 = null;
        goto L137
    L41:
        r113 = null;
        goto L42
    L38:
        r109 = null;
        goto L39
    L43:
        PendantViewModel r120 = com.bytedance.locallife.biz.pendant.c.f256775a;
        if (r100 == null) goto L47;
        String r121 = UriProtector.getQueryParameter(r100, "show_growth_coin_pendant");
        if (r121 == null) goto L47;
    L48:
        if (r100 == null) goto L51;
        String r122 = UriProtector.getQueryParameter(r100, "growth_biz_data");
        if (r122 == null) goto L51;
    L53:
        if (ap6.a.b(r121) == true) goto L55;
    L57:
        boolean r123 = false;
    L58:
        String r124 = "0";
        if (ap6.a.b(r121) == false) goto L61;
    L62:
        int r125 = com.bytedance.locallife.biz.mob.a.f256703c;
        LinkedHashMap r126 = new LinkedHashMap();
        if (r123 == false) goto L65;
        r126.put("status", "0");
    L73:
        if (r100 == null) goto L76;
        String r127 = r110.toString();
        if (r127 == null) goto L76;
    L77:
        r126.put("schema", r127);
        Unit r128 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("life_pendant_first_check_tech", r126);
    L78:
        if (r123 == false) goto L133;
        if (r100 != null) goto L147;
    L82:
        String r129 = "";
    L83:
        Lazy<bo6.e> r130 = PendantViewModel.f256781i;     // Catch: Throwable -> L104
        if (PendantViewModel.a.a() == false) goto L110;
        if (r100 == null) goto L87;
        String r131 = UriProtector.getQueryParameter(r100, "show_growth_coin_pendant");     // Catch: Throwable -> L104
    L88:
        if (r131 != null) goto L90;
        r131 = "";
    L90:
        com.bytedance.locallife.biz.pendant.c.f256780f = r131;     // Catch: Throwable -> L104
        if (r100 == null) goto L94;
        String r132 = UriProtector.getQueryParameter(r100, "growth_biz_data");     // Catch: Throwable -> L104
        if (r132 == null) goto L94;
    L95:
        if (r100 == null) goto L97;
        Uri r133 = w36.a.b(r100, "show_growth_coin_pendant");     // Catch: Throwable -> L104
    L98:
        if (r133 == null) goto L100;
        r100 = w36.a.b(r133, "growth_biz_data");     // Catch: Throwable -> L104
    L102:
        if (com.bytedance.locallife.biz.pendant.c.f256776b == null) goto L106;
        com.bytedance.locallife.biz.pendant.c.c();     // Catch: Throwable -> L104
    L106:
        com.bytedance.locallife.biz.pendant.c.f256778d = true;     // Catch: Throwable -> L104
        com.bytedance.locallife.biz.pendant.c.f256779e = false;     // Catch: Throwable -> L104
        com.bytedance.locallife.biz.pendant.c.b(r132, r129, com.bytedance.locallife.biz.pendant.c.f256780f);     // Catch: Throwable -> L104
        if (com.bytedance.locallife.biz.pendant.c.f256776b != null) goto L109;
        com.bytedance.locallife.biz.pendant.c.f256776b = new com.bytedance.locallife.biz.pendant.lifecycle.a(new com.bytedance.locallife.biz.pendant.b());     // Catch: Throwable -> L104
    L109:
        com.bytedance.locallife.biz.pendant.c.d(r100);     // Catch: Throwable -> L104
        goto L110
    L100:
        r100 = null;
        goto L102
    L97:
        r133 = null;
    L94:
        r132 = "";
        goto L95
    L87:
        r131 = null;
    L110:
        int r134 = com.bytedance.locallife.biz.mob.a.f256703c;     // Catch: Throwable -> L104
        LinkedHashMap r135 = new LinkedHashMap();     // Catch: Throwable -> L104
        if (PendantViewModel.a.a() == false) goto L120;
        PendantViewModel r136 = com.bytedance.locallife.biz.pendant.c.f256775a;     // Catch: Throwable -> L104
        if (r136 != null) goto L115;
    L117:
        if (r102 == false) goto L120;
    L123:
        r135.put("status", r124);     // Catch: Throwable -> L104
        r135.put("schema", r129);     // Catch: Throwable -> L104
        Unit r137 = Unit.INSTANCE;     // Catch: Throwable -> L104
        com.bytedance.locallife.biz.mob.a.C3646a.c("life_pendant_init_tech", r135);     // Catch: Throwable -> L104
        Object r138 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L104
    L126:
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L133;
        qs6.b r140 = HostServiceUtilsKt.k();
        String r141 = r139.getMessage();
        if (r141 == null) goto L132;
        r101 = r141;
    L132:
        r140.e("LifePendantManager", "start:".concat(r101));
    L104:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L126
    L115:
        if ((!((ArrayList) r136.f256783b).isEmpty()) != true) goto L117;
        r102 = true;
    L120:
        if (PendantViewModel.a.a() == false) goto L122;
        r124 = "1";
        goto L123
    L122:
        r124 = "2";
        goto L123
    L147:
        r129 = r110.toString();     // Catch: Throwable -> L104
        if (r129 != null) goto L83;
    L76:
        r127 = "";
        goto L77
    L65:
        r126.put("status", "1");
        if (r121.length() != 0) goto L68;
        boolean r143 = true;
    L69:
        if (r143 == false) goto L71;
        Object r144 = "show_growth_coin_pendant";
    L72:
        r126.put(SocialConstants.PARAM_APP_DESC, r144);
        goto L73
    L71:
        r144 = "growth_biz_data";
        goto L72
    L68:
        r143 = false;
        goto L69
    L61:
        if (ap6.a.b(r122) == false) goto L78;
    L55:
        if (ap6.a.b(r122) == false) goto L57;
        r123 = true;
    L51:
        r122 = "";
    L47:
        r121 = "";
        goto L48
    L19:
        if (((Boolean) LifeGoldPendantManager.f256774h.getValue()).booleanValue() == false) goto L28;
        LifeGoldPendantManager.f256769c = r106;     // Catch: Throwable -> L30
        LifeGoldPendantManager.f256770d = r107;     // Catch: Throwable -> L30
        if (r100 == null) goto L23;
        String r145 = UriProtector.getQueryParameter(r100, "life_pendant_track_params");     // Catch: Throwable -> L30
    L24:
        Type r146 = new com.bytedance.locallife.biz.pendant.a().getType();     // Catch: Throwable -> L30
        if (r145 != null) goto L27;
        r145 = "";
    L27:
        LifeGoldPendantManager.f256768b = (HashMap) GsonProtectorUtils.fromJson(com.bytedance.locallife.common.utils.d.b(), r145, r146);     // Catch: Throwable -> L30
        r108 = true;
        goto L34
    L23:
        r145 = null;
    L15:
        r107 = "";
    L11:
        r106 = "";
    L7:
        r105 = "";
    L30:
        th = move-exception;
        Result.Companion r147 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    }

    @Override // com.bytedance.locallife.pdp.d
    public final boolean f(Context r110, Uri r111, Long r112, Object r113, String r114, Object r115, Object r116) {
        if (r110 != null) goto L5;
        return false;
    L5:
        if (r111 == null) goto L7;
        String r100 = UriProtector.getQueryParameter(r111, "popup");
    L9:
        if (r100 != null) goto L11;
    L14:
        boolean r101 = true;
    L15:
        if (r101 == false) goto L17;
    L31:
        return false;
    L17:
        if (Intrinsics.areEqual(r100, "0") == true) goto L31;
        if ((r110 instanceof FragmentActivity) == false) goto L31;
        FragmentActivity r117 = (FragmentActivity) r110;
        Fragment r102 = d.a.a(this, r111, r112, r113, r114, r115, null, 32);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.locallife.pdp.view.GoodsDetailDialogFragment");
        GoodsDetailDialogFragment r103 = (GoodsDetailDialogFragment) r102;
        if ((r116 instanceof IPoiTradeGoodsDialogCloseListener) == false) goto L24;
        r103.f261773v = (IPoiTradeGoodsDialogCloseListener) r116;
    L24:
        FragmentManager r104 = r117.getSupportFragmentManager();
        if (r104.isStateSaved() == true) goto L31;
        if (r104.isDestroyed() == true) goto L31;
        com.bytedance.locallife.pdp.container.c<GoodsDetailDialogFragment> r105 = GoodsDetailFragmentInstanceUtil.f261106a;
        r103.show(r104, GoodsDetailFragmentInstanceUtil.f261106a.f261134b);
        return true;
    L11:
        if (r100.length() == 0) goto L14;
        r101 = false;
        goto L15
    L7:
        r100 = null;
        goto L9
    }
}

package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.SearchItemTrackParams;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopNavigationComponentV1$initView$5 implements com.bytedance.android.shopping.anchorv3.widget.e {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public final void c() {
        CommonMeta r0 = this.a.O1().d().getData().a().a();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Unit r2 = null;
        if (r0 == null) goto L10;
        SearchItemTrackParams r3 = r0.getSearchItemTrackParams();     // Catch: Throwable -> L12
        if (r3 == null) goto L10;
        Map r4 = r3.getShowSearch();     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SimilarProductParam.ENTER_FROM, "search_product_detail"), TuplesKt.to("btm_id", "a1.b8094.c9263.d4884")});     // Catch: Throwable -> L12
        r5.putAll(r4);     // Catch: Throwable -> L12
        this.a.Z1(vg3.w.class, new TopNavigationComponentV1$initView$5$logShow$1$1$1(r5, null));     // Catch: Throwable -> L12
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r2);     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L20;
        ECExceptionMonitor.e(r7);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public TopNavigationComponentV1$initView$5(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    public final void b(String r6) {
        CommonMeta r0 = this.a.O1().d().getData().a().a();
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("btm_id", r6), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail")});
        String r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        SearchItemTrackParams r3 = r0.getSearchItemTrackParams();     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        Map r4 = r3.getClickSearchBar();     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        r7.putAll(r4);     // Catch: Throwable -> L13
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r8 = Result.constructor-impl(r5);     // Catch: Throwable -> L13
    L15:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        ECExceptionMonitor.e(r9);
    L18:
        this.a.Z1(vg3.w.class, new TopNavigationComponentV1$initView$5$logClick$1(r7, null));
        if (r0 == null) goto L25;
        String r10 = r0.getEntranceInfo();
        if (r10 == null) goto L25;
        JSONObject r11 = com.bytedance.android.shopping.extensions.k.w(r10);
        if (r11 == null) goto L25;
        r1 = r11.optString("log_extra");
    L25:
        if (r0 == null) goto L32;
        String r12 = h73.a.b(r0);
        if (r12 == null) goto L33;
        s83.g r13 = AdLogUtils.a;
        AdLogUtils.k(r12, h73.a.a(r0), r1);
        return;
    L33:
        return;
    L32:
        return;
    L10:
        r5 = null;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final void a(String r19, com.bytedance.android.shopping.anchorv3.i r20) {
        if (r19 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L38;
        if (r20 == null) goto L39;
        PageMeta r2 = (PageMeta) this.a.O1().d().getData().b.a();
        String r3 = null;
        if (r2 == null) goto L15;
        CommonMeta r4 = r2.getCommonMeta();
    L16:
        if (r2 == null) goto L18;
        LinkedTreeMap r5 = r2.getTrackMeta();
    L19:
        if (r5 == null) goto L22;
        Object r6 = r5.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r6 == null) goto L22;
    L24:
        if (r4 == null) goto L26;
        Boolean r8 = Boolean.valueOf(r4.isLuban());
    L27:
        if (r4 == null) goto L29;
        Boolean r9 = Boolean.valueOf(r4.getThirdParty());
    L30:
        if (r4 == null) goto L32;
        String r10 = r4.getProductId();
    L33:
        Boolean r11 = Boolean.valueOf(true ^ Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.d.a(), Boolean.FALSE));
        StringBuilder r0 = new StringBuilder();
        r0.append(r6.toString());
        r0.append("_");
        if (r4 == null) goto L36;
        r3 = r4.getSourcePage();
    L36:
        r0.append(r3);
        this.a.Z1(vg3.w.class, new TopNavigationComponentV1$initView$5$logSearchWordShow$1(this, r20, new com.bytedance.android.shopping.anchorv3.widget.f(r8, r9, r10, r11, "search_product_detail", "half_screen_recom_search", r0.toString(), null, null, 800), r4, null));
        return;
    L32:
        r10 = null;
        goto L33
    L29:
        r9 = null;
        goto L30
    L26:
        r8 = null;
    L22:
        r6 = "";
        goto L24
    L18:
        r5 = null;
        goto L19
    L15:
        r4 = null;
        goto L16
    L39:
        return;
    L38:
        return;
    L5:
        if (r19.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}

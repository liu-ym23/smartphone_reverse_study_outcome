package com.bytedance.android.livesdk.livecommerce.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionListSearchButton;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements bf.c {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.router.a$a, reason: collision with other inner class name */
    public static final class C0120a {
    }

    static {
    }

    public a() {
    }

    public final void a() {
    }

    public final String b() {
        return "shopping_live_redirect_router";
    }

    public final boolean c(Context r11, Uri r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "uri");
        String r0 = UriProtector.getQueryParameter(r12, "source_btm_token");
        String r1 = UriProtector.getQueryParameter(r12, "url");
        if (r1 == null) goto L39;
        String r3 = l0.a(r1, "source_btm_token", r0);
        if (r3 == null) goto L39;
        int r14 = k.r(UriProtector.getQueryParameter(r12, LocationMonitorConst.TYPE), 0);
        JSONObject r15 = z1.g(UriProtector.getQueryParameter(r12, "extra"));
        if (r14 != RedirectType.SEARCH.getValue()) goto L37;
        Object r16 = null;
        if (r15 == null) goto L12;
        String r2 = r15.optString("room_id");
    L14:
        if (r15 == null) goto L16;
        String r17 = r15.optString("ecom_entrance_form");
    L17:
        if (r17 != null) goto L19;
        r17 = "";
    L19:
        int r4 = RoomContextController.h;
        com.bytedance.android.ec.adapter.api.state.a r5 = RoomContextController.a.b(r2, null).L();
        int r6 = PromotionListSearchButton.b;
        if (r5 == null) goto L22;
        String r7 = r5.g;
    L23:
        if (r5 == null) goto L25;
        String r8 = r5.f;
    L26:
        ECEventUtilsV2.b.getClass();
        JSONObject r9 = ECEventUtilsV2.f(r17, null, null);
        r9.put("ecom_entrance_form", r17);
        Unit r18 = Unit.INSTANCE;
        String r10 = r9.toString();
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L29
        Lazy r110 = Json.a;     // Catch: Throwable -> L29
        Object r111 = Result.constructor-impl(Json.d(new ECUIPromotionLiveListConfig(EComABUtils.shouldShowFindSimilar(), EComABUtils.getSimilarConfig().getTitle(), true, null)));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r111) == true) goto L35;
        r16 = r111;
    L35:
        p.a.openSchema(r11, PromotionListSearchButton.a.a(r3, r7, r8, null, null, r10, (String) r16));
        return true;
    L29:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L25:
        r8 = null;
        goto L26
    L22:
        r7 = null;
        goto L23
    L16:
        r17 = null;
        goto L17
    L12:
        r2 = null;
        goto L14
    L37:
        p.a.openSchema(r11, r3);
        return true;
    L39:
        return false;
    }
}

package com.bytedance.android.livesdk.livecommerce.room;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.l;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.host.api.core.api.IECRouterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static Context a() {
        return ECAppInfoService.e.getApplicationContext();
    }

    public static boolean c(Boolean r1) {
        if (hh2.f.f() == true) goto L5;
        return false;
    L5:
        if (EComABUtils.shouldHideSaasAnchorEntrance() == true) goto L7;
        return false;
    L7:
        if (r1.booleanValue() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static void b(Context r14, String r15) {
        xh.a r0 = xh.c.a("Live");
        String r1 = "open_schema_".concat("");
        xh.b.e r3 = new xh.b.e();
        r3.a(r15);
        Unit r4 = Unit.INSTANCE;
        xh.b r5 = new xh.b();
        JSONObject r6 = null;
        r5.c(null);
        r5.b(r1);
        r5.a(r3);
        r0.f(4, r5);
        boolean r7 = true;
        if (r15.startsWith("sslocal://webcast_lynxview") == false) goto L5;
    L19:
        Bundle r8 = new Bundle();
        if (ECAppInfoService.e.isLocalTest() == false) goto L22;
    L23:
        int r2 = RoomContextController.h;
        r8.putString("vmsdk_contextProvider", com.bytedance.android.ec.adapter.api.state.b.a(RoomContextController.a.a().L()).toString());
        r8.putString("vmsdk_scene", "live");
    L24:
        ECLiveHybridUtil.j(r14, r15, r8, false, false, false, null, null);
        int r9 = com.bytedance.android.ec.core.monitor.j.a;
        Intrinsics.checkNotNullParameter(r15, "orderUrl");
        if (StringsKt.contains$default(r15, "fe_lynx_commerce_buynow", false, 2, null) == true) goto L32;
        if (StringsKt.contains$default(r15, "ecommerce_buynow_aweme", false, 2, null) == true) goto L32;
        if (StringsKt.contains$default(r15, "ecommerce_buynow_huoshan", false, 2, null) == true) goto L32;
    L62:
        Lazy r10 = ECAppInfoService.a;
        if (we.a.a == false) goto L71;
        if (r7 == true) goto L72;
        int r11 = ECSdk.a;
        IECRouterService r12 = (IECRouterService) ECSdk.a(IECRouterService.class);
        Uri r16 = UriProtector.parse(r15);
        if (r12 != null) goto L68;
        return;
    L68:
        if (r12.match(r16, false) == false) goto L74;
        r12.open(r14, r16, false, false);
        return;
    L74:
        return;
    L72:
        return;
    L71:
        return;
    L32:
        if (a2.b(r15) == false) goto L62;
        Uri r13 = UriProtector.parse(r15);
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r13, "is_cart_order"), "1") == true) goto L62;
        String r17 = UriProtector.getQueryParameter(r13, "rifle_mega_object");
        if (r17 == null) goto L40;
        HashMap r18 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        r6 = com.bytedance.android.ec.core.hybrid.utils.j.i(r17);
    L40:
        if (r6 != null) goto L42;
    L43:
        UriProtector.getQueryParameter(r13, "entrance_info");
    L44:
        if (r6 == null) goto L47;
        String r19 = r6.optString("entrance_info");
        if (r19 == null) goto L47;
    L48:
        if (r6 == null) goto L51;
        String r20 = r6.optString("entrance_info");
        if (r20 == null) goto L51;
    L52:
        int r21 = l.a;
        l.a(r15, "", "order_page", CollectionsKt.listOf(new l.a[]{new l.a("id", "presence"), new l.a("entrance_info", "is_json_string"), new l.a("combo_id", "presence"), new l.a("combo_num", "valid_number"), new l.a("origin_type", "presence"), new l.a("origin_id", "presence")}));
        if (a2.b(r19) == false) goto L62;
        if (r20 != null) goto L56;
    L59:
        boolean r22 = true;
    L60:
        if (r22 == false) goto L62;
        com.bytedance.android.ec.core.monitor.d.c(null, "order_page", r15, "dependency_cid_log_extra", "extra", "cid非空时log_extra字段为空", 1);
        goto L62
    L56:
        if (r20.length() == 0) goto L59;
        r22 = false;
    L51:
        r20 = UriProtector.getQueryParameter(r13, "log_extra");
    L47:
        r19 = UriProtector.getQueryParameter(r13, "cid");
        goto L48
    L42:
        if (r6.optString("entrance_info") != null) goto L44;
    L22:
        if (ECSettingKeys.l() == false) goto L24;
    L5:
        if (r15.startsWith("sslocal://webcast_webview") == true) goto L19;
        int r23 = ECSdk.a;
        IAdapterService r24 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r24 != null) goto L10;
        return;
    L10:
        o r25 = (o) ECSdk.a(o.class);
        if (r25 == null) goto L14;
        int r26 = RoomContextController.h;
        r25.b(r14, r15, com.bytedance.android.ec.adapter.api.state.b.a(RoomContextController.a.a().L()).toString());
    L14:
        if (r15.startsWith("sslocal://buy_now/") == false) goto L16;
    L17:
        HashMap r27 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        r15 = com.bytedance.android.ec.core.hybrid.utils.j.b(r15, false, "", false);
    L18:
        r7 = r24.handleSchemaWithLive(r14, UriProtector.parse(r15), true, null);
        goto L62
    L16:
        if (r15.startsWith("sslocal://buy_now?") == false) goto L18;
        goto L17
    }

    public static void d(final String r2, final Map<String, String> r3) {
        hh2.g r0 = hh2.f.a.a;
        if (r0 == null) goto L5;
        String r1 = r0.f();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        r2 = r1 + r2;
    L9:
        Single.fromCallable(new e(r2, r3)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static void e(final String r2, final Map<String, String> r3, final String r4, final PageFinder r5) {
        hh2.g r0 = hh2.f.a.a;
        if (r0 == null) goto L5;
        String r1 = r0.f();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        r2 = r1 + r2;
    L9:
        Single.fromCallable(new d(r2, r3, r4, r5)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static ECAlertDialog f(Context r1, int r2, int r3, int r4, DialogInterface.OnClickListener r5, DialogInterface.OnClickListener r6) {
        ECAlertDialog r0 = new ECAlertDialog(r1);
        if (r2 == 0) goto L5;
        r0.setTitle(th.a.g(r1, r2));
    L5:
        if (r3 == 0) goto L7;
        r0.setMessage(th.a.g(r1, r3));
    L7:
        r0.setDialogCancelable(false);
        r0.setPositiveButton(th.a.g(r1, r4), r5);
        r0.setNegativeButton(th.a.g(r1, 2131896358), r6);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r0);
    L12:
        return r0;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L12
    }
}

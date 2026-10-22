package com.bytedance.android.livesdk.livecommerce.utils;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ShoppingCart;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECEnterRoomJumpLogUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Map r3 = MapsKt.mapOf(TuplesKt.to("schema", r2));
        xh.b r1 = new xh.b();
        r1.c("LiveRoom");
        r1.b("get_jump_schema");
        r1.a(r3);
        xh.c.a("EnterJump").f(4, r1);
        d(r1);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void d(final xh.b r1) {
        com.bytedance.android.ec.sdk.helper.l.a(new ECEnterRoomJumpLogUtils$recordLocalEnterRoomLog$1(r1));
    }

    public static void a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "destination");
        Map r0 = MapsKt.mapOf(TuplesKt.to("destination", r6));
        xh.b r1 = new xh.b();
        r1.c("LiveRoom");
        r1.b("enter_room_jump_success");
        r1.a(r0);
        xh.c.a("EnterJump").f(4, r1);
        d(r1);
        Intrinsics.checkNotNullParameter(r6, "host");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L17;
        int r2 = RoomContextController.h;
        String r3 = null;
        com.bytedance.android.ec.common.api.jump.model.b r4 = RoomContextController.a.b(r5, null).l();
        if (r4 != null) goto L7;
        r4 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        sg2.v r7 = new sg2.v("livesdk_schema_jump_success", r4);
        r7.c("host", r6);
        boolean r8 = EntryController.M1;
        ShoppingCart r9 = EntryController.a.b(r5, null).s;
        if (r9 == null) goto L10;
        View r10 = r9.getViewSafe();
    L11:
        if (r10 == null) goto L13;
        r3 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r10));
    L13:
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r7.j("c9398.d8575", r3);
        return;
    L10:
        r10 = null;
        goto L11
    }

    public static void b(String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Map r6 = MapsKt.mapOf(new Pair[]{TuplesKt.to("path", r3), TuplesKt.to(LocationMonitorConst.IS_SUCCESS, Boolean.valueOf(r4)), TuplesKt.to("message", r5)});
        xh.b r7 = new xh.b();
        r7.c("LiveRoom");
        r7.b("jump_request_result");
        r7.a(r6);
        xh.c.a("EnterJump").f(4, r7);
        d(r7);
    }

    public static void e(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "host");
        Intrinsics.checkNotNullParameter(r7, "failReason");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L17;
        int r2 = RoomContextController.h;
        String r3 = null;
        com.bytedance.android.ec.common.api.jump.model.b r4 = RoomContextController.a.b(r5, null).l();
        if (r4 != null) goto L7;
        r4 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        sg2.v r1 = new sg2.v("livesdk_schema_jump_fail", r4);
        r1.c("host", r6);
        r1.c("fail_reason", r7);
        boolean r8 = EntryController.M1;
        ShoppingCart r9 = EntryController.a.b(r5, null).s;
        if (r9 == null) goto L10;
        View r10 = r9.getViewSafe();
    L11:
        if (r10 == null) goto L13;
        r3 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r10));
    L13:
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r1.j("c9398.d8575", r3);
        return;
    L10:
        r10 = null;
        goto L11
    }

    public static void f(String r5, Map r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "ecomParams");
        Intrinsics.checkNotNullParameter(r7, "jumpSchema");
        Intrinsics.checkNotNullParameter(r8, "host");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L17;
        int r2 = RoomContextController.h;
        String r3 = null;
        com.bytedance.android.ec.common.api.jump.model.b r4 = RoomContextController.a.b(r5, null).l();
        if (r4 != null) goto L7;
        r4 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        sg2.v r1 = new sg2.v("livesdk_schema_jump_start", r4);
        r1.c("ecom_live_params", cd.a.a(r6).toString());
        r1.c("jump_schema", r7);
        r1.c("host", r8);
        boolean r9 = EntryController.M1;
        ShoppingCart r10 = EntryController.a.b(r5, null).s;
        if (r10 == null) goto L10;
        View r11 = r10.getViewSafe();
    L11:
        if (r11 == null) goto L13;
        r3 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r11));
    L13:
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r1.j("c9398.d8575", r3);
        return;
    L10:
        r11 = null;
        goto L11
    }
}

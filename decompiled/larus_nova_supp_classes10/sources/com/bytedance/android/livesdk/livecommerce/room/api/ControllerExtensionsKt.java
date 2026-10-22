package com.bytedance.android.livesdk.livecommerce.room.api;

import android.os.Bundle;
import com.bytedance.android.ec.adapter.api.state.ECEcomData;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.BottomRightBanner;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.DirectedFLashSaleEntrance;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.FloatingButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.HourRankEntrance;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.PublicScreenBottomWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.StartLivePreviewButtonCommerce;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ToolbarMain;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.TopRightRow4thWidget;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xd.j;
import xd.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ControllerExtensionsKt {
    public static final ILayoutConstraint a(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$live");
        if ((r1 instanceof xd.b) == false) goto L6;
        return BottomRightBanner.INSTANCE;
    L6:
        if ((r1 instanceof xd.d) == false) goto L9;
        return FloatingButton.INSTANCE;
    L9:
        if ((r1 instanceof xd.i) == false) goto L12;
        return ToolbarMain.INSTANCE;
    L12:
        if ((r1 instanceof xd.h) == false) goto L15;
        return StartLivePreviewButtonCommerce.INSTANCE;
    L15:
        if ((r1 instanceof xd.e) == false) goto L18;
        return HourRankEntrance.INSTANCE;
    L18:
        if ((r1 instanceof xd.c) == false) goto L21;
        return DirectedFLashSaleEntrance.INSTANCE;
    L21:
        if ((r1 instanceof j) == false) goto L24;
        return TopRightRow4thWidget.INSTANCE;
    L24:
        if ((r1 instanceof xd.f) == false) goto L28;
        return PublicScreenBottomWidget.INSTANCE;
    L28:
        throw new Exception("unknown layout constraint!!");
    }

    public static final PromotionListController b(PromotionListController r1, String r2) {
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        if (r1 != null) goto L8;
        PromotionListController.T.getClass();
        return PromotionListController.a.a();
    L8:
        return r1;
    L6:
        PromotionListController.T.getClass();
        return PromotionListController.a.c(r2, null);
    }

    public static final RoomContextController c(RoomContextController r1, String r2) {
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        if (r1 != null) goto L8;
        int r3 = RoomContextController.h;
        return RoomContextController.a.a();
    L8:
        return r1;
    L6:
        int r4 = RoomContextController.h;
        return RoomContextController.a.b(r2, null);
    }

    public static final com.bytedance.android.ec.adapter.api.state.a d(IRoomState r29, i r30) {
        Intrinsics.checkNotNullParameter(r30, "roomApiInfo");
        if (r29 != null) goto L5;
        return null;
    L5:
        Map r2 = r29.getEnterRoomParams();
        Map r3 = r29.getReportParams();
        if (r29.getEnterRoomParams().containsKey("tmp_log_extra_for_inner") == false) goto L22;
        r2 = MapsKt.toMutableMap(r2);
        String r4 = (String) r2.get("tmp_log_extra_for_inner");
        if (r4 == null) goto L21;
        JSONObject r5 = z1.g(r4);
        if (r5 == null) goto L21;
        r3 = MapsKt.toMutableMap(r29.getReportParams());
        if (r3.containsKey("log_extra") == true) goto L17;
        String r7 = a2.d(r5.optString("log_extra"));
        if (r7 == null) goto L17;
        r3.put("log_extra", r7);
    L17:
        if (r3.containsKey("creative_id") == true) goto L21;
        String r6 = a2.d(r5.optString("creative_id"));
        if (r6 == null) goto L21;
        r3.put("creative_id", r6);
    L21:
        r2.remove("tmp_log_extra_for_inner");
    L22:
        Map r21 = r2;
        Map r18 = r3;
        int r8 = r29.getItemType();
        boolean r9 = r29.isAnchor();
        boolean r10 = r29.isPortrait();
        String r11 = r30.b;
        String r12 = r29.getRoomId();
        String r13 = r29.getRoomAnchorId();
        String r14 = r29.getRoomAnchorSecId();
        boolean r15 = r29.isFollowed();
        boolean r16 = r29.isReplayOpen();
        Function0 r17 = r29.isLoginFunc();
        int r19 = r29.getStreamType();
        Bundle r110 = r29.getExtra();
        int r20 = r29.getLiveSdkVersion();
        Function0 r22 = r29.isKtvFun();
        Function0 r23 = r29.isInInteractionGameFun();
        Function0 r24 = r29.getPanelHeight();
        py.k r0 = r29.getCartIcon();
        if (r0 != null) goto L25;
        ECUrlModel r25 = null;
    L26:
        py.k r1 = r29.getLandscapeCartIcon();
        if (r1 == null) goto L31;
        ECUrlModel r26 = new ECUrlModel();
        r26.setUri(r1.getUri());
        r26.setUrlList(r1.getUrls());
    L31:
        return new com.bytedance.android.ec.adapter.api.state.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r18, r110, r20, r21, r22, r23, r24, r25, false, ControllerExtensionsKt$trans$2.INSTANCE, new ECEcomData(null));
    L25:
        ECUrlModel r27 = new ECUrlModel();
        r27.setUri(r0.getUri());
        r27.setUrlList(r0.getUrls());
        r25 = r27;
        goto L26
    }
}

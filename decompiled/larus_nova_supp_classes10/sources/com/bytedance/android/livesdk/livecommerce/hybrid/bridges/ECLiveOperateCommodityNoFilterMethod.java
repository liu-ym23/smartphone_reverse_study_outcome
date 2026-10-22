package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.os.Bundle;
import ch2.c;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveOperateCommodityNoFilterMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveOperateCommodityNoFilterMethod extends ECBaseBridgeMethod {
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "operateCommodityNoFilter";
    }

    public ECLiveOperateCommodityNoFilterMethod() {
        this.e = LazyKt.lazy(ECLiveOperateCommodityNoFilterMethod$noFilterSwitchHelper$2.INSTANCE);
    }

    public final void c(JSONObject r8, final ECBaseBridgeMethod.a r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "iReturn");
        if (r8.optBoolean("is_write") == false) goto L29;
        boolean r10 = r8.optBoolean("switch_enable");
        if (EComABUtils.enableFixCommodityNoFilter().booleanValue() == false) goto L9;
        ch2.b r0 = (ch2.b) this.e.getValue();
        Function1<Boolean, Unit> r1 = new ECLiveOperateCommodityNoFilterMethod$handle$1(r9);
        r0.getClass();
        int r11 = ECSdk.a;
        IAdapterService r12 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r12 == null) goto L34;
        r12.notifyCommodityNoFilterStatus(true, r10, new c(r1));
        return;
    L34:
        return;
    L9:
        String r2 = ControllerCenter.c;
        String r5 = ControllerCenter.d;
        Lazy r6 = LiveRoomProvider.a;
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        com.bytedance.android.livesdk.livecommerce.room.api.b r3 = LiveRoomProvider.g(r2, r5);
        if ((r3 instanceof RealRoomController) == true) goto L17;
        r3 = null;
    L17:
        RealRoomController r4 = (RealRoomController) r3;
        if (r4 == null) goto L20;
        boolean r7 = r4.z;
    L21:
        if (r7 == false) goto L25;
        ch2.b r13 = (ch2.b) this.e.getValue();
        Function1<Boolean, Unit> r14 = new ECLiveOperateCommodityNoFilterMethod$handle$2(r9);
        r13.getClass();
        int r15 = ECSdk.a;
        IAdapterService r16 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r16 == null) goto L36;
        r16.notifyCommodityNoFilterStatus(true, r10, new c(r14));
        return;
    L36:
        return;
    L25:
        Bundle r17 = new Bundle();
        int r18 = ch2.b.a;
        r17.putBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER", r10);
        r17.putBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN", false);
        int r19 = ECSdk.a;
        IAdapterService r20 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r20 == null) goto L28;
        r20.preOperateNoFilterStatus(true, r17);
    L28:
        JSONObject r21 = new JSONObject();
        r21.put("operate_result", true);
        Unit r22 = Unit.INSTANCE;
        r9.onSuccess(r21);
        return;
    L20:
        r7 = false;
        goto L21
    L29:
        Bundle r23 = new Bundle();
        int r24 = ECSdk.a;
        IAdapterService r25 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r25 == null) goto L32;
        r25.preOperateNoFilterStatus(false, r23);
    L32:
        int r26 = ch2.b.a;
        boolean r27 = r23.getBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER", false);
        boolean r28 = r23.getBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER_DEFAULT_OPEN", false);
        JSONObject r29 = new JSONObject();
        r29.put("switch_enable", r27);
        r29.put("switch_default_enable", r28);
        r9.onSuccess(r29);
    }
}

package qn2;

import am2.x;
import android.os.Bundle;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.enterparam.CommonEnterParamsData;
import com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import com.bytedance.android.livesdkapi.paramtransfer.utils.RoomParamTransferUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends BaseRoomParamsConsumer {
    public i() {
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        if (r100 != null) goto L5;
        return;
    L5:
        int r104 = h.f534018a[r101.ordinal()];
        com.bytedance.android.livesdk.log.filter.o r105 = null;
        if (r104 != 1) goto L8;
        com.bytedance.android.livesdk.log.filter.o r106 = j0.l().c(x.class);
        if ((r106 instanceof t) == false) goto L90;
        r105 = r106;
    L90:
        t r107 = (t) r105;
        if (r107 == null) goto L93;
        r107.r(true);
    L93:
        j0.l().addSendLogFilter(md1.a.class, md1.a.f513263a);
        RoomParamTransferUtils.INSTANCE.updateOuterTracker(r102, true, true);
        return;
    L8:
        if (r104 != 2) goto L10;
        HashMap<String, String> r108 = r100.getEventFirstShow();
        if (r108 != null) goto L45;
    L55:
        CommonEnterParamsData r109 = r100.getCommonEnterParams();
        if (r109 == null) goto L70;
        HashMap<String, String> r110 = r109.getMobParams();
        if (r110 == null) goto L70;
        if ((!r110.isEmpty()) == true) goto L63;
        r110 = null;
    L63:
        if (r110 == null) goto L70;
        com.bytedance.android.livesdk.log.filter.o r111 = j0.l().c(x.class);
        if ((r111 instanceof t) == true) goto L67;
        r111 = null;
    L67:
        t r112 = (t) r111;
        if (r112 == null) goto L70;
        r112.s(r110);
    L70:
        CommonEnterParamsData r113 = r100.getCommonEnterParams();
        if (r113 == null) goto L98;
        HashMap<String, String> r114 = r113.getFirstRoomMobParams();
        if (r114 != null) goto L75;
        return;
    L75:
        if ((!r114.isEmpty()) == true) goto L78;
        r114 = null;
    L78:
        if (r114 == null) goto L100;
        com.bytedance.android.livesdk.log.filter.o r115 = j0.l().c(x.class);
        if ((r115 instanceof t) == false) goto L83;
        r105 = r115;
    L83:
        t r116 = (t) r105;
        if (r116 == null) goto L101;
        r116.G(r114, false);
        return;
    L101:
        return;
    L100:
        return;
    L98:
        return;
    L45:
        if ((!r108.isEmpty()) == true) goto L48;
        r108 = null;
    L48:
        if (r108 == null) goto L55;
        com.bytedance.android.livesdk.log.filter.o r117 = j0.l().c(x.class);
        if ((r117 instanceof t) == true) goto L52;
        r117 = null;
    L52:
        t r118 = (t) r117;
        if (r118 == null) goto L55;
        r118.G(r108, true);
        goto L55
    L10:
        if (r104 != 3) goto L12;
        com.bytedance.android.livesdk.log.filter.o r119 = j0.l().c(x.class);
        if ((r119 instanceof t) == false) goto L38;
        r105 = r119;
    L38:
        t r120 = (t) r105;
        if (r120 == null) goto L41;
        r120.r(true);
    L41:
        RoomParamTransferUtils.INSTANCE.updateOuterTracker(r102, false, false);
        return;
    L12:
        if (r104 != 4) goto L14;
        CommonEnterParamsData r121 = r100.getCommonEnterParams();
        if (r121 == null) goto L33;
        HashMap<String, String> r122 = r121.getFirstRoomMobParams();
        if (r122 == null) goto L33;
        if ((!r122.isEmpty()) == true) goto L25;
        r122 = null;
    L25:
        if (r122 == null) goto L33;
        com.bytedance.android.livesdk.log.filter.o r123 = j0.l().c(x.class);
        if ((r123 instanceof t) == false) goto L30;
        r105 = r123;
    L30:
        t r124 = (t) r105;
        if (r124 == null) goto L33;
        r124.G(r122, false);
    L33:
        RoomParamTransferUtils.INSTANCE.updateOuterTracker(r102, true, false);
        return;
    L14:
        if (r104 != 5) goto L103;
        RoomParamTransferUtils.INSTANCE.setTrackerDataList(null);
        j0.l().removeSendLogFilter(md1.a.class);
        return;
    }
}

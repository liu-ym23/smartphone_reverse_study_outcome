package qn2;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.enterparam.CommonEnterParamsData;
import com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends BaseRoomParamsConsumer {
    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getBundleKey() {
        return "live.intent.extra.ENTER_LIVE_EXTRA";
    }

    public k() {
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final void consume(RoomBundleParams r110, RoomParamsConsumeStage r111, Bundle r112, Map<String, String> r113) {
        Intrinsics.checkNotNullParameter(r111, "stage");
        if (r110 != null) goto L5;
        return;
    L5:
        if (r112 == null) goto L51;
        Bundle r114 = m0.a(r112);
        if (r114 == null) goto L52;
        long r100 = r112.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID);
        Bundle r101 = r114.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_PARAM);
        if (r101 != null) goto L12;
        r101 = new Bundle();
    L12:
        Bundle r102 = r114.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_FIRST_ROOM);
        if (r102 != null) goto L15;
        r102 = new Bundle();
    L15:
        Bundle r103 = r114.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_FIRST_SHOW_ROOM);
        if (r103 != null) goto L18;
        r103 = new Bundle();
    L18:
        int r115 = j.f534019a[r111.ordinal()];
        if (r115 != 1) goto L21;
        CommonEnterParamsData r116 = r110.getCommonEnterParams();
        if (r116 == null) goto L49;
        Bundle r117 = r116.getCommonParamsBundle();
        if (r117 == null) goto L49;
        r101.putAll(r117);
    L49:
        r114.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_PARAM, r101);
        r114.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_FIRST_ROOM, r102);
        r114.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_FIRST_SHOW_ROOM, r103);
        return;
    L21:
        if (r115 == 2) goto L33;
        if (r115 != 3) goto L24;
        dispatchConsumeObserver(1, r101, r100);
        goto L49
    L24:
        if (r115 != 4) goto L49;
        CommonEnterParamsData r118 = r110.getCommonEnterParams();
        if (r118 == null) goto L31;
        Bundle r119 = r118.getFirstRoomParamsBundle();
        if (r119 == null) goto L31;
        r102.putAll(r119);
    L31:
        dispatchConsumeObserver(2, r102, r100);
        goto L49
    L33:
        CommonEnterParamsData r120 = r110.getCommonEnterParams();
        if (r120 == null) goto L38;
        Bundle r121 = r120.getFirstRoomParamsBundle();
        if (r121 == null) goto L38;
        r102.putAll(r121);
    L38:
        CommonEnterParamsData r122 = r110.getCommonEnterParams();
        if (r122 == null) goto L43;
        Bundle r123 = r122.getFirstShowRoomParamsBundle();
        if (r123 == null) goto L43;
        r103.putAll(r123);
    L43:
        dispatchConsumeObserver(1, r101, r100);
        dispatchConsumeObserver(2, r102, r100);
        dispatchConsumeObserver(3, r103, r100);
        goto L49
    L52:
        return;
    }
}

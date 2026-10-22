package qn2;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o extends c {
    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getBundleKey() {
        return ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS;
    }

    public o() {
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getClickParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getLifeClick();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getCommonParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getLifeCommon();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getFirstShowParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getLifeFirstShow();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // qn2.c, com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r110 == null) goto L27;
        Bundle r112 = m0.a(r110);
        if (r112 == null) goto L28;
        Bundle r102 = r112.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_LIFE_PARAM);
        if (r102 != null) goto L12;
        r102 = new Bundle();
    L12:
        String r103 = r100.getLifeCommon();
        String r104 = r100.getLifeClick();
        String r105 = r100.getLifeFirstShow();
        int r106 = n.f534021a[r101.ordinal()];
        if (r106 != 1) goto L15;
        r102.putString("life_common_param", r103);
        r102.putString("life_click_param", r104);
        r102.putString("life_first_show_param", r105);
    L25:
        r112.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_LIFE_PARAM, r102);
        return;
    L15:
        if (r106 != 2) goto L17;
        r102.putString("life_common_param", r103);
        goto L25
    L17:
        if (r106 != 3) goto L19;
        r102.putString("life_click_param", r104);
        goto L25
    L19:
        if (r106 != 4) goto L25;
        r102.remove("life_click_param");
        r102.remove("life_first_show_param");
        goto L25
    L28:
        return;
    }
}

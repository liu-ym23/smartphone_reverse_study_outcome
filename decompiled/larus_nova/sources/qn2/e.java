package qn2;

import android.os.Bundle;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends c {
    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getBundleKey() {
        return ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS;
    }

    public e() {
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getClickParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getEcomClick();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getCommonParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getEcomCommon();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getFirstShowParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getEcomFirstShow();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // qn2.c, com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        super.consume(r100, r101, r102, r103);
    }
}

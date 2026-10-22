package qn2;

import android.os.Bundle;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends c {
    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getBundleKey() {
        return "live_community_params";
    }

    public d() {
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getClickParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getCommunityClick();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getCommonParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getCommunityCommon();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getFirstShowParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getCommunityFirstShow();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // qn2.c, com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        super.consume(r100, r101, r102, r103);
        if (r100 == null) goto L11;
        HashMap<String, String> r104 = r100.getCommunityClickMap();
        if (r104 == null) goto L12;
        String r105 = r104.get(ILiveRoomPlayFragmentConstant.EXTRA_MENTION_CHAT_PARAM);
        if (r105 == null) goto L13;
        if (r102 == null) goto L14;
        r102.putString(ILiveRoomPlayFragmentConstant.EXTRA_MENTION_CHAT_PARAM, r105);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }
}

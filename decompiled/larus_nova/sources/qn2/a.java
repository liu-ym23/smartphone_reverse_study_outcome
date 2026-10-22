package qn2;

import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends c {
    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getBundleKey() {
        return "ad_data_params";
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getClickParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getAdClick();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getCommonParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getAdCommon();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getFirstShowParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getAdFirstShow();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }
}

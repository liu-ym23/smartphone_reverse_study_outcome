package qn2;

import android.os.Bundle;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.enterparam.CommonEnterParamsData;
import com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends BaseRoomParamsConsumer {
    public g() {
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        if (r100 != null) goto L6;
        return;
    L6:
        if (f.f534017a[r101.ordinal()] != 1) goto L41;
        HashMap<String, String> r104 = r100.getEnterClick();
        HashMap<String, String> r105 = null;
        if (r104 != null) goto L11;
    L17:
        HashMap<String, String> r106 = r100.getEnterCommon();
        if (r106 != null) goto L20;
    L26:
        CommonEnterParamsData r107 = r100.getCommonEnterParams();
        if (r107 == null) goto L38;
        HashMap<String, String> r108 = r107.getEnterRoom();
        if (r108 != null) goto L31;
        return;
    L31:
        if ((!r108.isEmpty()) == false) goto L33;
        r105 = r108;
    L33:
        if (r105 == null) goto L40;
        if (r103 == null) goto L36;
        r103.putAll(r105);
    L36:
        r105.clear();
        return;
    L40:
        return;
    L38:
        return;
    L20:
        if ((!r106.isEmpty()) == true) goto L23;
        r106 = null;
    L23:
        if (r106 == null) goto L26;
        if (r103 == null) goto L26;
        r103.putAll(r106);
        goto L26
    L11:
        if ((!r104.isEmpty()) == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L17;
        if (r103 == null) goto L17;
        r103.putAll(r104);
        goto L17
    }
}

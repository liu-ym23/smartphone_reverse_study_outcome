package qn2;

import android.os.Bundle;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import com.bytedance.android.livesdkapi.paramtransfer.utils.RoomParamTransferUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class c extends BaseRoomParamsConsumer {
    public c() {
    }

    public static boolean b(String r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return false;
    L8:
        if ((!Intrinsics.areEqual(r100, SliceInitService.DEFAULT_SWITCH)) == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public final void a(String r100, String r101, Bundle r110) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r110.putString(getBundleKey(), r101);
        return;
    L11:
        RoomParamTransferUtils r103 = RoomParamTransferUtils.INSTANCE;
        JSONObject r104 = RoomParamTransferUtils.createJSONObject$default(r103, r100, "", null, 4, null);
        if (r104 != null) goto L14;
        return;
    L14:
        JSONObject r105 = RoomParamTransferUtils.createJSONObject$default(r103, r101, "", null, 4, null);
        if (r105 != null) goto L17;
        return;
    L17:
        Iterator<String> r106 = r105.keys();
    L19:
        if (r106.hasNext() == false) goto L21;
        String r107 = r106.next();
        r104.put(r107, r105.opt(r107));
        goto L19
    L21:
        String r108 = r104.toString();
        if (b(r108) == false) goto L26;
        r110.putString(getBundleKey(), r108);
        return;
    L26:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
        return;
    L7:
        int r104 = b.f534016a[r101.ordinal()];
        if (r104 != 1) goto L10;
    L12:
        String r105 = getCommonParam(r100);
        String r106 = null;
        if (r105 != null) goto L15;
    L20:
        String r107 = getClickParam(r100);
        if (r107 != null) goto L23;
    L28:
        String r108 = getFirstShowParam(r100);
        if (r108 != null) goto L31;
        return;
    L31:
        if (b(r108) == false) goto L33;
        r106 = r108;
    L33:
        if (r106 == null) goto L37;
        a(r102.getString(getBundleKey()), r106, r102);
        return;
    L37:
        return;
    L23:
        if (b(r107) == true) goto L26;
        r107 = null;
    L26:
        if (r107 == null) goto L28;
        a(r102.getString(getBundleKey()), r107, r102);
        goto L28
    L15:
        if (b(r105) == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L20;
        a(r102.getString(getBundleKey()), r105, r102);
        goto L20
    L10:
        if (r104 == 2) goto L12;
    }
}

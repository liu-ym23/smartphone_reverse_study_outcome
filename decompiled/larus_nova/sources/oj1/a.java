package oj1;

import android.os.Bundle;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.utility.StringUtils;
import java.util.ArrayList;
import java.util.List;
import ls2.c;
import ls2.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.bytedance.android.livesdk.room.Task.base.a<d, c> {
    @Override // gs2.a
    public final String taskID() {
        return "LiveSessionEcomParamsInitTask";
    }

    @Override // com.bytedance.android.livesdk.room.Task.base.LiveTask
    public final List<String> f() {
        ArrayList r100 = new ArrayList();
        r100.add("RoomSessionTaskConst_SessionInitProviderAndExtraTask");
        return r100;
    }

    @Override // gs2.a
    public final void run() {
        ik1.d r100 = (ik1.d) h().b("RoomSessionTaskConst_live_room_container_data");
        Bundle r101 = h().f510526o;
        String r102 = r101.getString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, null);     // Catch: JSONException -> L29
        if (r102 != null) goto L6;
    L8:
        String r103 = r100.f490227c.getString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS);     // Catch: JSONException -> L29
        if (StringUtils.isEmpty(r103) == true) goto L11;
        JSONObject r104 = new JSONObject(r103);     // Catch: JSONException -> L29
    L12:
        String r105 = r101.getString(ILiveRoomPlayFragmentConstant.EXTRA_SHOP_GUIDE_ID, "");     // Catch: JSONException -> L29
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L29
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_SHOP_GUIDE_ID, r105);     // Catch: JSONException -> L29
        if (r104.has("pass_through_log_data") == true) goto L16;
        r104.put("pass_through_log_data", r106);     // Catch: JSONException -> L29
    L23:
        String r107 = r104.toString();     // Catch: JSONException -> L29
        if (r107 != null) goto L26;
        return;
    L26:
        if (r107.length() <= 0) goto L35;
        r100.f490227c.putString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r107);     // Catch: JSONException -> L29
        return;
    L35:
        return;
    L16:
        if (r104.optJSONObject("pass_through_log_data") == null) goto L23;
        if ((r104.optJSONObject("pass_through_log_data") instanceof JSONObject) == false) goto L23;
        if (r105 == null) goto L23;
        if (r105.isEmpty() == true) goto L23;
        r104.optJSONObject("pass_through_log_data").put(ILiveRoomPlayFragmentConstant.EXTRA_SHOP_GUIDE_ID, r105);     // Catch: JSONException -> L29
        goto L23
    L11:
        r104 = new JSONObject();     // Catch: JSONException -> L29
        goto L12
    L6:
        if (r102.length() <= 0) goto L8;
        r100.f490227c.putString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r102);     // Catch: JSONException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    }

    public a() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}

package hj7;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public b() {
    }

    @BridgeMethod("luckycatShowRewardVideoAd")
    public void showExcitingVideoAd(@BridgeContext IBridgeContext r100, @BridgeParam("data") JSONObject r110) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "3.0: luckycatShowRewardVideoAd");
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_exciting_video_ad_request", r110, true);
        if (r110 != null) goto L11;
        JSONObject r101 = new JSONObject();
        r101.put("error_code", 90031);     // Catch: JSONException -> L7
        r101.put("error_msg", "input_params_empty");     // Catch: JSONException -> L7
    L9:
        com.bytedance.ug.sdk.luckycat.impl.model.d.d(90031, r110);
        r100.callback(a.a(2, r101, "data empty"));
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L11:
        String r102 = r110.optString(DbJsonConstants.DBJSON_KEY_TASK_KEY);
        String r103 = r110.optString("ad_rit");
        String r104 = r110.optString("ad_alias_position");
        r110.optInt("amount");
        if (TextUtils.isEmpty(r102) == false) goto L14;
    L20:
        JSONObject r105 = new JSONObject();
        r105.put("error_code", 90012);     // Catch: JSONException -> L23
        r105.put("error_msg", "input_params_empty");     // Catch: JSONException -> L23
    L25:
        com.bytedance.ug.sdk.luckycat.impl.model.d.d(90012, r110);
        r100.callback(a.a(3, r105, "failed"));
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L14:
        if (TextUtils.isEmpty(r103) == true) goto L20;
        if (TextUtils.isEmpty(r104) == true) goto L20;
        r110.optBoolean("need_reward", true);
        com.bytedance.ug.sdk.luckycat.impl.manager.m r111 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        r100.getActivity();
    }
}

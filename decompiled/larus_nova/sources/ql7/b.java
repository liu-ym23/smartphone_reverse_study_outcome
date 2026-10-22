package ql7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @BridgeMethod("luckycatGetUnionInfo")
    public final void getUnionInfo(@BridgeContext IBridgeContext r100, @BridgeParam("activity_id") String r101) {
        if (r100 == null) goto L15;
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L10
        mk7.a.C6825a r103 = mk7.a.b.f514328a.c(r101);     // Catch: JSONException -> L10
        if (r103 == null) goto L7;
        r102.put("from_app_id", r103.f514324a);     // Catch: JSONException -> L10
        r102.put("from_act_hash", r103.f514325b);     // Catch: JSONException -> L10
        r102.put("current_app_id", r103.f514326c);     // Catch: JSONException -> L10
        r102.put("current_act_hash", r103.f514327d);     // Catch: JSONException -> L10
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckycatGetUnionInfoModule", "getUnionInfo() 返回冲突信息 fromAid = " + r103.f514324a);     // Catch: JSONException -> L10
    L8:
        r100.callback(pk7.a.a(1, r102, "success"));     // Catch: JSONException -> L10
        return;
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckycatGetUnionInfoModule", "LuckycatGetUnionInfo() 没有冲突信息");     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckycatGetUnionInfoModule", e.getLocalizedMessage());
        r100.callback(pk7.a.a(0, null, "failed"));
        return;
    }
}

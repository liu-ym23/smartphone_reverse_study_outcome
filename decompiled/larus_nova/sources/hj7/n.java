package hj7;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.map.api.monitor.MonitorValueConst;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class n {
    public n() {
    }

    @BridgeMethod("luckycatDirectShare")
    public void directShare(@BridgeContext IBridgeContext r100, @BridgeParam("data") JSONObject r101) {
        if (r100.getActivity() != null) goto L6;
        r100.callback(a.a(0, null, MonitorValueConst.TYPE_CONTEXT_NULL));
        return;
    L6:
        if (r101 == null) goto L12;
        r101.optString("channel");
        r101.optString(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r101.optString("content_type");
        r101.optString("title");
        r101.optString("abstract");
        r101.optString("target_url");
        r101.optString("video_url");
        r101.optString("image_url");
        r101.optString("panel_id");
        r101.optBoolean("show_panel");
        JSONObject r102 = r101.optJSONObject("token");
        if (r102 == null) goto L11;
        r102.optString("title");
        r102.optString("description");
        r102.optString("tips");
    L11:
        r101.optJSONObject("extra");
    L12:
        com.bytedance.ug.sdk.luckycat.impl.manager.m r103 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        r100.callback(a.a(1, null, "failed"));
    }
}

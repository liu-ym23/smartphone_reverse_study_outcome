package rl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckycatGetUnionInfo", owner = "pengweitao")
public final class f extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538472a;

    public f() {
        this.f538472a = "luckycatGetUnionInfo";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f538472a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "LuckycatGetUnionInfo on call");
        String r102 = s.f(r100, "activity_id", "");
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L9
        mk7.a.C6825a r104 = mk7.a.b.f514328a.c(r102);     // Catch: JSONException -> L9
        if (r104 == null) goto L6;
        r103.put("from_app_id", r104.f514324a);     // Catch: JSONException -> L9
        r103.put("from_act_hash", r104.f514325b);     // Catch: JSONException -> L9
        r103.put("current_app_id", r104.f514326c);     // Catch: JSONException -> L9
        r103.put("current_act_hash", r104.f514327d);     // Catch: JSONException -> L9
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "LuckycatGetUnionInfo() 返回冲突信息 fromAid = " + r104.f514324a);     // Catch: JSONException -> L9
    L7:
        r101.a(1, r103, "success");     // Catch: JSONException -> L9
        return;
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "LuckycatGetUnionInfo() 没有冲突信息");     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogXBridge", e.getLocalizedMessage());
        i.b(r101, 0, null, "fail", 2);
    }
}

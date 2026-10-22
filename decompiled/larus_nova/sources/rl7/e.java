package rl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckycatDeleteUnionInfo", owner = "pengweitao")
public final class e extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538471a;

    public e() {
        this.f538471a = "luckycatDeleteUnionInfo";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f538471a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "LuckycatDeleteUnionInfo on call");
        String r102 = s.f(r100, "activity_id", "");
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L5
        mk7.a.b.f514328a.b(r102);     // Catch: JSONException -> L5
        r101.a(1, r103, "success");     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogXBridge", e.getLocalizedMessage());
        i.b(r101, 0, null, "fail", 2);
    }
}

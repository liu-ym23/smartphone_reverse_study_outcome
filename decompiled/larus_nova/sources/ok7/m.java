package ok7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatGetCurrentTime", owner = "pengweitao")
public final class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523695a;

    public m() {
        this.f523695a = "luckycatGetCurrentTime";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f523695a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        long r102 = hl7.b.b().a();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "luckycatGetCurrentTime on call. current ts = " + r102);
        if (r102 > 0) goto L5;
        i.b(r101, 0, null, "get server timestamp failed. ret = " + r102, 2);
        return;
    L5:
        JSONObject r103 = new JSONObject();
        r103.put("ts", MathKt.roundToInt(r102 / 1000.0d));
        r101.a(1, r103, "success");
    }
}

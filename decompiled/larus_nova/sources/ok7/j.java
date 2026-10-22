package ok7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatGetBatchSettingsInfo", owner = "pengweitao")
public final class j extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523692a;

    public j() {
        this.f523692a = "luckycatGetBatchSettingsInfo";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f523692a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "LuckycatGetBatchSettingsInfo on call");
        String r102 = s.f(r100, "activity_id", "");
        v r103 = s.a(r100, "keys");
        if (r103 == null) goto L5;
        JSONArray r104 = com.bytedance.ies.xbridge.utils.j.c(r103);
    L6:
        ArrayList r105 = o.a(r104);
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L16;
        i.b(r101, 0, null, "msg_is_null", 2);
        return;
    L16:
        r101.a(1, o.b(r102, r105), "success");
        return;
    L9:
        if (r105.isEmpty() == true) goto L12;
        r106 = false;
        goto L13
    L5:
        r104 = new JSONArray();
        goto L6
    }
}

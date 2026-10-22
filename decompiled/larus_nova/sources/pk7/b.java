package pk7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import java.util.ArrayList;
import ok7.o;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @BridgeMethod("luckycatGetBatchSettingsInfo")
    public final void handleGetBatchSettingsInfo(@BridgeParam("activity_id") String r100, @BridgeParam("keys") JSONArray r101, @BridgeContext IBridgeContext r102) {
        if (r102 == null) goto L18;
        if (r101 != null) goto L6;
        r101 = new JSONArray();
    L6:
        ArrayList r103 = o.a(r101);
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        r102.callback(pk7.a.a(0, null, "msg_is_null"));
        return;
    L16:
        r102.callback(pk7.a.a(1, o.b(r100, r103), ""));
        return;
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    }
}

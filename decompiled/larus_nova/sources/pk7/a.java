package pk7;

import com.bytedance.sdk.bridge.model.BridgeResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static final BridgeResult a(int r100, JSONObject r101, String r102) {
        if (r101 != null) goto L14;
        r101 = new JSONObject();
    L14:
        r101.put("bridge_version", "3.0");     // Catch: JSONException -> L7
    L10:
        if (r100 != 1) goto L13;
        return BridgeResult.Companion.createSuccessResult(r101, r102);
    L13:
        return BridgeResult.Companion.createErrorResult(r102, r101);
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}

package pk7;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @BridgeMethod("luckycatGetSettingsInfo")
    public final void handleGetSettingsInfo(@BridgeParam("activity_id") String r110, @BridgeParam("key") String r111, @BridgeContext IBridgeContext r112) {
        if (r112 == null) goto L28;
        String r100 = null;
        if (TextUtils.isEmpty(r111) == false) goto L7;
        r112.callback(pk7.a.a(0, null, "key_is_null"));
        return;
    L7:
        if (r111 == null) goto L9;
        List r113 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);
    L10:
        if (r113 == null) goto L12;
        String r101 = (String) CollectionsKt.getOrNull(r113, 0);
    L14:
        if (r113 == null) goto L16;
        String r102 = (String) CollectionsKt.getOrNull(r113, 1);
    L17:
        if (r113 == null) goto L19;
        r100 = (String) CollectionsKt.getOrNull(r113, 2);
    L19:
        Object r114 = ok7.b.c(r110, r101, r102, r100);
        JSONObject r115 = new JSONObject();
        r115.put("setting", r114);     // Catch: JSONException -> L22
    L24:
        r112.callback(pk7.a.a(1, r115, ""));
        return;
    L22:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("luckydog_js_tag", e.getMessage());
        goto L24
    L16:
        r102 = null;
        goto L17
    L12:
        r101 = null;
        goto L14
    L9:
        r113 = null;
        goto L10
    }
}

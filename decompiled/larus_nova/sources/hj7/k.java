package hj7;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes22.dex */
public final class k {
    public k() {
    }

    @BridgeMethod("luckycatGetGeckoInfo")
    public void getGeckoInfo(@BridgeParam("channels") JSONArray r100, @BridgeParam("access_key") String r101, @BridgeContext IBridgeContext r102) {
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (r100 != null) goto L10;
    L14:
        r102.callback(a.a(0, null, "channel length is 0"));
        return;
    L10:
        if (r100.length() == 0) goto L14;
        ak7.c.f4079b.f0(r101);
        r102.callback(a.a(0, null, "gecko client is null"));
    }
}

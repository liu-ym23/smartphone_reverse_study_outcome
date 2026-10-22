package com.bytedance.bdlocation_impl.shake;

import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ShakeInfoUtil {
    public ShakeInfoUtil() {
    }

    public static JsonArray getBleInfoArray(List<BDBleInfo> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        JsonElement r3 = JsonUtil.toJsonTreeSafely(r2, new AnonymousClass1().getType());
        if (r3 != null) goto L8;
    L12:
        return null;
    L8:
        if (r3.isJsonArray() == false) goto L12;
        return r3.getAsJsonArray();
    }
}

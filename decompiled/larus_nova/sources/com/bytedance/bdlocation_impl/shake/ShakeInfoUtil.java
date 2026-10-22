package com.bytedance.bdlocation_impl.shake;

import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ShakeInfoUtil {
    public ShakeInfoUtil() {
    }

    public static JsonArray getBleInfoArray(List<BDBleInfo> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JsonElement r101 = JsonUtil.toJsonTreeSafely(r100, new AnonymousClass1().getType());
        if (r101 != null) goto L8;
    L12:
        return null;
    L8:
        if (r101.isJsonArray() == false) goto L12;
        return r101.getAsJsonArray();
    }
}

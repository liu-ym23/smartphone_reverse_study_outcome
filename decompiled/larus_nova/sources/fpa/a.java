package fpa;

import com.privacy.azerothprivacy.AzerothPrivacy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static Map<String, String> a() {
        HashMap r100 = new HashMap();
        if (AzerothPrivacy.getAppInfo() == null) goto L5;
        r100.put("user_id", AzerothPrivacy.getAppInfo().f530146e);
        r100.put("device_id", AzerothPrivacy.getAppInfo().f530145d);
    L5:
        r100.put("azeroth_sdk_version", AzerothPrivacy.getVersion());
        return r100;
    }
}

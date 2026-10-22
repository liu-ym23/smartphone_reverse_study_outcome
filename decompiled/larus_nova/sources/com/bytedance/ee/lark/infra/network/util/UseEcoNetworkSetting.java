package com.bytedance.ee.lark.infra.network.util;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "use_econetwork_api")
public class UseEcoNetworkSetting implements Serializable {

    @SerializedName("default")
    public boolean defaultVal;

    @SerializedName("path")
    public HashMap<String, Boolean> pathList;

    @SerializedName("regexPath")
    public HashMap<String, Boolean> regexPathList;

    public UseEcoNetworkSetting() {
    }

    public static boolean useEco(String r100) {
        UseEcoNetworkSetting r101 = (UseEcoNetworkSetting) SettingManager.getInstance().get(UseEcoNetworkSetting.class);
        HashMap<String, Boolean> r102 = r101.pathList;
        HashMap<String, Boolean> r103 = r101.regexPathList;
        boolean r104 = r101.defaultVal;
        if (r102 == null) goto L7;
        Boolean r105 = r102.get(r100);
        if (r105 == null) goto L7;
        return r105.booleanValue();
    L7:
        if (r103 == null) goto L19;
        Iterator<Map.Entry<String, Boolean>> r106 = r103.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, Boolean> r107 = r106.next();
        if (PatternProtector.compile(r107.getKey()).matcher(r100).matches() == false) goto L10;
        return r107.getValue().booleanValue();
    L20:
        return r104;
    L19:
        return r104;
    }
}

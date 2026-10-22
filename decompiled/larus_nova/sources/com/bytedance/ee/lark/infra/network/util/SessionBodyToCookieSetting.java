package com.bytedance.ee.lark.infra.network.util;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.io.Serializable;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "openplatform_network_session_body_to_cookie")
public class SessionBodyToCookieSetting implements Serializable {

    @SerializedName("default")
    public boolean defaultVal;

    @SerializedName("host")
    public LinkedList<String> hostList;

    @SerializedName("path")
    public LinkedList<String> pathList;

    public SessionBodyToCookieSetting() {
    }

    public static boolean match(String r100, String r101) {
        SessionBodyToCookieSetting r102 = (SessionBodyToCookieSetting) SettingManager.getInstance().get(SessionBodyToCookieSetting.class);
        if (r102.defaultVal == false) goto L5;
        return true;
    L5:
        LinkedList<String> r103 = r102.pathList;
        if (r103 != null) goto L8;
    L17:
        return false;
    L8:
        if (r102.hostList == null) goto L17;
        if (r103.contains(r100) == true) goto L13;
    L15:
        return false;
    L13:
        if (r102.hostList.contains(r101) == false) goto L15;
        return true;
    }
}

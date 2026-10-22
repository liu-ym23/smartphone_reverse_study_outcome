package com.bytedance.ttnet.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ttnet.TTNetInit;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MultiProcessFileUtils {
    public static final String KEY_DNS = "dns";
    public static final String KEY_FRONTIER_URLS = "frontier_urls";
    public static final String KEY_HTTPS_DNS = "https_dns";
    public static final String KEY_IS_FULL_CONFIG = "is_full_config";
    public static final String KEY_SSIDS = "ssids";
    public static final String KEY_TNC_ABTEST = "tnc_abtest";
    public static final String KEY_TNC_CONFIG = "tnc_config";
    public static final String KEY_TNC_ETAG = "tnc_etag";
    private static final String TAG = "MultiProcessFileUtils";
    public static final int TYPE_DNS = 2;
    public static final int TYPE_HTTPS_DNS = 3;
    public static final int TYPE_SSIDS = 1;
    public static final int TYPE_TNC_ABTEST = 6;
    public static final int TYPE_TNC_CONFIG = 4;
    public static final int TYPE_TNC_ETAG = 5;
    public static final int TYPE_TNC_FULL_CONFIG_FLAG = 7;

    public MultiProcessFileUtils() {
    }

    public static String bool2Str(boolean r100) {
        return Boolean.valueOf(r100).toString();
    }

    public static boolean str2Bool(String r100) {
        return Boolean.parseBoolean(r100);
    }

    public static String getData(Context r100, int r101) {
        switch(r101) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L14;
        };
    L5:
        String r102 = TTNetInit.getTTNetDepend().getProviderString(r100, "is_full_config", "");     // Catch: Exception -> L13
    L19:
    L16:
        if ((r102 instanceof String) == true) goto L18;
        return "";
    L18:
        return String.valueOf(r102);
    L6:
        r102 = TTNetInit.getTTNetDepend().getProviderString(r100, KEY_TNC_ABTEST, "");     // Catch: Exception -> L13
        goto L19
    L7:
        r102 = TTNetInit.getTTNetDepend().getProviderString(r100, KEY_TNC_ETAG, "");     // Catch: Exception -> L13
        goto L19
    L8:
        r102 = TTNetInit.getTTNetDepend().getProviderString(r100, KEY_TNC_CONFIG, "");     // Catch: Exception -> L13
        goto L19
    L9:
        r102 = TTNetInit.getTTNetDepend().getProviderString(r100, KEY_HTTPS_DNS, "");     // Catch: Exception -> L13
        goto L19
    L10:
        r102 = TTNetInit.getTTNetDepend().getProviderString(r100, KEY_DNS, "");     // Catch: Exception -> L13
        goto L19
    L11:
        r102 = TTNetInit.getTTNetDepend().getProviderString(r100, KEY_SSIDS, "");     // Catch: Exception -> L13
    L14:
        r102 = "";
        goto L16
    }

    public static void getSSIDs(Context r100, Map<String, String> r101) {
        if (r100 == null) goto L17;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L15;
        Logger.d("PushService", "getSSIDs start");
    L15:
        String r102 = getData(r100, 1);     // Catch: Exception -> L14
        if (StringUtils.isEmpty(r102) == false) goto L12;
        return;
    L12:
        StringUtils.stringToMap(r102, r101);     // Catch: Exception -> L14
        return;
    L19:
        return;
    }

    public static void saveSSIDs(Context r100, Map<String, String> r101) {
        if (r100 == null) goto L13;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L11;
        Logger.d("PushService", "saveSSIDs start");
    L11:
        saveData(r100, 1, StringUtils.mapToString(r101));     // Catch: Exception -> L10
        return;
    L15:
        return;
    }

    public static void saveData(Context r100, int r101, String r102) {
        LinkedHashMap r103 = new LinkedHashMap();     // Catch: Exception -> L18
        switch(r101) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L14;
        };     // Catch: Exception -> L18
    L6:
        r103.put("is_full_config", r102);     // Catch: Exception -> L18
        goto L14
    L7:
        r103.put(KEY_TNC_ABTEST, r102);     // Catch: Exception -> L18
        goto L14
    L8:
        r103.put(KEY_TNC_ETAG, r102);     // Catch: Exception -> L18
        goto L14
    L9:
        r103.put(KEY_TNC_CONFIG, r102);     // Catch: Exception -> L18
        goto L14
    L10:
        r103.put(KEY_HTTPS_DNS, r102);     // Catch: Exception -> L18
        goto L14
    L11:
        r103.put(KEY_DNS, r102);     // Catch: Exception -> L18
        goto L14
    L12:
        r103.put(KEY_SSIDS, r102);     // Catch: Exception -> L18
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("PushService", "saveData = " + r102);     // Catch: Exception -> L18
    L16:
        TTNetInit.getTTNetDepend().saveMapToProvider(r100, r103);     // Catch: Exception -> L18
        return;
    }
}

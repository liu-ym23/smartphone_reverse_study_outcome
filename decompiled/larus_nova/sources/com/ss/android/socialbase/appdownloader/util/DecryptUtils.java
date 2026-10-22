package com.ss.android.socialbase.appdownloader.util;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class DecryptUtils {
    public DecryptUtils() {
    }

    public static String decryptOpenUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return new String(Base64.decode(DownloadUtils.hexToString(r100), 0));
    }

    public static String decrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        int r102 = 0;
        byte[] r103 = Base64.decode(DownloadUtils.hexToString(r100), 0);
        int r104 = r101.length();
        int r105 = r103.length;
        StringBuilder r106 = new StringBuilder();
        int r107 = 0;
    L8:
        if (r102 >= r105) goto L13;
        if (r107 < r104) goto L11;
        r107 = r107 % r104;
    L11:
        r106.append((char) (r103[r102] ^ r101.charAt(r107)));
        r107 = r107 + 1;
        r102 = r102 + 1;
        goto L8
    L13:
        return r106.toString();
    L19:
        return null;
    }

    public static String decryptSetting(JSONObject r100, String r101, String r102) {
        return decrypt(r100.optString(r101), r102);
    }
}

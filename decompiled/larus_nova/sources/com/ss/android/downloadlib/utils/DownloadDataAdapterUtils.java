package com.ss.android.downloadlib.utils;

import android.text.TextUtils;
import com.ss.android.downloadlib.constants.DownloadConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadDataAdapterUtils {
    public DownloadDataAdapterUtils() {
    }

    public static String generateDownloadExtra(String r100, String r101, boolean r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put("extra", r100);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r104.put("notification_jump_url", r101);     // Catch: JSONException -> L8
    L6:
        r104.put(DownloadConstants.KEY_TOAST, r102);     // Catch: JSONException -> L8
        r104.put("business_type", r103);     // Catch: JSONException -> L8
    L11:
        return r104.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}

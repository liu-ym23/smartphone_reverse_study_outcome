package com.huawei.hms.framework.common;

import android.os.Bundle;
import android.text.TextUtils;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class BundleUtil {
    public static final String TAG = "BundleUtil";
    public static final String UNDERLINE_TAG = "_";

    public BundleUtil() {
    }

    public static String bundleToJson(Bundle r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: JSONException -> L11
    L8:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();     // Catch: JSONException -> L11
        r101.put(r103, String.valueOf(r100.get(r103)));     // Catch: JSONException -> L11
    L13:
        return r101.toString();
    L11:
        Logger.e(TAG, "bundleToJson meet error");
        goto L13
    L5:
        return r101.toString();
    }

    public static Bundle jsonToBundle(String r100) {
        Bundle r101 = new Bundle();
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return r101;
    L12:
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L10
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L10
    L7:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next();     // Catch: JSONException -> L10
        r101.putString(r104, r102.optString(r104));     // Catch: JSONException -> L10
    L11:
        return r101;
    L10:
        Logger.e(TAG, "jsonToBundle meet error");
        goto L11
    }

    public static String transPkgPrefix(String r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L13;
        if (r100.contains(".") == false) goto L13;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length <= 0) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L11;
        r101.append(r102[r104]);
        r104 = r104 + 1;
    L11:
        r101.append("_");
    L13:
        return r101.toString();
    }
}

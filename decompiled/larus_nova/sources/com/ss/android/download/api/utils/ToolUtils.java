package com.ss.android.download.api.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ToolUtils {
    public ToolUtils() {
    }

    public static JSONObject copyJson(JSONObject r100) {
        return copyJson(r100, new JSONObject());
    }

    public static String getComplianceDataFromLogExtra(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        GlobalInfo.getTTMonitor().monitorDataError("parseComplianceData empty LogExtra");
        return "";
    L11:
        return new JSONObject(r100).optString("compliance_data");
    L8:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(false, true, e, "parseComplianceData error");
        return "";
    }

    public static String getNotEmptyStr(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        String r103 = r100[r102];
        if (TextUtils.isEmpty(r103) == false) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return "";
    }

    public static boolean isApkDownloadUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return true;
    L5:
        String r101 = UriProtector.parse(r100).getLastPathSegment();
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return true;
    L9:
        return r101.endsWith(".apk");
    }

    public static JSONObject mergeJson(JSONObject... r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
    L13:
        return r101;
    L5:
        if (r100.length == 0) goto L13;
        int r102 = r100.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        JSONObject r104 = r100[r103];
        if (r104 == null) goto L12;
        copyJson(r104, r101);
    L12:
        r103 = r103 + 1;
        goto L8
    }

    public static JSONObject copyJson(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        Iterator<String> r102 = r100.keys();     // Catch: JSONException -> L9
    L6:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();     // Catch: JSONException -> L9
        r101.put(r103, r100.get(r103));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        return r101;
    }

    public static Drawable getIconByPackageName(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        PackageManager r102 = r100.getPackageManager();
        return r102.getApplicationIcon(r102.getApplicationInfo(r101, 128));
    L11:
        return null;
    }

    public static String getNameByPackageName(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return "";
    L5:
        PackageManager r102 = r100.getPackageManager();
        return r102.getApplicationLabel(r102.getApplicationInfo(r101, 128)).toString();
    L11:
        return "";
    }

    public static long optLong(JSONObject r100, String r101) {
        if (r100 != null) goto L9;
        return 0;
    L9:
        return CastLongProtector.valueOf(r100.optString(r101)).longValue();
    L11:
        return 0;
    }

    public static boolean shouldDownloadWithPatchApply(DownloadSetting r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.optInt(DownloadSettingKeys.APK_UPDATE_HANDLER_ENABLE, 1) == 1) goto L6;
        return false;
    L6:
        return Constants.MIME_PATCH.equals(r101);
    }
}

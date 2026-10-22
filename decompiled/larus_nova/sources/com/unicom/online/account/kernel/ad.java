package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ttnet.org.chromium.base.BaseSwitches;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f461959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Boolean f461960b = null;

    static {
        f461959a = ad.class.getName();
        f461960b = Boolean.FALSE;
    }

    public ad() {
    }

    private static String a(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        PackageManager r101 = r100.getPackageManager();
        PackageInfo r102 = r101.getPackageInfo(r100.getPackageName(), 0);     // Catch: Exception -> L10
        if (r102 == null) goto L15;
        return r102.versionName;
    L15:
        return null;
    L10:
        e = move-exception;
        aj.b(e.getMessage());
        return null;
    }

    public static String a(Context r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put(OfficeSDKRequestTag.KEY_NEW_USER, d(r100));     // Catch: JSONException -> L5
        r102.put(BaseSwitches.V, a(r100));     // Catch: JSONException -> L5
        StringBuilder r103 = new StringBuilder();     // Catch: JSONException -> L5
        r103.append(b(r100));     // Catch: JSONException -> L5
        r102.put("c", r103.toString());     // Catch: JSONException -> L5
        JSONObject r104 = new JSONObject(r101);     // Catch: JSONException -> L5
        r104.put("app", r102);     // Catch: JSONException -> L5
        return r104.toString();
    L5:
        e = move-exception;
        aj.b(e.getMessage());
        return r101;
    }

    private static int b(Context r100) {
        if (r100 != null) goto L12;
        return -1;
    L12:
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(c(r100), 1);     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        return r101.versionCode;
    L14:
        return -1;
    L9:
        e = move-exception;
        aj.b(e.getMessage());
        return -1;
    }

    private static String c(Context r100) {
        if (r100 != null) goto L11;
        String r101 = "mContext 为空";
    L5:
        aj.b(r101);
        return null;
    L11:
        return r100.getPackageName();
    L9:
        e = move-exception;
        r101 = e.getMessage();
        goto L5
    }

    private static String d(Context r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        PackageManager r101 = r100.getPackageManager();     // Catch: Exception -> L7
        return r101.getApplicationLabel(r101.getApplicationInfo(r100.getPackageName(), 128)).toString();
    L7:
        e = move-exception;
        aj.b(e.getMessage());
        return null;
    }
}

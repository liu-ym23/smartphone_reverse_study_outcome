package com.huawei.secure.android.common.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.secure.android.common.util.LogsUtil;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class UriUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278259a = "UriUtil";

    public UriUtil() {
    }

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        LogsUtil.i(f278259a, "whiteListUrl is null");
        return null;
    L7:
        if (URLUtil.isNetworkUrl(r100) == true) goto L10;
        return r100;
    L10:
        return getHostByURI(r100);
    }

    public static String getHostByURI(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
        LogsUtil.i(f278259a, "url is null");
        return r100;
    L15:
    L12:
        e = move-exception;
        LogsUtil.e(f278259a, "getHostByURI error  MalformedURLException : " + e.getMessage());
        return "";
    L7:
        if (URLUtil.isNetworkUrl(r100) == true) goto L11;
        LogsUtil.e(f278259a, "url don't starts with http or https");     // Catch: MalformedURLException -> L12
        return "";
    L11:
        return new URL(r100.replaceAll("[\\\\#]", HTTP.URL_DEFAULT)).getHost();
    }

    public static boolean isUrlHostAndPathInWhitelist(String r100, String[] r101) {
        if (r101 != null) goto L5;
    L15:
        LogsUtil.e(f278259a, "whitelist is null");
        return false;
    L5:
        if (r101.length == 0) goto L15;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        if (isUrlHostAndPathMatchWhitelist(r100, r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L33:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L33;
        String r102 = Uri.decode(r100);
        String r103 = Uri.decode(r101);
        if (r102.contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L33;
        if (r103.contains("@") == true) goto L33;
        if (r100.contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L33;
        if (r100.contains("@") == true) goto L33;
        if (r101.equals(r100) == false) goto L20;
    L32:
        return true;
    L20:
        if (r100.startsWith(r101.concat("?")) == true) goto L32;
        if (r100.startsWith(r101.concat("#")) == true) goto L32;
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L27;
        return false;
    L27:
        List<String> r104 = UriProtector.parse(r103).getPathSegments();
        if ((UriProtector.parse(r102).getPathSegments().size() - r104.size()) == 1) goto L31;
        return false;
    L31:
        return r100.startsWith(r101);
    }

    public static boolean isUrlHostInWhitelist(String r100, String[] r101) {
        if (r101 != null) goto L5;
    L15:
        LogsUtil.e(f278259a, "whitelist is null");
        return false;
    L5:
        if (r101.length == 0) goto L15;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        if (isUrlHostMatchWhitelist(r100, r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(String r100, String r101) {
        String r102 = getHostByURI(r100);
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L27:
        LogsUtil.e(f278259a, "url or whitelist is null");
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L27;
        String r103 = a(r101);
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return false;
    L11:
        if (r103.equals(r102) == false) goto L15;
        return true;
    L15:
        if (r102.endsWith(r103) == true) goto L29;
    L26:
        return false;
    L29:
        String r104 = r102.substring(0, r102.length() - r103.length());     // Catch: Exception -> L21 IndexOutOfBoundsException -> L24
        if (r104.endsWith(".") == true) goto L19;
        return false;
    L19:
        return r104.matches("^[A-Za-z0-9.-]+$");
    L24:
        e = move-exception;
        LogsUtil.e(f278259a, "IndexOutOfBoundsException" + e.getMessage());
    L21:
        e = move-exception;
        LogsUtil.e(f278259a, "Exception : " + e.getMessage());
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String r100, String[] r101) {
        if (r101 != null) goto L5;
    L15:
        LogsUtil.e(f278259a, "whitelist is null");
        return false;
    L5:
        if (r101.length == 0) goto L15;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        if (isUrlHostSameWhitelist(r100, r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        return TextUtils.equals(getHostByURI(r100), a(r101));
    }
}

package vwb;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: classes37.dex */
public final class b {
    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L8:
        if (r100 != null) goto L11;
        return "null";
    L11:
        if (TextUtils.isEmpty(r100) == false) goto L14;
        return "empty";
    L14:
        if (r100.length() <= 24) goto L20;
        String r101 = r100.substring(0, 12);
        String r102 = r100.substring(r100.length() - 12);
        return r101 + r100.substring(12, r100.length() - 12).replaceAll("[\\s\\S]", "*") + r102;
    L20:
        return "less 24,currentLength:" + r100.length();
    L5:
        if (r100.startsWith("http") == false) goto L8;
        return UriProtector.parse(r100).getHost();
    }

    public static String b(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L26;
        j.b("SessionUtils", "getSession empty url");
        return "";
    L26:
        CookieManager r100 = a.C8047a.f557454a.f557453a;     // Catch: Throwable -> L23
        if (r100 != null) goto L9;
        j.e("LarkCookieManager", "getCookie mCookieManager is null");     // Catch: Throwable -> L23
        String r111 = null;
    L11:
        if (TextUtils.isEmpty(r111) == true) goto L21;
        StringBuffer r101 = new StringBuffer();     // Catch: Throwable -> L23
        String[] r112 = r111.split(i.f25853b);     // Catch: Throwable -> L23
        int r102 = 0;
    L14:
        if (r102 >= r112.length) goto L20;
        String[] r103 = r112[r102].trim().split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L23
        if (r103.length < 2) goto L18;
        r101.append(r103[0]);     // Catch: Throwable -> L23
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L23
        r101.append(a(r103[1]));     // Catch: Throwable -> L23
        r101.append(i.f25853b);     // Catch: Throwable -> L23
    L18:
        r102 = r102 + 1;     // Catch: Throwable -> L23
        goto L14
    L20:
        return r101.toString();
    L21:
        j.b("SessionUtils", "getSession empty cookie");     // Catch: Throwable -> L23
        return "";
    L9:
        r111 = r100.getCookie(r110);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        j.d("SessionUtils", th);
        return "";
    }
}

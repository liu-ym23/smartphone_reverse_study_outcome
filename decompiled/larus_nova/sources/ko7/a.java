package ko7;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jn7.i;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        StringBuilder r101 = new StringBuilder(r100);
        c(r101);
        return r101.toString();
    L6:
        return r100;
    }

    public static String b(String r100) {
        eo7.a r101 = eo7.a.b.f473353a;
        i r102 = r101.f473330d;
        if (r102 == null) goto L5;
        r102.getHost();
        String r103 = "";
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        r103 = "https://polaris.zijieapi.com";
    L9:
        String r104 = r103 + r100;
        if (r101.f473349w == true) goto L19;
        return r104;
    L19:
        if (TextUtils.isEmpty(r104) == true) goto L21;
        Uri r105 = UriProtector.parse(r104.trim());     // Catch: Throwable -> L18
        Uri.Builder r106 = new Uri.Builder();     // Catch: Throwable -> L18
        r106.scheme("http");     // Catch: Throwable -> L18
        r106.encodedAuthority(r105.getEncodedAuthority() + CJPayConstant.BOE_SUFFIX);     // Catch: Throwable -> L18
        r106.encodedPath(r105.getPath());     // Catch: Throwable -> L18
        r106.encodedQuery(r105.getEncodedQuery());     // Catch: Throwable -> L18
        r104 = r106.build().toString();     // Catch: Throwable -> L18
        goto L16
    L21:
        return null;
    L16:
        return r104;
    L5:
        r103 = null;
        goto L7
    }

    public static void c(StringBuilder r100) {
        if (r100.toString().indexOf(63) >= 0) goto L5;
        r100.append("?");
    L6:
        LinkedHashMap r101 = new LinkedHashMap();
        eo7.a r102 = eo7.a.b.f473353a;
        jn7.a r103 = r102.f473332f;
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.getDeviceId();
    L11:
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r101.put("ug_share_did", r105);
    L13:
        jn7.a r106 = r102.f473332f;
        if (r106 == null) goto L16;
        String r107 = r106.getAppId();
    L18:
        if (TextUtils.isEmpty(r107) == true) goto L20;
        r101.put("ug_share_aid", r107);
        r101.put("aid", r107);
    L20:
        Activity r108 = r102.h();
        if (r108 == null) goto L24;
        r104 = r108.getPackageName();
    L24:
        if (TextUtils.isEmpty(r104) == true) goto L26;
        r101.put("ug_share_package_name", r104);
    L26:
        r101.put("ug_share_v_code", String.valueOf(241059));
        r101.put("ug_share_v_name", "2.4.1-rc.59");
        r101.put("ug_share_os_api", String.valueOf(Build.VERSION.SDK_INT));
        r101.put("device_platform", "android");
        r101.put("ug_share_platform", "android");
        ArrayList r109 = new ArrayList();
        Iterator r110 = r101.entrySet().iterator();
    L28:
        if (r110.hasNext() == false) goto L30;
        Map.Entry r111 = (Map.Entry) r110.next();
        r109.add(new Pair(r111.getKey(), r111.getValue()));
        goto L28
    L30:
        StringBuilder r112 = new StringBuilder();
        Iterator r113 = r109.iterator();
    L32:
        if (r113.hasNext() == false) goto L50;
        Pair r114 = (Pair) r113.next();
        String r115 = URLEncoder.encode((String) r114.first, "UTF-8");     // Catch: UnsupportedEncodingException -> L47
        String r116 = (String) r114.second;
        if (r116 != null) goto L52;
        String r117 = "";
    L44:
        if (r112.length() <= 0) goto L46;
        r112.append("&");
    L46:
        r112.append(r115);
        r112.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r112.append(r117);
        goto L32
    L52:
        r117 = URLEncoder.encode(r116, "UTF-8");     // Catch: UnsupportedEncodingException -> L39
    L39:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L47:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L50:
        r100.append(r112.toString());
        return;
    L16:
        r107 = null;
        goto L18
    L9:
        r105 = null;
        goto L11
    L5:
        r100.append("&");
        goto L6
    }
}

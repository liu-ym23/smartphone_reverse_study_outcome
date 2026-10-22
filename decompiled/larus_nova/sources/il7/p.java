package il7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class p {
    static {
    }

    public static String a(String r100) {
        Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L28
        Set<String> r102 = UriProtector.getQueryParameterNames(r101);     // Catch: Throwable -> L28
        if (r102.contains("device_platform") == true) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(" UriUtils", "append query directly");     // Catch: Throwable -> L28
        return r101.buildUpon().appendQueryParameter("device_platform", "android").toString();
    L9:
        if (TextUtils.equals(UriProtector.getQueryParameter(r101, "device_platform"), "android") == false) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(" UriUtils", "query equals, return origin url");     // Catch: Throwable -> L28
        return r100;
    L12:
        com.bytedance.ug.sdk.luckydog.api.log.d.d(" UriUtils", "query:" + r101.getQuery());     // Catch: Throwable -> L28
        HashMap r103 = new HashMap();     // Catch: Throwable -> L28
        Iterator<String> r104 = r102.iterator();     // Catch: Throwable -> L28
    L14:
        if (r104.hasNext() == false) goto L22;
        String r105 = r104.next();     // Catch: Throwable -> L28
        if (TextUtils.equals(r105, "device_platform") == true) goto L14;
        String r106 = UriProtector.getQueryParameter(r101, r105);     // Catch: Throwable -> L28
        if (r106 != null) goto L21;
        r106 = "";
    L21:
        r103.put(r105, r106);     // Catch: Throwable -> L28
        goto L14
    L22:
        Uri.Builder r107 = UriProtector.parse(r101.buildUpon().clearQuery().toString()).buildUpon();     // Catch: Throwable -> L28
        Iterator r108 = r103.entrySet().iterator();     // Catch: Throwable -> L28
    L24:
        if (r108.hasNext() == false) goto L26;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L28
        r107.appendQueryParameter((String) r109.getKey(), (String) r109.getValue());     // Catch: Throwable -> L28
        goto L24
    L26:
        r107.appendQueryParameter("device_platform", "android");     // Catch: Throwable -> L28
        return r107.build().toString();
    L28:
        com.bytedance.ug.sdk.luckydog.api.log.d.b(" UriUtils", "append or replace query error, return origin url");
        return r100;
    }

    public static String b(String r100) {
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L15
        com.bytedance.ug.sdk.luckydog.api.log.d.d(" UriUtils", "removeQueryParameterSafely call");     // Catch: Exception -> L15
        Uri.Builder r102 = r101.buildUpon().clearQuery();     // Catch: Exception -> L15
        Iterator<String> r103 = UriProtector.getQueryParameterNames(r101).iterator();     // Catch: Exception -> L15
    L5:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();     // Catch: Exception -> L15
        if ((!Intrinsics.areEqual(r104, "device_platform")) == true) goto L8;
        r102.appendQueryParameter(r104, "");     // Catch: Exception -> L15
        goto L5
    L8:
        Iterator<String> r105 = UriProtector.getQueryParameters(r101, r104).iterator();     // Catch: Exception -> L15
    L10:
        if (r105.hasNext() == false) goto L5;
        r102.appendQueryParameter(r104, r105.next());     // Catch: Exception -> L15
        goto L10
    L13:
        return r102.toString();
    L15:
        com.bytedance.ug.sdk.luckydog.api.log.d.b(" UriUtils", "remove query error, return origin url");
        return r100;
    }
}

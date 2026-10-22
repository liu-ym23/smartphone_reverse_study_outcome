package wh3;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static String a(String r3, String r4, String r5) {
        Uri r1 = UriProtector.parse(r3);     // Catch: Exception -> L9
        String r2 = UriProtector.getQueryParameter(r1, "url");     // Catch: Exception -> L9
        if (r2 == null) goto L8;
        return d(r1, "url", d(UriProtector.parse(r2), r4, r5).toString()).toString();
    L8:
        return d(r1, r4, r5).toString();
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r3;
    }

    public static String b(String r4, String r5, Map<String, String> r6) {
        Uri r0 = UriProtector.parse(r4);     // Catch: Exception -> L17
        String r1 = UriProtector.getQueryParameter(r0, r5);     // Catch: Exception -> L17
        if (r1 != null) goto L5;
    L6:
        r1 = "{}";
    L7:
        JSONObject r2 = new JSONObject(r1);     // Catch: Exception -> L17
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();     // Catch: Exception -> L17
    L9:
        if (r7.hasNext() == false) goto L15;
        Map.Entry<String, String> r3 = r7.next();     // Catch: Exception -> L17
        if (r3.getKey() == null) goto L9;
        if (r3.getValue() == null) goto L9;
        r2.put(r3.getKey(), r3.getValue());     // Catch: Exception -> L17
        goto L9
    L15:
        return d(r0, r5, r2.toString()).toString();
    L5:
        if (r1.isEmpty() == false) goto L7;
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r4;
    }

    public static String c(String r0, String r1, String r2) {
        Uri.Builder r3 = UriProtector.parse(r0).buildUpon();
        r3.appendQueryParameter(r1, r2);
        return r3.build().toString();
    }

    public static Uri d(Uri r5, String r6, String r7) {
        if (r7 == null) goto L25;
        Uri.Builder r0 = r5.buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r5, r6)) == false) goto L7;
        r0.appendQueryParameter(r6, r7);
    L18:
        return r0.build();
    L7:
        r0.clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r5).iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) r1.next();
        if (r2.equals(r6) == false) goto L12;
        r0.appendQueryParameter(r2, r7);
        goto L9
    L12:
        Iterator r3 = UriProtector.getQueryParameters(r5, r2).iterator();
    L14:
        if (r3.hasNext() == false) goto L9;
        r0.appendQueryParameter(r2, (String) r3.next());
        goto L14
    L25:
        return r5;
    }
}

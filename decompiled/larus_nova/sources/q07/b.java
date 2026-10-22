package q07;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import o07.d;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getHost();
        String r103 = r101.getPath();
        String r104 = r101.getQuery();
        if (TextUtils.isEmpty(r102) == false) goto L19;
        if (TextUtils.isEmpty(r103) == true) goto L19;
        int r105 = 0;
    L11:
        if (r105 >= r103.length()) goto L16;
        if (r103.charAt(r105) != '/') goto L16;
        r105 = r105 + 1;
    L16:
        if (r105 >= r103.length()) goto L19;
        r103 = r103.substring(r105);
    L19:
        if (TextUtils.isEmpty(r103) == false) goto L22;
        r103 = HTTP.URL_DEFAULT;
    L24:
        StringBuilder r106 = new StringBuilder();
        r106.append(r101.getScheme());
        r106.append("://");
        r106.append(r101.getHost());
        r106.append(r103);
        if (TextUtils.isEmpty(r104) == false) goto L27;
        String r107 = "";
    L28:
        r106.append(r107);
        return r106.toString();
    L27:
        r107 = "?" + r104;
        goto L28
    L22:
        if (r103.charAt(r103.length() - 1) == '/') goto L24;
        r103 = r103.concat(HTTP.URL_DEFAULT);
        goto L24
    }

    public static WebResourceResponse c(d r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.f521640b != null) goto L7;
        return null;
    L7:
        return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(r100.f521640b));
    }

    public static String a(d r100, String r101, String r102) {
        if (r100 == null) goto L17;
        Map<String, List<String>> r103 = r100.f521642d;
        if (r103 == null) goto L17;
        if (r103.isEmpty() == true) goto L17;
        List<String> r104 = r100.f521642d.get(r101);
        if (r104 != null) goto L11;
    L12:
        r104 = r100.f521642d.get(r102);
    L13:
        if (r104 == null) goto L17;
        if (r104.isEmpty() == true) goto L17;
        return (String) ListProtector.get(r104, 0);
    L11:
        if (r104.isEmpty() == false) goto L13;
    L17:
        return null;
    }
}

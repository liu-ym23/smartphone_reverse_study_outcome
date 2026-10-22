package ry7;

import android.text.TextUtils;
import com.larksuite.component.blockit.d;
import com.larksuite.framework.http.request.HttpHeaders;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.larksuite.component.blockit.a f539909a;

    public static HttpHeaders a() {
        HttpHeaders r100 = new HttpHeaders();
        StringBuilder r101 = new StringBuilder("session=");
        String r102 = ((d) ApiUtils.getApi(d.class)).getSession();
        if (TextUtils.isEmpty(r102) == false) goto L6;
        r102 = "XN0YXJ0-a8da7d90-9b05-4ad0-9f16-b22ac409410g-WVuZA";
    L6:
        r101.append(r102);
        r100.put("Cookie", r101.toString());
        r100.put("Accept-Language", b());
        return r100;
    }

    public static String b() {
        Locale r100 = ((d) ApiUtils.getApi(d.class)).getLocale();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLanguage().toLowerCase() + "-" + r100.getCountry().toUpperCase();
    }
}

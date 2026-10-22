package qx6;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f535148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f535149b = null;

    static {
        f535148a = new HashMap();
        f535149b = new HashMap();
    }

    public static String a(String r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        if (StringsKt.isBlank(r110) == false) goto L8;
        return null;
    L8:
        HashMap<String, String> r100 = f535149b;
        if (r100.containsKey(r110) == true) goto L11;
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r110), "bundle");
        if (r101 != null) goto L15;
        return null;
    L15:
        List r102 = StringsKt.split$default(r101, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if (r102.size() == 2) goto L18;
        return null;
    L18:
        r100.put(r110, (String) ListProtector.get(r102, 0));
        return (String) ListProtector.get(r102, 0);
    L11:
        return r100.get(r110);
    }
}

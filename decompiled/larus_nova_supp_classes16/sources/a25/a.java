package a25;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import du5.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final Set<String> a = null;
    public static final Set<String> b = null;

    static {
        a = Collections.synchronizedSet(new HashSet());
        b = Collections.synchronizedSet(new HashSet());
    }

    public static void a(Context r2, String r3, RouteBean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        String r5 = null;
    L6:
        ((h) org.koin.java.a.a(h.class)).R3(r2, r5, r4);
        tt5.a.h("MinutesThreeInOneRedirector", "openRedirectUrl, url: " + b.h(r5));
        return;
    L5:
        r5 = "https://www.doubao.com/docx/" + r3;
        goto L6
    }
}

package io.noties.markwon.html.jsoup.nodes;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import tsc.x;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f492580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, String> f492581b;

    static {
        boolean r100 = x.f547490a;
        if (x.f547490a == false) goto L5;
        f492581b = new CommonMarkEntities$1();
        return;
    L5:
        b();
    }

    public static void b() {
        Field r100 = tvc.b.class.getDeclaredField(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);     // Catch: Throwable -> L4
        r100.setAccessible(true);     // Catch: Throwable -> L4
        Map<String, String> r101 = (Map) r100.get(null);     // Catch: Throwable -> L4
    L6:
        f492580a = r101;
        return;
    L4:
        th = move-exception;
        Map<String, String> r102 = Collections.emptyMap();
        th.printStackTrace();
        r101 = r102;
        goto L6
    }

    public static String a(String r100) {
        Map<String, String> r101 = f492581b;
        if (r101 == null) goto L5;
        String r102 = (String) ((HashMap) r101).get(r100);
    L6:
        if (r102 == null) goto L9;
        return r102;
    L9:
        if (f492580a != null) goto L12;
        b();
    L12:
        return f492580a.get(r100);
    L5:
        r102 = null;
        goto L6
    }
}

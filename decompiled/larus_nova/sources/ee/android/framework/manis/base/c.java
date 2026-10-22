package ee.android.framework.manis.base;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, String> f472269a = null;

    static {
        f472269a = new HashMap();
    }

    public static String a(Context r100, Class<?> r101) {
        Map<Class, String> r102 = f472269a;
        String r103 = (String) ((HashMap) r102).get(r101);
        if (TextUtils.isEmpty(r103) == true) goto L5;
        return r103;
    L5:
        monitor-enter(r102);
        String r104 = (String) ((HashMap) r102).get(r101);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r104) == true) goto L10;
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r104;
    L10:
        String r105 = r101.getName();     // Catch: Throwable -> L16
        krc.b.c("ProviderProcessMatcher", "getTargetProcess serviceClass:".concat(r105));     // Catch: Throwable -> L16
        String r106 = null;
        if (TextUtils.isEmpty(null) == false) goto L13;
        krc.b.c("UriMatcher", "getUri process is empty for Main Process class:".concat(r105));     // Catch: Throwable -> L16
        r106 = "";
    L13:
        String r107 = String.format("content://%s.IPC.%sIPCProvider/main", new Object[]{r100.getPackageName(), r106}) + "?class=" + r105;     // Catch: Throwable -> L16
        ((HashMap) r102).put(r101, r107);     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r107;
    L16:
        th = move-exception;
        throw th;
    }
}

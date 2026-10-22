package ty2;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f547963a;

    public static void d() {
        if (f547963a == true) goto L5;
        return;
    L5:
        b("ContainerStandardApi");
    }

    public static void a(String r100) {
        if (f547963a == true) goto L5;
        return;
    L5:
        b(r100);
    }

    public static void b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (r100.startsWith("hybrid_multi_monitor_") == true) goto L9;
        "hybrid_multi_monitor_".concat(r100);
        return;
    }

    public static void c(String r100) {
        if (f547963a == true) goto L5;
        return;
    L5:
        b(r100);
    }
}

package h97;

import android.os.Build;
import android.text.TextUtils;
import zg4.i;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f484330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f484331b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f484332c = -1;

    public static String a() {
        if (f484330a != null) goto L21;
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L19
        if (Build.SUPPORTED_ABIS.length <= 0) goto L13;
        int r101 = 0;
    L7:
        String[] r102 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L19
        if (r101 >= r102.length) goto L15;
        r100.append(r102[r101]);     // Catch: Exception -> L19
        if (r101 == (r102.length - 1)) goto L12;
        r100.append(", ");     // Catch: Exception -> L19
    L12:
        r101 = r101 + 1;     // Catch: Exception -> L19
    L15:
        if (TextUtils.isEmpty(r100.toString()) == false) goto L17;
        f484330a = "unknown";     // Catch: Exception -> L19
    L17:
        f484330a = r100.toString();     // Catch: Exception -> L19
        goto L21
    L13:
        r100 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L19
    L19:
        boolean r103 = i.f572087c;
        f484330a = "unknown";
    L21:
        return f484330a;
    }
}

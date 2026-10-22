package evc;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;

/* JADX INFO: loaded from: classes5.dex */
public final class f {
    public static boolean a(String r100) {
        if (r100.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r100.equals("PATCH") == true) goto L14;
        if (r100.equals("PUT") == true) goto L14;
        if (r100.equals("DELETE") == true) goto L14;
        if (r100.equals("MOVE") == true) goto L14;
        return false;
    }

    public static boolean b(String r100) {
        if (r100.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals("HEAD") == true) goto L7;
        return true;
    }

    public static boolean c(String r100) {
        if (r100.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r100.equals("PUT") == true) goto L14;
        if (r100.equals("PATCH") == true) goto L14;
        if (r100.equals(OpenNetMethod.PROPPATCH) == true) goto L14;
        if (r100.equals(OpenNetMethod.REPORT) == true) goto L14;
        return false;
    }
}

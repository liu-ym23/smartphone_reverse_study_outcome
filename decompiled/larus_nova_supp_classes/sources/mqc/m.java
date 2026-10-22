package mqc;

import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m {
    public static boolean a() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean b() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 30) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }
}

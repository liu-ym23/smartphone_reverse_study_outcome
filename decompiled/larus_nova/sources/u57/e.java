package u57;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static boolean a() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 28) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }
}

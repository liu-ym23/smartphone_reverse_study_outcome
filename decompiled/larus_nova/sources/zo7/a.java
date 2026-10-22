package zo7;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static String a() {
        String r100 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r100) == false) goto L10;
        String r101 = Build.BRAND;
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return "unknown";
    L11:
        return r101.toLowerCase();
    L10:
        return r100.toLowerCase();
    }
}

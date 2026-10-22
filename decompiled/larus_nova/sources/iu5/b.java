package iu5;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        if (TextUtils.equals(UriProtector.getQueryParameter(r101, "sourceType"), "feed") == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        if (TextUtils.equals(UriProtector.getQueryParameter(r101, "sourceType"), "push") == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}

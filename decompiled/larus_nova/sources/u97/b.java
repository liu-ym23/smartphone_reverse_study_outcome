package u97;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static String a(String r100) {
        Uri r101 = UriProtector.parse(r100);
        if (r101.isHierarchical() == true) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101.getScheme()) == false) goto L7;
        return r100;
    L7:
        return "//" + r101.getAuthority() + r101.getPath();
    }

    public static String b(String r100) {
        Uri r101 = UriProtector.parse(r100);
        if (r101.isHierarchical() == true) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101.getScheme()) == true) goto L9;
        return r101.getScheme() + "://" + r101.getAuthority() + r101.getPath();
    L9:
        return "//" + r101.getAuthority() + r101.getPath();
    }

    public static boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return UriProtector.parse(r100).isHierarchical();
    }
}

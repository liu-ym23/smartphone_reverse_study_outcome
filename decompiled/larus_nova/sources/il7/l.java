package il7;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class l {
    public static boolean a(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L52
        boolean r103 = b(r102.getScheme());     // Catch: Throwable -> L52
        String r104 = r102.getHost();     // Catch: Throwable -> L52
        if (r103 == false) goto L11;
        if ("polaris".equals(r104) == false) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L57;
        if (TextUtils.isEmpty(r100) == true) goto L30;
        Uri r106 = UriProtector.parse(r100);     // Catch: Throwable -> L51
        boolean r107 = b(r106.getScheme());     // Catch: Throwable -> L51
        String r108 = r106.getHost();     // Catch: Throwable -> L51
        List<String> r109 = r106.getPathSegments();     // Catch: Throwable -> L51
        if (r109.size() <= 0) goto L19;
        String r110 = (String) ListProtector.get(r109, 0);     // Catch: Throwable -> L51
    L20:
        if (r107 == false) goto L30;
        if ("polaris".equals(r108) == false) goto L30;
        if ("lynx".equals(r110) == false) goto L26;
    L29:
        boolean r111 = true;
    L31:
        if (r111 == false) goto L33;
        return true;
    L33:
        if (TextUtils.isEmpty(r100) == true) goto L46;
        Uri r112 = UriProtector.parse(r100);
        boolean r113 = b(r112.getScheme());
        String r114 = r112.getHost();
        List<String> r115 = r112.getPathSegments();
        if (r115.size() <= 0) goto L38;
        r101 = (String) ListProtector.get(r115, 0);
    L38:
        if (r113 == false) goto L46;
        if ("polaris".equals(r114) == false) goto L46;
        if ("lynx_popup".equals(r101) == false) goto L44;
    L45:
        boolean r116 = true;
    L47:
        if (r116 == true) goto L59;
        return false;
    L59:
        return true;
    L44:
        if ("lynxview_popup".equals(r101) == true) goto L45;
    L46:
        r116 = false;
        goto L47
    L26:
        if (ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW.equals(r110) == true) goto L29;
        if ("lynx_page".equals(r110) == false) goto L30;
    L19:
        r110 = "";
    L30:
        r111 = false;
        goto L31
    L57:
        return true;
    L11:
        r105 = false;
        goto L12
    }

    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (AppConstants.SCHEME_SS_LOCAL.equals(r100) == false) goto L8;
        return true;
    L8:
        Application r101 = rk7.m.f538347a;
        int r102 = rk7.m.f();
        if (r100.equals(AppConstants.SCHEME_SNSSDK + r102) == false) goto L12;
        return true;
    L12:
        if (r100.equals("polaris" + r102) == false) goto L14;
        return true;
    L14:
        return false;
    }
}

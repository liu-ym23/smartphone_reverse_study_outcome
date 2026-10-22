package fx4;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static boolean e(int r100) {
        if (r100 != 22) goto L5;
    L14:
        return true;
    L5:
        if (r100 == 30) goto L14;
        if (r100 == 3) goto L14;
        if (r100 == 8) goto L14;
        if (r100 == 84) goto L14;
        return false;
    }

    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return false;
    L9:
        return TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r100), "open_type"), DocViewModel.ANNOUNCE);
    L7:
        tt5.a.k("DocumentTypeUtil", "illegal url to judge is announce doc");
        return false;
    }

    public static boolean b(BearUrl r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r100.f222571l) == false) goto L7;
        return false;
    L7:
        if (r100.f222571l.startsWith(HTTP.URL_DEFAULT) == false) goto L9;
        String r101 = r100.f222571l;
    L11:
        return s45.a.d(r101);
    L9:
        r101 = HTTP.URL_DEFAULT + r100.f222571l;
        goto L11
    }

    public static boolean c(int r100) {
        e r101 = e.d(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (d(r101.getType()) == false) goto L7;
        return true;
    }

    public static boolean d(String r100) {
        if (TextUtils.equals(r100, e.f541304o.getType()) == false) goto L5;
    L18:
        return true;
    L5:
        if (TextUtils.equals(r100, e.f541297h.getType()) == true) goto L18;
        if (TextUtils.equals(r100, e.f541296g.getType()) == true) goto L18;
        if (TextUtils.equals(r100, e.f541298i.getType()) == true) goto L18;
        if (TextUtils.equals(r100, e.f541299j.getType()) == true) goto L18;
        if (TextUtils.equals(r100, e.f541300k.getType()) == true) goto L18;
        if (TextUtils.equals(r100, e.f541302m.getType()) == true) goto L18;
        return false;
    }

    public static boolean f(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.contains("subscription=1") == false) goto L6;
        return true;
    }

    public static boolean g(BearUrl r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.equals(r100.f222560a, e.f541303n.getType()) == false) goto L6;
        return true;
    }
}

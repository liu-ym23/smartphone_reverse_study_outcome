package fx4;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static boolean e(int r1) {
        if (r1 != 22) goto L5;
    L14:
        return true;
    L5:
        if (r1 == 30) goto L14;
        if (r1 == 3) goto L14;
        if (r1 == 8) goto L14;
        if (r1 == 84) goto L14;
        return false;
    }

    public static boolean a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return false;
    L9:
        return TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r2), "open_type"), DocViewModel.ANNOUNCE);
    L7:
        tt5.a.k("DocumentTypeUtil", "illegal url to judge is announce doc");
        return false;
    }

    public static boolean b(BearUrl r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r2.l) == false) goto L7;
        return false;
    L7:
        if (r2.l.startsWith("/") == false) goto L9;
        String r3 = r2.l;
    L11:
        return s45.a.d(r3);
    L9:
        r3 = "/" + r2.l;
        goto L11
    }

    public static boolean c(int r0) {
        e r1 = e.d(r0);
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (d(r1.getType()) == false) goto L7;
        return true;
    }

    public static boolean d(String r1) {
        if (TextUtils.equals(r1, e.o.getType()) == false) goto L5;
    L18:
        return true;
    L5:
        if (TextUtils.equals(r1, e.h.getType()) == true) goto L18;
        if (TextUtils.equals(r1, e.g.getType()) == true) goto L18;
        if (TextUtils.equals(r1, e.i.getType()) == true) goto L18;
        if (TextUtils.equals(r1, e.j.getType()) == true) goto L18;
        if (TextUtils.equals(r1, e.k.getType()) == true) goto L18;
        if (TextUtils.equals(r1, e.m.getType()) == true) goto L18;
        return false;
    }

    public static boolean f(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.contains("subscription=1") == false) goto L6;
        return true;
    }

    public static boolean g(BearUrl r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.equals(r1.a, e.n.getType()) == false) goto L6;
        return true;
    }
}

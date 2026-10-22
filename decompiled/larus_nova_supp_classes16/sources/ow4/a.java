package ow4;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.mt.protector.impl.UriProtector;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static String a;

    public static boolean b(int r1) {
        if (r1 != e.g.b) goto L5;
        return true;
    L5:
        if (r1 != e.o.b) goto L7;
        return true;
    L7:
        if (r1 != e.h.b) goto L9;
        return true;
    L9:
        if (r1 != e.k.b) goto L11;
        return true;
    L11:
        if (r1 != e.i.b) goto L13;
        return true;
    L13:
        if (r1 != e.m.b) goto L15;
        return true;
    L15:
        if (r1 != e.n.b) goto L17;
        return true;
    L17:
        if (r1 == e.j.b) goto L29;
        return false;
    L29:
        return true;
    }

    public static String a(String r3, String r4) {
        Uri.Builder r0 = UriProtector.parse(r3).buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r0.build(), DocRedirectToDocxPlugin.FROM)) == false) goto L6;
        r0.appendQueryParameter(DocRedirectToDocxPlugin.FROM, r4);
        return r0.build().toString();
    L6:
        return r3;
    }
}

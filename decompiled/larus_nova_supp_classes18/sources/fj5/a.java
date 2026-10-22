package fj5;

import android.text.TextUtils;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import s45.g;
import s45.h;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static String a() {
        h r0 = g.a;
        return g.a.a("dlp_banner_help_center", "809587899257", "593647785207", null);
    }

    public static boolean b(int r2) {
        if (r2 != e.g.b) goto L6;
        return true;
    L6:
        if (r2 != e.k.b) goto L9;
        return true;
    L9:
        if (r2 != e.l.b) goto L12;
        return true;
    L12:
        if (r2 != e.i.b) goto L15;
        return true;
    L15:
        if (r2 != e.o.b) goto L18;
        return true;
    L18:
        if (r2 != e.h.b) goto L21;
        return true;
    L21:
        if (r2 != e.m.b) goto L25;
        return c.a.a.g("ccm.mobile.slides_enabled");
    L25:
        if (sbb.g.b(r2) == false) goto L27;
        return true;
    L27:
        return false;
    }

    public static boolean e(DocMetaInfo r7) {
        boolean r1 = true;
        if (r7 != null) goto L5;
    L22:
        StringBuilder r3 = new StringBuilder("isForceSecret false docMetaInfo: ");
        if (r7 == null) goto L26;
        r1 = false;
    L26:
        r3.append(r1);
        tt5.a.h("SecretHelper", r3.toString());
        return false;
    L5:
        if (r7.getDoubleCheckDefaultLabel() == true) goto L7;
    L11:
        boolean r4 = false;
    L13:
        if (r7.isSecretUnSet() == true) goto L15;
    L17:
        boolean r5 = false;
    L18:
        tt5.a.h("SecretHelper", "isForceSecret, doubleCheck: " + r4 + ", mustSetButNotSet: " + r5);
        if (r4 == true) goto L21;
        if (r5 == false) goto L22;
    L21:
        return true;
    L15:
        if (r7.getMustSetLabel() == false) goto L17;
        r5 = true;
        goto L18
    L7:
        if (r7.isSecretAdminDefault() == false) goto L11;
        if (TextUtils.equals(r7.getDefaultSecretLabelId(), r7.getSecretLevel().getId()) == false) goto L11;
        r4 = true;
        goto L13
    }

    public static boolean c(int r0, boolean r1) {
        if (r1 == true) goto L4;
        return false;
    L4:
        return b(r0);
    }

    public static boolean d(DocMetaInfo r2, IDocUserPermission r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L9;
        if (r3.canModifySecretLevel() == false) goto L9;
        return e(r2);
    L9:
        StringBuilder r0 = new StringBuilder("isForceSecret false docMetaInfo: ");
        if (r2 != null) goto L12;
        boolean r4 = true;
    L13:
        r0.append(r4);
        r0.append(" userPermission: ");
        r0.append(r3);
        tt5.a.h("SecretHelper", r0.toString());
        return false;
    L12:
        r4 = false;
        goto L13
    }
}

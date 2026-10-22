package fj5;

import android.text.TextUtils;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import s45.g;
import s45.h;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static String a() {
        h r100 = g.f540568a;
        return g.a.a("dlp_banner_help_center", "809587899257", "593647785207", null);
    }

    public static boolean b(int r100) {
        if (r100 != e.f541296g.f541317b) goto L6;
        return true;
    L6:
        if (r100 != e.f541300k.f541317b) goto L9;
        return true;
    L9:
        if (r100 != e.f541301l.f541317b) goto L12;
        return true;
    L12:
        if (r100 != e.f541298i.f541317b) goto L15;
        return true;
    L15:
        if (r100 != e.f541304o.f541317b) goto L18;
        return true;
    L18:
        if (r100 != e.f541297h.f541317b) goto L21;
        return true;
    L21:
        if (r100 != e.f541302m.f541317b) goto L25;
        return c.a.f206237a.g("ccm.mobile.slides_enabled");
    L25:
        if (sbb.g.b(r100) == false) goto L27;
        return true;
    L27:
        return false;
    }

    public static boolean e(DocMetaInfo r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L22:
        StringBuilder r102 = new StringBuilder("isForceSecret false docMetaInfo: ");
        if (r100 == null) goto L26;
        r101 = false;
    L26:
        r102.append(r101);
        tt5.a.h("SecretHelper", r102.toString());
        return false;
    L5:
        if (r100.getDoubleCheckDefaultLabel() == true) goto L7;
    L11:
        boolean r103 = false;
    L13:
        if (r100.isSecretUnSet() == true) goto L15;
    L17:
        boolean r104 = false;
    L18:
        tt5.a.h("SecretHelper", "isForceSecret, doubleCheck: " + r103 + ", mustSetButNotSet: " + r104);
        if (r103 == true) goto L21;
        if (r104 == false) goto L22;
    L21:
        return true;
    L15:
        if (r100.getMustSetLabel() == false) goto L17;
        r104 = true;
        goto L18
    L7:
        if (r100.isSecretAdminDefault() == false) goto L11;
        if (TextUtils.equals(r100.getDefaultSecretLabelId(), r100.getSecretLevel().getId()) == false) goto L11;
        r103 = true;
        goto L13
    }

    public static boolean c(int r100, boolean r101) {
        if (r101 == true) goto L4;
        return false;
    L4:
        return b(r100);
    }

    public static boolean d(DocMetaInfo r100, IDocUserPermission r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        if (r101.canModifySecretLevel() == false) goto L9;
        return e(r100);
    L9:
        StringBuilder r102 = new StringBuilder("isForceSecret false docMetaInfo: ");
        if (r100 != null) goto L12;
        boolean r103 = true;
    L13:
        r102.append(r103);
        r102.append(" userPermission: ");
        r102.append(r101);
        tt5.a.h("SecretHelper", r102.toString());
        return false;
    L12:
        r103 = false;
        goto L13
    }
}

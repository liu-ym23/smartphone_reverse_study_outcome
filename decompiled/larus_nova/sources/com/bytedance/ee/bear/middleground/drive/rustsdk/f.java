package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class f {
    public static String a(String r100, String r101, String r102) {
        tt5.a.h("DriveRustDataUtils", "assembleUrl, mountPoint: " + r100 + ", fileToken: " + du5.b.i(r101) + ", mountNodeToken: " + du5.b.i(r102));
        boolean r103 = TextUtils.equals(r100, "wiki");
        if (r103 == false) goto L5;
        sbb.e r104 = sbb.e.f541303n;
    L6:
        String r105 = r104.getType();
        if (r103 == true) goto L11;
        r102 = r101;
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L14;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, fileToken is null or empty.");
        return null;
    L14:
        String r106 = s45.p.a().ua(sbb.e.f541301l.getType(), r101, "");
        if (TextUtils.isEmpty(r106) == false) goto L43;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, srcUrl is null or empty.");
        return null;
    L43:
        Uri r107 = UriProtector.parse(r106);     // Catch: Exception -> L21
    L24:
        if (r107 != null) goto L27;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, srcUri invalid.");
        return null;
    L27:
        String r108 = r107.getScheme();
        String r109 = r107.getAuthority();
        tt5.a.h("DriveRustDataUtils", "assembleUrl, srcScheme: " + r108 + ", srcAuthority: " + r109);
        if (TextUtils.isEmpty(r108) == false) goto L30;
    L41:
        tt5.a.k("DriveRustDataUtils", "assembleUrl, srcUri invalid.");
        return null;
    L30:
        if (TextUtils.isEmpty(r109) == true) goto L41;
        String r110 = new Uri.Builder().scheme(r108).authority(r109).appendPath(r105).appendPath(r102).build().toString();     // Catch: Exception -> L34
    L37:
        if (TextUtils.isEmpty(r110) == false) goto L40;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, targetUrl invalid.");
        return null;
    L40:
        return r110;
    L34:
        e = move-exception;
        tt5.a.e("DriveRustDataUtils", "assembleUrl, error when build targetUri", e, false);
        r110 = null;
    L21:
        e = move-exception;
        tt5.a.e("DriveRustDataUtils", "assembleUrl, error when parse srcUri", e, false);
        r107 = null;
        goto L24
    L5:
        r104 = sbb.e.f541301l;
        goto L6
    }
}

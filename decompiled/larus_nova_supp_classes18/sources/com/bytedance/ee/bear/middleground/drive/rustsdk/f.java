package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static String a(String r7, String r8, String r9) {
        tt5.a.h("DriveRustDataUtils", "assembleUrl, mountPoint: " + r7 + ", fileToken: " + du5.b.i(r8) + ", mountNodeToken: " + du5.b.i(r9));
        boolean r10 = TextUtils.equals(r7, DocumentType.WIKI_NAME);
        if (r10 == false) goto L5;
        sbb.e r0 = sbb.e.n;
    L6:
        String r1 = r0.getType();
        if (r10 == true) goto L11;
        r9 = r8;
    L11:
        if (TextUtils.isEmpty(r9) == false) goto L14;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, fileToken is null or empty.");
        return null;
    L14:
        String r11 = s45.p.a().ua(sbb.e.l.getType(), r8, "");
        if (TextUtils.isEmpty(r11) == false) goto L43;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, srcUrl is null or empty.");
        return null;
    L43:
        Uri r12 = UriProtector.parse(r11);     // Catch: Exception -> L21
    L24:
        if (r12 != null) goto L27;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, srcUri invalid.");
        return null;
    L27:
        String r4 = r12.getScheme();
        String r13 = r12.getAuthority();
        tt5.a.h("DriveRustDataUtils", "assembleUrl, srcScheme: " + r4 + ", srcAuthority: " + r13);
        if (TextUtils.isEmpty(r4) == false) goto L30;
    L41:
        tt5.a.k("DriveRustDataUtils", "assembleUrl, srcUri invalid.");
        return null;
    L30:
        if (TextUtils.isEmpty(r13) == true) goto L41;
        String r14 = new Uri.Builder().scheme(r4).authority(r13).appendPath(r1).appendPath(r9).build().toString();     // Catch: Exception -> L34
    L37:
        if (TextUtils.isEmpty(r14) == false) goto L40;
        tt5.a.k("DriveRustDataUtils", "assembleUrl, targetUrl invalid.");
        return null;
    L40:
        return r14;
    L34:
        e = move-exception;
        tt5.a.e("DriveRustDataUtils", "assembleUrl, error when build targetUri", e, false);
        r14 = null;
    L21:
        e = move-exception;
        tt5.a.e("DriveRustDataUtils", "assembleUrl, error when parse srcUri", e, false);
        r12 = null;
        goto L24
    L5:
        r0 = sbb.e.l;
        goto L6
    }
}

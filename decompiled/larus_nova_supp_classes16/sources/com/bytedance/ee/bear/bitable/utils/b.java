package com.bytedance.ee.bear.bitable.utils;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static String a(String r1) {
        if (TextUtils.equals(r1, sbb.e.h.getType()) == false) goto L7;
        return "from_parent_sheet";
    L7:
        if (TextUtils.equals(r1, sbb.e.g.getType()) == false) goto L11;
        return "from_parent_docs";
    L11:
        if (TextUtils.equals(r1, sbb.e.o.getType()) == false) goto L15;
        return "from_parent_docx";
    L15:
        if (TextUtils.equals(r1, sbb.e.i.getType()) == false) goto L18;
        return "from_parent_bitable";
    L18:
        return "from_parent_document";
    }

    public static boolean b(BearUrl r3) {
        if (r3 == null) goto L16;
        String r4 = r3.l;
        if (s45.a.c() == false) goto L7;
        boolean r5 = !s45.a.b(s45.a.a(r4, "/share/base/add/"));
    L13:
        if (r5 == false) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (s45.a.b(r4) == false) goto L9;
    L11:
        r5 = false;
        goto L13
    L9:
        if (r4.startsWith("/base/add/") == false) goto L11;
        r5 = true;
        goto L13
    L16:
        return false;
    }
}

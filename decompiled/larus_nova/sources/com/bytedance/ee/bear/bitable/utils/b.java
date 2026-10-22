package com.bytedance.ee.bear.bitable.utils;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static String a(String r100) {
        if (TextUtils.equals(r100, sbb.e.f541297h.getType()) == false) goto L7;
        return "from_parent_sheet";
    L7:
        if (TextUtils.equals(r100, sbb.e.f541296g.getType()) == false) goto L11;
        return "from_parent_docs";
    L11:
        if (TextUtils.equals(r100, sbb.e.f541304o.getType()) == false) goto L15;
        return "from_parent_docx";
    L15:
        if (TextUtils.equals(r100, sbb.e.f541298i.getType()) == false) goto L18;
        return "from_parent_bitable";
    L18:
        return "from_parent_document";
    }

    public static boolean b(BearUrl r100) {
        if (r100 == null) goto L16;
        String r101 = r100.f222571l;
        if (s45.a.c() == false) goto L7;
        boolean r102 = !s45.a.b(s45.a.a(r101, "/share/base/add/"));
    L13:
        if (r102 == false) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (s45.a.b(r101) == false) goto L9;
    L11:
        r102 = false;
        goto L13
    L9:
        if (r101.startsWith("/base/add/") == false) goto L11;
        r102 = true;
        goto L13
    L16:
        return false;
    }
}

package com.suite.lark.emm.impl.clipboard.utils;

import android.content.ClipData;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;

/* JADX INFO: loaded from: classes40.dex */
public final class a {
    public static final boolean a() {
        return ((doc.d) k.a(LarkContext.getApplication(), doc.d.class)).X4();
    }

    public static final String b(ClipData r100) {
        if (r100 != null) goto L5;
    L19:
        return "";
    L5:
        if (r100.getItemCount() == 0) goto L19;
        int r101 = r100.getItemCount();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L19;
        String r103 = r100.getItemAt(r102).getHtmlText();
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L17;
        r102 = r102 + 1;
        goto L8
    L17:
        return r103;
    L12:
        if (r103.length() == 0) goto L15;
        r104 = false;
        goto L16
    }

    public static final CharSequence c(ClipData r100) {
        if (r100 != null) goto L5;
    L19:
        return "";
    L5:
        if (r100.getItemCount() == 0) goto L19;
        int r101 = r100.getItemCount();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L19;
        CharSequence r103 = r100.getItemAt(r102).getText();
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L17;
        r102 = r102 + 1;
        goto L8
    L17:
        return r103;
    L12:
        if (r103.length() == 0) goto L15;
        r104 = false;
        goto L16
    }
}

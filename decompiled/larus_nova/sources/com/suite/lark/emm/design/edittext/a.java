package com.suite.lark.emm.design.edittext;

import android.content.ClipData;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f460432a = 0;

    static {
    }

    public static CharSequence a(ClipData r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.getItemCount() == 0) goto L22;
        int r101 = r100.getItemCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L23;
        CharSequence r103 = r100.getItemAt(r102).getText();
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L16;
        r102 = r102 + 1;
        goto L7
    L16:
        return r103;
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
        goto L15
    L23:
        return "";
    L22:
        return "";
    }
}

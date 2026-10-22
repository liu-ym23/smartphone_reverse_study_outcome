package com.larus.bmhome.view.screenmenu;

import android.content.Context;

/* JADX INFO: loaded from: classes26.dex */
public final class d0 {
    public static final CharSequence a(Context r100, l0 r101) {
        String r102 = r101.f317322c;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L16;
        int r104 = r101.f317321b;
        if (r104 != 0) goto L17;
        return "";
    L17:
        return r100.getText(r104);
    L16:
        return r101.f317322c;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}

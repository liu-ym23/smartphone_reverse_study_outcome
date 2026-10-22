package com.ss.android.lark.widget.richtext;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class h {
    public static int a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L18:
        return 0;
    L5:
        if (TextUtils.isEmpty(r100.trim()) == true) goto L18;
        String r101 = r100.trim();
        if (r101.charAt(0) == '#') goto L11;
        r101 = "#".concat(r101);
    L11:
        if (r101.length() == 7) goto L17;
        if (r101.length() == 9) goto L17;
        return 0;
    L17:
        return ColorProtector.parseColor(r101);
    }
}

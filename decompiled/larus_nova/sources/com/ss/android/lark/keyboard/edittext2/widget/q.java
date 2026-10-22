package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.PatternProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class q implements InputFilter, d {

    public static final class a {
    }

    static {
    }

    public q() {
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (PatternProtector.compile("[\\u0737]|[\\u0736]").matcher(r100).find() == true) goto L8;
        return r100;
    L8:
        return "";
    }
}

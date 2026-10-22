package com.larus.dora.impl.device.settings.rename;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.rename.a$a, reason: collision with other inner class name */
    public static final class C4238a {
    }

    static {
    }

    public a() {
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        boolean r106 = false;
        if (r100 != null) goto L5;
    L7:
        if (r106 == false) goto L9;
        return null;
    L9:
        return "";
    L5:
        if (new Regex("^[a-zA-Z0-9_ \\u4e00-\\u9fa5\\u278b-\\u2792]+$").matches(r100) != true) goto L7;
        r106 = true;
        goto L7
    }
}

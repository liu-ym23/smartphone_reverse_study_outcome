package com.bytedance.android.shopping.service;

import android.graphics.Typeface;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.lynx.tasm.behavior.shadow.text.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements g.b {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Typeface a(String r4, int r5) {
        if (r4 == null) goto L20;
        int r6 = r4.hashCode();
        if (r6 == (-1461481587)) goto L18;
        if (r6 == (-981614931)) goto L15;
        if (r6 != 1866312093) goto L20;
        if (r4.equals("DouyinNumberABC-Medium") == false) goto L20;
        return ECFontHelper.e.b("DouyinNumberABC", 400, false);
    L15:
        if (r4.equals("DouyinNumberABC-Bold") == false) goto L20;
        return ECFontHelper.e.b("DouyinNumberABC", 500, false);
    L18:
        if (r4.equals("DouyinNumberABC-ExtraBold") == false) goto L20;
        return ECFontHelper.e.b("DouyinNumberABC", 600, false);
    L20:
        return null;
    }
}

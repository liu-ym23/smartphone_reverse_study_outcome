package com.bytedance.android.shopping.extensions;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static String a(Long r6) {
        Intrinsics.checkNotNullParameter("", "default");
        if (r6 == null) goto L25;
        r6.longValue();
        if (r6.longValue() <= 0) goto L27;
        String r1 = String.valueOf(r6.longValue() / ((double) 100));
        if (StringsKt.contains$default(r1, '.', false, 2, null) == false) goto L28;
    L10:
        Character r7 = StringsKt.lastOrNull(r1);
        if (r7 == null) goto L16;
        if (r7.charValue() != '0') goto L16;
        r1 = StringsKt.removeRange(r1, r1.length() - 1, r1.length()).toString();
    L16:
        Character r8 = StringsKt.lastOrNull(r1);
        if (r8 != null) goto L20;
        return r1;
    L20:
        if (r8.charValue() == '.') goto L22;
        return r1;
    L22:
        return StringsKt.removeRange(r1, r1.length() - 1, r1.length()).toString();
    L28:
        return r1;
    L27:
        return "";
    L25:
        return "";
    }
}

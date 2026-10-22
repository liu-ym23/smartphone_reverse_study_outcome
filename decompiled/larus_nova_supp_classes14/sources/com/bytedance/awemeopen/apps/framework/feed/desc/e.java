package com.bytedance.awemeopen.apps.framework.feed.desc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final CharSequence a(CharSequence r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 < 0) goto L21;
        if (r4 < 0) goto L22;
        int r0 = r4 - r3;
        if (r0 >= 1) goto L8;
        return r2;
    L8:
        if (r4 <= r2.length()) goto L11;
        return r2;
    L11:
        if (Character.isHighSurrogate(r2.charAt((r0 + r3) - 1)) == false) goto L13;
        r0 = r0 - 1;
    L13:
        if (r3 > 0) goto L15;
    L17:
        if (r0 > 0) goto L20;
        r0 = 0;
    L20:
        return r2.subSequence(r3, r0 + r3);
    L15:
        if (Character.isLowSurrogate(r2.charAt(r3)) == false) goto L17;
        r3 = r3 + 1;
        r0 = r0 - 1;
        goto L17
    L22:
        return r2;
    L21:
        return r2;
    }
}

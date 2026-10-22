package com.bytedance.awemeopen.apps.framework.feed.desc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {
    public static final CharSequence a(CharSequence r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 < 0) goto L21;
        if (r102 < 0) goto L22;
        int r103 = r102 - r101;
        if (r103 >= 1) goto L8;
        return r100;
    L8:
        if (r102 <= r100.length()) goto L11;
        return r100;
    L11:
        if (Character.isHighSurrogate(r100.charAt((r103 + r101) - 1)) == false) goto L13;
        r103 = r103 - 1;
    L13:
        if (r101 > 0) goto L15;
    L17:
        if (r103 > 0) goto L20;
        r103 = 0;
    L20:
        return r100.subSequence(r101, r103 + r101);
    L15:
        if (Character.isLowSurrogate(r100.charAt(r101)) == false) goto L17;
        r101 = r101 + 1;
        r103 = r103 - 1;
        goto L17
    L22:
        return r100;
    L21:
        return r100;
    }
}

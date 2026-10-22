package com.bytedance.ee.bear.middleground.comment.input.utils;

import android.text.SpannableStringBuilder;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import un5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final SpannableStringBuilder a(CharSequence r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        SpannableStringBuilder r0 = new SpannableStringBuilder(r14);
        LinkedHashSet r15 = new LinkedHashSet();
        int r3 = 0;
        Object[] r1 = r0.getSpans(0, r0.length(), l.class);
        int r2 = r1.length;
    L3:
        if (r3 >= r2) goto L18;
        l r4 = (l) r1[r3];
        int r5 = r0.getSpanStart(r4);
        int r6 = r0.getSpanEnd(r4);
        String r7 = r4.d;
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        if (r5 < 0) goto L16;
        if (r6 <= r5) goto L16;
        if (r6 > r0.length()) goto L16;
        if (r15.add(new g(r5, r6, r7)) == true) goto L17;
        tt5.a.h("CommentInputUtils", "copyWithDeduplicatedUserSpans remove duplicate UserSpan start=" + r5 + " end=" + r6 + " length=" + r0.length() + " token=" + r7);
        r0.removeSpan(r4);
    L17:
        r3 = r3 + 1;
    L16:
        tt5.a.k("CommentInputUtils", "copyWithDeduplicatedUserSpans skip invalid UserSpan start=" + r5 + " end=" + r6 + " length=" + r0.length() + " token=" + r7);
        goto L17
    L18:
        return r0;
    }
}

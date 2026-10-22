package com.bytedance.ee.bear.middleground.comment.input.utils;

import android.text.SpannableStringBuilder;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import un5.l;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static final SpannableStringBuilder a(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        SpannableStringBuilder r100 = new SpannableStringBuilder(r110);
        LinkedHashSet r111 = new LinkedHashSet();
        int r101 = 0;
        Object[] r102 = r100.getSpans(0, r100.length(), l.class);
        int r103 = r102.length;
    L3:
        if (r101 >= r103) goto L18;
        l r104 = (l) r102[r101];
        int r105 = r100.getSpanStart(r104);
        int r106 = r100.getSpanEnd(r104);
        String r107 = r104.f550815d;
        if (r107 != null) goto L8;
        r107 = "";
    L8:
        if (r105 < 0) goto L16;
        if (r106 <= r105) goto L16;
        if (r106 > r100.length()) goto L16;
        if (r111.add(new g(r105, r106, r107)) == true) goto L17;
        tt5.a.h("CommentInputUtils", "copyWithDeduplicatedUserSpans remove duplicate UserSpan start=" + r105 + " end=" + r106 + " length=" + r100.length() + " token=" + r107);
        r100.removeSpan(r104);
    L17:
        r101 = r101 + 1;
    L16:
        tt5.a.k("CommentInputUtils", "copyWithDeduplicatedUserSpans skip invalid UserSpan start=" + r105 + " end=" + r106 + " length=" + r100.length() + " token=" + r107);
        goto L17
    L18:
        return r100;
    }
}

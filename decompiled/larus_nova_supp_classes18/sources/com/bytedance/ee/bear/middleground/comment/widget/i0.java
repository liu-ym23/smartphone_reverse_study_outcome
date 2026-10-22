package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableStringBuilder;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 extends db5.l {

    public static final class a {
    }

    static {
    }

    public i0() {
    }

    public final void e(SpannableStringBuilder r34, un5.k[] r35, List<bo4.a> r36) {
        Intrinsics.checkNotNullParameter(r34, "content");
        Intrinsics.checkNotNullParameter(r35, "unknownAtSpans");
        Intrinsics.checkNotNullParameter(r36, "atList");
        int r4 = r35.length;     // Catch: Exception -> L18
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L26;
        un5.k r6 = r35[r5];     // Catch: Exception -> L18
        int r8 = r34.getSpanStart(r6);     // Catch: Exception -> L18
        int r9 = r34.getSpanEnd(r6);     // Catch: Exception -> L18
        if (r8 == r9) goto L17;
        String r14 = r34.subSequence(r8, r9).toString();     // Catch: Exception -> L18
        Integer r7 = r6.getType();     // Catch: Exception -> L18
        if (r7 == null) goto L11;
        int r11 = r7.intValue();     // Catch: Exception -> L18
    L12:
        Integer r10 = r6.g;     // Catch: Exception -> L18
        if (r10 == null) goto L15;
        int r12 = r10.intValue();     // Catch: Exception -> L18
    L16:
        String r13 = r6.e;     // Catch: Exception -> L18
        String r15 = r6.d;     // Catch: Exception -> L18
        String r16 = r6.i;     // Catch: Exception -> L18
        String r17 = r6.j;     // Catch: Exception -> L18
        int r18 = r11;
        int r19 = r12;
        bo4.a r3 = new bo4.a(r8, r9, r18, r19, r13, r15, r14, null, null, null, null, r6.h, r17, r16, 0, false, null, false, false, "", "", null, null, null, 0);     // Catch: Exception -> L18
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L18
        ((LinkedList) r36).add(r3);     // Catch: Exception -> L18
        goto L17
    L15:
        r12 = -1;
        goto L16
    L11:
        r11 = -1;
    L17:
        r5 = r5 + 1;
        goto L4
    L26:
        return;
    L18:
        e = move-exception;
        tt5.a.f("CommentUnFormatFun", e, false);
    }
}

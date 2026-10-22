package com.ss.android.lark.myai.chat.quickactions;

import android.text.Editable;
import com.ss.android.lark.keyboard.edittext2.span.f;
import com.ss.android.lark.keyboard.edittext2.span.k;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes36.dex */
public interface a extends f {

    /* JADX INFO: renamed from: com.ss.android.lark.myai.chat.quickactions.a$a, reason: collision with other inner class name */
    public static final class C5145a {
        public static k.a a(a r100, int r101, int r102, Editable r110) {
            Intrinsics.checkNotNullParameter(r110, "text");
            int r103 = r110.getSpanStart(r100);
            int r104 = r110.getSpanEnd(r100);
            boolean r105 = false;
            if (r103 < 0) goto L6;
            if (r103 > r104) goto L6;
            boolean r106 = true;
        L8:
            if (r106 == true) goto L10;
            return null;
        L10:
            QuickActionNameSpan r107 = (QuickActionNameSpan) ArraysKt.getOrNull(r110.getSpans(0, r110.length(), QuickActionNameSpan.class), 0);
            if (r101 != r102) goto L13;
            boolean r108 = true;
        L15:
            if (r110.getSpanEnd(r107) != r103) goto L17;
            r105 = true;
        L17:
            if (r108 == false) goto L28;
            if (r105 == false) goto L20;
        L23:
            IntRange r109 = new IntRange(r103, r104);
        L25:
            if (r109.contains(r101) == true) goto L27;
        L39:
            return null;
        L27:
            return r100.a(r104, r104, r110);
        L20:
            if ((r100 instanceof QuickActionNameSpan) == true) goto L23;
            r109 = new IntRange(r103 + 1, r104);
            goto L25
        L28:
            IntRange r111 = new IntRange(r103 + 1, r104 - 1);
            if (r111.contains(r101) == false) goto L31;
            int r112 = r111.getFirst() - 1;
        L33:
            if (r111.contains(r102) == false) goto L35;
            int r113 = r111.getLast() + 1;
        L36:
            if (r112 != r101) goto L41;
            if (r113 == r102) goto L39;
        L41:
            return r100.a(r112, r113, r110);
        L35:
            r113 = r102;
            goto L36
        L31:
            r112 = r101;
            goto L33
        L13:
            r108 = false;
        L6:
            r106 = false;
            goto L8
        }
    }
}

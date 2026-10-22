package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableStringBuilder;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i0 extends db5.l {

    public static final class a {
    }

    static {
    }

    public i0() {
    }

    @Override // db5.l
    public final void e(SpannableStringBuilder r310, un5.k[] r311, List<bo4.a> r312) {
        Intrinsics.checkNotNullParameter(r310, "content");
        Intrinsics.checkNotNullParameter(r311, "unknownAtSpans");
        Intrinsics.checkNotNullParameter(r312, "atList");
        int r100 = r311.length;     // Catch: Exception -> L18
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L26;
        un5.k r102 = r311[r101];     // Catch: Exception -> L18
        int r103 = r310.getSpanStart(r102);     // Catch: Exception -> L18
        int r104 = r310.getSpanEnd(r102);     // Catch: Exception -> L18
        if (r103 == r104) goto L17;
        String r110 = r310.subSequence(r103, r104).toString();     // Catch: Exception -> L18
        Integer r105 = r102.getType();     // Catch: Exception -> L18
        if (r105 == null) goto L11;
        int r111 = r105.intValue();     // Catch: Exception -> L18
    L12:
        Integer r106 = r102.f550810g;     // Catch: Exception -> L18
        if (r106 == null) goto L15;
        int r112 = r106.intValue();     // Catch: Exception -> L18
    L16:
        String r113 = r102.f550808e;     // Catch: Exception -> L18
        String r114 = r102.f550805d;     // Catch: Exception -> L18
        String r107 = r102.f550812i;     // Catch: Exception -> L18
        String r115 = r102.f550813j;     // Catch: Exception -> L18
        int r116 = r111;
        int r117 = r112;
        bo4.a r108 = new bo4.a(r103, r104, r116, r117, r113, r114, r110, null, null, null, null, r102.f550811h, r115, r107, 0, false, null, false, false, "", "", null, null, null, 0);     // Catch: Exception -> L18
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L18
        ((LinkedList) r312).add(r108);     // Catch: Exception -> L18
        goto L17
    L15:
        r112 = -1;
        goto L16
    L11:
        r111 = -1;
    L17:
        r101 = r101 + 1;
        goto L4
    L26:
        return;
    L18:
        e = move-exception;
        tt5.a.f("CommentUnFormatFun", e, false);
    }
}

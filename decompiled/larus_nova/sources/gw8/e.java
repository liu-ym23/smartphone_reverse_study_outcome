package gw8;

import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {
    public static final int a(Spanned r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object[] r102 = r100.getSpans(0, r100.length(), LeadingMarginSpan.class);
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L13;
        Object r106 = r102[r105];
        LeadingMarginSpan r107 = (LeadingMarginSpan) r106;
        if (r100.getSpanStart(r107) <= r101) goto L7;
    L9:
        boolean r108 = false;
    L10:
        if (r108 == false) goto L12;
        r103.add(r106);
    L12:
        r105 = r105 + 1;
        goto L3
    L7:
        if (r101 > r100.getSpanEnd(r107)) goto L9;
        r108 = true;
        goto L10
    L13:
        Iterator r109 = r103.iterator();
        int r110 = 0;
    L15:
        if (r109.hasNext() == false) goto L17;
        r110 = r110 + ((LeadingMarginSpan) r109.next()).getLeadingMargin(false);
        goto L15
    L17:
        return r110;
    }
}

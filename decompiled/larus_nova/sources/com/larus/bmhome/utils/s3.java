package com.larus.bmhome.utils;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class s3 {
    static {
    }

    public static String a(String r310) {
        Intrinsics.checkNotNullParameter(r310, "tsvText");
        if (r310.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return "<table></table>";
    L9:
        StringBuilder r101 = new StringBuilder("<table style=\"border-collapse:collapse;\"><tbody>");
        Iterator r102 = StringsKt.split$default(r310, new String[]{"\n"}, false, 0, 6, null).iterator();
    L11:
        if (r102.hasNext() == false) goto L22;
        String r103 = (String) r102.next();
        if (r103.length() != 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L11;
        r101.append("<tr>");
        Iterator r105 = StringsKt.split$default(r103, new String[]{"\t"}, false, 0, 6, null).iterator();
    L19:
        if (r105.hasNext() == false) goto L21;
        String r106 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) r105.next(), "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null), "\"", "&quot;", false, 4, null), "'", "&#39;", false, 4, null);
        r101.append("<td style=\"border:1px solid #d0d0d0;padding:4px;\">");
        r101.append(r106);
        r101.append("</td>");
        goto L19
    L21:
        r101.append("</tr>");
        goto L11
    L15:
        r104 = false;
        goto L16
    L22:
        r101.append("</tbody></table>");
        return r101.toString();
    L5:
        r100 = false;
        goto L6
    }
}

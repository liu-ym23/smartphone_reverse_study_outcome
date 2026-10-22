package guc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
public final class c {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder("\"");
        int r102 = r100.length();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L25;
        char r104 = r100.charAt(r103);
        if (r104 != '\"') goto L9;
        r101.append("\\\"");
    L24:
        r103 = r103 + 1;
        goto L4
    L9:
        if (r104 != '\\') goto L12;
        r101.append("\\\\");
        goto L24
    L12:
        if (r104 != '\b') goto L15;
        r101.append("\\b");
        goto L24
    L15:
        if (r104 != '\t') goto L18;
        r101.append("\\t");
        goto L24
    L18:
        if (r104 != '\n') goto L21;
        r101.append("\\n");
        goto L24
    L21:
        if (r104 != '\r') goto L23;
        r101.append("\\r");
        goto L24
    L23:
        r101.append(r104);
        goto L24
    L25:
        r101.append(Typography.quote);
        return r101.toString();
    }
}

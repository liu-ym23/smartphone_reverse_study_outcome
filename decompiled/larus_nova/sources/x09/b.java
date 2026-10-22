package x09;

import java.util.ArrayList;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class b {
    public static final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "colorStr");
        String r111 = StringsKt.replace$default(r110, "#", "", false, 4, null).toUpperCase(Locale.ROOT);
        if (new Regex("[0-9A-F]+").matches(r111) == true) goto L5;
        return null;
    L5:
        int r100 = r111.length();
        if (r100 != 3) goto L8;
        StringBuilder r101 = new StringBuilder("#");
        ArrayList r102 = new ArrayList(r111.length());
        int r103 = 0;
    L13:
        if (r103 >= r111.length()) goto L15;
        r102.add(StringsKt.repeat(String.valueOf(r111.charAt(r103)), 2));
        r103 = r103 + 1;
        goto L13
    L15:
        r101.append(CollectionsKt.joinToString$default(r102, "", null, null, 0, null, null, 62, null));
        return r101.toString();
    L8:
        if (r100 == 6) goto L18;
        return null;
    L18:
        return "#".concat(r111);
    }
}

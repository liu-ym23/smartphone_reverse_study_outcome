package jaa;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L35:
        return null;
    L11:
        if (r4.length() < 2) goto L35;
        if (r4.charAt(1) != ':') goto L35;
        String r1 = r4.substring(2);
        char r5 = r4.charAt(0);
        if (r5 == 'b') goto L42;
        if (r5 == 'd') goto L41;
        if (r5 == 'f') goto L40;
        if (r5 == 'i') goto L39;
        if (r5 == 'l') goto L38;
        if (r5 == 'n') goto L35;
        if (r5 != 's') goto L35;
        return r1;
    L38:
        return StringsKt.toLongOrNull(r1);
    L39:
        return StringsKt.toIntOrNull(r1);
    L40:
        return StringsKt.toFloatOrNull(r1);
    L41:
        return StringsKt.toDoubleOrNull(r1);
    L42:
        return Boolean.valueOf(Intrinsics.areEqual(r1, "1"));
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r2 = false;
        goto L9
    }
}

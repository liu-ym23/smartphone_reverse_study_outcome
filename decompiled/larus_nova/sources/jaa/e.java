package jaa;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497969a = 0;

    static {
    }

    public static Object a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L35:
        return null;
    L11:
        if (r100.length() < 2) goto L35;
        if (r100.charAt(1) != ':') goto L35;
        String r102 = r100.substring(2);
        char r103 = r100.charAt(0);
        if (r103 == 'b') goto L42;
        if (r103 == 'd') goto L41;
        if (r103 == 'f') goto L40;
        if (r103 == 'i') goto L39;
        if (r103 == 'l') goto L38;
        if (r103 == 'n') goto L35;
        if (r103 != 's') goto L35;
        return r102;
    L38:
        return StringsKt.toLongOrNull(r102);
    L39:
        return StringsKt.toIntOrNull(r102);
    L40:
        return StringsKt.toFloatOrNull(r102);
    L41:
        return StringsKt.toDoubleOrNull(r102);
    L42:
        return Boolean.valueOf(Intrinsics.areEqual(r102, "1"));
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}

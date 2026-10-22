package va5;

import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static final String a(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (StringsKt.contains$default(r100, "<em>", false, 2, null) == false) goto L9;
        Pattern r101 = c.f569228a;
        return r100.replace("<em>", "").replace("</em>", "");
    L9:
        return r100;
    }

    public static final String b(Object... r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        return ArraysKt.joinToString$default(r110, "-", null, null, 0, null, null, 62, null);
    }
}

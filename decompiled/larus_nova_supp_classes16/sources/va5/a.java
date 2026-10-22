package va5;

import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final String a(String r5) {
        if (r5 != null) goto L6;
        return "";
    L6:
        if (StringsKt.contains$default(r5, "<em>", false, 2, null) == false) goto L9;
        Pattern r1 = c.a;
        return r5.replace("<em>", "").replace("</em>", "");
    L9:
        return r5;
    }

    public static final String b(Object... r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return ArraysKt.joinToString$default(r10, "-", null, null, 0, null, null, 62, null);
    }
}

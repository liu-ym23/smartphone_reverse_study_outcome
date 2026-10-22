package ga3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(Object r1) {
        if ((r1 instanceof String) == true) goto L5;
        return r1;
    L5:
        if (((CharSequence) r1).length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
    L13:
        return "";
    L10:
        if (Intrinsics.areEqual("null", r1) == true) goto L13;
        return (String) r1;
    L7:
        r0 = false;
        goto L8
    }
}

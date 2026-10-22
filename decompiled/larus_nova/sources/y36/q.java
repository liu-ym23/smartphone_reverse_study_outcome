package y36;

import android.graphics.Color;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565863a = 0;

    static {
    }

    public static Integer a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "string");
    L27:
        return null;
    L4:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L7;
        r100 = r100.substring(1);     // Catch: Exception -> L27
    L7:
        if (StringsKt.startsWith$default(r100, "%23", false, 2, null) == false) goto L12;
        if (r100 == null) goto L11;
        r100 = r100.substring(3);     // Catch: Exception -> L27
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L27
    L12:
        int r102 = r100.length();     // Catch: Exception -> L27
        if (r102 != 3) goto L16;
        r100 = "#FF" + r100.charAt(0) + r100.charAt(0) + r100.charAt(1) + r100.charAt(1) + r100.charAt(2) + r100.charAt(2);     // Catch: Exception -> L27
    L26:
        return Integer.valueOf(Color.parseColor(r100));
    L16:
        if (r102 != 6) goto L18;
        r100 = "#FF".concat(r100);     // Catch: Exception -> L27
        goto L26
    L18:
        if (r102 != 8) goto L26;
        if (r101 == false) goto L22;
        r100 = "#".concat(r100);     // Catch: Exception -> L27
        goto L26
    L22:
        r100 = "#" + StringsKt.takeLast(r100, 2) + StringsKt.dropLast(r100, 2);     // Catch: Exception -> L27
        goto L26
    }
}

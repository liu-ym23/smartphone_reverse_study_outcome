package n55;

import android.text.TextUtils;
import i55.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static boolean a(f85.a r2) {
        if (r2 == null) goto L6;
        String r3 = ((f85.a.C0229a) r2.a).b;
        tt5.a.h("ImportTypeUtil", "canImport starting...");
        if (f.a(r3) < 101) goto L6;
        return true;
    L6:
        return false;
    }

    public static int b(f85.a r3) {
        if (r3 != null) goto L5;
        return 2131887760;
    L5:
        if (TextUtils.isEmpty(((f85.a.C0229a) r3.a).b) == true) goto L17;
        String r4 = ((f85.a.C0229a) r3.a).b;
        tt5.a.h("ImportTypeUtil", "canImport starting...");
        int r5 = f.a(r4);
        if (r5 != 102) goto L10;
        return 2131887762;
    L10:
        if (r5 != 103) goto L18;
        return 2131887761;
    L18:
        return 2131887760;
    L17:
        return 2131887760;
    }
}

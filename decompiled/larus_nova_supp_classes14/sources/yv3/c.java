package yv3;

import com.larus.navigation.api.x;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final String a(String r2) {
        if (r2 == null) goto L13;
        String r3 = StringsKt.trim(r2).toString();
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        return r3;
    L9:
        r1 = false;
        goto L10
    L13:
        return null;
    }

    public static final a b(b r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r2 = a(r4.c());
        if (r2 != null) goto L8;
        return null;
    L8:
        String r3 = a(r4.b());
        if (r3 != null) goto L12;
        return null;
    L12:
        return new a(r2, r3, a(r4.a()), a(r4.d()));
    }

    public static final ci9.a c(b r4) {
        a r5 = b(r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new ci9.a(r5.a, r5.b, r5.c, r5.d);
    }

    public static final x d(b r4) {
        a r5 = b(r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new x(r5.a, r5.b, r5.c, r5.d);
    }
}

package yv3;

import com.larus.navigation.api.x;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static final String a(String r100) {
        if (r100 == null) goto L13;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r101;
    L9:
        r102 = false;
        goto L10
    L13:
        return null;
    }

    public static final a b(b r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = a(r100.c());
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = a(r100.b());
        if (r102 != null) goto L12;
        return null;
    L12:
        return new a(r101, r102, a(r100.a()), a(r100.d()));
    }

    public static final ci9.a c(b r100) {
        a r101 = b(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new ci9.a(r101.f569283a, r101.f569284b, r101.f569285c, r101.f569286d);
    }

    public static final x d(b r100) {
        a r101 = b(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new x(r101.f569283a, r101.f569284b, r101.f569285c, r101.f569286d);
    }
}

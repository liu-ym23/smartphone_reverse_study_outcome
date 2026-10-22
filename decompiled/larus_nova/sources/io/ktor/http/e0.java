package io.ktor.http;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class e0 {
    public static z b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "query");
        if (StringsKt.getLastIndex(r110) >= 0) goto L5;
        z.f491930b.getClass();
        return z.a.f491932b;
    L5:
        z.a r100 = z.f491930b;
        b0 r101 = d0.a();
        int r102 = StringsKt.getLastIndex(r110);
        int r103 = 0;
        if (r102 < 0) goto L20;
        int r104 = 0;
        int r105 = -1;
        int r111 = 0;
        int r112 = 0;
    L8:
        if (r111 == 1000) goto L25;
        char r106 = r110.charAt(r112);
        if (r106 != '&') goto L14;
        a(r101, r110, r104, r105, r112, false);
        r104 = r112 + 1;
        r111 = r111 + 1;
        r105 = -1;
    L17:
        if (r112 == r102) goto L19;
        r112 = r112 + 1;
        goto L8
    L19:
        r103 = r111;
    L21:
        if (r103 == 1000) goto L25;
        a(r101, r110, r104, r105, r110.length(), false);
        goto L25
    L14:
        if (r106 != '=') goto L17;
        if (r105 != (-1)) goto L17;
        r105 = r112;
    L25:
        return new c0(r101.f491945b);
    L20:
        r104 = 0;
        r105 = -1;
        goto L21
    }

    public static final int c(int r100, int r101, CharSequence r102) {
    L2:
        if (r101 <= r100) goto L6;
        if (CharsKt.isWhitespace(r102.charAt(r101 - 1)) == false) goto L6;
        r101 = r101 - 1;
    L6:
        return r101;
    }

    public static final void a(b0 r100, String r101, int r102, int r103, int r104, boolean r105) {
        if (r103 != (-1)) goto L15;
    L4:
        if (r102 >= r104) goto L8;
        if (CharsKt.isWhitespace(r101.charAt(r102)) == false) goto L8;
        r102 = r102 + 1;
    L8:
        int r106 = c(r102, r104, r101);
        if (r106 <= r102) goto L41;
        if (r105 == false) goto L12;
        String r107 = CodecsKt.e(r101, r102, r106, false, 12);
    L13:
        r100.d(r107, CollectionsKt.emptyList());
        return;
    L12:
        r107 = r101.substring(r102, r106);
        goto L13
    L41:
        return;
    L15:
        if (r102 >= r103) goto L19;
        if (CharsKt.isWhitespace(r101.charAt(r102)) == false) goto L19;
        r102 = r102 + 1;
    L19:
        int r108 = c(r102, r103, r101);
        if (r108 <= r102) goto L42;
        if (r105 == false) goto L23;
        String r109 = CodecsKt.e(r101, r102, r108, false, 12);
    L24:
        int r110 = r103 + 1;
    L25:
        if (r110 >= r104) goto L29;
        if (CharsKt.isWhitespace(r101.charAt(r110)) == false) goto L29;
        r110 = r110 + 1;
    L29:
        int r111 = c(r110, r104, r101);
        if (r105 == false) goto L32;
        String r112 = CodecsKt.e(r101, r110, r111, true, 8);
    L33:
        r100.e(r109, r112);
        return;
    L32:
        r112 = r101.substring(r110, r111);
        goto L33
    L23:
        r109 = r101.substring(r102, r108);
        goto L24
    }
}

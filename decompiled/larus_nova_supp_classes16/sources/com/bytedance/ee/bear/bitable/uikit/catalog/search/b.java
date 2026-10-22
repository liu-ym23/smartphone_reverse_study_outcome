package com.bytedance.ee.bear.bitable.uikit.catalog.search;

import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.bitable.uikit.catalog.search.a {
    public final Function0<Boolean> a;
    public a b;

    public static final class a {
        public final String a;
        public final String b;
        public String c;
        public boolean d;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "keyword");
            Intrinsics.checkNotNullParameter(r3, "lowercaseKeyword");
            this.a = r2;
            this.b = r3;
        }
    }

    public b(Object r2) {
        KeywordMatcher$1 r3 = KeywordMatcher$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "isHomophoneSearchEnabled");
        this.a = r3;
    }

    public static String b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "text");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(c.d(r1).toLowerCase(Locale.ROOT));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L11;
        r2 = null;
    L11:
        return (String) r2;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.catalog.search.a
    public final boolean a(String r9, String r10) {
        if (((Boolean) this.a.invoke()).booleanValue() == true) goto L13;
        if (r9 != null) goto L6;
        r9 = "";
    L6:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        String r11 = r10.toLowerCase(Locale.getDefault());
        if (StringsKt.contains$default(r9.toLowerCase(Locale.getDefault()), r11, false, 2, null) == false) goto L12;
        return true;
    L12:
        return StringsKt.contains$default(c.d(r9).toLowerCase(Locale.getDefault()), r11, false, 2, null);
    L13:
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        Locale r0 = Locale.ROOT;
        String r1 = r9.toLowerCase(r0);
        a r6 = this.b;
        if (r6 != null) goto L20;
    L25:
        r6 = new a(r10, r10.toLowerCase(r0));
        this.b = r6;
    L27:
        if (StringsKt.contains$default(r1, r6.b, false, 2, null) == false) goto L29;
        return true;
    L29:
        String r12 = b(r9);
        if (r12 != null) goto L33;
        return false;
    L33:
        if (StringsKt.contains$default(r12, r6.b, false, 2, null) == false) goto L36;
        return true;
    L36:
        if (r6.d == true) goto L38;
        r6.c = b(r6.a);
        r6.d = true;
    L38:
        String r13 = r6.c;
        if (r13 != null) goto L42;
        return false;
    L42:
        if (r13.length() <= 0) goto L44;
        boolean r2 = true;
    L45:
        if (r2 == true) goto L47;
    L49:
        return false;
    L47:
        if (StringsKt.contains$default(r12, r13, false, 2, null) == false) goto L49;
        return true;
    L44:
        r2 = false;
        goto L45
    L20:
        if (Intrinsics.areEqual(r6.a, r10) == true) goto L23;
        r6 = null;
    L23:
        if (r6 == null) goto L25;
        goto L25
    }
}

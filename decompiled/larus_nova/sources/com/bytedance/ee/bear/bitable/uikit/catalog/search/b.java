package com.bytedance.ee.bear.bitable.uikit.catalog.search;

import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru7.c;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.bytedance.ee.bear.bitable.uikit.catalog.search.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f216110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f216111b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f216112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f216113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f216114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f216115d;

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "keyword");
            Intrinsics.checkNotNullParameter(r101, "lowercaseKeyword");
            this.f216112a = r100;
            this.f216113b = r101;
        }
    }

    public b(Object r100) {
        KeywordMatcher$1 r101 = KeywordMatcher$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "isHomophoneSearchEnabled");
        this.f216110a = r101;
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(c.d(r100).toLowerCase(Locale.ROOT));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.catalog.search.a
    public final boolean a(String r100, String r110) {
        if (this.f216110a.invoke().booleanValue() == true) goto L13;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        if (r110 != null) goto L8;
        r110 = "";
    L8:
        String r111 = r110.toLowerCase(Locale.getDefault());
        if (StringsKt.contains$default(r100.toLowerCase(Locale.getDefault()), r111, false, 2, null) == false) goto L12;
        return true;
    L12:
        return StringsKt.contains$default(c.d(r100).toLowerCase(Locale.getDefault()), r111, false, 2, null);
    L13:
        if (r100 != null) goto L15;
        r100 = "";
    L15:
        if (r110 != null) goto L17;
        r110 = "";
    L17:
        Locale r101 = Locale.ROOT;
        String r102 = r100.toLowerCase(r101);
        a r103 = this.f216111b;
        if (r103 != null) goto L20;
    L25:
        r103 = new a(r110, r110.toLowerCase(r101));
        this.f216111b = r103;
    L27:
        if (StringsKt.contains$default(r102, r103.f216113b, false, 2, null) == false) goto L29;
        return true;
    L29:
        String r104 = b(r100);
        if (r104 != null) goto L33;
        return false;
    L33:
        if (StringsKt.contains$default(r104, r103.f216113b, false, 2, null) == false) goto L36;
        return true;
    L36:
        if (r103.f216115d == true) goto L38;
        r103.f216114c = b(r103.f216112a);
        r103.f216115d = true;
    L38:
        String r112 = r103.f216114c;
        if (r112 != null) goto L42;
        return false;
    L42:
        if (r112.length() <= 0) goto L44;
        boolean r105 = true;
    L45:
        if (r105 == true) goto L47;
    L49:
        return false;
    L47:
        if (StringsKt.contains$default(r104, r112, false, 2, null) == false) goto L49;
        return true;
    L44:
        r105 = false;
        goto L45
    L20:
        if (Intrinsics.areEqual(r103.f216112a, r110) == true) goto L23;
        r103 = null;
    L23:
        if (r103 == null) goto L25;
        goto L25
    }
}

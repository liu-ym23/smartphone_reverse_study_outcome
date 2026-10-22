package io.ktor.client.plugins.cookies;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import io.ktor.http.Url;
import io.ktor.http.d;
import io.ktor.http.j0;
import io.ktor.http.y;
import io.ktor.util.t;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static final boolean a(d r110, Url r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "requestUrl");
        String r100 = r110.f491847f;
        if (r100 == null) goto L48;
        String r101 = t.c(r100);
        if (r101 == null) goto L48;
        String r102 = StringsKt.trimStart(r101, new char[]{'.'});
        if (r102 == null) goto L48;
        String r103 = r110.f491848g;
        if (r103 == null) goto L46;
        if (StringsKt.endsWith$default(r103, '/', false, 2, null) == true) goto L14;
        r103 = r110.f491848g + '/';
    L14:
        String r104 = t.c(r111.f491817b);
        String r105 = r111.a();
        if (StringsKt.endsWith$default(r105, '/', false, 2, null) == true) goto L19;
        r105 = r105 + '/';
    L19:
        if (Intrinsics.areEqual(r104, r102) == true) goto L26;
        gsc.b r106 = y.f491929a;
        Intrinsics.checkNotNullParameter(r104, "host");
        gsc.b r107 = y.f491929a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r104, "input");
        if (r107.f482485a.matches(r104) == false) goto L23;
    L24:
        return false;
    L23:
        if (StringsKt.endsWith$default(r104, ".".concat(r102), false, 2, null) == false) goto L24;
    L26:
        if (Intrinsics.areEqual(r103, HTTP.URL_DEFAULT) == true) goto L33;
        if (Intrinsics.areEqual(r105, r103) == true) goto L33;
        if (StringsKt.startsWith$default(r105, r103, false, 2, null) == true) goto L33;
        return false;
    L33:
        if (r110.f491849h == false) goto L49;
        j0 r112 = r111.f491816a;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        if (Intrinsics.areEqual(r112.f491881a, "https") == false) goto L37;
    L40:
        boolean r113 = true;
    L41:
        if (r113 == true) goto L50;
        return false;
    L50:
        return true;
    L37:
        if (Intrinsics.areEqual(r112.f491881a, "wss") == true) goto L40;
        r113 = false;
        goto L41
    L49:
        return true;
    L46:
        throw new IllegalStateException("Path field should have the default value".toString());
    L48:
        throw new IllegalStateException("Domain field should have the default value".toString());
    }
}

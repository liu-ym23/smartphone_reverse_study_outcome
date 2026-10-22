package io.ktor.http;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.charset.Charset;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static final Charset a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getClass();
        Intrinsics.checkNotNullParameter("charset", "name");
        int r101 = CollectionsKt.getLastIndex(r100.f491888b);
        if (r101 < 0) goto L10;
        int r102 = 0;
    L5:
        k r103 = (k) ListProtector.get(r100.f491888b, r102);
        if (StringsKt.equals(r103.f491883a, "charset", true) == true) goto L7;
        if (r102 == r101) goto L10;
        r102 = r102 + 1;
        goto L5
    L7:
        String r104 = r103.f491884b;
    L11:
        if (r104 == null) goto L20;
        return Charset.forName(r104);
    L21:
        return null;
    L20:
        return null;
    L10:
        r104 = null;
        goto L11
    }
}

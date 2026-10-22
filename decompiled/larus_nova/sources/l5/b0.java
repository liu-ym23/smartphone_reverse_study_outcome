package l5;

import kotlin.jvm.internal.Intrinsics;
import m5.h1;

/* JADX INFO: loaded from: classes43.dex */
public final class b0 {
    public static final Long a(h1 r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "startKey");
        Intrinsics.checkNotNullParameter(r110, "endKey");
        Long r111 = Long.valueOf(r100.c(r110));
        boolean r102 = false;
        if (r111.longValue() <= 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L10;
        r111 = null;
    L10:
        if (r111 == null) goto L20;
        long r104 = r111.longValue();
        Long r105 = Long.valueOf(r100.c(r101));
        if (r105.longValue() <= 0) goto L14;
        r102 = true;
    L14:
        if (r102 == true) goto L17;
        r105 = null;
    L17:
        if (r105 == null) goto L20;
        return Long.valueOf(r104 - r105.longValue());
    L20:
        return null;
    L5:
        r103 = false;
        goto L7
    }
}

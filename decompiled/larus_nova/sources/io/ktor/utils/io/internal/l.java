package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class l {
    public static final int a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        String r102 = System.getProperty("io.ktor.utils.io.".concat(r100));     // Catch: SecurityException -> L5
    L6:
        if (r102 == null) goto L13;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 != null) goto L10;
        return r101;
    L10:
        return r103.intValue();
    L13:
        return r101;
    L5:
        r102 = null;
        goto L6
    }

    public static final int b(ByteBuffer r100, ByteBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sub");
        int r102 = r101.position();
        int r103 = r101.remaining();
        byte r104 = r101.get(r102);
        int r105 = r100.limit();
        int r106 = r100.position();
    L3:
        if (r106 >= r105) goto L16;
        if (r100.get(r106) != r104) goto L15;
        int r107 = 1;
    L7:
        if (r107 >= r103) goto L14;
        int r108 = r106 + r107;
        if (r108 == r105) goto L14;
        if (r100.get(r108) != r101.get(r102 + r107)) goto L15;
        r107 = r107 + 1;
    L14:
        return r106 - r100.position();
    L15:
        r106 = r106 + 1;
        goto L3
    L16:
        return -1;
    }

    public static final int c(ByteBuffer r100, ByteBuffer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "src");
        int r103 = r100.remaining();
        int r104 = r101.remaining();
        if (r104 > r103) goto L6;
        if (r104 > r102) goto L6;
        r100.put(r101);
    L11:
        return r104;
    L6:
        r104 = Math.min(r103, Math.min(r104, r102));
        int r105 = 1;
        if (1 > r104) goto L11;
    L8:
        r100.put(r101.get());
        if (r105 == r104) goto L11;
        r105 = r105 + 1;
        goto L8
    }

    public static final int d(ByteBuffer r100, ByteBuffer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "src");
        return c(r100, r101, r102 - r101.position());
    }

    public static final boolean e(ByteBuffer r100, ByteBuffer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        int r103 = Math.min(r100.remaining(), r101.remaining() - r102);
        if (r103 > 0) goto L5;
        return false;
    L5:
        int r104 = r100.position();
        int r105 = r101.position() + r102;
        int r106 = 0;
    L6:
        if (r106 >= r103) goto L11;
        if (r100.get(r104 + r106) != r101.get(r105 + r106)) goto L9;
        r106 = r106 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}

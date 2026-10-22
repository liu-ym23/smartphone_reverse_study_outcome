package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class h2 {
    public static final int a(luc.f r100, luc.f[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeParams");
        int r102 = (r100.f().hashCode() * 31) + Arrays.hashCode(r101);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.d();
        int r104 = 1;
    L3:
        int r105 = 0;
        if (r103 <= 0) goto L6;
        boolean r106 = true;
    L7:
        if (r106 == false) goto L12;
        int r107 = r103 - 1;
        int r108 = r104 * 31;
        String r109 = r100.h(r100.d() - r103).f();
        if (r109 == null) goto L11;
        r105 = r109.hashCode();
    L11:
        r104 = r108 + r105;
        r103 = r107;
        goto L3
    L12:
        int r110 = r100.d();
        int r111 = 1;
    L13:
        if (r110 <= 0) goto L15;
        boolean r112 = true;
    L16:
        if (r112 == false) goto L23;
        int r113 = r110 - 1;
        int r114 = r111 * 31;
        luc.o r115 = r100.h(r100.d() - r110).getKind();
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        r111 = r114 + r116;
        r110 = r113;
        goto L13
    L20:
        r116 = 0;
        goto L21
    L23:
        return (((r102 * 31) + r104) * 31) + r111;
    L15:
        r112 = false;
        goto L16
    L6:
        r106 = false;
        goto L7
    }
}

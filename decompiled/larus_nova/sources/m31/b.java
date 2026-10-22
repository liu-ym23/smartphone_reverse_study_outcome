package m31;

import k31.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public b() {
    }

    public static k31.c a(l31.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (r100.f507224b != 0) goto L5;
        return null;
    L5:
        if (r100.f507225c == 0) goto L23;
        Float r101 = r100.a();
        if (r101 == null) goto L21;
        float r102 = r101.floatValue();
        int r103 = r100.f507224b;
        int r104 = r100.f507225c;
        if ((r103 / r104) <= r102) goto L15;
        Integer r105 = o.b(r104, r100.a());
        if (r105 == null) goto L19;
        int r106 = r105.intValue();
        return new k31.c(r106, r104, 0, (int) ((r100.f507224b - r106) / 2.0f));
    L19:
        return null;
    L15:
        Integer r107 = o.a(r103, r100.a());
        if (r107 == null) goto L22;
        int r108 = r107.intValue();
        return new k31.c(r103, r108, (int) ((r100.f507225c - r108) / 2.0f), 0);
    L22:
        return null;
    L21:
        return null;
    L23:
        return null;
    }
}

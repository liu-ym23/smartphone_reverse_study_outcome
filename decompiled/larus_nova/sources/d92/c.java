package d92;

import kotlin.jvm.internal.Intrinsics;
import z82.g;
import z82.h;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements c92.a {
    public c() {
        new b92.b();
    }

    @Override // c92.a
    public final z82.b a(a92.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        int r101 = r100.f2268b;
        Integer r102 = h.b(r101, r100.a());
        if (r102 == null) goto L16;
        int r103 = r102.intValue();
        g r104 = r100.f2271e;
        int r105 = 0;
        if (r100.f2269c == true) goto L7;
        r104.getClass();
    L10:
        int r106 = 0;
    L12:
        if (r100.f2272f == null) goto L15;
        r105 = z82.a.a();
    L15:
        return new z82.b(r103, r101, r106 + r105, (int) ((r100.f2267a - r103) / 2.0f));
    L7:
        if (r104.f570909a == false) goto L10;
        r106 = r104.f570910b;
        goto L12
    L16:
        return null;
    }
}

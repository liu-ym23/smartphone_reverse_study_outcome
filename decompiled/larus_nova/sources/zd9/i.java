package zd9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static final <T> T a(String r100, juc.d<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "serializer");
        wt7.a.f561230a.getClass();
        return (T) wt7.c.a(r100, r101);
    }

    public static final <T> List<T> b(String r100, juc.d<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "elementSerializer");
        wt7.c r102 = wt7.a.f561230a;
        nuc.f r103 = kuc.a.b(r101);
        r102.getClass();
        return (List) wt7.c.a(r100, r103);
    }

    public static final <T> String c(T r100, juc.d<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "serializer");
        wt7.a.f561230a.getClass();
        return wt7.c.b(r100, r101);
    }
}

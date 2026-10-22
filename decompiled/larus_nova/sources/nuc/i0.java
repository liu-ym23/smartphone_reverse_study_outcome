package nuc;

import java.lang.annotation.Annotation;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class i0 {
    public static final h0 b(String r100, Enum[] r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "values");
        return new h0(r100, r101);
    }

    public static final h0 a(String r100, Enum[] r110, String[] r111, Annotation[][] r112) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r110, "values");
        Intrinsics.checkNotNullParameter(r111, "names");
        Intrinsics.checkNotNullParameter(r112, "entryAnnotations");
        f0 r101 = new f0(r100, r110.length);
        int r102 = r110.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L14;
        Enum r105 = r110[r103];
        int r106 = r104 + 1;
        String r107 = (String) ArraysKt.getOrNull(r111, r104);
        if (r107 != null) goto L7;
        r107 = r105.name();
    L7:
        r101.j(r107, false);
        Annotation[] r108 = (Annotation[]) ArraysKt.getOrNull(r112, r104);
        if (r108 == null) goto L12;
        int r109 = r108.length;
        int r113 = 0;
    L10:
        if (r113 >= r109) goto L12;
        r101.k(r108[r113]);
        r113 = r113 + 1;
    L12:
        r103 = r103 + 1;
        r104 = r106;
        goto L3
    L14:
        return new h0(r100, r110, r101);
    }
}

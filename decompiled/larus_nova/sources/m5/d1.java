package m5;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d1 {
    public static final z0 a(Map<String, z0> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        z0 r102 = r100.get(r101);
        if (r102 != null) goto L6;
        z0 r103 = new z0();
        r100.put(r101, r103);
        return r103;
    L6:
        return r102;
    }

    public static final b1 b(Map<String, b1> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        b1 r102 = r100.get(r101);
        if (r102 != null) goto L6;
        b1 r103 = new b1();
        r100.put(r101, r103);
        return r103;
    L6:
        return r102;
    }

    public static final h1 c(LruCache<String, h1> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        h1 r102 = r100.get(r101);
        if (r102 != null) goto L6;
        h1 r103 = new h1();
        r100.put(r101, r103);
        return r103;
    L6:
        return r102;
    }

    public static final h1 d(Map<String, h1> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        h1 r102 = r100.get(r101);
        if (r102 != null) goto L6;
        h1 r103 = new h1();
        r100.put(r101, r103);
        return r103;
    L6:
        return r102;
    }
}

package yx4;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static a a;
    public static Map<bk5.d, ? extends bk5.c> b;

    static {
        a = new zx4.a();
        b = MapsKt.emptyMap();
    }

    public static void a(bk5.d r1, bk5.c r2) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "creator");
        b = MapsKt.plus(b, TuplesKt.to(r1, r2));
    }
}

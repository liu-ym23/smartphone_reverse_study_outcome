package yx4;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f569407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<bk5.d, ? extends bk5.c> f569408b;

    static {
        f569407a = new zx4.a();
        f569408b = MapsKt.emptyMap();
    }

    public static void a(bk5.d r100, bk5.c r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "creator");
        f569408b = MapsKt.plus(f569408b, TuplesKt.to(r100, r101));
    }
}

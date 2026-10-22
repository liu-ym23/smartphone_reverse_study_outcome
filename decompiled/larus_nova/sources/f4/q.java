package f4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f475479a = 0;

    static {
    }

    public static void a(final e3.d r100, final boolean r101, final Class r102, final String r110, final f3.h r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "resultClass");
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "callback");
        p2.c.d(new p(r100, r110, r111, r101, r102));
    }
}

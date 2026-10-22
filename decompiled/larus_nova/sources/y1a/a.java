package y1a;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import x1a.b;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565679a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b r102 = x1a.a.f562152c;
        if (r102 == null) goto L6;
        r102.log(2, "Component_".concat(r100), r101);
        Unit r103 = Unit.INSTANCE;
        return;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b r102 = x1a.a.f562152c;
        if (r102 == null) goto L6;
        r102.log(5, "Component_".concat(r100), r101);
        Unit r103 = Unit.INSTANCE;
        return;
    }

    public static void c(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b r102 = x1a.a.f562152c;
        if (r102 == null) goto L6;
        r102.ensureNotReachHere(r100, r101);
        Unit r103 = Unit.INSTANCE;
        return;
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b r102 = x1a.a.f562152c;
        if (r102 == null) goto L6;
        r102.log(3, "Component_".concat(r100), r101);
        Unit r103 = Unit.INSTANCE;
        return;
    }
}

package ki4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f503619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f503620b = null;

    static {
        f503619a = new d0(0, -1);
        f503620b = new b0(0);
    }

    public static final boolean a(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f503622b > (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}

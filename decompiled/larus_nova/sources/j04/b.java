package j04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f496807a;

    static {
    }

    public b() {
    }

    public static /* synthetic */ void b(String r100) {
        a(r100, 0L);
    }

    public static void a(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "reportEntranceType");
        if (f496807a == null) goto L5;
        return;
    L5:
        f496807a = new a(r100, r101);
    }
}

package j04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static a a;

    static {
    }

    public b() {
    }

    public static /* synthetic */ void b(String r2) {
        a(r2, 0L);
    }

    public static void a(String r1, Long r2) {
        Intrinsics.checkNotNullParameter(r1, "reportEntranceType");
        if (a == null) goto L5;
        return;
    L5:
        a = new a(r1, r2);
    }
}

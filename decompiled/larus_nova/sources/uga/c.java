package uga;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<String> f550072a = null;

    static {
        f550072a = new AtomicReference();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        AtomicReference<String> r101 = f550072a;
        String r102 = r101.get();
        if (r102 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r102, r100) == true) goto L8;
        return;
    L8:
        if (r101.compareAndSet(r102, null) == true) goto L16;
        if (r101.get() == r102) goto L8;
        return;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(f550072a.get(), r100) == false) goto L7;
        return true;
    }
}

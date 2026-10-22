package hq9;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f486745a = 0;

    static {
    }

    public static Object a(Object r100, Function0 r101, Function1 r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "stateLock");
        Intrinsics.checkNotNullParameter(r101, "readContext");
        Intrinsics.checkNotNullParameter(r102, "evaluate");
        Intrinsics.checkNotNullParameter(r103, "publishIfCurrent");
    L3:
        Object r104 = r101.invoke();
        Object r105 = r102.invoke(r104);
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (Intrinsics.areEqual(r104, r101.invoke()) == false) goto L9;
        Object r106 = r103.invoke(r105);     // Catch: Throwable -> L13
    L10:
        monitor-exit(r100);
        if (r106 == null) goto L3;
        return r106;
    L9:
        r106 = null;
        goto L10
    }
}

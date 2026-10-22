package xp9;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f564774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Function1<Object, Unit>> f564775b = null;

    static {
        f564775b = new CopyOnWriteArrayList();
    }

    public static void a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) f564775b).add(r100);
        Object r101 = f564774a;
        if (r101 == null) goto L6;
        r100.invoke(r101);
        return;
    }

    public static void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) f564775b).remove(r100);
    }
}

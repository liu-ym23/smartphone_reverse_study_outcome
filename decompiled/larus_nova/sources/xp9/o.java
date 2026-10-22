package xp9;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f564776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Function1<Object, Unit>> f564777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Function1<Object, Unit>> f564778c = null;

    static {
        f564777b = new CopyOnWriteArrayList();
        f564778c = new CopyOnWriteArrayList();
    }

    public static void a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) f564777b).add(r100);
        Object r101 = f564776a;
        if (r101 == null) goto L6;
        r100.invoke(r101);
        return;
    }

    public static void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = f564776a;
        if (r101 == null) goto L5;
        r100.invoke(r101);
        return;
    L5:
        ((CopyOnWriteArrayList) f564778c).add(r100);
    }

    public static void c(Object r100) {
        f564776a = r100;
        if (r100 == null) goto L12;
        Iterator r101 = ((CopyOnWriteArrayList) f564778c).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((Function1) r101.next()).invoke(r100);
        goto L6
    L8:
        ((CopyOnWriteArrayList) f564778c).clear();
        Iterator r102 = ((CopyOnWriteArrayList) f564777b).iterator();
    L10:
        if (r102.hasNext() == false) goto L15;
        ((Function1) r102.next()).invoke(r100);
        goto L10
    L15:
        return;
    }

    public static void d(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) f564777b).remove(r100);
    }
}

package ir8;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f495501a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f495502b = null;

    public interface a {
        void a();
    }

    static {
        f495501a = new CopyOnWriteArraySet();
        f495502b = new CopyOnWriteArrayList();
    }

    public static boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (CollectionsKt.lastOrNull(f495502b) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (f495501a.contains(r100) == true) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<a> r101 = f495502b;
        if (CollectionsKt.lastOrNull(r101) != r100) goto L8;
        return;
    L8:
        r101.remove(r100);
        r101.add(r100);
    }

    public static void c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        f495501a.remove(r100);
        f495502b.remove(r100);
    }
}

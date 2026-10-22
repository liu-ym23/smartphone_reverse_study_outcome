package ul;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<c> f550585a = null;

    static {
        f550585a = new ArrayList();
    }

    public static void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<c> r101 = f550585a;
        ((ArrayList) r101).remove(r100);
        c r102 = (c) CollectionsKt.lastOrNull(r101);
        if (r102 == null) goto L6;
        r102.a(true);
        return;
    }

    public static void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        r100.a(true);
        Iterator r101 = ((ArrayList) f550585a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).a(false);
        goto L4
    L6:
        ((ArrayList) f550585a).add(r100);
    }
}

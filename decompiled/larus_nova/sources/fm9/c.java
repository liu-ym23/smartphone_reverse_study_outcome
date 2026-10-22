package fm9;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f477877a = null;

    static {
        f477877a = new CopyOnWriteArrayList();
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "headers");
        CopyOnWriteArrayList<b> r101 = f477877a;
        if (r101 == null) goto L8;
        Iterator<b> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        r102.next().a(r100);
        goto L6
    L10:
        return;
    }
}

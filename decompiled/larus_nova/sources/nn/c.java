package nn;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f519622a = 0;

    static {
    }

    public static void a(Rect r100, ln.c r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        Intrinsics.checkNotNullParameter(r102, "result");
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof b) == false) goto L13;
        ln.c r103 = ((b) r101).f519621a;
        if (r103 == null) goto L21;
        List<ln.c> r104 = r103.L(r100);
        if (r104 == null) goto L22;
        ArrayList r105 = (ArrayList) r102;
        r105.addAll(r104);
        return;
    L22:
        return;
    L21:
        return;
    L13:
        if ((r101 instanceof a) == false) goto L18;
        Iterator<T> r106 = ((a) r101).f519620b.iterator();
    L16:
        if (r106.hasNext() == false) goto L24;
        CollectionsKt.addAll(r102, ((ln.c) r106.next()).L(r100));
        goto L16
    L24:
        return;
    L18:
        ArrayList r107 = (ArrayList) r102;
        r107.addAll(r101.L(r100));
    }
}

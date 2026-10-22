package vp;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556544a = 0;

    static {
    }

    public static void a(Rect r100, tp.c r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        Intrinsics.checkNotNullParameter(r102, "result");
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof c) == false) goto L13;
        tp.c r103 = ((c) r101).f556543a;
        if (r103 == null) goto L21;
        List<tp.c> r104 = r103.L(r100);
        if (r104 == null) goto L22;
        ArrayList r105 = (ArrayList) r102;
        r105.addAll(r104);
        return;
    L22:
        return;
    L21:
        return;
    L13:
        if ((r101 instanceof b) == false) goto L18;
        Iterator<T> r106 = ((b) r101).f556542b.iterator();
    L16:
        if (r106.hasNext() == false) goto L24;
        CollectionsKt.addAll(r102, ((tp.c) r106.next()).L(r100));
        goto L16
    L24:
        return;
    L18:
        ArrayList r107 = (ArrayList) r102;
        r107.addAll(r101.L(r100));
    }
}

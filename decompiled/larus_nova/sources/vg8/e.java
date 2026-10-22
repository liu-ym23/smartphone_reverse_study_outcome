package vg8;

import android.view.View;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f554740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f554741b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f554742c = null;

    static {
        f554740a = LazyKt.lazy(new b());
        f554741b = LazyKt.lazy(new c());
        f554742c = LazyKt.lazy(new d());
    }

    public static boolean b() {
        return ((Boolean) f554741b.getValue()).booleanValue();
    }

    public static uvc.b a(uvc.b r100) {
        uvc.b r101 = com.larus.business.markdown.impl.widget.f.c(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        r101.f551905f = r100.f551905f;
        uvc.b r102 = r100.f551901b;
    L6:
        if (r102 == null) goto L11;
        uvc.b r103 = a(r102);
        if (r103 == null) goto L9;
        r101.b(r103);
        r102 = r102.f551904e;
        goto L6
    L9:
        return null;
    L11:
        return r101;
    }

    public static void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (b() == true) goto L5;
        return;
    L5:
        ((Map) f554742c.getValue()).remove(r100);
    }
}

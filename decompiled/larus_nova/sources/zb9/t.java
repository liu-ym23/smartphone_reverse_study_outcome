package zb9;

import com.baidu.platform.comapi.map.MapController;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class t<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<u<ITEM>> f571200a;

    public t() {
        this.f571200a = new CopyOnWriteArraySet();
    }

    public final void a(u<ITEM> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f571200a.add(r100);
    }

    public final void b(k<i<ITEM>> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Iterator<T> r101 = this.f571200a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((u) r101.next()).a(r100);
        goto L4
    }

    public final void c(i<ITEM> r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Iterator<u<ITEM>> r101 = this.f571200a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().b(r100);
        goto L4
    }

    public final void d(u<ITEM> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f571200a.remove(r100);
    }
}

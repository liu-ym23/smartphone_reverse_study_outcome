package g04;

import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<Model> extends a<Model> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<a<Model>> f479461e;

    @Override // g04.a
    public final void g() {
        Iterator<T> r100 = this.f479461e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).j();
        goto L4
    }

    @Override // g04.a
    public final void h() {
        Iterator<T> r100 = this.f479461e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).k();
        goto L4
    }

    @Override // g04.a
    public final void i() {
        Iterator<T> r100 = this.f479461e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).l();
        goto L4
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f479461e = new ArrayList();
    }

    @Override // g04.a
    public final void f(Model r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Iterator<T> r101 = this.f479461e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).b(r100);
        goto L4
    }

    public final void m(a r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (((ArrayList) this.f479461e).contains(r100) == true) goto L6;
        r100.f479458b = this;
        ((ArrayList) this.f479461e).add(r100);
        return;
    }
}

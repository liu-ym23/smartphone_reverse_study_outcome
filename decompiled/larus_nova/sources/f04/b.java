package f04;

import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<Model> extends a<Model> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a<Model>> f474979d;

    @Override // f04.a
    public final void k() {
        Iterator<T> r100 = this.f474979d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).l();
        goto L4
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f474979d = new ArrayList();
    }

    @Override // f04.a
    public final void j(Model r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Iterator<T> r101 = this.f474979d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).f(r100);
        goto L4
    }

    public final void m(a r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (((ArrayList) this.f474979d).contains(r100) == true) goto L6;
        r100.f474977b = this;
        ((ArrayList) this.f474979d).add(r100);
        return;
    }
}

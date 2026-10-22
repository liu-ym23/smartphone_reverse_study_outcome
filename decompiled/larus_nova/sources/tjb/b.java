package tjb;

import java.lang.ref.WeakReference;
import rjb.g;
import ujb.f;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference<g> f546448a;

    @Override // ujb.f
    public final void close() {
        WeakReference<g> r100 = this.f546448a;
        if (r100 == null) goto L8;
        g r101 = r100.get();
        if (r101 == null) goto L9;
        r101.close();
        return;
    L9:
        return;
    }

    @Override // ujb.f
    public final boolean d() {
        WeakReference<g> r100 = this.f546448a;
        if (r100 == null) goto L7;
        g r101 = r100.get();
        if (r101 == null) goto L7;
        return r101.isShowing();
    L7:
        return false;
    }

    public b(WeakReference<g> r100) {
        this.f546448a = r100;
    }
}

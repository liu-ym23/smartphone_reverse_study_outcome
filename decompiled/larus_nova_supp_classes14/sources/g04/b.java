package g04;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<Model> extends a<Model> {
    public final List<a<Model>> e;

    @Override // g04.a
    public final void g() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).j();
        goto L4
    }

    @Override // g04.a
    public final void h() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).k();
        goto L4
    }

    @Override // g04.a
    public final void i() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).l();
        goto L4
    }

    public b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.e = new ArrayList();
    }

    @Override // g04.a
    public final void f(Model r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).b(r3);
        goto L4
    }

    public final void m(a r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        if (((ArrayList) this.e).contains(r2) == true) goto L6;
        r2.b = this;
        ((ArrayList) this.e).add(r2);
        return;
    }
}

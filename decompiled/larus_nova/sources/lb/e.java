package lb;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends h<f> implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f508284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f508285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MVIState<?> f508286d;

    public final void k() {
        if (this.f508289a.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.f508286d.modifiedProperties.isEmpty() == false) goto L8;
        return;
    L8:
        int r100 = a.f508281c;
        i r101 = a.C6668a.a(this.f508286d, false);
        Iterator r102 = this.f508289a.iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        ((f) r102.next()).g(this.f508285c, r101);
        goto L10
    }

    @Override // lb.f
    public final void d(BaseMVIViewModel<?, ?> r100) {
        Iterator r101 = this.f508289a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).d(r100);
        goto L4
    }

    @Override // lb.f
    public final void e(i r100) {
        Iterator r101 = this.f508289a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).e(r100);
        goto L4
    }

    @Override // lb.f
    public final void f(v<?, ?> r100) {
        Iterator r101 = this.f508289a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).f(r100);
        goto L4
    }

    @Override // lb.f
    public final void i(i r100) {
        Iterator r101 = this.f508289a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).i(r100);
        goto L4
    }

    public final void l(Map<Object, ? extends com.bytedance.android.anya.j<?>> r100) {
        if (this.f508289a.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.f508286d.modifiedProperties.isEmpty() == false) goto L8;
        return;
    L8:
        int r101 = a.f508281c;
        i r102 = a.C6668a.a(this.f508286d, false);
        Iterator r103 = this.f508289a.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        ((f) r103.next()).h(r102, r100);
        goto L10
    }

    public e(MVIState<?> r100, Collection<? extends f> r101) {
        super(r101);
        this.f508286d = r100;
    }

    @Override // lb.f
    public final void g(int r100, i r101) {
        Iterator r102 = this.f508289a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((f) r102.next()).g(r100, r101);
        goto L4
    }

    @Override // lb.f
    public final void h(i r100, Map<Object, ? extends com.bytedance.android.anya.j<?>> r101) {
        Iterator r102 = this.f508289a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((f) r102.next()).h(r100, r101);
        goto L4
    }
}

package gi9;

import androidx.recyclerview.widget.RecyclerView;
import ei9.f;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<b> f481476a;

    public a() {
        this.f481476a = new LinkedHashSet();
    }

    @Override // gi9.b
    public final void c(int r100) {
        Iterator<T> r101 = this.f481476a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).c(r100);
        goto L4
    }

    @Override // gi9.b
    public final void a(int r100, Class<? extends RecyclerView.ViewHolder> r101) {
        Intrinsics.checkNotNullParameter(r101, "holderClazz");
        Iterator<T> r102 = this.f481476a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((b) r102.next()).a(r100, r101);
        goto L4
    }

    @Override // gi9.b
    public final void d(Class<? extends RecyclerView.ViewHolder> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holderClazz");
        Iterator<T> r102 = this.f481476a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((b) r102.next()).d(r100, r101);
        goto L4
    }

    @Override // gi9.b
    public final void b(Class<? extends RecyclerView.ViewHolder> r100, f r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holderClazz");
        Intrinsics.checkNotNullParameter(r101, "state");
        Iterator<T> r103 = this.f481476a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((b) r103.next()).b(r100, r101, r102);
        goto L4
    }
}

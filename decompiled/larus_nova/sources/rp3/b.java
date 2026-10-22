package rp3;

import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements pq3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f538843a;

    @Override // pq3.a
    public final void a(List<? extends f> r100) {
        Intrinsics.checkNotNullParameter(r100, "voList");
    }

    @Override // pq3.a
    public final void onFinished() {
    }

    @Override // pq3.a
    public final void onReset() {
        ((ArrayList) this.f538843a).clear();
    }

    public b() {
        this.f538843a = new ArrayList();
    }

    @Override // pq3.a
    public final void b(List<? extends f> r100) {
        Intrinsics.checkNotNullParameter(r100, "voList");
        List<Long> r101 = this.f538843a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof o0) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r102.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        Long r107 = ((o0) r106.next()).f189620o;
        if (r107 == null) goto L10;
        r105.add(r107);
        goto L10
    L14:
        ((ArrayList) r101).addAll(r105);
    }
}

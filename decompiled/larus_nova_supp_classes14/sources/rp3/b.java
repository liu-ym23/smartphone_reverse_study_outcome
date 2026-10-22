package rp3;

import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements pq3.a {
    public final List<Long> a;

    @Override // pq3.a
    public final void a(List<? extends f> r2) {
        Intrinsics.checkNotNullParameter(r2, "voList");
    }

    @Override // pq3.a
    public final void onFinished() {
    }

    @Override // pq3.a
    public final void onReset() {
        ((ArrayList) this.a).clear();
    }

    public b() {
        this.a = new ArrayList();
    }

    @Override // pq3.a
    public final void b(List<? extends f> r5) {
        Intrinsics.checkNotNullParameter(r5, "voList");
        List<Long> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if ((r2 instanceof o0) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        ArrayList r7 = new ArrayList();
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Long r4 = ((o0) r3.next()).o;
        if (r4 == null) goto L10;
        r7.add(r4);
        goto L10
    L14:
        ((ArrayList) r0).addAll(r7);
    }
}

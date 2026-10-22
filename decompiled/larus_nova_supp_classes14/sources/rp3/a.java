package rp3;

import com.bytedance.android.shopping.api.window.AwemeInfo;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements pq3.a {
    public final LinkedHashSet<AwemeInfo> a;
    public final LinkedBlockingQueue<List<AwemeInfo>> b;
    public final Function0<Unit> c;

    /* JADX INFO: renamed from: rp3.a$a, reason: collision with other inner class name */
    public static final class C0165a {
    }

    static {
    }

    @Override // pq3.a
    public final void a(List<? extends f> r2) {
        Intrinsics.checkNotNullParameter(r2, "voList");
    }

    @Override // pq3.a
    public final void onFinished() {
    }

    @Override // pq3.a
    public final void onReset() {
        this.a.clear();
    }

    public a(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "triggerLoadMore");
        this.c = r2;
        this.a = new LinkedHashSet();
        this.b = new LinkedBlockingQueue();
    }

    @Override // pq3.a
    public final void b(List<? extends f> r5) {
        Intrinsics.checkNotNullParameter(r5, "voList");
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r2 = r6.next();
        if ((r2 instanceof o) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterator r7 = r1.iterator();
    L10:
        if (r7.hasNext() == false) goto L18;
        AwemeInfo r3 = ((o) r7.next()).e();
        if (r3 == null) goto L10;
        if (this.a.add(r3) == false) goto L10;
        r0.add(r3);
        goto L10
    L18:
        if ((!r0.isEmpty()) == false) goto L33;
        this.b.add(r0);
        return;
    }
}

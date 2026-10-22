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

/* JADX INFO: loaded from: classes14.dex */
public final class a implements pq3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<AwemeInfo> f538840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<List<AwemeInfo>> f538841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f538842c;

    /* JADX INFO: renamed from: rp3.a$a, reason: collision with other inner class name */
    public static final class C7513a {
    }

    static {
    }

    @Override // pq3.a
    public final void a(List<? extends f> r100) {
        Intrinsics.checkNotNullParameter(r100, "voList");
    }

    @Override // pq3.a
    public final void onFinished() {
    }

    @Override // pq3.a
    public final void onReset() {
        this.f538840a.clear();
    }

    public a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerLoadMore");
        this.f538842c = r100;
        this.f538840a = new LinkedHashSet();
        this.f538841b = new LinkedBlockingQueue();
    }

    @Override // pq3.a
    public final void b(List<? extends f> r100) {
        Intrinsics.checkNotNullParameter(r100, "voList");
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof o) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L18;
        AwemeInfo r106 = ((o) r105.next()).e();
        if (r106 == null) goto L10;
        if (this.f538840a.add(r106) == false) goto L10;
        r101.add(r106);
        goto L10
    L18:
        if ((!r101.isEmpty()) == false) goto L33;
        this.f538841b.add(r101);
        return;
    }
}

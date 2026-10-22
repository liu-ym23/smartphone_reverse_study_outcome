package cq5;

import com.bytedance.ee.bear.contract.route.parcelable.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<g.a> f464790a;

    public b() {
        this.f464790a = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.g
    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f464790a.remove(r100);
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.g
    public final void c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f464790a.add(r100);
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.g
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r101, "spaceClassId");
        Iterator<T> r102 = this.f464790a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((g.a) r102.next()).a(r100, r101);
        goto L4
    }
}

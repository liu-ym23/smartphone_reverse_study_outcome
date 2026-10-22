package fi9;

import com.larus.list.arch.IFlowListCell;
import ei9.f;
import ei9.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C5914a> f477422a;

    /* JADX INFO: renamed from: fi9.a$a, reason: collision with other inner class name */
    public final class C5914a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends f> f477423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<? extends IFlowListCell<f>> f477424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g<?, ? extends f> f477425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final hi9.a<f> f477426d;

        public C5914a(Class r100, Class r101, g r102, hi9.a r103) {
            Intrinsics.checkNotNullParameter(r100, "stateClazz");
            Intrinsics.checkNotNullParameter(r101, "cellType");
            Intrinsics.checkNotNullParameter(r102, "transformer");
            Intrinsics.checkNotNullParameter(r103, "matcher");
            this.f477423a = r100;
            this.f477424b = r101;
            this.f477425c = r102;
            this.f477426d = r103;
        }
    }

    public a() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = CollectionsKt.emptyList().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add((C5914a) r101.next());
        goto L4
    L6:
        this.f477422a = r100;
    }

    public final int a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator<T> r101 = this.f477422a.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L11;
        r102 = r102 + 1;
        C5914a r103 = (C5914a) r101.next();
        hi9.a<f> r104 = r103.f477426d;
        if (Intrinsics.areEqual(r103.f477423a, r100.getClass()) == false) goto L4;
        if (r104.a(r100) == false) goto L4;
        return (r102 * 100000) + (r104.b(r100) * 10);
    L11:
        return -1;
    }
}

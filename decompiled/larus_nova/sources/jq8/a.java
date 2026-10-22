package jq8;

import com.larus.bmhome.interactionpanel.m;
import com.larus.bmhome.interactionpanel.n;
import com.larus.bmhome.interactionpanel.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: jq8.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes26.dex */
    public static final class C6477a<T> implements Comparator {
        public C6477a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((m) r100).f312381h), Long.valueOf(((m) r101).f312381h));
        }
    }

    public a() {
    }

    public static v a(n r100, List r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "entries");
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L3:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L12;
        Object r106 = r104.next();
        Long r107 = ((m) r106).f312380g;
        if (r107 != null) goto L8;
    L9:
        r105 = true;
    L10:
        if (r105 == false) goto L3;
        r103.add(r106);
        goto L3
    L8:
        if (r107.longValue() <= r102) goto L10;
    L12:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r103.iterator();
    L14:
        if (r109.hasNext() == false) goto L36;
        Object r110 = r109.next();
        m r111 = (m) r110;
        if ((r100 instanceof n.a) == false) goto L23;
        if (Intrinsics.areEqual(r111.f312374a.f312389a, ((n.a) r100).f312386a) == true) goto L20;
    L31:
        boolean r112 = false;
    L32:
        if (r112 == false) goto L14;
        r108.add(r110);
        goto L14
    L20:
        if (r111.f312376c == null) goto L31;
    L30:
        r112 = true;
        goto L32
    L23:
        if ((r100 instanceof n.b) == false) goto L35;
        n.b r113 = (n.b) r100;
        if (Intrinsics.areEqual(r111.f312374a.f312389a, r113.f312387a) == false) goto L31;
        if (Intrinsics.areEqual(r111.f312374a.f312390b, r113.f312388b) == false) goto L31;
        if (r111.f312377d == null) goto L31;
    L35:
        throw new NoWhenBranchMatchedException();
    L36:
        List r114 = CollectionsKt.sortedWith(r108, new C6477a());
        return new v(r100, r114, (m) CollectionsKt.firstOrNull(r114));
    }
}

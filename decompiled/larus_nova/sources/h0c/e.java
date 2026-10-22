package h0c;

import com.ss.android.lark.passportc.entity.UserState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e<S, E, C, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<S, List<i0c.d<S, C, R>>> f483509a;

    public e() {
        this.f483509a = new HashMap();
    }

    public final List a(Object r100, UserState r101, int r102) {
        if (Intrinsics.areEqual(r100, r101) == true) goto L5;
        List<i0c.d<S, C, R>> r103 = this.f483509a.get(r100);
        if (r103 == null) goto L23;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
        int r106 = Integer.MAX_VALUE;
    L10:
        if (r105.hasNext() == false) goto L21;
        i0c.d r107 = (i0c.d) r105.next();
        ArrayList r108 = new ArrayList();
        if (Intrinsics.areEqual(r107.getTo(), r101) == false) goto L14;
        r108.add(r107);
    L17:
        if ((!r108.isEmpty()) == false) goto L10;
        if (r108.size() >= r106) goto L10;
        r106 = r108.size();
        r104 = r108;
        goto L10
    L14:
        if (r102 <= 0) goto L17;
        r108.add(r107);
        r108.addAll(a(r107.getTo(), r101, r102 - 1));
        goto L17
    L21:
        return r104;
    L23:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }
}

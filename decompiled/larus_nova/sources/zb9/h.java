package zb9;

import com.baidu.platform.comapi.map.MapController;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.home.impl.main.side_bar.view.group.render.e0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h<ITEM> implements l<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<i<ITEM>, Object> f571185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<i<ITEM>, i<ITEM>, i<ITEM>> f571186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<GroupSortPolicy, Comparator<i<ITEM>>> f571187c;

    @Override // zb9.l
    public final Comparator<i<ITEM>> a(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "sortPolicy");
        return this.f571187c.invoke(r100);
    }

    @Override // zb9.l
    public final Object c(i<ITEM> r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return this.f571185a.invoke(r100);
    }

    @Override // zb9.l
    public final i<ITEM> b(i<ITEM> r100, i<ITEM> r101) {
        Intrinsics.checkNotNullParameter(r100, "existing");
        Intrinsics.checkNotNullParameter(r101, "incoming");
        return this.f571186b.invoke(r100, r101);
    }

    @Override // zb9.l
    public final List<i<ITEM>> e(List<i<ITEM>> r100, List<i<ITEM>> r101) {
        Intrinsics.checkNotNullParameter(r100, "originItems");
        Intrinsics.checkNotNullParameter(r101, "newItems");
        LinkedHashMap r102 = new LinkedHashMap(r100.size() + r101.size());
        Iterator r103 = CollectionsKt.plus(r100, r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        i<ITEM> r104 = (i) r103.next();
        Object r105 = c(r104);
        i<ITEM> r106 = (i) r102.get(r105);
        if (r106 == null) goto L9;
        r104 = b(r106, r104);
    L9:
        r102.put(r105, r104);
        goto L4
    L11:
        return CollectionsKt.toList(r102.values());
    }

    public h(Function1 r100, e0 r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new e();
    L6:
        if ((r102 & 2) == 0) goto L8;
        Function2<i<ITEM>, i<ITEM>, i<ITEM>> r103 = new f();
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = (Function1<GroupSortPolicy, Comparator<i<ITEM>>>) new g();
    L12:
        Intrinsics.checkNotNullParameter(r100, "dedupKeySelector");
        Intrinsics.checkNotNullParameter(r103, "conflictResolver");
        Intrinsics.checkNotNullParameter(r101, "comparatorFactory");
        this.f571185a = r100;
        this.f571186b = r103;
        this.f571187c = r101;
        return;
    L8:
        r103 = null;
        goto L10
    }

    @Override // zb9.l
    public final List<i<ITEM>> d(List<i<ITEM>> r100, List<i<ITEM>> r101, GroupSortPolicy r102) {
        Intrinsics.checkNotNullParameter(r100, "originItems");
        Intrinsics.checkNotNullParameter(r101, "newItems");
        Intrinsics.checkNotNullParameter(r102, "sortPolicy");
        return CollectionsKt.sortedWith(e(r100, r101), a(r102));
    }
}

package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarQuickAccessPinnedDataSource implements zb9.s<com.larus.home.impl.main.side_bar.data.j0>, il9.h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f345316n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f345317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final il9.b f345318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ll9.k f345319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f345320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zb9.t<com.larus.home.impl.main.side_bar.data.j0> f345321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap<String, ll9.t> f345322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GroupSortPolicy f345323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f345324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f345325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f345326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f345327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f345328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f345329m;

    public static final class a {
    }

    static {
    }

    public final zb9.k<zb9.i<com.larus.home.impl.main.side_bar.data.j0>> j() {
        Collection<ll9.t> r100 = this.f345322f.values();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        ll9.t r103 = (ll9.t) r102.next();
        Long r104 = r103.f509783j;
        if (r104 == null) goto L8;
        long r105 = r104.longValue();
    L9:
        long r110 = r105 / 1000000;
        r101.add(new zb9.i(new com.larus.home.impl.main.side_bar.data.j0(SideBarItemType.QUICK_ACCESS, null, null, null, r103, null, null, null, false, 0, 1006), r110, r110, r110, false, 16));
        goto L4
    L8:
        r105 = 0;
        goto L9
    L11:
        return new zb9.k(r101, this.f345326j, null);
    }

    @Override // zb9.s
    public final GroupSortPolicy e() {
        return this.f345323g;
    }

    public static boolean k(ll9.t r100) {
        if (r100.f509774a != NodeType.UNKNOWN) goto L5;
        return false;
    L5:
        if (r100.f509775b.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L24;
        ll9.a r102 = r100.f509781h;
        if (r102 == null) goto L19;
        String r103 = r102.f509710a;
        if (r103 == null) goto L19;
        if (r103.length() <= 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 != true) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L25;
        return true;
    L25:
        return false;
    L16:
        r104 = false;
    L19:
        r105 = false;
        goto L20
    L24:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public static String m(ll9.t r100) {
        return r100.f509774a.getValue() + ':' + r100.f509775b;
    }

    @Override // zb9.s
    public final void a(zb9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f345324h = RangesKt.coerceAtLeast(r100.f571193a, 1);
        if (this.f345326j == true) goto L5;
    L7:
        this.f345321e.b(j());
        return;
    L5:
        if (this.f345325i == null) goto L7;
        l(false);
    }

    @Override // zb9.s
    public final void d(zb9.u<com.larus.home.impl.main.side_bar.data.j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345321e.a(r100);
        if (this.f345327k == true) goto L8;
        this.f345327k = true;
        il9.b r101 = this.f345318b;
        if (r101 == null) goto L9;
        r101.s2(this);
        return;
    L9:
        return;
    }

    @Override // zb9.s
    public final void f(zb9.u<com.larus.home.impl.main.side_bar.data.j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345321e.d(r100);
        if (this.f345327k == true) goto L5;
        return;
    L5:
        if (this.f345321e.f571200a.isEmpty() == false) goto L11;
        this.f345327k = false;
        this.f345328l++;
        this.f345329m++;
        il9.b r101 = this.f345318b;
        if (r101 == null) goto L12;
        r101.w0(this);
        return;
    L12:
        return;
    }

    @Override // zb9.s
    public final void g(zb9.j r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        this.f345324h = RangesKt.coerceAtLeast(r110.f571193a, 1);
        il9.b r100 = this.f345318b;
        if (r100 == null) goto L5;
        ll9.v r101 = r100.g2();
    L6:
        this.f345322f.clear();
        if (r101 == null) goto L9;
        List<ll9.t> r102 = r101.f509787a;
    L10:
        if (r102 != null) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        List r103 = CollectionsKt.filterNotNull(r102);
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if (k((ll9.t) r106) == false) goto L14;
        r104.add(r106);
        goto L14
    L18:
        Iterator r107 = r104.iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        ll9.t r108 = (ll9.t) r107.next();
        this.f345322f.put(m(r108), r108);
        goto L20
    L22:
        Function1<Boolean, Unit> r109 = this.f345320d;
        Collection<ll9.t> r111 = this.f345322f.values();
        boolean r112 = false;
        if (r111.isEmpty() == true) goto L39;
        Iterator<T> r113 = r111.iterator();
    L27:
        if (r113.hasNext() == false) goto L39;
        ll9.t r114 = (ll9.t) r113.next();
        ll9.k r115 = this.f345319c;
        if (r115 != null) goto L32;
    L36:
        boolean r116 = false;
    L37:
        if (r116 == false) goto L27;
        boolean r117 = true;
    L40:
        r109.invoke(Boolean.valueOf(r117));
        il9.b r118 = this.f345318b;
        if (r118 == null) goto L47;
        ll9.k r119 = this.f345319c;
        if (r119 == null) goto L47;
        int r120 = this.f345329m + 1;
        this.f345329m = r120;
        BuildersKt.launch$default(this.f345317a, null, null, new SideBarQuickAccessPinnedDataSource$refreshObservedNodePinnedState$1(this, r120, r119, r118, null), 3, null);
    L47:
        this.f345325i = null;
        if (r101 == null) goto L50;
        r112 = Intrinsics.areEqual(r101.f509788b, Boolean.TRUE);
    L50:
        this.f345326j = r112;
        this.f345321e.b(j());
        l(true);
        return;
    L32:
        if (r114.f509774a != r115.f509747a) goto L36;
        if (Intrinsics.areEqual(r114.f509775b, r115.f509748b) == false) goto L36;
        r116 = true;
    L39:
        r117 = false;
        goto L40
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // zb9.s
    public final void h(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f345323g = r100;
    }

    public final void l(boolean r110) {
        il9.b r100 = this.f345318b;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this.f345328l + 1;
        this.f345328l = r101;
        if (r110 == false) goto L8;
        String r102 = null;
    L9:
        BuildersKt.launch$default(this.f345317a, null, null, new SideBarQuickAccessPinnedDataSource$loadPage$1(this, r101, r110, r100, r102, null), 3, null);
        return;
    L8:
        r102 = this.f345325i;
        goto L9
    }

    @Override // il9.h
    public final void b(NodeType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeType");
        Intrinsics.checkNotNullParameter(r101, "referenceId");
        if (this.f345327k == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f345317a, null, null, new SideBarQuickAccessPinnedDataSource$onPinned$1(this, r100, r101, null), 3, null);
    }

    @Override // il9.h
    public final void c(NodeType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeType");
        Intrinsics.checkNotNullParameter(r101, "referenceId");
        if (this.f345327k == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f345317a, null, null, new SideBarQuickAccessPinnedDataSource$onUnpinned$1(this, r100, r101, null), 3, null);
    }

    public SideBarQuickAccessPinnedDataSource(CoroutineScope r100, il9.b r101, ll9.k r102, Function1 r103) {
        this.f345317a = r100;
        this.f345318b = r101;
        this.f345319c = r102;
        this.f345320d = r103;
        this.f345321e = new zb9.t();
        this.f345322f = new LinkedHashMap();
        this.f345323g = GroupSortPolicy.UpdateTime;
        this.f345324h = 6;
    }

    public static final void i(SideBarQuickAccessPinnedDataSource r100, NodeType r101, String r102, boolean r103) {
        ll9.k r104 = r100.f345319c;
        if (r104 != null) goto L6;
        return;
    L6:
        if (r104.f509747a == r101) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r104.f509748b, r102) == false) goto L14;
        r100.f345329m++;
        r100.f345320d.invoke(Boolean.valueOf(r103));
        return;
    }
}

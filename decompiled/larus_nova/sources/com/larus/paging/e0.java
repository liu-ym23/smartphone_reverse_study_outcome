package com.larus.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class e0<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f363815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PagingSource.b.c<Key, Value>> f363816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<PagingSource.b.c<Key, Value>> f363817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f363818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f363819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f363820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f363821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f363822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Channel<Integer> f363823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Channel<Integer> f363824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<LoadType, f1> f363825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y f363826l;

    public static final class a<Key, Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutexImpl f363827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e0<Key, Value> f363828b;

        public a(j0 r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f363827a = kotlinx.coroutines.sync.b.a();
            this.f363828b = new e0(r100);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363829a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f363829a = r100;
        }
    }

    public final int d() {
        if (this.f363815a.f363867c == true) goto L7;
        return 0;
    L7:
        return this.f363819e;
    }

    public e0(j0 r100) {
        this.f363815a = r100;
        ArrayList r101 = new ArrayList();
        this.f363816b = r101;
        this.f363817c = r101;
        this.f363823i = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.f363824j = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.f363825k = new LinkedHashMap();
        y r102 = new y();
        r102.c(LoadType.REFRESH, u.b.f363921b);
        this.f363826l = r102;
    }

    public final w0<Key, Value> a(f1.a r100) {
        List r101 = CollectionsKt.toList(this.f363817c);
        if (r100 == null) goto L14;
        int r102 = d();
        int r103 = -this.f363818d;
        int r104 = CollectionsKt.getLastIndex(this.f363817c) - this.f363818d;
        int r105 = r100.f363845e;
        int r106 = r103;
    L5:
        if (r106 >= r105) goto L10;
        if (r106 <= r104) goto L8;
        int r107 = this.f363815a.f363865a;
    L9:
        r102 = r102 + r107;
        r106 = r106 + 1;
        goto L5
    L8:
        r107 = ((PagingSource.b.c) ListProtector.get(this.f363817c, this.f363818d + r106)).f363729a.size();
        goto L9
    L10:
        int r108 = r102 + r100.f363846f;
        if (r100.f363845e >= r103) goto L13;
        r108 = r108 - this.f363815a.f363865a;
    L13:
        Integer r109 = Integer.valueOf(r108);
    L16:
        return new w0(r101, r109, this.f363815a, d());
    L14:
        r109 = null;
        goto L16
    }

    public final void b(PageEvent.a<Value> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = 0;
        if (r100.d() > ((ArrayList) this.f363817c).size()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L31;
        this.f363825k.remove(r100.f363678a);
        this.f363826l.c(r100.f363678a, u.c.f363923c);
        int r103 = b.f363829a[r100.f363678a.ordinal()];
        if (r103 != 2) goto L10;
        int r104 = r100.d();
        int r105 = 0;
    L22:
        if (r105 >= r104) goto L24;
        ListProtector.remove(this.f363816b, 0);
        r105 = r105 + 1;
        goto L22
    L24:
        this.f363818d -= r100.d();
        int r106 = r100.f363681d;
        if (r106 == Integer.MIN_VALUE) goto L28;
        r101 = r106;
    L28:
        this.f363819e = r101;
        int r107 = this.f363821g + 1;
        this.f363821g = r107;
        this.f363823i.offer(Integer.valueOf(r107));
        return;
    L10:
        if (r103 != 3) goto L20;
        int r108 = r100.d();
        int r109 = 0;
    L12:
        if (r109 >= r108) goto L14;
        ListProtector.remove(this.f363816b, ((ArrayList) this.f363817c).size() - 1);
        r109 = r109 + 1;
        goto L12
    L14:
        int r110 = r100.f363681d;
        if (r110 == Integer.MIN_VALUE) goto L18;
        r101 = r110;
    L18:
        this.f363820f = r101;
        int r111 = this.f363822h + 1;
        this.f363822h = r111;
        this.f363824j.offer(Integer.valueOf(r111));
        return;
    L20:
        throw new IllegalArgumentException("cannot drop " + r100.f363678a);
    L31:
        throw new IllegalStateException(("invalid drop count. have " + ((ArrayList) this.f363817c).size() + " but wanted to drop " + r100.d()).toString());
    L5:
        r102 = false;
        goto L6
    }

    public final PageEvent.a<Value> c(LoadType r110, f1 r111) {
        Intrinsics.checkNotNullParameter(r110, "loadType");
        Intrinsics.checkNotNullParameter(r111, "hint");
        PageEvent.a<Value> r100 = null;
        if (this.f363815a.f363869e != Integer.MAX_VALUE) goto L6;
        return null;
    L6:
        if (((ArrayList) this.f363817c).size() > 2) goto L8;
        return null;
    L8:
        Iterator r101 = ((ArrayList) this.f363817c).iterator();
        int r102 = 0;
        int r103 = 0;
    L10:
        if (r101.hasNext() == false) goto L13;
        r103 = r103 + ((PagingSource.b.c) r101.next()).f363729a.size();
        goto L10
    L13:
        if (r103 > this.f363815a.f363869e) goto L16;
        return null;
    L16:
        if (r110 == LoadType.REFRESH) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == false) goto L63;
        int r105 = 0;
        int r106 = 0;
    L22:
        if (r105 >= ((ArrayList) this.f363817c).size()) goto L40;
        Iterator r107 = ((ArrayList) this.f363817c).iterator();
        int r108 = 0;
    L25:
        if (r107.hasNext() == false) goto L28;
        r108 = r108 + ((PagingSource.b.c) r107.next()).f363729a.size();
        goto L25
    L28:
        if ((r108 - r106) <= this.f363815a.f363869e) goto L40;
        int[] r109 = b.f363829a;
        if (r109[r110.ordinal()] != 2) goto L32;
        int r112 = ((PagingSource.b.c) ListProtector.get(this.f363817c, r105)).f363729a.size();
    L34:
        if (r109[r110.ordinal()] != 2) goto L36;
        int r113 = r111.f363841a;
    L38:
        if (((r113 - r106) - r112) < this.f363815a.f363866b) goto L40;
        r106 = r106 + r112;
        r105 = r105 + 1;
        goto L22
    L36:
        r113 = r111.f363842b;
        goto L38
    L32:
        List<PagingSource.b.c<Key, Value>> r114 = this.f363817c;
        r112 = ((PagingSource.b.c) ListProtector.get(r114, CollectionsKt.getLastIndex(r114) - r105)).f363729a.size();
    L40:
        if (r105 == 0) goto L61;
        int[] r115 = b.f363829a;
        if (r115[r110.ordinal()] != 2) goto L45;
        int r116 = -this.f363818d;
    L47:
        if (r115[r110.ordinal()] != 2) goto L49;
        int r117 = (r105 - 1) - this.f363818d;
    L50:
        boolean r118 = this.f363815a.f363867c;
        if (r118 == true) goto L54;
    L60:
        r100 = new PageEvent.a(r110, r116, r117, r102);
        goto L61
    L54:
        if (r110 != LoadType.PREPEND) goto L56;
        int r119 = d();
    L59:
        r102 = r119 + r106;
        goto L60
    L56:
        if (r118 == false) goto L58;
        r102 = this.f363820f;
    L58:
        r119 = r102;
        goto L59
    L49:
        r117 = CollectionsKt.getLastIndex(this.f363817c) - this.f363818d;
        goto L50
    L45:
        r116 = (CollectionsKt.getLastIndex(this.f363817c) - this.f363818d) - (r105 - 1);
    L61:
        return r100;
    L63:
        throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + r110).toString());
    L18:
        r104 = false;
        goto L19
    }

    public final PageEvent.Insert e(PagingSource.b.c r110, LoadType r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "loadType");
        int[] r100 = b.f363829a;
        int r101 = r100[r111.ordinal()];
        int r102 = 0;
        if (r101 == 1) goto L10;
        if (r101 == 2) goto L9;
        if (r101 != 3) goto L8;
        int r103 = (((ArrayList) this.f363817c).size() - this.f363818d) - 1;
    L11:
        List r112 = CollectionsKt.listOf(new d1(r103, r110.f363729a));
        int r104 = r100[r111.ordinal()];
        if (r104 != 1) goto L14;
        PageEvent.Insert<Object> r105 = PageEvent.Insert.f363671g;
        int r106 = d();
        if (this.f363815a.f363867c == false) goto L28;
        r102 = this.f363820f;
    L28:
        return PageEvent.Insert.a.a(r112, r106, r102, this.f363826l.d(), null);
    L14:
        if (r104 == 2) goto L23;
        if (r104 != 3) goto L22;
        PageEvent.Insert<Object> r107 = PageEvent.Insert.f363671g;
        if (this.f363815a.f363867c == false) goto L19;
        int r113 = this.f363820f;
    L20:
        v r114 = this.f363826l.d();
        Intrinsics.checkNotNullParameter(r112, "pages");
        Intrinsics.checkNotNullParameter(r114, "sourceLoadStates");
        return new PageEvent.Insert(LoadType.APPEND, r112, -1, r113, r114, null);
    L19:
        r113 = 0;
        goto L20
    L22:
        throw new NoWhenBranchMatchedException();
    L23:
        PageEvent.Insert<Object> r108 = PageEvent.Insert.f363671g;
        int r115 = d();
        v r116 = this.f363826l.d();
        Intrinsics.checkNotNullParameter(r112, "pages");
        Intrinsics.checkNotNullParameter(r116, "sourceLoadStates");
        return new PageEvent.Insert(LoadType.PREPEND, r112, r115, -1, r116, null);
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r103 = 0 - this.f363818d;
        goto L11
    L10:
        r103 = 0;
        goto L11
    }

    public final boolean insert(int r100, LoadType r101, PagingSource.b.c<Key, Value> r102) {
        Intrinsics.checkNotNullParameter(r101, "loadType");
        Intrinsics.checkNotNullParameter(r102, "page");
        int r103 = b.f363829a[r101.ordinal()];
        int r104 = 0;
        if (r103 == 1) goto L42;
        if (r103 == 2) goto L28;
        if (r103 == 3) goto L10;
    L55:
        return true;
    L10:
        if ((!((ArrayList) this.f363817c).isEmpty()) == false) goto L26;
        if (r100 == this.f363822h) goto L14;
        return false;
    L14:
        ((ArrayList) this.f363816b).add(r102);
        int r105 = r102.f363733e;
        if (r105 == Integer.MIN_VALUE) goto L17;
    L21:
        if (r105 == Integer.MIN_VALUE) goto L24;
        r104 = r105;
    L24:
        this.f363820f = r104;
        this.f363825k.remove(LoadType.APPEND);
        goto L55
    L17:
        if (this.f363815a.f363867c == false) goto L19;
        int r106 = this.f363820f;
    L20:
        r105 = RangesKt.coerceAtLeast(r106 - r102.f363729a.size(), 0);
        goto L21
    L19:
        r106 = 0;
        goto L20
    L26:
        throw new IllegalStateException("should've received an init before append".toString());
    L28:
        if ((!((ArrayList) this.f363817c).isEmpty()) == false) goto L40;
        if (r100 == this.f363821g) goto L32;
        return false;
    L32:
        ListProtector.add(this.f363816b, 0, r102);
        this.f363818d++;
        int r107 = r102.f363732d;
        if (r107 != Integer.MIN_VALUE) goto L35;
        r107 = RangesKt.coerceAtLeast(d() - r102.f363729a.size(), 0);
    L35:
        if (r107 == Integer.MIN_VALUE) goto L38;
        r104 = r107;
    L38:
        this.f363819e = r104;
        this.f363825k.remove(LoadType.PREPEND);
        goto L55
    L40:
        throw new IllegalStateException("should've received an init before prepend".toString());
    L42:
        if (((ArrayList) this.f363817c).isEmpty() == false) goto L59;
        if (r100 != 0) goto L45;
        boolean r108 = true;
    L46:
        if (r108 == false) goto L57;
        ((ArrayList) this.f363816b).add(r102);
        this.f363818d = 0;
        int r109 = r102.f363733e;
        if (r109 != Integer.MIN_VALUE) goto L50;
        r109 = 0;
    L50:
        this.f363820f = r109;
        int r110 = r102.f363732d;
        if (r110 == Integer.MIN_VALUE) goto L54;
        r104 = r110;
    L54:
        this.f363819e = r104;
        goto L55
    L57:
        throw new IllegalStateException("init loadId must be the initial value, 0".toString());
    L45:
        r108 = false;
        goto L46
    L59:
        throw new IllegalStateException("cannot receive multiple init calls".toString());
    }
}

package com.larus.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f363882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f363883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<d1<T>> f363884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f363885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f363886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f363887f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363888a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.PREPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadType.REFRESH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f363888a = r100;
        }
    }

    public final List<PageEvent<T>> b() {
        if (this.f363887f == false) goto L5;
        ArrayList r100 = new ArrayList();
        v r101 = this.f363885d.d();
        if ((!this.f363884c.isEmpty()) == false) goto L9;
        PageEvent.Insert<Object> r102 = PageEvent.Insert.f363671g;
        r100.add(PageEvent.Insert.a.a(CollectionsKt.toList(this.f363884c), this.f363882a, this.f363883b, r101, this.f363886e));
    L10:
        return r100;
    L9:
        r100.add(new PageEvent.b(r101, this.f363886e));
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    public n() {
        this.f363884c = new ArrayDeque();
        this.f363885d = new y();
    }

    public final void a(PageEvent<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f363887f = true;
        int r101 = 0;
        if ((r100 instanceof PageEvent.Insert) == false) goto L17;
        PageEvent.Insert r102 = (PageEvent.Insert) r100;
        this.f363885d.b(r102.f363676e);
        this.f363886e = r102.f363677f;
        LoadType r103 = r102.f363672a;
        int r104 = a.f363888a[r103.ordinal()];
        if (r104 == 1) goto L12;
        if (r104 != 2) goto L8;
        this.f363883b = r102.f363675d;
        this.f363884c.addAll(r102.f363673b);
        return;
    L8:
        if (r104 != 3) goto L39;
        this.f363884c.clear();
        this.f363883b = r102.f363675d;
        this.f363882a = r102.f363674c;
        this.f363884c.addAll(r102.f363673b);
        return;
    L39:
        return;
    L12:
        this.f363882a = r102.f363674c;
        Iterator<Integer> r105 = RangesKt.downTo(r102.f363673b.size() - 1, 0).iterator();
    L14:
        if (r105.hasNext() == false) goto L40;
        int r106 = ((IntIterator) r105).nextInt();
        this.f363884c.addFirst((d1<T>) ListProtector.get(r102.f363673b, r106));
        goto L14
    L40:
        return;
    L17:
        if ((r100 instanceof PageEvent.a) == false) goto L30;
        PageEvent.a r107 = (PageEvent.a) r100;
        this.f363885d.c(r107.f363678a, u.c.f363923c);
        LoadType r108 = r107.f363678a;
        int r109 = a.f363888a[r108.ordinal()];
        if (r109 == 1) goto L26;
        if (r109 != 2) goto L25;
        this.f363883b = r107.f363681d;
        int r110 = r107.d();
    L22:
        if (r101 >= r110) goto L41;
        this.f363884c.removeLast();
        r101 = r101 + 1;
        goto L22
    L41:
        return;
    L25:
        throw new IllegalArgumentException("Page drop type must be prepend or append");
    L26:
        this.f363882a = r107.f363681d;
        int r111 = r107.d();
    L27:
        if (r101 >= r111) goto L42;
        this.f363884c.removeFirst();
        r101 = r101 + 1;
        goto L27
    L42:
        return;
    L30:
        if ((r100 instanceof PageEvent.b) == false) goto L38;
        PageEvent.b r112 = (PageEvent.b) r100;
        this.f363885d.b(r112.f363682a);
        this.f363886e = r112.f363683b;
        return;
    }
}

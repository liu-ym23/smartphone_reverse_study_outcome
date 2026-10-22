package com.obric.oui.orecyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes34.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap<RecyclerView.y, a> f401835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LongSparseArray<RecyclerView.y> f401836b;

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Pools.SimplePool f401837d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.ItemAnimator.c f401839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RecyclerView.ItemAnimator.c f401840c;

        static {
            f401837d = new Pools.SimplePool(20);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static a a() {
            a r100 = (a) f401837d.acquire();
            if (r100 == null) goto L5;
            return r100;
        L5:
            return new a();
        }

        public a() {
        }
    }

    public j0() {
        this.f401835a = new SimpleArrayMap();
        this.f401836b = new LongSparseArray();
    }

    public final void c(RecyclerView.y r100) {
        a r101 = this.f401835a.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.f401838a &= -2;
    }

    public final void d(RecyclerView.y r100) {
        int r101 = this.f401836b.size();
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L8;
        if (r100 != this.f401836b.valueAt(r101)) goto L3;
        this.f401836b.removeAt(r101);
    L8:
        a r102 = this.f401835a.remove(r100);
        if (r102 == null) goto L15;
        r102.f401838a = 0;
        r102.f401839b = null;
        r102.f401840c = null;
        a.f401837d.release(r102);
        return;
    }

    public final void a(RecyclerView.y r100, RecyclerView.ItemAnimator.c r101) {
        a r102 = this.f401835a.get(r100);
        if (r102 != null) goto L5;
        r102 = a.a();
        this.f401835a.put(r100, r102);
    L5:
        r102.f401840c = r101;
        r102.f401838a |= 8;
    }

    public final RecyclerView.ItemAnimator.c b(RecyclerView.y r100, int r101) {
        int r102 = this.f401835a.indexOfKey(r100);
        if (r102 >= 0) goto L5;
        return null;
    L5:
        a r103 = this.f401835a.valueAt(r102);
        if (r103 == null) goto L21;
        int r104 = r103.f401838a;
        if ((r104 & r101) == 0) goto L21;
        int r105 = r104 & (~r101);
        r103.f401838a = r105;
        if (r101 != 4) goto L13;
        RecyclerView.ItemAnimator.c r106 = r103.f401839b;
    L16:
        if ((r105 & 12) != 0) goto L18;
        this.f401835a.removeAt(r102);
        r103.f401838a = 0;
        r103.f401839b = null;
        r103.f401840c = null;
        a.f401837d.release(r103);
    L18:
        return r106;
    L13:
        if (r101 != 8) goto L20;
        r106 = r103.f401840c;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    L21:
        return null;
    }
}

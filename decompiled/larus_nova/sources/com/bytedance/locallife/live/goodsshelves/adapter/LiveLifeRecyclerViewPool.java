package com.bytedance.locallife.live.goodsshelves.adapter;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/adapter/LiveLifeRecyclerViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeRecyclerViewPool extends RecyclerView.RecycledViewPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<b> f259515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.locallife.live.goodsshelves.adapter.a f259516b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<RecyclerView.ViewHolder> f259517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f259518b;

        public b() {
            this.f259517a = new ArrayList();
            this.f259518b = 5;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void clear() {
        int r100 = this.f259515a.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L13;
        b r102 = this.f259515a.valueAt(r101);
        if (this.f259516b == null) goto L12;
        Iterator<T> r103 = r102.f259517a.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        RecyclerView.ViewHolder r104 = (RecyclerView.ViewHolder) r103.next();
        com.bytedance.locallife.live.goodsshelves.adapter.a r105 = this.f259516b;
        if (r105 == null) goto L8;
        r105.a(r104.getItemViewType(), r104);
    L12:
        r102.f259517a.clear();
        r101 = r101 + 1;
        goto L3
    }

    public LiveLifeRecyclerViewPool() {
        this.f259515a = new SparseArray();
    }

    public final b a(int r100) {
        b r101 = this.f259515a.get(r100);
        if (r101 != null) goto L6;
        b r102 = new b();
        this.f259515a.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final RecyclerView.ViewHolder getRecycledView(int r100) {
        b r101 = this.f259515a.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.f259517a.isEmpty() == true) goto L10;
        ArrayList<RecyclerView.ViewHolder> r102 = r101.f259517a;
        return (RecyclerView.ViewHolder) ListProtector.remove(r102, r102.size() - 1);
    L10:
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final int getRecycledViewCount(int r100) {
        return a(r100).f259517a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void putRecycledView(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "scrap");
        int r101 = r100.getItemViewType();
        ArrayList<RecyclerView.ViewHolder> r102 = a(r101).f259517a;
        if (this.f259515a.get(r101).f259518b > r102.size()) goto L8;
        com.bytedance.locallife.live.goodsshelves.adapter.a r103 = this.f259516b;
        if (r103 == null) goto L26;
        r103.a(r101, r100);
        return;
    L26:
        return;
    L8:
        Method[] r104 = RecyclerView.ViewHolder.class.getDeclaredMethods();
        int r105 = r104.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L14;
        Method r107 = r104[r106];
        if (Intrinsics.areEqual(r107.getName(), "resetInternal") == true) goto L15;
        r106 = r106 + 1;
    L15:
        if (r107 != null) goto L22;
    L20:
        r102.add(r100);
        return;
    L22:
        r107.setAccessible(true);     // Catch: Exception -> L19
        r107.invoke(r100, new Object[0]);     // Catch: Exception -> L19
    L19:
        Unit r108 = Unit.INSTANCE;
        goto L20
    L14:
        r107 = null;
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void setMaxRecycledViews(int r100, int r101) {
        b r102 = a(r100);
        r102.f259518b = r101;
        ArrayList<RecyclerView.ViewHolder> r103 = r102.f259517a;
    L4:
        if (r103.size() <= r101) goto L8;
        if ((!r103.isEmpty()) == false) goto L11;
        ListProtector.remove(r103, r103.size() - 1);
        goto L4
    L11:
        return;
    }
}

package com.ss.android.ugc.aweme.search.common.result.optimize.vhpreload;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/optimize/vhpreload/ECSearchRecycledViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "()V", "InnerScrapData", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchRecycledViewPool extends RecyclerView.RecycledViewPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<InnerScrapData> f451867a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/optimize/vhpreload/ECSearchRecycledViewPool$InnerScrapData;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerScrapData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f451868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<RecyclerView.ViewHolder> f451869b;

        public InnerScrapData() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof InnerScrapData) == false) goto L10;
            InnerScrapData r101 = (InnerScrapData) r100;
            if (this.f451868a == r101.f451868a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f451869b, r101.f451869b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f451868a * 31;
            ArrayList<RecyclerView.ViewHolder> r101 = this.f451869b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "InnerScrapData(mMaxScrap=" + this.f451868a + ", mScrapHeap=" + this.f451869b + ")";
        }

        public InnerScrapData(Object r100) {
            ArrayList<RecyclerView.ViewHolder> r101 = new ArrayList(5);
            Intrinsics.checkNotNullParameter(r101, "mScrapHeap");
            this.f451868a = 5;
            this.f451869b = r101;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final synchronized void clear() {
        monitor-enter(this);
        super.clear();     // Catch: Throwable -> L9
        int r100 = this.f451867a.size();     // Catch: Throwable -> L9
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L7;
        this.f451867a.valueAt(r101).f451869b.clear();     // Catch: Throwable -> L9
        r101 = r101 + 1;
        goto L4
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ECSearchRecycledViewPool() {
        this.f451867a = new SparseArray();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final synchronized RecyclerView.ViewHolder getRecycledView(int r100) {
        monitor-enter(this);
        InnerScrapData r101 = this.f451867a.get(r100);     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        ArrayList<RecyclerView.ViewHolder> r102 = r101.f451869b;     // Catch: Throwable -> L17
        if (r102 == null) goto L8;
        r102.size();     // Catch: Throwable -> L17
    L8:
        if (r101 != null) goto L10;
    L14:
        RecyclerView.ViewHolder r103 = super.getRecycledView(r100);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r103;
    L10:
        if ((!r101.f451869b.isEmpty()) == false) goto L14;
        ArrayList<RecyclerView.ViewHolder> r104 = r101.f451869b;     // Catch: Throwable -> L17
        ListProtector.remove(r104, r104.size() - 1);     // Catch: Throwable -> L17
        r104.size();     // Catch: Throwable -> L17
        int r105 = this.f451867a.get(r100).f451868a;     // Catch: Throwable -> L17
        RecyclerView.ViewHolder r106 = super.getRecycledView(r100);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r106;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final synchronized void putRecycledView(RecyclerView.ViewHolder r100) {
        monitor-enter(this);
        if (r100 != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        super.putRecycledView(r100);     // Catch: Throwable -> L16
        int r101 = r100.getItemViewType();     // Catch: Throwable -> L16
        InnerScrapData r102 = this.f451867a.get(r101);     // Catch: Throwable -> L16
        if (r102 != null) goto L9;
        r102 = new InnerScrapData(null);     // Catch: Throwable -> L16
        this.f451867a.put(r101, r102);     // Catch: Throwable -> L16
    L9:
        ArrayList<RecyclerView.ViewHolder> r103 = r102.f451869b;     // Catch: Throwable -> L16
        if (this.f451867a.get(r101).f451868a > r103.size()) goto L13;
        monitor-exit(this);
        return;
    L13:
        r103.add(r100);     // Catch: Throwable -> L16
        r103.size();     // Catch: Throwable -> L16
        int r104 = this.f451867a.get(r101).f451868a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final synchronized void setMaxRecycledViews(int r100, int r101) {
        monitor-enter(this);
        super.setMaxRecycledViews(r100, r101);     // Catch: Throwable -> L13
        InnerScrapData r102 = this.f451867a.get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L6;
        r102 = new InnerScrapData(null);     // Catch: Throwable -> L13
        this.f451867a.put(r100, r102);     // Catch: Throwable -> L13
    L6:
        r102.f451868a = r101;     // Catch: Throwable -> L13
        ArrayList<RecyclerView.ViewHolder> r103 = r102.f451869b;     // Catch: Throwable -> L13
    L7:
        if (r103.size() <= r101) goto L11;
        ListProtector.remove(r103, r103.size() - 1);     // Catch: Throwable -> L13
        goto L7
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}

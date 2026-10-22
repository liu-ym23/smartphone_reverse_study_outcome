package com.ss.android.lark.widget.recyclerview;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import zdc.c;

/* JADX INFO: loaded from: classes38.dex */
public class MultiSelector<VALUE, A extends c<VALUE>> extends RecyclerView.AdapterDataObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f448172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, VALUE> f448173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<VALUE> f448174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f448175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f448176e;

    public interface a {
        void a();

        void onStatusChanged(boolean r100);
    }

    public MultiSelector(A r100) {
        this.f448173b = new LinkedHashMap();
        this.f448174c = new SparseArray();
        this.f448172a = r100;
    }

    public boolean b(VALUE r100) {
        return this.f448175d;
    }

    public final void c(boolean r100) {
        if (this.f448175d == r100) goto L11;
        this.f448175d = r100;
        ((LinkedHashMap) this.f448173b).clear();
        this.f448174c.clear();
        this.f448172a.e().notifyDataSetChanged();
        boolean r101 = this.f448175d;
        a r102 = this.f448176e;
        if (r102 == null) goto L7;
        r102.onStatusChanged(r101);
    L7:
        if (r100 == false) goto L9;
        this.f448172a.e().registerAdapterDataObserver(this);
        return;
    L9:
        this.f448172a.e().unregisterAdapterDataObserver(this);
        return;
    }

    public final void d(int r100) {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L27;
        boolean r102 = !this.f448173b.containsKey(Integer.valueOf(this.f448172a.getItem(r100).hashCode()));
        if (r100 >= 0) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L18;
        Log.e(String.format("position %d out of index", new Object[]{Integer.valueOf(r100)}));
        return;
    L18:
        int r104 = this.f448173b.size();
        Object r105 = this.f448172a.getItem(r100);
        if (r102 == false) goto L21;
        this.f448173b.put(Integer.valueOf(r105.hashCode()), (VALUE) r105);
        this.f448174c.put(r100, (VALUE) r105);
    L22:
        this.f448172a.e().notifyItemChanged(r100);
        if (r104 == this.f448173b.size()) goto L30;
        a r106 = this.f448176e;
        if (r106 == null) goto L31;
        r106.a();
        return;
    L31:
        return;
    L30:
        return;
    L21:
        this.f448173b.remove(Integer.valueOf(r105.hashCode()));
        this.f448174c.remove(r100);
        goto L22
    L13:
        if (r100 >= this.f448172a.getItemCount()) goto L15;
        r103 = true;
        goto L16
    L27:
        Log.e(String.format("position %d out of index", new Object[]{Integer.valueOf(r100)}));
        return;
    L5:
        if (r100 >= this.f448172a.getItemCount()) goto L7;
        r101 = true;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int r100, int r101) {
        int r102 = (r101 + r100) - 1;
    L3:
        if (r102 < r100) goto L8;
        VALUE r103 = this.f448174c.get(r102);
        if (r103 == null) goto L7;
        this.f448173b.remove(Integer.valueOf(r103.hashCode()));
    L7:
        r102 = r102 - 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = r101 + r103;
        Object r105 = this.f448172a.getItem(r104);
        this.f448174c.put(r104, (VALUE) r105);
        this.f448174c.remove(r100 + r103);
        r103 = r103 + 1;
        goto L3
    }
}

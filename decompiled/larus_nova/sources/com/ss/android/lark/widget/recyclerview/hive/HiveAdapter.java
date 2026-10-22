package com.ss.android.lark.widget.recyclerview.hive;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zdc.c;

/* JADX INFO: loaded from: classes38.dex */
public abstract class HiveAdapter<Value> extends RecyclerView.Adapter<HiveViewHolder> implements c<Value>, View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<aec.a> f448184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a<Value>> f448185b;

    public interface a<Value> {
        aec.a a();
    }

    @Override // zdc.c
    public final RecyclerView.Adapter<?> e() {
        return this;
    }

    @Override // zdc.c
    public abstract Value getItem(int r100);

    public HiveAdapter() {
        this.f448184a = new SparseArray();
        this.f448185b = new ArrayList();
    }

    public static RecyclerView y2(View r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = r100.getParent();
        if ((r101 instanceof RecyclerView) == false) goto L10;
        return (RecyclerView) r101;
    L10:
        if ((r101 instanceof View) == true) goto L12;
        return null;
    L12:
        return y2((View) r101);
    }

    public static HiveViewHolder z2(View r100) {
        RecyclerView r101 = y2(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        RecyclerView.ViewHolder r102 = r101.findContainingViewHolder(r100);
        if (r102 != null) goto L9;
        return null;
    L9:
        if ((r102 instanceof HiveViewHolder) == true) goto L12;
        return null;
    L12:
        return (HiveViewHolder) r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Value r101 = getItem(r100);
        Iterator r102 = ((ArrayList) this.f448185b).iterator();
        aec.a r103 = null;
    L4:
        if (r102.hasNext() == false) goto L7;
        r103 = ((a) r102.next()).a();
        if (r103 == null) goto L4;
    L7:
        if (r103 == null) goto L11;
        int r104 = r103.h();
        aec.a r105 = this.f448184a.get(r104);
        this.f448184a.put(r104, r103);
        return r104;
    L11:
        throw new IllegalStateException("cannot found cell for " + r101.getClass());
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        HiveViewHolder r101 = z2(r100);
        if (r101 == null) goto L9;
        if (r101.getAdapterPosition() == (-1)) goto L10;
        r101.f448187b.d(r101.f448186a);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("Could not find RecyclerView holder for clicked view");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        HiveViewHolder r101 = z2(r100);
        if (r101 == null) goto L11;
        if (r101.getAdapterPosition() != (-1)) goto L7;
        return false;
    L7:
        return r101.f448187b.e(r101.f448186a);
    L11:
        throw new IllegalStateException("Could not find RecyclerView holder for clicked view");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        aec.a r101 = ((HiveViewHolder) r100).f448187b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        aec.a r101 = ((HiveViewHolder) r100).f448187b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        HiveViewHolder r101 = (HiveViewHolder) r100;
        aec.a r102 = r101.f448187b;
        if (r102 == null) goto L8;
        VH r103 = r101.f448186a;
        if (r103 == 0) goto L9;
        r102.g(r103);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [VH extends aec.e, aec.e] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        HiveViewHolder r102 = (HiveViewHolder) r100;
        PerfLog.start("onBindViewHolder_" + r101, "");
        Value r103 = getItem(r101);
        r102.f448188c = r103;
        r102.itemView.setOnClickListener(this);
        r102.itemView.setOnLongClickListener(this);
        aec.a r104 = r102.f448187b;
        if (r102.f448186a != 0) goto L5;
        ?? r105 = r104.f();
        r102.f448186a = r105;
        r105.f3133b = r102;
        r105.f(r102.itemView);
    L5:
        r104.c(r102.f448186a, r103);
        PerfLog.end("onBindViewHolder_" + r101, "");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        PerfLog.start("onCreateViewHolder_" + r101, "");
        aec.a r102 = this.f448184a.get(r101);
        HiveViewHolder r103 = new HiveViewHolder(r102.a(r100), r102);
        PerfLog.end("onCreateViewHolder_" + r101, "");
        return r103;
    }
}

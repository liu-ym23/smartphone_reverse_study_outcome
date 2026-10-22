package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import dw7.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bouncycastle.asn1.cmc.BodyPartID;
import wv7.d;
import yv7.a;
import yv7.c;

/* JADX INFO: loaded from: classes23.dex */
public class ComposedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements d<RecyclerView.ViewHolder>, BridgeAdapterDataObserver.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f276033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f276034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yv7.d f276035c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        c r100 = this.f276034b;
        if (r100.f569306e != (-1)) goto L10;
        int r101 = ((ArrayList) r100.f569302a.f569300c).size();
        if (r101 != 0) goto L7;
        int r102 = 0;
    L8:
        r100.f569306e = r102;
        goto L10
    L7:
        int r103 = r101 - 1;
        r102 = r100.a(r103) + r100.b(r103);
    L10:
        return r100.f569306e;
    }

    public ComposedAdapter() {
        a r100 = new a(this);
        this.f276033a = r100;
        this.f276034b = new c(r100);
        this.f276035c = new yv7.d();
        setHasStableIds(true);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void M(Object r100) {
        List r101 = (List) r100;
        c r102 = this.f276034b;
        r102.f569306e = -1;
        r102.f569303b = 0;
        Arrays.fill(r102.f569304c, -1);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        long r101 = this.f276034b.c(r100);
        int r102 = (int) (r101 >>> 32);
        int r103 = (int) (r101 & BodyPartID.bodyIdMax);
        RecyclerView.Adapter r104 = this.f276033a.a(r102);
        int r105 = r104.getItemViewType(r103);
        long r106 = r104.getItemId(r103);
        int r107 = (this.f276035c.c(r102, r105) & 2130706432) >>> 24;
        if (r107 < 0) goto L9;
        if (r107 > 127) goto L9;
        return (r106 & (-9151314442816847873L)) | (((long) r107) << 56);
    L9:
        throw new IllegalArgumentException("Segment value is out of range. (segment = " + r107 + ")");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        long r101 = this.f276034b.c(r100);
        int r102 = (int) (r101 >>> 32);
        int r103 = (int) (r101 & BodyPartID.bodyIdMax);
        int r104 = this.f276033a.a(r102).getItemViewType(r103);
        return this.f276035c.c(r102, r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        List<RecyclerView.Adapter> r101 = this.f276033a.f569301d;
        int r102 = 0;
    L3:
        ArrayList r103 = (ArrayList) r101;
        if (r102 >= r103.size()) goto L6;
        ((RecyclerView.Adapter) ListProtector.get(r103, r102)).onAttachedToRecyclerView(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        List<RecyclerView.Adapter> r101 = this.f276033a.f569301d;
        int r102 = 0;
    L3:
        ArrayList r103 = (ArrayList) r101;
        if (r102 >= r103.size()) goto L6;
        ((RecyclerView.Adapter) ListProtector.get(r103, r102)).onDetachedFromRecyclerView(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        return h1(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        C1(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        C(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        E0(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r100) {
        if (r100 == true) goto L4;
    L12:
        super.setHasStableIds(r100);
        return;
    L4:
        if (hasStableIds() == true) goto L12;
        int r101 = ((ArrayList) this.f276033a.f569300c).size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L12;
        if (this.f276033a.a(r102).hasStableIds() == false) goto L11;
        r102 = r102 + 1;
        goto L6
    L11:
        throw new IllegalStateException("All child adapters must support stable IDs");
    }

    @Override // wv7.c
    public final void C(RecyclerView.ViewHolder r100, int r101) {
        long r102 = this.f276035c.b(r101);
        int r103 = (int) ((r102 >>> 48) & 65535);
        int r104 = yv7.d.a(r102);
        b.c(this.f276033a.a(r103), r100, r104);
    }

    @Override // wv7.c
    public final void C1(RecyclerView.ViewHolder r100, int r101) {
        long r102 = this.f276035c.b(r101);
        int r103 = (int) ((r102 >>> 48) & 65535);
        int r104 = yv7.d.a(r102);
        b.b(this.f276033a.a(r103), r100, r104);
    }

    @Override // wv7.c
    public final void E0(RecyclerView.ViewHolder r100, int r101) {
        long r102 = this.f276035c.b(r101);
        int r103 = (int) ((r102 >>> 48) & 65535);
        int r104 = yv7.d.a(r102);
        b.d(this.f276033a.a(r103), r100, r104);
    }

    @Override // wv7.c
    public final boolean h1(RecyclerView.ViewHolder r100, int r101) {
        long r102 = this.f276035c.b(r101);
        int r103 = (int) ((r102 >>> 48) & 65535);
        int r104 = yv7.d.a(r102);
        return b.a(this.f276033a.a(r103), r100, r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        long r102 = this.f276034b.c(r101);
        int r103 = (int) (r102 >>> 32);
        int r104 = (int) (r102 & BodyPartID.bodyIdMax);
        this.f276033a.a(r103).onBindViewHolder(r100, r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        long r102 = this.f276035c.b(r101);
        int r103 = (int) ((r102 >>> 48) & 65535);
        int r104 = yv7.d.a(r102);
        return this.f276033a.a(r103).onCreateViewHolder(r100, r104);
    }

    @Override // wv7.d
    public final void w1(wv7.b r100, int r101) {
        long r102 = this.f276034b.c(r101);
        if (r102 == (-1)) goto L6;
        int r103 = (int) (r102 >>> 32);
        int r104 = (int) (r102 & BodyPartID.bodyIdMax);
        r100.f561598a = this.f276033a.a(r103);
        r100.f561599b = r104;
        yv7.b r105 = (yv7.b) ListProtector.get(this.f276033a.f569299b, r103);
        r100.getClass();
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void U(Object r100, int r101, int r102) {
        List r103 = (List) r100;
        if (r102 <= 0) goto L14;
        int r104 = r103.size();
        int r105 = 0;
        if (r104 != 1) goto L8;
        int r106 = this.f276033a.b((yv7.b) ListProtector.get(r103, 0));
        this.f276034b.d(r106);
        notifyItemRangeInserted(this.f276034b.b(r106) + r101, r102);
        return;
    L8:
        if (r105 >= r104) goto L10;
        int r107 = this.f276033a.b((yv7.b) ListProtector.get(r103, r105));
        this.f276034b.d(r107);
        r105 = r105 + 1;
        goto L8
    L10:
        notifyDataSetChanged();
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void h0(Object r100, int r101, int r102) {
        List r103 = (List) r100;
        if (r102 <= 0) goto L14;
        int r104 = r103.size();
        int r105 = 0;
        if (r104 != 1) goto L8;
        int r106 = this.f276033a.b((yv7.b) ListProtector.get(r103, 0));
        this.f276034b.d(r106);
        notifyItemRangeRemoved(this.f276034b.b(r106) + r101, r102);
        return;
    L8:
        if (r105 >= r104) goto L10;
        int r107 = this.f276033a.b((yv7.b) ListProtector.get(r103, r105));
        this.f276034b.d(r107);
        r105 = r105 + 1;
        goto L8
    L10:
        notifyDataSetChanged();
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void i0(Object r100, int r101, int r102) {
        List r103 = (List) r100;
        int r104 = r103.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        int r106 = this.f276033a.b((yv7.b) ListProtector.get(r103, r105));
        notifyItemRangeChanged(this.f276034b.b(r106) + r101, r102);
        r105 = r105 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        long r103 = this.f276034b.c(r101);
        int r104 = (int) (r103 >>> 32);
        int r105 = (int) (r103 & BodyPartID.bodyIdMax);
        this.f276033a.a(r104).onBindViewHolder(r100, r105, r102);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void B1(Object r100, int r101, int r102, int r103) {
        List r104 = (List) r100;
        if (r103 != 1) goto L10;
        if (r104.size() != 1) goto L7;
        int r105 = this.f276033a.b((yv7.b) ListProtector.get(r104, 0));
        notifyItemMoved(this.f276034b.b(r105) + r101, this.f276034b.b(r105) + r102);
        return;
    L7:
        notifyDataSetChanged();
        return;
    L10:
        throw new IllegalStateException("itemCount should be always 1  (actual: " + r103 + ")");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void w2(Object r100, int r101, int r102, Object r103) {
        List r104 = (List) r100;
        int r105 = r104.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        int r107 = this.f276033a.b((yv7.b) ListProtector.get(r104, r106));
        notifyItemRangeChanged(this.f276034b.b(r107) + r101, r102, r103);
        r106 = r106 + 1;
        goto L3
    }
}

package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import aw7.c;
import com.bytedance.ee.android.file.picker.lib.v2.ui.confirm.ConfirmAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractExpandableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements c<GVH, CVH> {
    public int P(int r100, int r101) {
        return 0;
    }

    @Override // aw7.c
    public final void R1() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 0;
    }

    public boolean l1(int r100) {
        return this instanceof ConfirmAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return null;
    }

    public void y2() {
    }

    public void z2() {
    }

    public AbstractExpandableItemAdapter() {
    }

    @Override // aw7.c
    public final boolean K0(int r100, boolean r101) {
        z2();
        return true;
    }

    @Override // aw7.c
    public final boolean v1(int r100, boolean r101) {
        y2();
        return true;
    }

    public void a1(GVH r100, int r101, int r102, List<Object> r103) {
        p0(r100, r101);
    }

    public void f1(CVH r100, int r101, int r102, int r103, List<Object> r104) {
        d1(r100, r101, r102, r103);
    }
}

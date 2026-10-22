package com.ixigua.lib.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface a<T, V extends RecyclerView.ViewHolder> extends c {
    V a(LayoutInflater r100, ViewGroup r101);

    void b(V r100);

    void c(V r100);

    void d(V r100, T r101);

    boolean e(V r100);

    void f(V r100, T r101, List<? extends Object> r102);

    void onViewRecycled(V r100);
}

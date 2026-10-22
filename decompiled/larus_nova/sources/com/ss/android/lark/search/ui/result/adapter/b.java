package com.ss.android.lark.search.ui.result.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface b<T, VH extends RecyclerView.ViewHolder> {
    void a(RecyclerView.ViewHolder r100, SearchBaseInfo r101, int r102, List r103);

    void b(VH r100);

    void c(VH r100);

    RecyclerView.ViewHolder d(Context r100, ViewGroup r101);

    void e(RecyclerView.ViewHolder r100);

    void onViewRecycled(VH r100);
}

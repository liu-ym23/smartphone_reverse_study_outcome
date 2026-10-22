package com.ss.android.lark.biz.im.api.extension.list;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes34.dex */
public interface a<VO, VH extends RecyclerView.ViewHolder> {
    void a();

    int b();

    RecyclerView.ViewHolder c();

    long getItemId();

    void onViewRecycled();
}

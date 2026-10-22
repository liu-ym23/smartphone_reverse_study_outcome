package com.larksuite.component.blockit.hashtag.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes24.dex */
public abstract class RecyclerSwipeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements py7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f283058a;

    public final void y2() {
        this.f283058a.b(true);
    }

    public RecyclerSwipeAdapter() {
        this.f283058a = new b(this);
    }

    public final void z2() {
        super.notifyDataSetChanged();
    }
}

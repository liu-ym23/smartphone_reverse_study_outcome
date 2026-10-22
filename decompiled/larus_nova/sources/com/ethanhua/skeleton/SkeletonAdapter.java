package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.supercharge.shimmerlayout.ShimmerLayout;

/* JADX INFO: loaded from: classes22.dex */
public class SkeletonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f274012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f274014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f274015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f274016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f274017f;

    public class a extends RecyclerView.ViewHolder {
        public a(View r100) {
            super(r100);
        }
    }

    public SkeletonAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f274012a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (this.f274015d == false) goto L6;
        ShimmerLayout r102 = (ShimmerLayout) r100.itemView;
        r102.setShimmerAnimationDuration(this.f274016e);
        r102.setShimmerAngle(this.f274017f);
        r102.setShimmerColor(this.f274014c);
        r102.c();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (this.f274015d == false) goto L7;
        return new ShimmerViewHolder(r102, r100, this.f274013b);
    L7:
        return new a(r102.inflate(this.f274013b, r100, false));
    }
}

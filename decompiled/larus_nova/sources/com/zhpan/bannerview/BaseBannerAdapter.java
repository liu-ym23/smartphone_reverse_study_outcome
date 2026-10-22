package com.zhpan.bannerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import arc.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BaseBannerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f464552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f464553b;

    public abstract int getLayoutId(int r100);

    public abstract void y2(BaseViewHolder r100, Object r101, int r102);

    public final int A2() {
        return ((ArrayList) this.f464552a).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f464553b == false) goto L9;
        if (A2() <= 1) goto L9;
        return 1000;
    L9:
        return A2();
    }

    public BaseBannerAdapter() {
        this.f464552a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        a.b(r100, A2());
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseViewHolder r102 = (BaseViewHolder) r100;
        int r103 = a.b(r101, A2());
        r102.itemView.setOnClickListener(new xqc.a(this, r101));
        Object r104 = ListProtector.get(this.f464552a, r103);
        A2();
        y2(r102, r104, r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, LayoutInflater.from(r100.getContext()).inflate(getLayoutId(r101), r100, false));
    }

    public BaseViewHolder z2(ViewGroup r100, View r101) {
        return new BaseViewHolder(r101);
    }
}

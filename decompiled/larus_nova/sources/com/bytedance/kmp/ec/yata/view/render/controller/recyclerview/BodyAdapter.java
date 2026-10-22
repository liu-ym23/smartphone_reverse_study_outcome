package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/ec/yata/view/render/controller/recyclerview/BodyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/kmp/ec/yata/view/render/controller/recyclerview/YaTaRecyclerViewHolder;", "yata-view-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class BodyAdapter extends RecyclerView.Adapter<YaTaRecyclerViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h<com.bytedance.kmp.ec.yata.view.render.controller.common.c> f251891a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f251891a.f251963f.size();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.BodyAdapter$itemCallback$1] */
    public BodyAdapter(com.bytedance.kmp.ec.yata.view.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        this.f251891a = new h(r100, this, new BodyAdapter$itemCallback$1());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(this.f251891a.f251963f, r100)).b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        YaTaRecyclerViewHolder r102 = (YaTaRecyclerViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r103 = (com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(this.f251891a.f251963f, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "holder");
        r102.f251902a = r103;
        r103.d(r102.itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Iterator<T> r102 = this.f251891a.f251963f.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((com.bytedance.kmp.ec.yata.view.render.controller.common.c) r103).b() != r101) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L12:
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r105 = (com.bytedance.kmp.ec.yata.view.render.controller.common.c) r103;
        if (r105 == null) goto L17;
        View r106 = r105.a();
        r106.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        YaTaRecyclerViewHolder r107 = new YaTaRecyclerViewHolder(r106);
        Intrinsics.checkNotNullParameter(r105, "holder");
        r107.f251902a = r105;
        return r107;
    L17:
        throw new RuntimeException("create vh error.");
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }
}

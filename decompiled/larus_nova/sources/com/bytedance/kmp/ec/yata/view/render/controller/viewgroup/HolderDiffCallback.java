package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/kmp/ec/yata/view/render/controller/viewgroup/HolderDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "yata-view-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class HolderDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.kmp.ec.yata.view.render.controller.common.c> f251964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.kmp.ec.yata.view.render.controller.common.c> f251965b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f251965b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f251964a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HolderDiffCallback(List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r100, List<? extends com.bytedance.kmp.ec.yata.view.render.controller.common.c> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        this.f251964a = r100;
        this.f251965b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        int r102 = com.bytedance.kmp.ec.yata.view.render.controller.common.d.f251846a;
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r103 = (com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(this.f251964a, r100);
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r104 = (com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(this.f251965b, r101);
        Intrinsics.checkNotNullParameter(r103, "oldItem");
        Intrinsics.checkNotNullParameter(r104, "newItem");
        return r103.c().o(r104.c());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        int r102 = com.bytedance.kmp.ec.yata.view.render.controller.common.d.f251846a;
        return com.bytedance.kmp.ec.yata.view.render.controller.common.d.a((com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(this.f251964a, r100), (com.bytedance.kmp.ec.yata.view.render.controller.common.c) ListProtector.get(this.f251965b, r101));
    }
}

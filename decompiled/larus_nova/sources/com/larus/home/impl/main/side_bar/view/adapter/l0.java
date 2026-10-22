package com.larus.home.impl.main.side_bar.view.adapter;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l0 extends DiffUtil.ItemCallback<com.larus.home.impl.main.side_bar.data.j0> {
    public l0() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(com.larus.home.impl.main.side_bar.data.j0 r100, com.larus.home.impl.main.side_bar.data.j0 r101) {
        com.larus.home.impl.main.side_bar.data.j0 r102 = r100;
        com.larus.home.impl.main.side_bar.data.j0 r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(com.larus.home.impl.main.side_bar.data.j0 r100, com.larus.home.impl.main.side_bar.data.j0 r101) {
        com.larus.home.impl.main.side_bar.data.j0 r102 = r100;
        com.larus.home.impl.main.side_bar.data.j0 r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.f344506a != r103.f344506a) goto L5;
        return true;
    L5:
        return false;
    }
}

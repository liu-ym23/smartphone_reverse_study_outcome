package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.anim;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c extends AbsAnimator {
    public abstract boolean i(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104);

    public c(RecyclerViewItemAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "viewItemAnimator");
        super(AnimateType.MOVE, r100);
    }
}

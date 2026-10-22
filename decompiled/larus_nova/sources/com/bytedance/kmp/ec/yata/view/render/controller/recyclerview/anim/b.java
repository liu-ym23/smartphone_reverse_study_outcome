package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.anim;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b {
    public abstract void a(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r103, int r104, int r105);

    public abstract void b(RecyclerView.ViewHolder r100);

    public abstract void c();

    public abstract boolean d();

    public abstract void e();

    public b(com.bytedance.kmp.ec.yata.view.c r100, RecyclerViewItemAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        Intrinsics.checkNotNullParameter(r101, "viewItemAnimator");
    }
}

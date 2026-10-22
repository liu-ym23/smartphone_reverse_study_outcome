package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {
    public static final ba6.d a(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof YaTaRecyclerViewHolder) == false) goto L5;
        YaTaRecyclerViewHolder r101 = (YaTaRecyclerViewHolder) r100;
    L6:
        if (r101 == null) goto L13;
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r102 = r101.f251902a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("innerHolder");
        r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.c();
    L13:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public static final String b(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof YaTaRecyclerViewHolder) == false) goto L5;
        YaTaRecyclerViewHolder r101 = (YaTaRecyclerViewHolder) r100;
    L6:
        if (r101 == null) goto L15;
        com.bytedance.kmp.ec.yata.view.render.controller.common.c r102 = r101.f251902a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("innerHolder");
        r102 = null;
    L10:
        if (r102 == null) goto L16;
        ba6.d r103 = r102.c();
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.getNodeName();
    L16:
        return null;
    L15:
        return null;
    L5:
        r101 = null;
        goto L6
    }
}

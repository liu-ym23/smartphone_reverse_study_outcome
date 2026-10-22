package com.obric.miniapp.lynx;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f398026c;

    public a(int r100, int r101) {
        this.f398024a = r100;
        this.f398025b = r101;
        this.f398026c = 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L5;
        int r106 = r105.getItemCount();
    L6:
        if (r104 != 0) goto L9;
        r100.top = 0;
        return;
    L9:
        if (r104 == (r106 - 1)) goto L11;
        r100.top = this.f398024a;
        return;
    L11:
        if (r106 < this.f398026c) goto L13;
        r100.top = this.f398025b;
        return;
    L13:
        r100.top = this.f398024a;
        return;
    L5:
        r106 = 0;
        goto L6
    }
}

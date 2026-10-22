package com.bytedance.locallife.poi.media.ui.indicator;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/LinearItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LinearItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f262849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f262850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f262851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f262852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f262853e;

    public LinearItemDecoration(int r100, int r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this.f262849a = r100;
        this.f262850b = r101;
        this.f262851c = r102;
        this.f262852d = false;
        this.f262853e = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        if ((r104 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r105 = (LinearLayoutManager) r104;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        int r106 = r102.getChildAdapterPosition(r101);
        if (r106 != (-1)) goto L11;
        return;
    L11:
        int r107 = r105.getOrientation();
        if (r107 == 0) goto L29;
        if (r107 != 1) goto L45;
        if (r106 == 0) goto L17;
        int r108 = this.f262849a / 2;
    L21:
        r100.top = r108;
        if (r106 == (r103.getItemCount() - 1)) goto L24;
        int r109 = this.f262849a / 2;
    L28:
        r100.bottom = r109;
        return;
    L24:
        if (this.f262853e == false) goto L26;
        r109 = this.f262849a + this.f262851c;
        goto L28
    L26:
        r109 = this.f262851c;
        goto L28
    L17:
        if (this.f262852d == false) goto L19;
        r108 = this.f262849a + this.f262850b;
        goto L21
    L19:
        r108 = this.f262850b;
        goto L21
    L45:
        return;
    L29:
        if (r106 == 0) goto L31;
        int r110 = this.f262849a / 2;
    L35:
        r100.left = r110;
        if (r106 == (r103.getItemCount() - 1)) goto L38;
        int r111 = this.f262849a / 2;
    L42:
        r100.right = r111;
        return;
    L38:
        if (this.f262853e == false) goto L40;
        r111 = this.f262849a + this.f262851c;
        goto L42
    L40:
        r111 = this.f262851c;
        goto L42
    L31:
        if (this.f262852d == false) goto L33;
        r110 = this.f262849a + this.f262850b;
        goto L35
    L33:
        r110 = this.f262850b;
        goto L35
    L5:
        r105 = null;
        goto L6
    }
}

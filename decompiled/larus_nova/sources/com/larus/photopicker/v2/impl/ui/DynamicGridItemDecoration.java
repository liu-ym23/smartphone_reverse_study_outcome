package com.larus.photopicker.v2.impl.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/DynamicGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "initSpacing", "<init>", "(II)V", "currentSpacing", "setCurrentSpacing", "", "curSpacing", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f364615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f364616b;

    public DynamicGridItemDecoration(int r100, int r101) {
        this.f364615a = r100;
        this.f364616b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f364615a;
        int r106 = r104 % r105;
        int r107 = this.f364616b;
        r100.left = (r106 * r107) / r105;
        r100.right = r107 - (((r106 + 1) * r107) / r105);
        if (r104 < r105) goto L6;
        r100.top = r107;
        return;
    }
}

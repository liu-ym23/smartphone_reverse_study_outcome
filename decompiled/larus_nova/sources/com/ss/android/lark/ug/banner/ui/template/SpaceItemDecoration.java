package com.ss.android.lark.ug.banner.ui.template;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/ug/banner/ui/template/SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "start", "", "space", "end", "<init>", "(III)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "ug-banner-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f444397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f444398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f444399c;

    public SpaceItemDecoration(int r100, int r101, int r102) {
        this.f444397a = r100;
        this.f444398b = r101;
        this.f444399c = r102;
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
        if (r104 >= r106) goto L16;
        r100.top = 0;
        if (r104 != 1) goto L10;
        int r107 = this.f444397a;
    L11:
        r100.left = r107;
        if (r104 != (r106 - 1)) goto L14;
        int r108 = this.f444399c;
    L15:
        r100.right = r108;
        r100.bottom = 0;
        return;
    L14:
        r108 = 0;
        goto L15
    L10:
        r107 = this.f444398b;
        goto L11
    L16:
        super.getItemOffsets(r100, r101, r102, r103);
        return;
    L5:
        r106 = 0;
        goto L6
    }
}

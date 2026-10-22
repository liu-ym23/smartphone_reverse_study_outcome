package com.bytedance.ee.bear.list.homepage.banner;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/RecommendItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "columnCount", "", "<init>", "(I)V", "getColumnCount", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f228270a;

    public RecommendItemDecoration() {
        this.f228270a = 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = n.d(12);
        int r105 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r106 = r102.getAdapter();
        boolean r107 = false;
        if (r106 == null) goto L5;
        int r108 = r106.getItemCount();
    L6:
        int r109 = this.f228270a;
        int r110 = r108 / r109;
        if ((r108 % r109) != 0) goto L9;
        int r111 = 0;
    L11:
        if (r105 < (((r110 + r111) - 1) * r109)) goto L13;
        r107 = true;
    L13:
        int r112 = ((r105 % r109) * r104) / r109;
        r100.left = r112;
        r100.right = ((r104 * (r109 - 1)) / r109) - r112;
        if (r107 == false) goto L16;
        int r113 = 16;
    L17:
        r100.bottom = n.d(r113);
        return;
    L16:
        r113 = 18;
        goto L17
    L9:
        r111 = 1;
        goto L11
    L5:
        r108 = 0;
        goto L6
    }
}

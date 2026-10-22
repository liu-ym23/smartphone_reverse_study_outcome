package com.bytedance.ee.bear.list.homepage.banner;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/RecommendItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "columnCount", "", "<init>", "(I)V", "getColumnCount", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public RecommendItemDecoration() {
        this.a = 3;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        super.getItemOffsets(r5, r6, r7, r8);
        int r9 = n.d(12);
        int r10 = r7.getChildAdapterPosition(r6);
        RecyclerView.Adapter r11 = r7.getAdapter();
        boolean r0 = false;
        if (r11 == null) goto L5;
        int r12 = r11.getItemCount();
    L6:
        int r1 = this.a;
        int r2 = r12 / r1;
        if ((r12 % r1) != 0) goto L9;
        int r13 = 0;
    L11:
        if (r10 < (((r2 + r13) - 1) * r1)) goto L13;
        r0 = true;
    L13:
        int r14 = ((r10 % r1) * r9) / r1;
        r5.left = r14;
        r5.right = ((r9 * (r1 - 1)) / r1) - r14;
        if (r0 == false) goto L16;
        int r15 = 16;
    L17:
        r5.bottom = n.d(r15);
        return;
    L16:
        r15 = 18;
        goto L17
    L9:
        r13 = 1;
        goto L11
    L5:
        r12 = 0;
        goto L6
    }
}

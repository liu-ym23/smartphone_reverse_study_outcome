package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableMemberItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "maxCount", "", "<init>", "(I)V", "getMaxCount", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMemberItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public static final class a {
    }

    static {
    }

    public BitableMemberItemDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r6, View r7, RecyclerView r8, RecyclerView.State r9) {
        Intrinsics.checkNotNullParameter(r6, "outRect");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "state");
        super.getItemOffsets(r6, r7, r8, r9);
        int r10 = n.d(8);
        RecyclerView.Adapter r0 = r8.getAdapter();
        if (r0 == null) goto L5;
        int r1 = r0.getItemCount();
    L6:
        int r11 = r8.getChildAdapterPosition(r7);
        int r2 = this.a;
        int r3 = com.bytedance.ee.bear.bitable.core.usercomponent.d.a;
        Intrinsics.checkNotNullParameter("bitable.big.screen.impro.disable", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.big.screen.impro.disable") == true) goto L9;
        r2 = r8.getWidth() / y9c.d.a(40);
    L9:
        if (r1 < r2) goto L18;
        if (r2 <= 0) goto L18;
        int r12 = y9c.d.a(32);
        Intrinsics.checkNotNullParameter("bitable.big.screen.impro.disable", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.big.screen.impro.disable") == true) goto L14;
        int r13 = (r8.getWidth() - (r12 * r2)) / (r2 - 1);
    L16:
        if (r11 == (r2 - 1)) goto L20;
        r6.right = r13;
        return;
    L20:
        return;
    L14:
        r13 = ((n.w(r8.getContext()) - y9c.d.a(64)) - (r12 * r2)) / (r2 - 1);
    L18:
        r6.right = r10;
        return;
    L5:
        r1 = 0;
        goto L6
    }
}

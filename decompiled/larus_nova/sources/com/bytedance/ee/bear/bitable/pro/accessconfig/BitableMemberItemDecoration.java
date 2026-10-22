package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableMemberItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "maxCount", "", "<init>", "(I)V", "getMaxCount", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMemberItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f215114a;

    public static final class a {
    }

    static {
    }

    public BitableMemberItemDecoration(int r100) {
        this.f215114a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = n.d(8);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L5;
        int r106 = r105.getItemCount();
    L6:
        int r107 = r102.getChildAdapterPosition(r101);
        int r108 = this.f215114a;
        int r109 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("bitable.big.screen.impro.disable", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.big.screen.impro.disable") == true) goto L9;
        r108 = r102.getWidth() / y9c.d.a(40);
    L9:
        if (r106 < r108) goto L18;
        if (r108 <= 0) goto L18;
        int r110 = y9c.d.a(32);
        Intrinsics.checkNotNullParameter("bitable.big.screen.impro.disable", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.big.screen.impro.disable") == true) goto L14;
        int r111 = (r102.getWidth() - (r110 * r108)) / (r108 - 1);
    L16:
        if (r107 == (r108 - 1)) goto L20;
        r100.right = r111;
        return;
    L20:
        return;
    L14:
        r111 = ((n.w(r102.getContext()) - y9c.d.a(64)) - (r110 * r108)) / (r108 - 1);
    L18:
        r100.right = r104;
        return;
    L5:
        r106 = 0;
        goto L6
    }
}

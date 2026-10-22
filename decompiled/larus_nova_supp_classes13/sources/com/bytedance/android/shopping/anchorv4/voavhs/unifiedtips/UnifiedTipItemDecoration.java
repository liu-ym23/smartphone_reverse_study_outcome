package com.bytedance.android.shopping.anchorv4.voavhs.unifiedtips;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/unifiedtips/UnifiedTipItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnifiedTipItemDecoration extends RecyclerView.ItemDecoration {
    public static final /* synthetic */ int c = 0;
    public final int a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public UnifiedTipItemDecoration() {
        this.a = b.b(8);
        this.b = b.b(12);
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        Object r7 = r4.getTag(2131896920);
        Boolean r8 = Boolean.TRUE;
        if (Intrinsics.areEqual(r7, r8) == true) goto L5;
        return;
    L5:
        int r9 = this.a;
        r3.left = r9;
        r3.right = r9;
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        if (Intrinsics.areEqual(r4.getTag(2131896918), r8) == false) goto L9;
        r3.top = this.b;
        return;
    }
}

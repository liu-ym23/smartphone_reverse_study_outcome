package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryNoBorderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryNoBorderItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public static final class a {
    }

    static {
    }

    public CategoryNoBorderItemDecoration() {
        this(2);
    }

    public CategoryNoBorderItemDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, BaseCoreViewModel.CORE_TAG_STATE);
        r2.top = 0;
        r2.bottom = 0;
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != 0) goto L5;
        r2.left = UtilityKotlinExtentionsKt.d(Integer.valueOf(this.a));
        r2.right = 0;
        return;
    L5:
        RecyclerView.LayoutManager r7 = r4.getLayoutManager();
        if (r7 == null) goto L8;
        int r8 = r7.getItemCount();
    L10:
        if (r6 != (r8 - 1)) goto L12;
        r2.left = 0;
        r2.right = UtilityKotlinExtentionsKt.d(Integer.valueOf(this.a));
        return;
    L12:
        r2.left = 0;
        r2.right = 0;
        return;
    L8:
        r8 = 0;
        goto L10
    }
}

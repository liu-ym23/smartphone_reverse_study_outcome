package com.bytedance.ee.bear.bitable.card.view.stage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.ee.bear.bitable.card.view.record.CellItemDecoration;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/stage/StageItemDecoration;", "Lcom/bytedance/ee/bear/bitable/card/view/record/CellItemDecoration;", "<init>", "()V", "setItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "viewType", "", "totalCount", "position", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageItemDecoration extends CellItemDecoration {
    public StageItemDecoration() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.record.CellItemDecoration
    public final void i(Rect r100, View r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Context r105 = r101.getContext();
        boolean r106 = false;
        if (r102 != (-2)) goto L7;
        int r107 = UIHelper.dp2px(16.0f);
        r100.set(r107, 0, r107, UIHelper.dp2px(24.0f));
        return;
    L7:
        if (r102 != (-3)) goto L10;
        r100.set(0, 0, 0, UIHelper.dp2px(8.0f));
        return;
    L10:
        int r108 = r105.getResources().getDimensionPixelSize(R.dimen.bitable_cell_itemview_horizon_margin);
        int r109 = r105.getResources().getDimensionPixelSize(R.dimen.bitable_cell_vertical_margin);
        int r110 = r105.getResources().getDimensionPixelSize(R.dimen.bitable_cell_last_vertical_margin);
        if (r104 != 0) goto L13;
        r106 = true;
    L13:
        if (r106 == false) goto L15;
        int r111 = r109;
    L17:
        if (h(r103, r104) == true) goto L20;
        r110 = r109 / 2;
    L20:
        r100.set(r108, r111, r108, r110);
        return;
    L15:
        r111 = r109 / 2;
        goto L17
    }
}

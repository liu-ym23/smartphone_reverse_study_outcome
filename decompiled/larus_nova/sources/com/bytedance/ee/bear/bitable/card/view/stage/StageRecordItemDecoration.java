package com.bytedance.ee.bear.bitable.card.view.stage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.ee.bear.bitable.card.view.record.CellItemDecoration;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0014¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/stage/StageRecordItemDecoration;", "Lcom/bytedance/ee/bear/bitable/card/view/record/CellItemDecoration;", "<init>", "()V", "isLastItem", "", "total", "", "position", "setItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "viewType", "totalCount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageRecordItemDecoration extends CellItemDecoration {
    @Override // com.bytedance.ee.bear.bitable.card.view.record.CellItemDecoration
    public final boolean h(int r100, int r101) {
        if (r101 != (r100 - 2)) goto L5;
        return true;
    L5:
        return false;
    }

    public StageRecordItemDecoration() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.record.CellItemDecoration
    public final void i(Rect r100, View r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Context r105 = r101.getContext();
        if (r102 != (-3)) goto L6;
        r100.set(0, 0, 0, 0);
        return;
    L6:
        int r106 = r105.getResources().getDimensionPixelSize(R.dimen.bitable_cell_last_vertical_margin);
        if (h(r103, r104) == true) goto L10;
        r106 = 0;
    L10:
        r100.set(0, 0, 0, r106);
    }
}

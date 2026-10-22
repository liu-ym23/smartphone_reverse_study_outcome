package com.bytedance.ee.bear.bitable.card.view.cell.select;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapterV2;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapter;", "<init>", "()V", "applySelectItemLayoutStyle", "", "selectItem", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "applySelectItemBorderColor", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseFlexSelectAdapterV2 extends BaseFlexSelectAdapter {
    public BaseFlexSelectAdapterV2() {
        super(R.layout.bitable_card_multiselect_cell_item_v3);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final void E2(SelectTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "selectItem");
        if ((r100 instanceof SelectTagView) == false) goto L5;
        SelectTagView r101 = (SelectTagView) r100;
    L6:
        if (r101 == null) goto L9;
        r101.U(BaseTagSize.MEDIUM);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final void D2(SelectTextView r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r101) {
        Intrinsics.checkNotNullParameter(r100, "selectItem");
        String r102 = null;
        if ((r100 instanceof SelectTagView) == false) goto L5;
        SelectTagView r103 = (SelectTagView) r100;
    L6:
        if (r103 == null) goto L11;
        if (r101 == null) goto L9;
        r102 = r101.f207146f;
    L9:
        r103.S(r102);
        return;
    L11:
        return;
    L5:
        r103 = null;
        goto L6
    }
}

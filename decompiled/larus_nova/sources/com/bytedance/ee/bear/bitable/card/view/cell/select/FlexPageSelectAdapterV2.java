package com.bytedance.ee.bear.bitable.card.view.cell.select;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/FlexPageSelectAdapterV2;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapter;", "tagSize", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;", "<init>", "(Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;)V", "applySelectItemLayoutStyle", "", "selectItem", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "applySelectItemBorderColor", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "textSizeDp", "", "getTextSizeDp", "()I", "itemHeightDp", "getItemHeightDp", "fixWidthDp", "getFixWidthDp", "getItemMargin", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FlexPageSelectAdapterV2 extends BaseFlexSelectAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BaseTagSize f208053j;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float m1() {
        return com.bytedance.ee.util.ui.n.d(4);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int y2() {
        return 22;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public int z2() {
        return 27;
    }

    public FlexPageSelectAdapterV2() {
        this(BaseTagSize.LARGE);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int C2() {
        return (int) this.f208053j.getTextSizeSp();
    }

    public FlexPageSelectAdapterV2(BaseTagSize r100) {
        Intrinsics.checkNotNullParameter(r100, "tagSize");
        super(R.layout.bitable_page_multiselect_cell_item_v3);
        this.f208053j = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final void E2(SelectTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "selectItem");
        if ((r100 instanceof SelectTagView) == false) goto L5;
        SelectTagView r101 = (SelectTagView) r100;
    L6:
        if (r101 == null) goto L9;
        r101.U(this.f208053j);
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

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Object r101) {
        F2(r100, (com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a) r101);
    }
}

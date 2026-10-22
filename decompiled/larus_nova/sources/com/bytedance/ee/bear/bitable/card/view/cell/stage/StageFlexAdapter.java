package com.bytedance.ee.bear.bitable.card.view.cell.stage;

import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/stage/StageFlexAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/stage/BaseStageFlexAdapter;", "<init>", "()V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "textSizeDp", "", "getTextSizeDp", "()I", "itemHeightDp", "getItemHeightDp", "fixWidthDp", "getFixWidthDp", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageFlexAdapter extends BaseStageFlexAdapter {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final float A2() {
        return 7.5f;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int C2() {
        return 13;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int y2() {
        return 30;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int z2() {
        return 34;
    }

    public StageFlexAdapter() {
        super(R.layout.bitable_card_stage_multi_cell_item);
    }
}

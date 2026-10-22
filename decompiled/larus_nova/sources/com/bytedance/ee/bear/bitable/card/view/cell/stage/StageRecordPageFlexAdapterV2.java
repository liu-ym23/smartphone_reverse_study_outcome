package com.bytedance.ee.bear.bitable.card.view.cell.stage;

import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.d;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/stage/StageRecordPageFlexAdapterV2;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/stage/StageRecordPageFlexAdapter;", "<init>", "()V", "size", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;", "applyTagBackground", "", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "applyStatusDot", "iconRing", "Lcom/bytedance/ee/bear/bitable/common/widgets/common/RingView;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageRecordPageFlexAdapterV2 extends StageRecordPageFlexAdapter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BaseTagSize f208203h;

    public StageRecordPageFlexAdapterV2() {
        this.f208203h = BaseTagSize.LARGE;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.stage.BaseStageFlexAdapter
    public final void D2(RingView r100) {
        Intrinsics.checkNotNullParameter(r100, "iconRing");
        int r101 = a.f208209a;
        a.c(r100, this.f208203h);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.stage.BaseStageFlexAdapter
    public final void E2(ViewGroup r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        int r102 = a.f208209a;
        a.d(r100, this.f208203h);
        a.b(r100, this.f208203h, r101.f207144d, r101.f207146f);
    }
}

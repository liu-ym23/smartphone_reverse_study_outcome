package com.bytedance.ee.bear.bitable.infoarch.nativeview.card;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseListViewData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardViewData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseListViewData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardCellData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardRecordData;", "<init>", "()V", "setting", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardSetting;", "getSetting", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardSetting;", "setSetting", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardSetting;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardViewData extends BaseListViewData<CardCellData, CardRecordData> {
    private CardSetting setting;

    public CardViewData() {
    }

    public final CardSetting getSetting() {
        return this.setting;
    }

    public final void setSetting(CardSetting r100) {
        this.setting = r100;
    }
}

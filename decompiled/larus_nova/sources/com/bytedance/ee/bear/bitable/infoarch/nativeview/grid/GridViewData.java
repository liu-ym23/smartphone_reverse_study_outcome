package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseListViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field.GridFieldHeaderData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseListViewData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridCellData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridRecordData;", "<init>", "()V", "setting", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSetting;", "getSetting", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSetting;", "setSetting", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSetting;)V", "fieldHeaderData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldHeaderData;", "getFieldHeaderData", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldHeaderData;", "setFieldHeaderData", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldHeaderData;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridViewData extends BaseListViewData<GridCellData, GridRecordData> {
    private GridFieldHeaderData fieldHeaderData;
    private GridSetting setting;

    public GridViewData() {
    }

    public final GridFieldHeaderData getFieldHeaderData() {
        return this.fieldHeaderData;
    }

    public final GridSetting getSetting() {
        return this.setting;
    }

    public final void setFieldHeaderData(GridFieldHeaderData r100) {
        this.fieldHeaderData = r100;
    }

    public final void setSetting(GridSetting r100) {
        this.setting = r100;
    }
}

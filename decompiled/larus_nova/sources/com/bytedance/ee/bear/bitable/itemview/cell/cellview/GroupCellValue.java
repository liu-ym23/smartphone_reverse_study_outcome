package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.GroupEntity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/GroupCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ChatterCellValue;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/GroupEntity;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupCellValue extends ChatterCellValue<GroupEntity> {
    public GroupCellValue() {
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.cellview.ChatterCellValue, java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ GroupEntity remove(int r100) {
        return removeAt(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.itemview.cell.cellview.ChatterCellValue
    public /* bridge */ GroupEntity removeAt(int r100) {
        return (GroupEntity) remove(r100);
    }
}

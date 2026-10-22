package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.CellDataParser;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridCellDataParser;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/CellDataParser;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridCellData;", "<init>", "()V", "buildCellData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "bizDeserialize", "", "jsonObject", "Lcom/google/gson/JsonObject;", "cellData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridCellDataParser extends CellDataParser<GridCellData> {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.CellDataParser
    public final BaseCellData b() {
        return new GridCellData();
    }

    public GridCellDataParser() {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.CellDataParser
    public final void a(JsonObject r100, BaseCellData r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "cellData");
        if ((r101 instanceof GridCellData) == false) goto L5;
        GridCellData r102 = (GridCellData) r101;
    L6:
        if (r102 == null) goto L20;
        String r103 = CellDataParser.d(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        if (r103 != null) goto L10;
        r103 = "center";
    L10:
        r102.setGravity(r103);
        Boolean r104 = CellDataParser.c(r100, "isEmptyCol");
        if (r104 == null) goto L13;
        boolean r105 = r104.booleanValue();
    L14:
        r102.setEmptyCol(r105);
        Boolean r106 = CellDataParser.c(r100, "showEmptyCell");
        if (r106 == null) goto L17;
        boolean r107 = r106.booleanValue();
    L18:
        r102.setShowEmptyCell(r107);
        return;
    L17:
        r107 = true;
        goto L18
    L13:
        r105 = false;
        goto L14
    L20:
        return;
    L5:
        r102 = null;
        goto L6
    }
}

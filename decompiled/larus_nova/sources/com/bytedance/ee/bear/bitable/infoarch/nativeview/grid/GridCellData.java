package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldUIKitFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridCellData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "<init>", "()V", "isEmptyCol", "", "()Z", "setEmptyCol", "(Z)V", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "getGravity", "()Ljava/lang/String;", "setGravity", "(Ljava/lang/String;)V", "showEmptyCell", "getShowEmptyCell", "setShowEmptyCell", "getType", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldUIKitFactory$Type;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridCellData extends BaseCellData {
    private String gravity;
    private boolean isEmptyCol;
    private boolean showEmptyCell;

    public GridCellData() {
        this.gravity = "center";
        this.showEmptyCell = true;
    }

    public final String getGravity() {
        return this.gravity;
    }

    public final boolean getShowEmptyCell() {
        return this.showEmptyCell;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData
    public FieldUIKitFactory.Type getType() {
        return FieldUIKitFactory.Type.GRID;
    }

    public final boolean isEmptyCol() {
        return this.isEmptyCol;
    }

    public final void setEmptyCol(boolean r100) {
        this.isEmptyCol = r100;
    }

    public final void setGravity(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gravity = r100;
    }

    public final void setShowEmptyCell(boolean r100) {
        this.showEmptyCell = r100;
    }
}

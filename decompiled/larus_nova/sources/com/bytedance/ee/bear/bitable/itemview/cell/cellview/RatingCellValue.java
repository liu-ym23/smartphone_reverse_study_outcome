package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/RatingCellValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "", "getMax", "()I", "setMax", "(I)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin", "setMin", "cellValue", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/NumberModel;", "getCellValue", "()Ljava/util/List;", "setCellValue", "(Ljava/util/List;)V", "rating", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberSymbol;", "getRating", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberSymbol;", "setRating", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberSymbol;)V", "getSymbol", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RatingCellValue implements NonProguard {
    private List<NumberModel> cellValue;
    private int max;
    private int min;
    private FieldConfigMetaModel.NumberSymbol rating;

    public final String getSymbol() {
        String r100 = this.rating.getSymbol();
        if (r100 != null) goto L6;
        return ScoreTags.SCORE_TYPE_STAR;
    L6:
        return r100;
    }

    public RatingCellValue() {
        this.max = 5;
        this.min = 1;
        this.cellValue = new ArrayList();
        this.rating = new FieldConfigMetaModel.NumberSymbol();
    }

    public final List<NumberModel> getCellValue() {
        return this.cellValue;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final FieldConfigMetaModel.NumberSymbol getRating() {
        return this.rating;
    }

    public final void setCellValue(List<NumberModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cellValue = r100;
    }

    public final void setMax(int r100) {
        this.max = r100;
    }

    public final void setMin(int r100) {
        this.min = r100;
    }

    public final void setRating(FieldConfigMetaModel.NumberSymbol r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rating = r100;
    }
}

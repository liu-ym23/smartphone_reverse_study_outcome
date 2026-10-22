package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ProgressCellValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "", "getMax", "()D", "setMax", "(D)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin", "setMin", "progress", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/Progress;", "getProgress", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/Progress;", "setProgress", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/Progress;)V", "cellValue", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/NumberModel;", "getCellValue", "()Ljava/util/List;", "setCellValue", "(Ljava/util/List;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProgressCellValue implements NonProguard {
    private List<NumberModel> cellValue;
    private double max;
    private double min;
    private Progress progress;

    public ProgressCellValue() {
        this.max = 100.0d;
        this.cellValue = new ArrayList();
    }

    public final List<NumberModel> getCellValue() {
        return this.cellValue;
    }

    public final double getMax() {
        return this.max;
    }

    public final double getMin() {
        return this.min;
    }

    public final Progress getProgress() {
        return this.progress;
    }

    public final void setCellValue(List<NumberModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cellValue = r100;
    }

    public final void setMax(double r100) {
        this.max = r100;
    }

    public final void setMin(double r100) {
        this.min = r100;
    }

    public final void setProgress(Progress r100) {
        this.progress = r100;
    }
}

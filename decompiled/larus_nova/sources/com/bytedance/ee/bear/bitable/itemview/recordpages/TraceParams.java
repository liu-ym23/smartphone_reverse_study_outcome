package com.bytedance.ee.bear.bitable.itemview.recordpages;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/TraceParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "buildRecordDuration", "", "getBuildRecordDuration", "()Ljava/lang/Double;", "setBuildRecordDuration", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "openRecordTimestamp", "getOpenRecordTimestamp", "setOpenRecordTimestamp", "editCellDuration", "getEditCellDuration", "setEditCellDuration", "editCellTimestamp", "getEditCellTimestamp", "setEditCellTimestamp", "editCellType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "getEditCellType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "setEditCellType", "(Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TraceParams implements NonProguard {
    private Double buildRecordDuration;
    private Double editCellDuration;
    private Double editCellTimestamp;
    private EFieldUIType editCellType;
    private Double openRecordTimestamp;

    public TraceParams() {
    }

    public final Double getBuildRecordDuration() {
        return this.buildRecordDuration;
    }

    public final Double getEditCellDuration() {
        return this.editCellDuration;
    }

    public final Double getEditCellTimestamp() {
        return this.editCellTimestamp;
    }

    public final EFieldUIType getEditCellType() {
        return this.editCellType;
    }

    public final Double getOpenRecordTimestamp() {
        return this.openRecordTimestamp;
    }

    public final void setBuildRecordDuration(Double r100) {
        this.buildRecordDuration = r100;
    }

    public final void setEditCellDuration(Double r100) {
        this.editCellDuration = r100;
    }

    public final void setEditCellTimestamp(Double r100) {
        this.editCellTimestamp = r100;
    }

    public final void setEditCellType(EFieldUIType r100) {
        this.editCellType = r100;
    }

    public final void setOpenRecordTimestamp(Double r100) {
        this.openRecordTimestamp = r100;
    }
}

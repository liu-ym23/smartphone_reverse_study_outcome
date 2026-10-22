package com.bytedance.ee.bear.bitable.celleditor.model.upload;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/model/upload/TargetCellInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "baseId", "", "tableId", "recordId", "fieldId", "editCellMode", "", "isPreAdd", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getBaseId", "()Ljava/lang/String;", "getTableId", "getRecordId", "getFieldId", "getEditCellMode", "()I", "()Z", "equals", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TargetCellInfo implements NonProguard {
    private final String baseId;
    private final int editCellMode;
    private final String fieldId;
    private final boolean isPreAdd;
    private final String recordId;
    private final String tableId;

    public int hashCode() {
        return (((((((this.baseId.hashCode() * 31) + this.tableId.hashCode()) * 31) + this.recordId.hashCode()) * 31) + this.fieldId.hashCode()) * 31) + this.editCellMode;
    }

    public String toString() {
        return "TargetCellInfo(tableId=" + this.tableId + ", recordId=" + this.recordId + ", fieldId=" + this.fieldId + ", editCellMode=" + this.editCellMode + ", isPreAdd=" + this.isPreAdd + ')';
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final int getEditCellMode() {
        return this.editCellMode;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final boolean isPreAdd() {
        return this.isPreAdd;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof TargetCellInfo) == false) goto L15;
        TargetCellInfo r101 = (TargetCellInfo) r100;
        if (Intrinsics.areEqual(this.baseId, r101.baseId) == false) goto L15;
        if (Intrinsics.areEqual(this.tableId, r101.tableId) == false) goto L15;
        if (Intrinsics.areEqual(this.recordId, r101.recordId) == false) goto L15;
        if (Intrinsics.areEqual(this.fieldId, r101.fieldId) == false) goto L15;
        if (this.editCellMode != r101.editCellMode) goto L15;
        return true;
    L15:
        return false;
    }

    public TargetCellInfo(String r100, String r101, String r102, String r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "baseId");
        Intrinsics.checkNotNullParameter(r101, "tableId");
        Intrinsics.checkNotNullParameter(r102, "recordId");
        Intrinsics.checkNotNullParameter(r103, "fieldId");
        this.baseId = r100;
        this.tableId = r101;
        this.recordId = r102;
        this.fieldId = r103;
        this.editCellMode = r104;
        this.isPreAdd = r105;
    }
}

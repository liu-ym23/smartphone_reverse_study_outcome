package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "tableId", "", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "recordId", "getRecordId", "setRecordId", "fieldId", "getFieldId", "setFieldId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditorParams implements NonProguard {
    private String fieldId;
    private String recordId;
    private String tableId;

    public EditorParams() {
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

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setRecordId(String r100) {
        this.recordId = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }
}

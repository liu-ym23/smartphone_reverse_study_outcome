package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorLocation;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "baseId", "", "getBaseId", "()Ljava/lang/String;", "setBaseId", "(Ljava/lang/String;)V", "fieldId", "getFieldId", "setFieldId", "recordId", "getRecordId", "setRecordId", "tableId", "getTableId", "setTableId", "renderId", "getRenderId", "setRenderId", "viewId", "getViewId", "setViewId", "mode", "", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditorLocation implements NonProguard {
    private String baseId;
    private String fieldId;
    private Integer mode;
    private String recordId;
    private String renderId;
    private String tableId;
    private String viewId;

    public EditorLocation() {
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getRenderId() {
        return this.renderId;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setBaseId(String r100) {
        this.baseId = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setMode(Integer r100) {
        this.mode = r100;
    }

    public final void setRecordId(String r100) {
        this.recordId = r100;
    }

    public final void setRenderId(String r100) {
        this.renderId = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }
}

package com.bytedance.ee.bear.bitable.card.model.jsmodel.permission;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B1\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/ParamBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "viewId", "recordId", "fieldId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTableId", "()Ljava/lang/String;", "setTableId", "(Ljava/lang/String;)V", "getViewId", "setViewId", "getRecordId", "setRecordId", "getFieldId", "setFieldId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParamBean implements NonProguard {
    private String fieldId;
    private String recordId;
    private String tableId;
    private String viewId;

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
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

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public ParamBean(String r100, String r101, String r102, String r103) {
        this.tableId = r100;
        this.viewId = r101;
        this.recordId = r102;
        this.fieldId = r103;
    }
}

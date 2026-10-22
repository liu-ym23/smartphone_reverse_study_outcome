package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageActionPayload;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "<init>", "()V", "stackIdentify", "", "getStackIdentify", "()Ljava/lang/String;", "setStackIdentify", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "viewId", "getViewId", "setViewId", "recordId", "getRecordId", "setRecordId", "fieldId", "getFieldId", "setFieldId", "extra", "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageExtra;", "getExtra", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageExtra;", "setExtra", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageExtra;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageActionPayload extends Action {
    private StageExtra extra;
    private String fieldId;
    private String recordId;
    private String stackIdentify;
    private String tableId;
    private String viewId;

    public StageActionPayload() {
        super(null, null);
    }

    public final StageExtra getExtra() {
        return this.extra;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getStackIdentify() {
        return this.stackIdentify;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setExtra(StageExtra r100) {
        this.extra = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setRecordId(String r100) {
        this.recordId = r100;
    }

    public final void setStackIdentify(String r100) {
        this.stackIdentify = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }
}

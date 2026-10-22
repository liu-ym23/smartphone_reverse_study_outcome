package com.bytedance.ee.bear.bitable.card.view.cell.formgrid;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FieldModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldId", "", "getFieldId", "()Ljava/lang/String;", "setFieldId", "(Ljava/lang/String;)V", "fieldName", "getFieldName", "setFieldName", "fieldWidth", "", "getFieldWidth", "()Ljava/lang/Float;", "setFieldWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "showRequired", "", "getShowRequired", "()Ljava/lang/Boolean;", "setShowRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldModel implements NonProguard {
    private String fieldId;
    private String fieldName;
    private Float fieldWidth;
    private Boolean showRequired;

    public FieldModel() {
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final Float getFieldWidth() {
        return this.fieldWidth;
    }

    public final Boolean getShowRequired() {
        return this.showRequired;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setFieldWidth(Float r100) {
        this.fieldWidth = r100;
    }

    public final void setShowRequired(Boolean r100) {
        this.showRequired = r100;
    }
}

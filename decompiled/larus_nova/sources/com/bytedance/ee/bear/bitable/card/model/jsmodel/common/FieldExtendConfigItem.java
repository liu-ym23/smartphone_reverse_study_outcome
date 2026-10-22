package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendConfigItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "extendFieldType", "", "getExtendFieldType", "()Ljava/lang/String;", "setExtendFieldType", "(Ljava/lang/String;)V", "fieldType", "", "fieldUIType", "name", "getName", "setName", "fieldId", "getFieldId", "setFieldId", "fieldName", "getFieldName", "setFieldName", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "getFieldCompositeType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "isChecked", "", "()Z", "setChecked", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldExtendConfigItem implements NonProguard {
    private String extendFieldType;
    private String fieldId;
    private String fieldName;
    private final int fieldType;
    private final String fieldUIType;
    private boolean isChecked;
    private String name;

    public FieldExtendConfigItem() {
    }

    public final FieldCompositeType getFieldCompositeType() {
        return new FieldCompositeType(Integer.valueOf(this.fieldType), this.fieldUIType);
    }

    public final String getExtendFieldType() {
        return this.extendFieldType;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean r100) {
        this.isChecked = r100;
    }

    public final void setExtendFieldType(String r100) {
        this.extendFieldType = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }
}

package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B/\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendFieldBaseInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldId", "", "fieldName", "fieldType", "", "fieldUIType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getFieldId", "()Ljava/lang/String;", "setFieldId", "(Ljava/lang/String;)V", "getFieldName", "setFieldName", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "getFieldCompositeType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "equals", "", "other", "", "hashCode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FieldExtendFieldBaseInfo implements NonProguard {
    private String fieldId;
    private String fieldName;
    private final int fieldType;
    private final String fieldUIType;

    public final FieldCompositeType getFieldCompositeType() {
        return new FieldCompositeType(Integer.valueOf(this.fieldType), this.fieldUIType);
    }

    public int hashCode() {
        String r100 = this.fieldId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.fieldName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.fieldType) * 31;
        String r107 = this.fieldUIType;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public FieldExtendFieldBaseInfo() {
        this.fieldType = 0;
        this.fieldUIType = null;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FieldExtendFieldBaseInfo) == true) goto L8;
        return false;
    L8:
        FieldExtendFieldBaseInfo r101 = (FieldExtendFieldBaseInfo) r100;
        if (Intrinsics.areEqual(this.fieldId, r101.fieldId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fieldName, r101.fieldName) == true) goto L15;
        return false;
    L15:
        if (this.fieldType == r101.fieldType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fieldUIType, r101.fieldUIType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public FieldExtendFieldBaseInfo(String r100, String r101, int r102, String r103) {
        this.fieldId = r100;
        this.fieldName = r101;
        this.fieldType = r102;
        this.fieldUIType = r103;
    }
}

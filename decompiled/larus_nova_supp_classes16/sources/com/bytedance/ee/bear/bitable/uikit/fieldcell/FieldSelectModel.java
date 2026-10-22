package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\tH\u0016J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldSelectModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "fieldId", "", "fieldName", "fieldUIType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "isError", "", "isShowIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;ZZ)V", "getFieldId", "()Ljava/lang/String;", "getFieldName", "getFieldUIType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "()Z", "isEmptyValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldSelectModel implements h0, NonProguard {
    private final String fieldId;
    private final String fieldName;
    private final EFieldUIType fieldUIType;
    private final boolean isError;
    private final boolean isShowIcon;

    public static /* synthetic */ FieldSelectModel copy$default(FieldSelectModel r3, String r4, String r5, EFieldUIType r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.fieldId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.fieldName;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.fieldUIType;
    L11:
        EFieldUIType r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isError;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isShowIcon;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.fieldId;
    }

    public final String component2() {
        return this.fieldName;
    }

    public final EFieldUIType component3() {
        return this.fieldUIType;
    }

    public final boolean component4() {
        return this.isError;
    }

    public final boolean component5() {
        return this.isShowIcon;
    }

    public final FieldSelectModel copy(String r8, String r9, EFieldUIType r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "fieldId");
        Intrinsics.checkNotNullParameter(r9, "fieldName");
        Intrinsics.checkNotNullParameter(r10, "fieldUIType");
        return new FieldSelectModel(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FieldSelectModel) == true) goto L8;
        return false;
    L8:
        FieldSelectModel r6 = (FieldSelectModel) r5;
        if (Intrinsics.areEqual(this.fieldId, r6.fieldId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fieldName, r6.fieldName) == true) goto L15;
        return false;
    L15:
        if (this.fieldUIType == r6.fieldUIType) goto L18;
        return false;
    L18:
        if (this.isError == r6.isError) goto L21;
        return false;
    L21:
        if (this.isShowIcon == r6.isShowIcon) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.fieldId.hashCode() * 31) + this.fieldName.hashCode()) * 31) + this.fieldUIType.hashCode()) * 31;
        int r2 = 1231;
        if (this.isError == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.isShowIcon == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.h0
    public boolean isEmptyValue() {
        return false;
    }

    public String toString() {
        return "FieldSelectModel(fieldId=" + this.fieldId + ", fieldName=" + this.fieldName + ", fieldUIType=" + this.fieldUIType + ", isError=" + this.isError + ", isShowIcon=" + this.isShowIcon + ')';
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final EFieldUIType getFieldUIType() {
        return this.fieldUIType;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final boolean isShowIcon() {
        return this.isShowIcon;
    }

    public FieldSelectModel(String r2, String r3, EFieldUIType r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fieldId");
        Intrinsics.checkNotNullParameter(r3, "fieldName");
        Intrinsics.checkNotNullParameter(r4, "fieldUIType");
        this.fieldId = r2;
        this.fieldName = r3;
        this.fieldUIType = r4;
        this.isError = r5;
        this.isShowIcon = r6;
    }

    public /* synthetic */ FieldSelectModel(String r7, String r8, EFieldUIType r9, boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r12 & 16) == 0) goto L9;
        boolean r5 = true;
    L10:
        this(r7, r8, r9, r4, r5);
        return;
    L9:
        r5 = r11;
        goto L10
    L5:
        r4 = r10;
        goto L7
    }
}

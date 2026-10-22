package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\tH\u0016J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldSelectModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "fieldId", "", "fieldName", "fieldUIType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "isError", "", "isShowIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;ZZ)V", "getFieldId", "()Ljava/lang/String;", "getFieldName", "getFieldUIType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "()Z", "isEmptyValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldSelectModel implements h0, NonProguard {
    private final String fieldId;
    private final String fieldName;
    private final EFieldUIType fieldUIType;
    private final boolean isError;
    private final boolean isShowIcon;

    public static /* synthetic */ FieldSelectModel copy$default(FieldSelectModel r100, String r101, String r102, EFieldUIType r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.fieldId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.fieldName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.fieldUIType;
    L11:
        EFieldUIType r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isError;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isShowIcon;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final FieldSelectModel copy(String r100, String r101, EFieldUIType r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "fieldId");
        Intrinsics.checkNotNullParameter(r101, "fieldName");
        Intrinsics.checkNotNullParameter(r110, "fieldUIType");
        return new FieldSelectModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FieldSelectModel) == true) goto L8;
        return false;
    L8:
        FieldSelectModel r101 = (FieldSelectModel) r100;
        if (Intrinsics.areEqual(this.fieldId, r101.fieldId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fieldName, r101.fieldName) == true) goto L15;
        return false;
    L15:
        if (this.fieldUIType == r101.fieldUIType) goto L18;
        return false;
    L18:
        if (this.isError == r101.isError) goto L21;
        return false;
    L21:
        if (this.isShowIcon == r101.isShowIcon) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.fieldId.hashCode() * 31) + this.fieldName.hashCode()) * 31) + this.fieldUIType.hashCode()) * 31;
        int r101 = 1231;
        if (this.isError == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isShowIcon == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
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

    public FieldSelectModel(String r100, String r101, EFieldUIType r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "fieldId");
        Intrinsics.checkNotNullParameter(r101, "fieldName");
        Intrinsics.checkNotNullParameter(r102, "fieldUIType");
        this.fieldId = r100;
        this.fieldName = r101;
        this.fieldUIType = r102;
        this.isError = r103;
        this.isShowIcon = r104;
    }

    public /* synthetic */ FieldSelectModel(String r100, String r101, EFieldUIType r102, boolean r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r112 & 16) == 0) goto L9;
        boolean r104 = true;
    L10:
        this(r100, r101, r102, r103, r104);
        return;
    L9:
        r104 = r111;
        goto L10
    L5:
        r103 = r110;
        goto L7
    }
}

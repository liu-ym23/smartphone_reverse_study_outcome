package com.ss.android.lark.profile.v2.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/CustomPhoneField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "customPhone", "Lcom/ss/android/lark/profile/v2/entity/CustomPhone;", "<init>", "(Lcom/ss/android/lark/profile/v2/entity/CustomPhone;)V", "getCustomPhone", "()Lcom/ss/android/lark/profile/v2/entity/CustomPhone;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomPhoneField extends BaseField {
    private final CustomPhone customPhone;

    public static /* synthetic */ CustomPhoneField copy$default(CustomPhoneField r100, CustomPhone r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.customPhone;
    L6:
        return r100.copy(r101);
    }

    public final CustomPhone component1() {
        return this.customPhone;
    }

    public final CustomPhoneField copy(CustomPhone r100) {
        Intrinsics.checkNotNullParameter(r100, "customPhone");
        return new CustomPhoneField(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomPhoneField) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.customPhone, ((CustomPhoneField) r100).customPhone) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.customPhone.hashCode();
    }

    public String toString() {
        return "CustomPhoneField(customPhone=" + this.customPhone + ')';
    }

    public final CustomPhone getCustomPhone() {
        return this.customPhone;
    }

    public CustomPhoneField(CustomPhone r100) {
        Intrinsics.checkNotNullParameter(r100, "customPhone");
        this.customPhone = r100;
    }
}

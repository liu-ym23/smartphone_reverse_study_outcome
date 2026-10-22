package com.ss.android.lark.profile.v2.entity;

import androidx.autofill.HintConstants;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/CustomPhone;", "Ljava/io/Serializable;", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "", "extensionNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPhoneNumber", "()Ljava/lang/String;", "getExtensionNumber", "join", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomPhone implements Serializable {

    @SerializedName("extension_number")
    private final String extensionNumber;

    @SerializedName(IGoogleService.ResponseKey.PHONE_NUMBER)
    private final String phoneNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomPhone() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomPhone copy$default(CustomPhone r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.phoneNumber;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extensionNumber;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.phoneNumber;
    }

    public final String component2() {
        return this.extensionNumber;
    }

    public final CustomPhone copy(String r100, String r101) {
        return new CustomPhone(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomPhone) == true) goto L8;
        return false;
    L8:
        CustomPhone r101 = (CustomPhone) r100;
        if (Intrinsics.areEqual(this.phoneNumber, r101.phoneNumber) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extensionNumber, r101.extensionNumber) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.phoneNumber;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.extensionNumber;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CustomPhone(phoneNumber=" + this.phoneNumber + ", extensionNumber=" + this.extensionNumber + ')';
    }

    public final String join() {
        String r100 = this.phoneNumber;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return "";
    L12:
        String r103 = this.extensionNumber;
        if (r103 != null) goto L15;
    L16:
        r101 = true;
    L17:
        if (r101 == false) goto L21;
        return this.phoneNumber;
    L21:
        return this.phoneNumber + ',' + this.extensionNumber;
    L15:
        if (r103.length() != 0) goto L17;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final String getExtensionNumber() {
        return this.extensionNumber;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public CustomPhone(String r100, String r101) {
        this.phoneNumber = r100;
        this.extensionNumber = r101;
    }

    public /* synthetic */ CustomPhone(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

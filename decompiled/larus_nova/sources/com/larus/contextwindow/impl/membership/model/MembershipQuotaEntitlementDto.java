package com.larus.contextwindow.impl.membership.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDto;", "", "usedAmount", "", "totalAmount", "totalUsedPercent", "Lcom/google/gson/JsonElement;", "totalLessThanOnePercent", "", "display", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDisplayDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDisplayDto;)V", "getUsedAmount", "()Ljava/lang/String;", "getTotalAmount", "getTotalUsedPercent", "()Lcom/google/gson/JsonElement;", "getTotalLessThanOnePercent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplay", "()Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDisplayDto;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDisplayDto;)Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDto;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipQuotaEntitlementDto {

    @SerializedName("display")
    private final MembershipQuotaEntitlementDisplayDto display;

    @SerializedName("total_amount")
    private final String totalAmount;

    @SerializedName("total_less_than_one_percent")
    private final Boolean totalLessThanOnePercent;

    @SerializedName("total_used_percent")
    private final JsonElement totalUsedPercent;

    @SerializedName("used_amount")
    private final String usedAmount;

    public MembershipQuotaEntitlementDto() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MembershipQuotaEntitlementDto copy$default(MembershipQuotaEntitlementDto r100, String r101, String r102, JsonElement r103, Boolean r104, MembershipQuotaEntitlementDisplayDto r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.usedAmount;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.totalAmount;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.totalUsedPercent;
    L11:
        JsonElement r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.totalLessThanOnePercent;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.display;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.usedAmount;
    }

    public final String component2() {
        return this.totalAmount;
    }

    public final JsonElement component3() {
        return this.totalUsedPercent;
    }

    public final Boolean component4() {
        return this.totalLessThanOnePercent;
    }

    public final MembershipQuotaEntitlementDisplayDto component5() {
        return this.display;
    }

    public final MembershipQuotaEntitlementDto copy(String r100, String r101, JsonElement r110, Boolean r111, MembershipQuotaEntitlementDisplayDto r112) {
        return new MembershipQuotaEntitlementDto(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MembershipQuotaEntitlementDto) == true) goto L8;
        return false;
    L8:
        MembershipQuotaEntitlementDto r101 = (MembershipQuotaEntitlementDto) r100;
        if (Intrinsics.areEqual(this.usedAmount, r101.usedAmount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.totalAmount, r101.totalAmount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.totalUsedPercent, r101.totalUsedPercent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.totalLessThanOnePercent, r101.totalLessThanOnePercent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.display, r101.display) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.usedAmount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.totalAmount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JsonElement r107 = this.totalUsedPercent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.totalLessThanOnePercent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        MembershipQuotaEntitlementDisplayDto r113 = this.display;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MembershipQuotaEntitlementDto(usedAmount=" + this.usedAmount + ", totalAmount=" + this.totalAmount + ", totalUsedPercent=" + this.totalUsedPercent + ", totalLessThanOnePercent=" + this.totalLessThanOnePercent + ", display=" + this.display + ')';
    }

    public final MembershipQuotaEntitlementDisplayDto getDisplay() {
        return this.display;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final Boolean getTotalLessThanOnePercent() {
        return this.totalLessThanOnePercent;
    }

    public final JsonElement getTotalUsedPercent() {
        return this.totalUsedPercent;
    }

    public final String getUsedAmount() {
        return this.usedAmount;
    }

    public MembershipQuotaEntitlementDto(String r100, String r101, JsonElement r102, Boolean r103, MembershipQuotaEntitlementDisplayDto r104) {
        this.usedAmount = r100;
        this.totalAmount = r101;
        this.totalUsedPercent = r102;
        this.totalLessThanOnePercent = r103;
        this.display = r104;
    }

    public /* synthetic */ MembershipQuotaEntitlementDto(String r100, String r101, JsonElement r102, Boolean r103, MembershipQuotaEntitlementDisplayDto r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        JsonElement r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Boolean r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        MembershipQuotaEntitlementDisplayDto r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}

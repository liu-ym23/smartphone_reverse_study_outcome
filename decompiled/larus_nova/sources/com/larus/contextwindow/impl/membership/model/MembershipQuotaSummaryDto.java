package com.larus.contextwindow.impl.membership.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaSummaryDto;", "", "memberInfo", "Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;", "windowLimitSection", "Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;", "enterpriseWindowLimitSection", "quotaPackageSection", "enterprisePackageEntitlementGroups", "", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementGroupDto;", "<init>", "(Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;Ljava/util/List;)V", "getMemberInfo", "()Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;", "getWindowLimitSection", "()Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;", "getEnterpriseWindowLimitSection", "getQuotaPackageSection", "getEnterprisePackageEntitlementGroups", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipQuotaSummaryDto {

    @SerializedName("enterprise_package_entitlement_groups")
    private final List<MembershipQuotaEntitlementGroupDto> enterprisePackageEntitlementGroups;

    @SerializedName("enterprise_window_limit_section")
    private final WindowLimitSectionDto enterpriseWindowLimitSection;

    @SerializedName("member_info")
    private final MembershipInfoDto memberInfo;

    @SerializedName("quota_package_section")
    private final WindowLimitSectionDto quotaPackageSection;

    @SerializedName("window_limit_section")
    private final WindowLimitSectionDto windowLimitSection;

    public MembershipQuotaSummaryDto() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MembershipQuotaSummaryDto copy$default(MembershipQuotaSummaryDto r100, MembershipInfoDto r101, WindowLimitSectionDto r102, WindowLimitSectionDto r103, WindowLimitSectionDto r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.memberInfo;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.windowLimitSection;
    L8:
        WindowLimitSectionDto r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.enterpriseWindowLimitSection;
    L11:
        WindowLimitSectionDto r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.quotaPackageSection;
    L14:
        WindowLimitSectionDto r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enterprisePackageEntitlementGroups;
    L17:
        MembershipInfoDto r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final MembershipInfoDto component1() {
        return this.memberInfo;
    }

    public final WindowLimitSectionDto component2() {
        return this.windowLimitSection;
    }

    public final WindowLimitSectionDto component3() {
        return this.enterpriseWindowLimitSection;
    }

    public final WindowLimitSectionDto component4() {
        return this.quotaPackageSection;
    }

    public final List<MembershipQuotaEntitlementGroupDto> component5() {
        return this.enterprisePackageEntitlementGroups;
    }

    public final MembershipQuotaSummaryDto copy(MembershipInfoDto r100, WindowLimitSectionDto r101, WindowLimitSectionDto r110, WindowLimitSectionDto r111, List<MembershipQuotaEntitlementGroupDto> r112) {
        return new MembershipQuotaSummaryDto(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MembershipQuotaSummaryDto) == true) goto L8;
        return false;
    L8:
        MembershipQuotaSummaryDto r101 = (MembershipQuotaSummaryDto) r100;
        if (Intrinsics.areEqual(this.memberInfo, r101.memberInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowLimitSection, r101.windowLimitSection) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterpriseWindowLimitSection, r101.enterpriseWindowLimitSection) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.quotaPackageSection, r101.quotaPackageSection) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enterprisePackageEntitlementGroups, r101.enterprisePackageEntitlementGroups) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        MembershipInfoDto r100 = this.memberInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        WindowLimitSectionDto r104 = this.windowLimitSection;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        WindowLimitSectionDto r107 = this.enterpriseWindowLimitSection;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        WindowLimitSectionDto r110 = this.quotaPackageSection;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<MembershipQuotaEntitlementGroupDto> r113 = this.enterprisePackageEntitlementGroups;
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
        return "MembershipQuotaSummaryDto(memberInfo=" + this.memberInfo + ", windowLimitSection=" + this.windowLimitSection + ", enterpriseWindowLimitSection=" + this.enterpriseWindowLimitSection + ", quotaPackageSection=" + this.quotaPackageSection + ", enterprisePackageEntitlementGroups=" + this.enterprisePackageEntitlementGroups + ')';
    }

    public final List<MembershipQuotaEntitlementGroupDto> getEnterprisePackageEntitlementGroups() {
        return this.enterprisePackageEntitlementGroups;
    }

    public final WindowLimitSectionDto getEnterpriseWindowLimitSection() {
        return this.enterpriseWindowLimitSection;
    }

    public final MembershipInfoDto getMemberInfo() {
        return this.memberInfo;
    }

    public final WindowLimitSectionDto getQuotaPackageSection() {
        return this.quotaPackageSection;
    }

    public final WindowLimitSectionDto getWindowLimitSection() {
        return this.windowLimitSection;
    }

    public MembershipQuotaSummaryDto(MembershipInfoDto r100, WindowLimitSectionDto r101, WindowLimitSectionDto r102, WindowLimitSectionDto r103, List<MembershipQuotaEntitlementGroupDto> r104) {
        this.memberInfo = r100;
        this.windowLimitSection = r101;
        this.enterpriseWindowLimitSection = r102;
        this.quotaPackageSection = r103;
        this.enterprisePackageEntitlementGroups = r104;
    }

    public /* synthetic */ MembershipQuotaSummaryDto(MembershipInfoDto r100, WindowLimitSectionDto r101, WindowLimitSectionDto r102, WindowLimitSectionDto r103, List r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        MembershipInfoDto r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        WindowLimitSectionDto r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        WindowLimitSectionDto r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        WindowLimitSectionDto r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        List r113 = null;
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

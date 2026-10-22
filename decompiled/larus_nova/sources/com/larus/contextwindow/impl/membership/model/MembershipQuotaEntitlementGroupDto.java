package com.larus.contextwindow.impl.membership.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementGroupDto;", "", "featureGroup", "", "entitlements", "", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDto;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getFeatureGroup", "()Ljava/lang/String;", "getEntitlements", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipQuotaEntitlementGroupDto {

    @SerializedName("entitlements")
    private final List<MembershipQuotaEntitlementDto> entitlements;

    @SerializedName("feature_group")
    private final String featureGroup;

    /* JADX WARN: Multi-variable type inference failed */
    public MembershipQuotaEntitlementGroupDto() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MembershipQuotaEntitlementGroupDto copy$default(MembershipQuotaEntitlementGroupDto r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.featureGroup;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.entitlements;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.featureGroup;
    }

    public final List<MembershipQuotaEntitlementDto> component2() {
        return this.entitlements;
    }

    public final MembershipQuotaEntitlementGroupDto copy(String r100, List<MembershipQuotaEntitlementDto> r101) {
        return new MembershipQuotaEntitlementGroupDto(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MembershipQuotaEntitlementGroupDto) == true) goto L8;
        return false;
    L8:
        MembershipQuotaEntitlementGroupDto r101 = (MembershipQuotaEntitlementGroupDto) r100;
        if (Intrinsics.areEqual(this.featureGroup, r101.featureGroup) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entitlements, r101.entitlements) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.featureGroup;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<MembershipQuotaEntitlementDto> r104 = this.entitlements;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MembershipQuotaEntitlementGroupDto(featureGroup=" + this.featureGroup + ", entitlements=" + this.entitlements + ')';
    }

    public final List<MembershipQuotaEntitlementDto> getEntitlements() {
        return this.entitlements;
    }

    public final String getFeatureGroup() {
        return this.featureGroup;
    }

    public MembershipQuotaEntitlementGroupDto(String r100, List<MembershipQuotaEntitlementDto> r101) {
        this.featureGroup = r100;
        this.entitlements = r101;
    }

    public /* synthetic */ MembershipQuotaEntitlementGroupDto(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

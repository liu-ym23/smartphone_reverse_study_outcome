package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/UserSubInfo;", "Ljava/io/Serializable;", "hasSubBenefits", "", "subscribed", "subInfo", "Lcom/larus/platform/model/SubInfo;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/platform/model/SubInfo;)V", "getHasSubBenefits", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSubscribed", "getSubInfo", "()Lcom/larus/platform/model/SubInfo;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/platform/model/SubInfo;)Lcom/larus/platform/model/UserSubInfo;", "equals", "other", "", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSubInfo implements Serializable {

    @SerializedName("has_sub_benefits")
    private final Boolean hasSubBenefits;

    @SerializedName("sub_info")
    private final SubInfo subInfo;

    @SerializedName("subscribed")
    private final Boolean subscribed;

    public UserSubInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UserSubInfo copy$default(UserSubInfo r100, Boolean r101, Boolean r102, SubInfo r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.hasSubBenefits;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.subscribed;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.subInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.hasSubBenefits;
    }

    public final Boolean component2() {
        return this.subscribed;
    }

    public final SubInfo component3() {
        return this.subInfo;
    }

    public final UserSubInfo copy(Boolean r100, Boolean r101, SubInfo r102) {
        return new UserSubInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserSubInfo) == true) goto L8;
        return false;
    L8:
        UserSubInfo r101 = (UserSubInfo) r100;
        if (Intrinsics.areEqual(this.hasSubBenefits, r101.hasSubBenefits) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subscribed, r101.subscribed) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subInfo, r101.subInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.hasSubBenefits;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.subscribed;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        SubInfo r107 = this.subInfo;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UserSubInfo(hasSubBenefits=" + this.hasSubBenefits + ", subscribed=" + this.subscribed + ", subInfo=" + this.subInfo + ')';
    }

    public final Boolean getHasSubBenefits() {
        return this.hasSubBenefits;
    }

    public final SubInfo getSubInfo() {
        return this.subInfo;
    }

    public final Boolean getSubscribed() {
        return this.subscribed;
    }

    public UserSubInfo(Boolean r100, Boolean r101, SubInfo r102) {
        this.hasSubBenefits = r100;
        this.subscribed = r101;
        this.subInfo = r102;
    }

    public /* synthetic */ UserSubInfo(Boolean r100, Boolean r101, SubInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

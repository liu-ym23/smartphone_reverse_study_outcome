package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0002\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "Ljava/io/Serializable;", "isMember", "", "isMemberExclusive", "hasMemberPrice", "showPriceType", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getHasMemberPrice", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowPriceType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/locallife/live/goodsshelves/bean/MemberInfo;", "equals", "other", "", "hashCode", "", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MemberInfo implements Serializable {

    @SerializedName("has_member_price")
    private final Boolean hasMemberPrice;

    @SerializedName("is_member")
    private final Boolean isMember;

    @SerializedName("is_member_exclusive")
    private final Boolean isMemberExclusive;

    @SerializedName("show_price_type")
    private final String showPriceType;

    public MemberInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MemberInfo copy$default(MemberInfo r100, Boolean r101, Boolean r102, Boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isMember;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isMemberExclusive;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.hasMemberPrice;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.showPriceType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Boolean component1() {
        return this.isMember;
    }

    public final Boolean component2() {
        return this.isMemberExclusive;
    }

    public final Boolean component3() {
        return this.hasMemberPrice;
    }

    public final String component4() {
        return this.showPriceType;
    }

    public final MemberInfo copy(Boolean r100, Boolean r101, Boolean r102, String r103) {
        return new MemberInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MemberInfo) == true) goto L8;
        return false;
    L8:
        MemberInfo r101 = (MemberInfo) r100;
        if (Intrinsics.areEqual(this.isMember, r101.isMember) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isMemberExclusive, r101.isMemberExclusive) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hasMemberPrice, r101.hasMemberPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showPriceType, r101.showPriceType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isMember;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isMemberExclusive;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.hasMemberPrice;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.showPriceType;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "MemberInfo(isMember=" + this.isMember + ", isMemberExclusive=" + this.isMemberExclusive + ", hasMemberPrice=" + this.hasMemberPrice + ", showPriceType=" + this.showPriceType + ')';
    }

    public final Boolean getHasMemberPrice() {
        return this.hasMemberPrice;
    }

    public final String getShowPriceType() {
        return this.showPriceType;
    }

    public final Boolean isMember() {
        return this.isMember;
    }

    public final Boolean isMemberExclusive() {
        return this.isMemberExclusive;
    }

    public MemberInfo(Boolean r100, Boolean r101, Boolean r102, String r103) {
        this.isMember = r100;
        this.isMemberExclusive = r101;
        this.hasMemberPrice = r102;
        this.showPriceType = r103;
    }

    public /* synthetic */ MemberInfo(Boolean r100, Boolean r101, Boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Boolean.FALSE;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "normal";
    L14:
        this(r100, r101, r102, r103);
    }
}

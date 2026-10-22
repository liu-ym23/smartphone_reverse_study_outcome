package com.larus.common.venue.impl.venue.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/common/venue/impl/venue/api/OSVersion;", "", "systemType", "", "isSupport", "", "lowestVersionCode", "", "highestVersionCode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getSystemType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLowestVersionCode", "()Ljava/lang/String;", "getHighestVersionCode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/common/venue/impl/venue/api/OSVersion;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSVersion {

    @SerializedName("highest_version_code")
    private final String highestVersionCode;

    @SerializedName("is_support")
    private final Boolean isSupport;

    @SerializedName("lowest_version_code")
    private final String lowestVersionCode;

    @SerializedName("sys_type")
    private final Integer systemType;

    public OSVersion() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ OSVersion copy$default(OSVersion r100, Integer r101, Boolean r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.systemType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isSupport;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.lowestVersionCode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.highestVersionCode;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.systemType;
    }

    public final Boolean component2() {
        return this.isSupport;
    }

    public final String component3() {
        return this.lowestVersionCode;
    }

    public final String component4() {
        return this.highestVersionCode;
    }

    public final OSVersion copy(Integer r100, Boolean r101, String r102, String r103) {
        return new OSVersion(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OSVersion) == true) goto L8;
        return false;
    L8:
        OSVersion r101 = (OSVersion) r100;
        if (Intrinsics.areEqual(this.systemType, r101.systemType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSupport, r101.isSupport) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lowestVersionCode, r101.lowestVersionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.highestVersionCode, r101.highestVersionCode) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.systemType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isSupport;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lowestVersionCode;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.highestVersionCode;
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
        return "OSVersion(systemType=" + this.systemType + ", isSupport=" + this.isSupport + ", lowestVersionCode=" + this.lowestVersionCode + ", highestVersionCode=" + this.highestVersionCode + ')';
    }

    public final String getHighestVersionCode() {
        return this.highestVersionCode;
    }

    public final String getLowestVersionCode() {
        return this.lowestVersionCode;
    }

    public final Integer getSystemType() {
        return this.systemType;
    }

    public final Boolean isSupport() {
        return this.isSupport;
    }

    public OSVersion(Integer r100, Boolean r101, String r102, String r103) {
        this.systemType = r100;
        this.isSupport = r101;
        this.lowestVersionCode = r102;
        this.highestVersionCode = r103;
    }

    public /* synthetic */ OSVersion(Integer r100, Boolean r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}

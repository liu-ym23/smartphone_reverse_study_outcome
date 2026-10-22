package com.larus.contextwindow.impl.membership.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/WindowLimitGroupDto;", "", "featureGroup", "", "featureGroupName", "windowLimits", "", "Lcom/larus/contextwindow/impl/membership/model/WindowLimitItemDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFeatureGroup", "()Ljava/lang/String;", "getFeatureGroupName", "getWindowLimits", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLimitGroupDto {

    @SerializedName("feature_group")
    private final String featureGroup;

    @SerializedName("feature_group_name")
    private final String featureGroupName;

    @SerializedName("window_limits")
    private final List<WindowLimitItemDto> windowLimits;

    public WindowLimitGroupDto() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowLimitGroupDto copy$default(WindowLimitGroupDto r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.featureGroup;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.featureGroupName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.windowLimits;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.featureGroup;
    }

    public final String component2() {
        return this.featureGroupName;
    }

    public final List<WindowLimitItemDto> component3() {
        return this.windowLimits;
    }

    public final WindowLimitGroupDto copy(String r100, String r101, List<WindowLimitItemDto> r102) {
        return new WindowLimitGroupDto(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WindowLimitGroupDto) == true) goto L8;
        return false;
    L8:
        WindowLimitGroupDto r101 = (WindowLimitGroupDto) r100;
        if (Intrinsics.areEqual(this.featureGroup, r101.featureGroup) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.featureGroupName, r101.featureGroupName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.windowLimits, r101.windowLimits) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.featureGroup;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.featureGroupName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<WindowLimitItemDto> r107 = this.windowLimits;
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
        return "WindowLimitGroupDto(featureGroup=" + this.featureGroup + ", featureGroupName=" + this.featureGroupName + ", windowLimits=" + this.windowLimits + ')';
    }

    public final String getFeatureGroup() {
        return this.featureGroup;
    }

    public final String getFeatureGroupName() {
        return this.featureGroupName;
    }

    public final List<WindowLimitItemDto> getWindowLimits() {
        return this.windowLimits;
    }

    public WindowLimitGroupDto(String r100, String r101, List<WindowLimitItemDto> r102) {
        this.featureGroup = r100;
        this.featureGroupName = r101;
        this.windowLimits = r102;
    }

    public /* synthetic */ WindowLimitGroupDto(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
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

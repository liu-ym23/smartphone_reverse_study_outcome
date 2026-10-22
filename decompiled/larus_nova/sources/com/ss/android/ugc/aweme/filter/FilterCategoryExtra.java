package com.ss.android.ugc.aweme.filter;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/filter/FilterCategoryExtra;", "Ljava/io/Serializable;", "abGroup", "", "cameraFacing", "(Ljava/lang/String;Ljava/lang/String;)V", "getAbGroup", "()Ljava/lang/String;", "getCameraFacing", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class FilterCategoryExtra implements Serializable {

    @SerializedName("ab_group")
    private final String abGroup;

    @SerializedName("panel_camera_type")
    private final String cameraFacing;

    /* JADX WARN: Multi-variable type inference failed */
    public FilterCategoryExtra() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FilterCategoryExtra copy$default(FilterCategoryExtra r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.abGroup;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cameraFacing;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.abGroup;
    }

    public final String component2() {
        return this.cameraFacing;
    }

    public final FilterCategoryExtra copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "abGroup");
        Intrinsics.checkNotNullParameter(r101, "cameraFacing");
        return new FilterCategoryExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FilterCategoryExtra) == false) goto L10;
        FilterCategoryExtra r101 = (FilterCategoryExtra) r100;
        if (Intrinsics.areEqual(this.abGroup, r101.abGroup) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cameraFacing, r101.cameraFacing) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.abGroup;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.cameraFacing;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FilterCategoryExtra(abGroup=" + this.abGroup + ", cameraFacing=" + this.cameraFacing + ")";
    }

    public final String getAbGroup() {
        return this.abGroup;
    }

    public final String getCameraFacing() {
        return this.cameraFacing;
    }

    public FilterCategoryExtra(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "abGroup");
        Intrinsics.checkNotNullParameter(r101, "cameraFacing");
        this.abGroup = r100;
        this.cameraFacing = r101;
    }

    public /* synthetic */ FilterCategoryExtra(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "0";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}

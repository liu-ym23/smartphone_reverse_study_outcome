package com.ss.android.ugc.aweme.poi.coi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/coi/CoiDisplayMobiInfo;", "Ljava/io/Serializable;", "hasRate", "", "rateStar", "(Ljava/lang/String;Ljava/lang/String;)V", "getHasRate", "()Ljava/lang/String;", "getRateStar", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CoiDisplayMobiInfo implements Serializable {

    @SerializedName("has_rate")
    private final String hasRate;

    @SerializedName("rate_star")
    private final String rateStar;

    /* JADX WARN: Multi-variable type inference failed */
    public CoiDisplayMobiInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CoiDisplayMobiInfo copy$default(CoiDisplayMobiInfo r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.hasRate;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.rateStar;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.hasRate;
    }

    public final String component2() {
        return this.rateStar;
    }

    public final CoiDisplayMobiInfo copy(String r100, String r101) {
        return new CoiDisplayMobiInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CoiDisplayMobiInfo) == true) goto L8;
        return false;
    L8:
        CoiDisplayMobiInfo r101 = (CoiDisplayMobiInfo) r100;
        if (Intrinsics.areEqual(this.hasRate, r101.hasRate) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rateStar, r101.rateStar) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.hasRate;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rateStar;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CoiDisplayMobiInfo(hasRate=" + this.hasRate + ", rateStar=" + this.rateStar + ')';
    }

    public final String getHasRate() {
        return this.hasRate;
    }

    public final String getRateStar() {
        return this.rateStar;
    }

    public CoiDisplayMobiInfo(String r100, String r101) {
        this.hasRate = r100;
        this.rateStar = r101;
    }

    public /* synthetic */ CoiDisplayMobiInfo(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

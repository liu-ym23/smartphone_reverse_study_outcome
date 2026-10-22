package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/canvas/service/bean/AIBeautify;", "Ljava/io/Serializable;", "maskUrl", "", "isExpand", "", "isErase", "isQualityImprove", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "()Ljava/lang/Boolean;", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/canvas/service/bean/AIBeautify;", "equals", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBeautify implements Serializable {

    @SerializedName("isErase")
    public final Boolean isErase;

    @SerializedName("isExpand")
    public final Boolean isExpand;

    @SerializedName("isQualityImprove")
    public final Boolean isQualityImprove;

    @SerializedName("mask_url")
    public final String maskUrl;

    public AIBeautify() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AIBeautify copy$default(AIBeautify r100, String r101, Boolean r102, Boolean r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.maskUrl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isExpand;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isErase;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isQualityImprove;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.maskUrl;
    }

    public final Boolean component2() {
        return this.isExpand;
    }

    public final Boolean component3() {
        return this.isErase;
    }

    public final Boolean component4() {
        return this.isQualityImprove;
    }

    public final AIBeautify copy(String r100, Boolean r101, Boolean r102, Boolean r103) {
        return new AIBeautify(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIBeautify) == true) goto L8;
        return false;
    L8:
        AIBeautify r101 = (AIBeautify) r100;
        if (Intrinsics.areEqual(this.maskUrl, r101.maskUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isExpand, r101.isExpand) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isErase, r101.isErase) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isQualityImprove, r101.isQualityImprove) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.maskUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isExpand;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isErase;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isQualityImprove;
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
        return "AIBeautify(maskUrl=" + this.maskUrl + ", isExpand=" + this.isExpand + ", isErase=" + this.isErase + ", isQualityImprove=" + this.isQualityImprove + ')';
    }

    public AIBeautify(String r100, Boolean r101, Boolean r102, Boolean r103) {
        this.maskUrl = r100;
        this.isExpand = r101;
        this.isErase = r102;
        this.isQualityImprove = r103;
    }

    public /* synthetic */ AIBeautify(String r100, Boolean r101, Boolean r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
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

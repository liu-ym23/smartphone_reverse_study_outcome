package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GsCountdown;", "Ljava/io/Serializable;", "prefixText", "", "endTime", "", "textColor", "backgroundGradientColor", "Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;)V", "getBackgroundGradientColor", "()Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPrefixText", "()Ljava/lang/String;", "getTextColor", "setTextColor", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;)Lcom/ss/android/ugc/aweme/discover/model/GsCountdown;", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GsCountdown implements Serializable {

    @SerializedName("background_gradient_color")
    private final ECGradientStruct backgroundGradientColor;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("prefix_text")
    private final String prefixText;

    @SerializedName("text_color")
    private String textColor;

    public GsCountdown() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GsCountdown copy$default(GsCountdown r100, String r101, Long r102, String r103, ECGradientStruct r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.prefixText;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.endTime;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.textColor;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.backgroundGradientColor;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.prefixText;
    }

    public final Long component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.textColor;
    }

    public final ECGradientStruct component4() {
        return this.backgroundGradientColor;
    }

    public final GsCountdown copy(String r100, Long r101, String r102, ECGradientStruct r103) {
        return new GsCountdown(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GsCountdown) == false) goto L14;
        GsCountdown r101 = (GsCountdown) r100;
        if (Intrinsics.areEqual(this.prefixText, r101.prefixText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundGradientColor, r101.backgroundGradientColor) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.prefixText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.endTime;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECGradientStruct r110 = this.backgroundGradientColor;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GsCountdown(prefixText=" + this.prefixText + ", endTime=" + this.endTime + ", textColor=" + this.textColor + ", backgroundGradientColor=" + this.backgroundGradientColor + ")";
    }

    public final ECGradientStruct getBackgroundGradientColor() {
        return this.backgroundGradientColor;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final String getPrefixText() {
        return this.prefixText;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public GsCountdown(String r100, Long r101, String r102, ECGradientStruct r103) {
        this.prefixText = r100;
        this.endTime = r101;
        this.textColor = r102;
        this.backgroundGradientColor = r103;
    }

    public /* synthetic */ GsCountdown(String r100, Long r101, String r102, ECGradientStruct r103, int r104, DefaultConstructorMarker r105) {
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

package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/InformationBackgroundColor;", "Ljava/io/Serializable;", "bgType", "", "gradientColor", "Lcom/ss/android/ugc/aweme/discover/model/ThemeGradientColor;", "(Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ThemeGradientColor;)V", "getBgType", "()Ljava/lang/String;", "getGradientColor", "()Lcom/ss/android/ugc/aweme/discover/model/ThemeGradientColor;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InformationBackgroundColor implements Serializable {

    @SerializedName("bg_type")
    private final String bgType;

    @SerializedName("gradient_color")
    private final ThemeGradientColor gradientColor;

    /* JADX WARN: Multi-variable type inference failed */
    public InformationBackgroundColor() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InformationBackgroundColor copy$default(InformationBackgroundColor r100, String r101, ThemeGradientColor r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.bgType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.gradientColor;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.bgType;
    }

    public final ThemeGradientColor component2() {
        return this.gradientColor;
    }

    public final InformationBackgroundColor copy(String r100, ThemeGradientColor r101) {
        return new InformationBackgroundColor(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InformationBackgroundColor) == false) goto L10;
        InformationBackgroundColor r101 = (InformationBackgroundColor) r100;
        if (Intrinsics.areEqual(this.bgType, r101.bgType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gradientColor, r101.gradientColor) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.bgType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ThemeGradientColor r104 = this.gradientColor;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InformationBackgroundColor(bgType=" + this.bgType + ", gradientColor=" + this.gradientColor + ")";
    }

    public final String getBgType() {
        return this.bgType;
    }

    public final ThemeGradientColor getGradientColor() {
        return this.gradientColor;
    }

    public InformationBackgroundColor(String r100, ThemeGradientColor r101) {
        this.bgType = r100;
        this.gradientColor = r101;
    }

    public /* synthetic */ InformationBackgroundColor(String r100, ThemeGradientColor r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

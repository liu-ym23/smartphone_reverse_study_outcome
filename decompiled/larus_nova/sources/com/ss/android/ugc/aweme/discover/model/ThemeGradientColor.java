package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ThemeGradientColor;", "Ljava/io/Serializable;", "light", "Lcom/ss/android/ugc/aweme/discover/model/GradientColor;", "dark", "(Lcom/ss/android/ugc/aweme/discover/model/GradientColor;Lcom/ss/android/ugc/aweme/discover/model/GradientColor;)V", "getDark", "()Lcom/ss/android/ugc/aweme/discover/model/GradientColor;", "getLight", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ThemeGradientColor implements Serializable {

    @SerializedName("dark")
    private final GradientColor dark;

    @SerializedName("light")
    private final GradientColor light;

    /* JADX WARN: Multi-variable type inference failed */
    public ThemeGradientColor() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ThemeGradientColor copy$default(ThemeGradientColor r100, GradientColor r101, GradientColor r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.light;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.dark;
    L9:
        return r100.copy(r101, r102);
    }

    public final GradientColor component1() {
        return this.light;
    }

    public final GradientColor component2() {
        return this.dark;
    }

    public final ThemeGradientColor copy(GradientColor r100, GradientColor r101) {
        return new ThemeGradientColor(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ThemeGradientColor) == false) goto L10;
        ThemeGradientColor r101 = (ThemeGradientColor) r100;
        if (Intrinsics.areEqual(this.light, r101.light) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dark, r101.dark) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        GradientColor r100 = this.light;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        GradientColor r104 = this.dark;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ThemeGradientColor(light=" + this.light + ", dark=" + this.dark + ")";
    }

    public final GradientColor getDark() {
        return this.dark;
    }

    public final GradientColor getLight() {
        return this.light;
    }

    public ThemeGradientColor(GradientColor r100, GradientColor r101) {
        this.light = r100;
        this.dark = r101;
    }

    public /* synthetic */ ThemeGradientColor(GradientColor r100, GradientColor r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

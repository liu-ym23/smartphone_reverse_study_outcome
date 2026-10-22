package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GradientConfig;", "Ljava/io/Serializable;", "light", "Lcom/ss/android/ugc/aweme/discover/model/BackGroundGradient;", "dark", "(Lcom/ss/android/ugc/aweme/discover/model/BackGroundGradient;Lcom/ss/android/ugc/aweme/discover/model/BackGroundGradient;)V", "getDark", "()Lcom/ss/android/ugc/aweme/discover/model/BackGroundGradient;", "getLight", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GradientConfig implements Serializable {

    @SerializedName("dark")
    private final BackGroundGradient dark;

    @SerializedName("light")
    private final BackGroundGradient light;

    /* JADX WARN: Multi-variable type inference failed */
    public GradientConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GradientConfig copy$default(GradientConfig r100, BackGroundGradient r101, BackGroundGradient r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.light;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.dark;
    L9:
        return r100.copy(r101, r102);
    }

    public final BackGroundGradient component1() {
        return this.light;
    }

    public final BackGroundGradient component2() {
        return this.dark;
    }

    public final GradientConfig copy(BackGroundGradient r100, BackGroundGradient r101) {
        return new GradientConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GradientConfig) == false) goto L10;
        GradientConfig r101 = (GradientConfig) r100;
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
        BackGroundGradient r100 = this.light;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BackGroundGradient r104 = this.dark;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GradientConfig(light=" + this.light + ", dark=" + this.dark + ")";
    }

    public final BackGroundGradient getDark() {
        return this.dark;
    }

    public final BackGroundGradient getLight() {
        return this.light;
    }

    public GradientConfig(BackGroundGradient r100, BackGroundGradient r101) {
        this.light = r100;
        this.dark = r101;
    }

    public /* synthetic */ GradientConfig(BackGroundGradient r100, BackGroundGradient r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

package com.ss.android.ugc.aweme.discover.model;

import com.facebook.keyframes.model.KFFeatureEffect;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig;", "Ljava/io/Serializable;", "backgroundType", "", KFFeatureEffect.GRADIENT_JSON_FIELD, "Lcom/ss/android/ugc/aweme/discover/model/GradientConfig;", "pureColor", "Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "(Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/GradientConfig;Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;)V", "getBackgroundType", "()Ljava/lang/String;", "getGradient", "()Lcom/ss/android/ugc/aweme/discover/model/GradientConfig;", "getPureColor", "()Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "BackgroundType", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackgroundConfig implements Serializable {

    @SerializedName("bg_type")
    private final String backgroundType;

    @SerializedName(KFFeatureEffect.GRADIENT_JSON_FIELD)
    private final GradientConfig gradient;

    @SerializedName("pure_color")
    private final ColorConfig pureColor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig$BackgroundType;", "", "Companion", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BackgroundType {
        public static final Companion Companion = null;
        public static final String TYPE_COLOR = "PURE_COLOR";
        public static final String TYPE_GRADIENT = "GRADIENT";
        public static final String TYPE_PICTURE = "PICTURE";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig$BackgroundType$Companion;", "", "<init>", "()V", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Companion f450481a = null;

            private Companion() {
            }

            static {
                f450481a = new Companion();
            }
        }

        static {
            Companion = Companion.f450481a;
        }
    }

    public BackgroundConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BackgroundConfig copy$default(BackgroundConfig r100, String r101, GradientConfig r102, ColorConfig r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.backgroundType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.gradient;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pureColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.backgroundType;
    }

    public final GradientConfig component2() {
        return this.gradient;
    }

    public final ColorConfig component3() {
        return this.pureColor;
    }

    public final BackgroundConfig copy(@BackgroundType String r100, GradientConfig r101, ColorConfig r102) {
        return new BackgroundConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BackgroundConfig) == false) goto L12;
        BackgroundConfig r101 = (BackgroundConfig) r100;
        if (Intrinsics.areEqual(this.backgroundType, r101.backgroundType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gradient, r101.gradient) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pureColor, r101.pureColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.backgroundType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        GradientConfig r104 = this.gradient;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ColorConfig r107 = this.pureColor;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "BackgroundConfig(backgroundType=" + this.backgroundType + ", gradient=" + this.gradient + ", pureColor=" + this.pureColor + ")";
    }

    public final String getBackgroundType() {
        return this.backgroundType;
    }

    public final GradientConfig getGradient() {
        return this.gradient;
    }

    public final ColorConfig getPureColor() {
        return this.pureColor;
    }

    public BackgroundConfig(@BackgroundType String r100, GradientConfig r101, ColorConfig r102) {
        this.backgroundType = r100;
        this.gradient = r101;
        this.pureColor = r102;
    }

    public /* synthetic */ BackgroundConfig(String r100, GradientConfig r101, ColorConfig r102, int r103, DefaultConstructorMarker r104) {
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

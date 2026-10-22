package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/service/bean/TabExtra;", "", "isSupportRefImage", "", "effectMode", "", "abilityType", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEffectMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAbilityType", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/canvas/service/bean/TabExtra;", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabExtra {

    @SerializedName("ability_type")
    private final Integer abilityType;

    @SerializedName("effect_mode")
    private final Integer effectMode;

    @SerializedName("is_support_ref_image")
    private final Boolean isSupportRefImage;

    public TabExtra() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TabExtra copy$default(TabExtra r100, Boolean r101, Integer r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isSupportRefImage;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.effectMode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.abilityType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.isSupportRefImage;
    }

    public final Integer component2() {
        return this.effectMode;
    }

    public final Integer component3() {
        return this.abilityType;
    }

    public final TabExtra copy(Boolean r100, Integer r101, Integer r102) {
        return new TabExtra(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TabExtra) == true) goto L8;
        return false;
    L8:
        TabExtra r101 = (TabExtra) r100;
        if (Intrinsics.areEqual(this.isSupportRefImage, r101.isSupportRefImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.effectMode, r101.effectMode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.abilityType, r101.abilityType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isSupportRefImage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.effectMode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.abilityType;
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
        return "TabExtra(isSupportRefImage=" + this.isSupportRefImage + ", effectMode=" + this.effectMode + ", abilityType=" + this.abilityType + ')';
    }

    public final Integer getAbilityType() {
        return this.abilityType;
    }

    public final Integer getEffectMode() {
        return this.effectMode;
    }

    public final Boolean isSupportRefImage() {
        return this.isSupportRefImage;
    }

    public TabExtra(Boolean r100, Integer r101, Integer r102) {
        this.isSupportRefImage = r100;
        this.effectMode = r101;
        this.abilityType = r102;
    }

    public /* synthetic */ TabExtra(Boolean r100, Integer r101, Integer r102, int r103, DefaultConstructorMarker r104) {
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

package com.bytedance.locallife.groupon.struct.popup;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJJ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/popup/GravityConfig;", "", "center", "", "left", "right", "top", "bottom", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBottom", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCenter", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/locallife/groupon/struct/popup/GravityConfig;", "equals", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GravityConfig {

    @SerializedName("bottom")
    private final Boolean bottom;

    @SerializedName("center")
    private final Boolean center;

    @SerializedName("left")
    private final Boolean left;

    @SerializedName("right")
    private final Boolean right;

    @SerializedName("top")
    private final Boolean top;

    public GravityConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GravityConfig copy$default(GravityConfig r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.center;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.left;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.right;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.top;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.bottom;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Boolean component1() {
        return this.center;
    }

    public final Boolean component2() {
        return this.left;
    }

    public final Boolean component3() {
        return this.right;
    }

    public final Boolean component4() {
        return this.top;
    }

    public final Boolean component5() {
        return this.bottom;
    }

    public final GravityConfig copy(Boolean r100, Boolean r101, Boolean r110, Boolean r111, Boolean r112) {
        return new GravityConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GravityConfig) == true) goto L8;
        return false;
    L8:
        GravityConfig r101 = (GravityConfig) r100;
        if (Intrinsics.areEqual(this.center, r101.center) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.top, r101.top) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.center;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.left;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.right;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.top;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.bottom;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "GravityConfig(center=" + this.center + ", left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    public final Boolean getBottom() {
        return this.bottom;
    }

    public final Boolean getCenter() {
        return this.center;
    }

    public final Boolean getLeft() {
        return this.left;
    }

    public final Boolean getRight() {
        return this.right;
    }

    public final Boolean getTop() {
        return this.top;
    }

    public GravityConfig(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104) {
        this.center = r100;
        this.left = r101;
        this.right = r102;
        this.top = r103;
        this.bottom = r104;
    }

    public /* synthetic */ GravityConfig(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Boolean r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Boolean r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Boolean r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Boolean r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Boolean r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}

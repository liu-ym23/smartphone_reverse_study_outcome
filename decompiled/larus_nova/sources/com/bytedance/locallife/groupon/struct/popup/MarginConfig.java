package com.bytedance.locallife.groupon.struct.popup;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/popup/MarginConfig;", "", "verticalRatio", "", "horizontalRatio", "left", "", "top", "right", "bottom", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHorizontalRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLeft", "getRight", "getTop", "getVerticalRatio", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/popup/MarginConfig;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MarginConfig {

    @SerializedName("bottom")
    private final Integer bottom;

    @SerializedName("horizontal_ratio")
    private final Float horizontalRatio;

    @SerializedName("left")
    private final Integer left;

    @SerializedName("right")
    private final Integer right;

    @SerializedName("top")
    private final Integer top;

    @SerializedName("vertical_ratio")
    private final Float verticalRatio;

    public MarginConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MarginConfig copy$default(MarginConfig r100, Float r101, Float r102, Integer r103, Integer r104, Integer r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.verticalRatio;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.horizontalRatio;
    L8:
        Float r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.left;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.top;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.right;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.bottom;
    L20:
        Float r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Float component1() {
        return this.verticalRatio;
    }

    public final Float component2() {
        return this.horizontalRatio;
    }

    public final Integer component3() {
        return this.left;
    }

    public final Integer component4() {
        return this.top;
    }

    public final Integer component5() {
        return this.right;
    }

    public final Integer component6() {
        return this.bottom;
    }

    public final MarginConfig copy(Float r100, Float r110, Integer r111, Integer r112, Integer r113, Integer r114) {
        return new MarginConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MarginConfig) == true) goto L8;
        return false;
    L8:
        MarginConfig r101 = (MarginConfig) r100;
        if (Intrinsics.areEqual(this.verticalRatio, r101.verticalRatio) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.horizontalRatio, r101.horizontalRatio) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.top, r101.top) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Float r100 = this.verticalRatio;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.horizontalRatio;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.left;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.top;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.right;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.bottom;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "MarginConfig(verticalRatio=" + this.verticalRatio + ", horizontalRatio=" + this.horizontalRatio + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    }

    public final Integer getBottom() {
        return this.bottom;
    }

    public final Float getHorizontalRatio() {
        return this.horizontalRatio;
    }

    public final Integer getLeft() {
        return this.left;
    }

    public final Integer getRight() {
        return this.right;
    }

    public final Integer getTop() {
        return this.top;
    }

    public final Float getVerticalRatio() {
        return this.verticalRatio;
    }

    public MarginConfig(Float r100, Float r101, Integer r102, Integer r103, Integer r104, Integer r105) {
        this.verticalRatio = r100;
        this.horizontalRatio = r101;
        this.left = r102;
        this.top = r103;
        this.right = r104;
        this.bottom = r105;
    }

    public /* synthetic */ MarginConfig(Float r100, Float r101, Integer r102, Integer r103, Integer r110, Integer r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Float r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Float r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Integer r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}

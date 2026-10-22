package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveLayoutConfig;", "Ljava/io/Serializable;", "topMargin", "", "bottomMargin", "leftMargin", "rightMargin", "topPadding", "bottomPadding", "leftPadding", "rightPadding", "width", "height", "widthSelfAdapt", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBottomMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomPadding", "getHeight", "getLeftMargin", "getLeftPadding", "getRightMargin", "getRightPadding", "getTopMargin", "getTopPadding", "getWidth", "getWidthSelfAdapt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveLayoutConfig;", "equals", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveLayoutConfig implements Serializable {

    @SerializedName("bottom_margin")
    private final Integer bottomMargin;

    @SerializedName("bottom_padding")
    private final Integer bottomPadding;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("left_margin")
    private final Integer leftMargin;

    @SerializedName("left_padding")
    private final Integer leftPadding;

    @SerializedName("right_margin")
    private final Integer rightMargin;

    @SerializedName("right_padding")
    private final Integer rightPadding;

    @SerializedName("top_margin")
    private final Integer topMargin;

    @SerializedName("top_padding")
    private final Integer topPadding;

    @SerializedName("width")
    private final Integer width;

    @SerializedName("width_self_adapt")
    private final Boolean widthSelfAdapt;

    public ECLiveLayoutConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ ECLiveLayoutConfig copy$default(ECLiveLayoutConfig r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, Integer r18, Integer r19, Integer r20, Integer r21, Integer r22, Boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        Integer r2 = r12.topMargin;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Integer r3 = r12.bottomMargin;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = r12.leftMargin;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = r12.rightMargin;
    L19:
        if ((r24 & 16) == 0) goto L21;
        Integer r6 = r12.topPadding;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Integer r7 = r12.bottomPadding;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r8 = r12.leftPadding;
    L31:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        Integer r9 = r12.rightPadding;
    L35:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Integer r10 = r12.width;
    L39:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        Integer r11 = r12.height;
    L43:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        Boolean r1 = r12.widthSelfAdapt;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final Integer component1() {
        return this.topMargin;
    }

    public final Integer component10() {
        return this.height;
    }

    public final Boolean component11() {
        return this.widthSelfAdapt;
    }

    public final Integer component2() {
        return this.bottomMargin;
    }

    public final Integer component3() {
        return this.leftMargin;
    }

    public final Integer component4() {
        return this.rightMargin;
    }

    public final Integer component5() {
        return this.topPadding;
    }

    public final Integer component6() {
        return this.bottomPadding;
    }

    public final Integer component7() {
        return this.leftPadding;
    }

    public final Integer component8() {
        return this.rightPadding;
    }

    public final Integer component9() {
        return this.width;
    }

    public final ECLiveLayoutConfig copy(Integer r14, Integer r15, Integer r16, Integer r17, Integer r18, Integer r19, Integer r20, Integer r21, Integer r22, Integer r23, Boolean r24) {
        return new ECLiveLayoutConfig(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECLiveLayoutConfig) == false) goto L28;
        ECLiveLayoutConfig r4 = (ECLiveLayoutConfig) r3;
        if (Intrinsics.areEqual(this.topMargin, r4.topMargin) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottomMargin, r4.bottomMargin) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftMargin, r4.leftMargin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightMargin, r4.rightMargin) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.topPadding, r4.topPadding) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bottomPadding, r4.bottomPadding) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.leftPadding, r4.leftPadding) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.rightPadding, r4.rightPadding) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.width, r4.width) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.height, r4.height) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.widthSelfAdapt, r4.widthSelfAdapt) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.topMargin;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.bottomMargin;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.leftMargin;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.rightMargin;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.topPadding;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.bottomPadding;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.leftPadding;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.rightPadding;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.width;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.height;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.widthSelfAdapt;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveLayoutConfig(topMargin=" + this.topMargin + ", bottomMargin=" + this.bottomMargin + ", leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ", topPadding=" + this.topPadding + ", bottomPadding=" + this.bottomPadding + ", leftPadding=" + this.leftPadding + ", rightPadding=" + this.rightPadding + ", width=" + this.width + ", height=" + this.height + ", widthSelfAdapt=" + this.widthSelfAdapt + ")";
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final Integer getBottomPadding() {
        return this.bottomPadding;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Integer getLeftPadding() {
        return this.leftPadding;
    }

    public final Integer getRightMargin() {
        return this.rightMargin;
    }

    public final Integer getRightPadding() {
        return this.rightPadding;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final Integer getTopPadding() {
        return this.topPadding;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Boolean getWidthSelfAdapt() {
        return this.widthSelfAdapt;
    }

    public ECLiveLayoutConfig(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, Boolean r11) {
        this.topMargin = r1;
        this.bottomMargin = r2;
        this.leftMargin = r3;
        this.rightMargin = r4;
        this.topPadding = r5;
        this.bottomPadding = r6;
        this.leftPadding = r7;
        this.rightPadding = r8;
        this.width = r9;
        this.height = r10;
        this.widthSelfAdapt = r11;
    }

    public /* synthetic */ ECLiveLayoutConfig(Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, Integer r18, Integer r19, Integer r20, Integer r21, Integer r22, Boolean r23, int r24, DefaultConstructorMarker r25) {
        Boolean r2 = null;
        if ((r24 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}

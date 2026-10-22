package com.bytedance.android.livesdk.livecommerce.largemode.model;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u009e\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001e\u0010\u0013R\u001a\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b \u0010\u0013R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "Ljava/io/Serializable;", "widthConfig", "Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;", "heightConfig", "drawableScale", "", "leftMargin", "", "rightMargin", "topMargin", "bottomMargin", "leftPadding", "rightPadding", "topPadding", "bottomPadding", "radius", "(Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottomMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomPadding", "getDrawableScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHeightConfig", "()Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;", "getLeftMargin", "getLeftPadding", "getRadius", "getRightMargin", "getRightPadding", "getTopMargin", "getTopPadding", "getWidthConfig", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutSizeLargeModeConfig;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/livesdk/livecommerce/largemode/model/LayoutLargeModeConfig;", "equals", "", "other", "", "hashCode", "toString", "", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class LayoutLargeModeConfig implements Serializable {

    @SerializedName("bottom_margin")
    private final Integer bottomMargin;

    @SerializedName("bottom_padding")
    private final Integer bottomPadding;

    @SerializedName("drawable_scale")
    private final Float drawableScale;

    @SerializedName("height")
    private final LayoutSizeLargeModeConfig heightConfig;

    @SerializedName("left_margin")
    private final Integer leftMargin;

    @SerializedName("left_padding")
    private final Integer leftPadding;

    @SerializedName("radius")
    private final Integer radius;

    @SerializedName("right_margin")
    private final Integer rightMargin;

    @SerializedName("right_padding")
    private final Integer rightPadding;

    @SerializedName("top_margin")
    private final Integer topMargin;

    @SerializedName("top_padding")
    private final Integer topPadding;

    @SerializedName("width")
    private final LayoutSizeLargeModeConfig widthConfig;

    public LayoutLargeModeConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ LayoutLargeModeConfig copy$default(LayoutLargeModeConfig r13, LayoutSizeLargeModeConfig r14, LayoutSizeLargeModeConfig r15, Float r16, Integer r17, Integer r18, Integer r19, Integer r20, Integer r21, Integer r22, Integer r23, Integer r24, Integer r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        LayoutSizeLargeModeConfig r2 = r13.widthConfig;
    L7:
        if ((r26 & 2) == 0) goto L9;
        LayoutSizeLargeModeConfig r3 = r13.heightConfig;
    L11:
        if ((r26 & 4) == 0) goto L13;
        Float r4 = r13.drawableScale;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Integer r5 = r13.leftMargin;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Integer r6 = r13.rightMargin;
    L23:
        if ((r26 & 32) == 0) goto L25;
        Integer r7 = r13.topMargin;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Integer r8 = r13.bottomMargin;
    L31:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        Integer r9 = r13.leftPadding;
    L35:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Integer r10 = r13.rightPadding;
    L39:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        Integer r11 = r13.topPadding;
    L43:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        Integer r12 = r13.bottomPadding;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        Integer r1 = r13.radius;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final LayoutSizeLargeModeConfig component1() {
        return this.widthConfig;
    }

    public final Integer component10() {
        return this.topPadding;
    }

    public final Integer component11() {
        return this.bottomPadding;
    }

    public final Integer component12() {
        return this.radius;
    }

    public final LayoutSizeLargeModeConfig component2() {
        return this.heightConfig;
    }

    public final Float component3() {
        return this.drawableScale;
    }

    public final Integer component4() {
        return this.leftMargin;
    }

    public final Integer component5() {
        return this.rightMargin;
    }

    public final Integer component6() {
        return this.topMargin;
    }

    public final Integer component7() {
        return this.bottomMargin;
    }

    public final Integer component8() {
        return this.leftPadding;
    }

    public final Integer component9() {
        return this.rightPadding;
    }

    public final LayoutLargeModeConfig copy(LayoutSizeLargeModeConfig r15, LayoutSizeLargeModeConfig r16, Float r17, Integer r18, Integer r19, Integer r20, Integer r21, Integer r22, Integer r23, Integer r24, Integer r25, Integer r26) {
        return new LayoutLargeModeConfig(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LayoutLargeModeConfig) == false) goto L30;
        LayoutLargeModeConfig r4 = (LayoutLargeModeConfig) r3;
        if (Intrinsics.areEqual(this.widthConfig, r4.widthConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.heightConfig, r4.heightConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.drawableScale, r4.drawableScale) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.leftMargin, r4.leftMargin) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.rightMargin, r4.rightMargin) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.topMargin, r4.topMargin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottomMargin, r4.bottomMargin) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.leftPadding, r4.leftPadding) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.rightPadding, r4.rightPadding) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.topPadding, r4.topPadding) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.bottomPadding, r4.bottomPadding) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.radius, r4.radius) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        LayoutSizeLargeModeConfig r0 = this.widthConfig;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LayoutSizeLargeModeConfig r4 = this.heightConfig;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Float r7 = this.drawableScale;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.leftMargin;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.rightMargin;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.topMargin;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.bottomMargin;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.leftPadding;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.rightPadding;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.topPadding;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.bottomPadding;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.radius;
        if (r34 == null) goto L50;
        r1 = r34.hashCode();
    L50:
        return r33 + r1;
    L45:
        r32 = 0;
        goto L46
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
        return "LayoutLargeModeConfig(widthConfig=" + this.widthConfig + ", heightConfig=" + this.heightConfig + ", drawableScale=" + this.drawableScale + ", leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ", topMargin=" + this.topMargin + ", bottomMargin=" + this.bottomMargin + ", leftPadding=" + this.leftPadding + ", rightPadding=" + this.rightPadding + ", topPadding=" + this.topPadding + ", bottomPadding=" + this.bottomPadding + ", radius=" + this.radius + ")";
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final Integer getBottomPadding() {
        return this.bottomPadding;
    }

    public final Float getDrawableScale() {
        return this.drawableScale;
    }

    public final LayoutSizeLargeModeConfig getHeightConfig() {
        return this.heightConfig;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Integer getLeftPadding() {
        return this.leftPadding;
    }

    public final Integer getRadius() {
        return this.radius;
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

    public final LayoutSizeLargeModeConfig getWidthConfig() {
        return this.widthConfig;
    }

    public LayoutLargeModeConfig(LayoutSizeLargeModeConfig r1, LayoutSizeLargeModeConfig r2, Float r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, Integer r11, Integer r12) {
        this.widthConfig = r1;
        this.heightConfig = r2;
        this.drawableScale = r3;
        this.leftMargin = r4;
        this.rightMargin = r5;
        this.topMargin = r6;
        this.bottomMargin = r7;
        this.leftPadding = r8;
        this.rightPadding = r9;
        this.topPadding = r10;
        this.bottomPadding = r11;
        this.radius = r12;
    }

    public /* synthetic */ LayoutLargeModeConfig(LayoutSizeLargeModeConfig r14, LayoutSizeLargeModeConfig r15, Float r16, Integer r17, Integer r18, Integer r19, Integer r20, Integer r21, Integer r22, Integer r23, Integer r24, Integer r25, int r26, DefaultConstructorMarker r27) {
        Integer r2 = null;
        if ((r26 & 1) == 0) goto L5;
        LayoutSizeLargeModeConfig r1 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        LayoutSizeLargeModeConfig r3 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        Float r4 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r26 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r26 & 2048) != 0) goto L50;
        r2 = r25;
    L50:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r2);
        return;
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}

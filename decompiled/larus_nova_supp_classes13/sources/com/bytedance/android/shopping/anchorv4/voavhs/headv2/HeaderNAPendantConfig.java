package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;", "Ljava/io/Serializable;", "backgroundColor", "", "borderRadius", "", "borderWidth", "borderColor", "padding", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;", "margin", "height", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Ljava/lang/Double;)V", "getBackgroundColor", "()Ljava/lang/String;", "bgColorInt", "", "getBgColorInt", "()Ljava/lang/Integer;", "bgColorInt$delegate", "Lkotlin/Lazy;", "getBorderColor", "borderColorInt", "getBorderColorInt", "borderColorInt$delegate", "getBorderRadius", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getBorderWidth", "getHeight", "getMargin", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;", "getPadding", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Padding;Ljava/lang/Double;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNAPendantConfig implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;
    private final Lazy bgColorInt$delegate;

    @SerializedName("border_color")
    private final String borderColor;
    private final Lazy borderColorInt$delegate;

    @SerializedName("border_radius")
    private final Double borderRadius;

    @SerializedName("border_width")
    private final Double borderWidth;

    @SerializedName("height")
    private final Double height;

    @SerializedName("margin")
    private final Padding margin;

    @SerializedName("padding")
    private final Padding padding;

    public HeaderNAPendantConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ HeaderNAPendantConfig copy$default(HeaderNAPendantConfig r5, String r6, Double r7, Double r8, String r9, Padding r10, Padding r11, Double r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.backgroundColor;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.borderRadius;
    L8:
        Double r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.borderWidth;
    L11:
        Double r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.borderColor;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.padding;
    L17:
        Padding r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.margin;
    L20:
        Padding r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.height;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final Double component2() {
        return this.borderRadius;
    }

    public final Double component3() {
        return this.borderWidth;
    }

    public final String component4() {
        return this.borderColor;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final Padding component6() {
        return this.margin;
    }

    public final Double component7() {
        return this.height;
    }

    public final HeaderNAPendantConfig copy(String r10, Double r11, Double r12, String r13, Padding r14, Padding r15, Double r16) {
        return new HeaderNAPendantConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderNAPendantConfig) == false) goto L20;
        HeaderNAPendantConfig r4 = (HeaderNAPendantConfig) r3;
        if (Intrinsics.areEqual(this.backgroundColor, r4.backgroundColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.borderRadius, r4.borderRadius) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.borderWidth, r4.borderWidth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderColor, r4.borderColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.padding, r4.padding) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.margin, r4.margin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.height, r4.height) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final Integer getBgColorInt() {
        return (Integer) this.bgColorInt$delegate.getValue();
    }

    public final Integer getBorderColorInt() {
        return (Integer) this.borderColorInt$delegate.getValue();
    }

    public int hashCode() {
        String r0 = this.backgroundColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.borderRadius;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.borderWidth;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.borderColor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Padding r13 = this.padding;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Padding r16 = this.margin;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Double r19 = this.height;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
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
        return "HeaderNAPendantConfig(backgroundColor=" + this.backgroundColor + ", borderRadius=" + this.borderRadius + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", padding=" + this.padding + ", margin=" + this.margin + ", height=" + this.height + ")";
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final Double getBorderRadius() {
        return this.borderRadius;
    }

    public final Double getBorderWidth() {
        return this.borderWidth;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Padding getMargin() {
        return this.margin;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public HeaderNAPendantConfig(String r1, Double r2, Double r3, String r4, Padding r5, Padding r6, Double r7) {
        this.backgroundColor = r1;
        this.borderRadius = r2;
        this.borderWidth = r3;
        this.borderColor = r4;
        this.padding = r5;
        this.margin = r6;
        this.height = r7;
        this.bgColorInt$delegate = LazyKt.lazy(new HeaderNAPendantConfig$bgColorInt$2(this));
        this.borderColorInt$delegate = LazyKt.lazy(new HeaderNAPendantConfig$borderColorInt$2(this));
    }

    public /* synthetic */ HeaderNAPendantConfig(String r7, Double r8, Double r9, String r10, Padding r11, Padding r12, Double r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        Double r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Double r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Padding r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        Padding r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        Double r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}

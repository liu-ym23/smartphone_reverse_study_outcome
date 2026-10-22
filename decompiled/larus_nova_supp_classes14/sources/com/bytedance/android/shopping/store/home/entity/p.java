package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\u001c\u0010 \u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/p;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "headerBackgroundImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "a", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "headerCardImg", "getHeaderCardImg", "", "primaryColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "secondaryColor", "d", "", "transparency", "Ljava/lang/Double;", "h", "()Ljava/lang/Double;", "", "shopUiTheme", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "tabTextColor", "g", "navSearchColor", "getNavSearchColor", "tabIndicatorColor", "f", "maskAlpha", "b", "splitRadius", "getSplitRadius", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("header_background_img")
    private final ECUrlModel headerBackgroundImg;

    @SerializedName("header_card_img")
    private final ECUrlModel headerCardImg;

    @SerializedName("mask_alpha")
    private final Double maskAlpha;

    @SerializedName("nav_search_color")
    private final String navSearchColor;

    @SerializedName("primary_color")
    private final String primaryColor;

    @SerializedName("secondary_color")
    private final String secondaryColor;

    @SerializedName("shop_ui_theme")
    private final Integer shopUiTheme;

    @SerializedName("split_radius")
    private final Integer splitRadius;

    @SerializedName("tab_selected_indicator_color")
    private final String tabIndicatorColor;

    @SerializedName("tab_text_color")
    private final String tabTextColor;

    @SerializedName("transparency")
    private final Double transparency;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L28;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.headerBackgroundImg, r4.headerBackgroundImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.headerCardImg, r4.headerCardImg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.primaryColor, r4.primaryColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secondaryColor, r4.secondaryColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.transparency, r4.transparency) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopUiTheme, r4.shopUiTheme) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tabTextColor, r4.tabTextColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.navSearchColor, r4.navSearchColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.tabIndicatorColor, r4.tabIndicatorColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maskAlpha, r4.maskAlpha) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.splitRadius, r4.splitRadius) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.headerBackgroundImg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.headerCardImg;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.primaryColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.secondaryColor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Double r13 = this.transparency;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.shopUiTheme;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.tabTextColor;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.navSearchColor;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.tabIndicatorColor;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Double r28 = this.maskAlpha;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.splitRadius;
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

    public final String toString() {
        return "ECStoreHeaderStyleInfoDTO(headerBackgroundImg=" + this.headerBackgroundImg + ", headerCardImg=" + this.headerCardImg + ", primaryColor=" + this.primaryColor + ", secondaryColor=" + this.secondaryColor + ", transparency=" + this.transparency + ", shopUiTheme=" + this.shopUiTheme + ", tabTextColor=" + this.tabTextColor + ", navSearchColor=" + this.navSearchColor + ", tabIndicatorColor=" + this.tabIndicatorColor + ", maskAlpha=" + this.maskAlpha + ", splitRadius=" + this.splitRadius + ")";
    }

    public p() {
        this.headerBackgroundImg = null;
        this.headerCardImg = null;
        this.primaryColor = null;
        this.secondaryColor = null;
        this.transparency = null;
        this.shopUiTheme = null;
        this.tabTextColor = null;
        this.navSearchColor = null;
        this.tabIndicatorColor = null;
        this.maskAlpha = null;
        this.splitRadius = null;
    }

    public final ECUrlModel a() {
        return this.headerBackgroundImg;
    }

    public final Double b() {
        return this.maskAlpha;
    }

    public final String c() {
        return this.primaryColor;
    }

    public final String d() {
        return this.secondaryColor;
    }

    public final Integer e() {
        return this.shopUiTheme;
    }

    public final String f() {
        return this.tabIndicatorColor;
    }

    public final String g() {
        return this.tabTextColor;
    }

    public final Double h() {
        return this.transparency;
    }
}

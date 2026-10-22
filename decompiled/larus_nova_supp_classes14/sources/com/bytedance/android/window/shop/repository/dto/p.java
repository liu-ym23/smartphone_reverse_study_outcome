package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/p;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "id", "b", "Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO;", "categoryConfig", "Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO;", "a", "()Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "selectedIconUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "f", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "unSelectedIconUrl", "j", "selectedColor", "e", "unSelectedColor", "i", "selectBackgroundColor", "d", "selectedIndicatorColor", "g", "Lcom/bytedance/android/window/shop/repository/dto/a0;", "tabBackgroundColor", "Lcom/bytedance/android/window/shop/repository/dto/a0;", "h", "()Lcom/bytedance/android/window/shop/repository/dto/a0;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("category_config")
    private final WindowCategoryConfigDTO categoryConfig;

    @SerializedName("back_category_ids")
    private final String id;

    @SerializedName("front_category_name")
    private final String name;

    @SerializedName("selected_background_color")
    private final String selectBackgroundColor;

    @SerializedName("selected_color")
    private final String selectedColor;

    @SerializedName(alternate = {"selected_icon_transparent_url"}, value = "selected_icon_url")
    private final ECUrlModel selectedIconUrl;

    @SerializedName("selected_indicator_color")
    private final String selectedIndicatorColor;

    @SerializedName("tab_background_color")
    private final a0 tabBackgroundColor;

    @SerializedName("category_type")
    private final Integer type;

    @SerializedName("unselected_color")
    private final String unSelectedColor;

    @SerializedName(alternate = {"unselected_icon_transparent_url"}, value = "unselected_icon_url")
    private final ECUrlModel unSelectedIconUrl;

    public p() {
        this(null, null, 2047);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L28;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.categoryConfig, r4.categoryConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.selectedIconUrl, r4.selectedIconUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.unSelectedIconUrl, r4.unSelectedIconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedColor, r4.selectedColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.unSelectedColor, r4.unSelectedColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.selectBackgroundColor, r4.selectBackgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectedIndicatorColor, r4.selectedIndicatorColor) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.tabBackgroundColor, r4.tabBackgroundColor) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        WindowCategoryConfigDTO r7 = this.categoryConfig;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.type;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ECUrlModel r13 = this.selectedIconUrl;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ECUrlModel r16 = this.unSelectedIconUrl;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.selectedColor;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.unSelectedColor;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.selectBackgroundColor;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.selectedIndicatorColor;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        a0 r31 = this.tabBackgroundColor;
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
        return "WindowCategoryDTO(name=" + this.name + ", id=" + this.id + ", categoryConfig=" + this.categoryConfig + ", type=" + this.type + ", selectedIconUrl=" + this.selectedIconUrl + ", unSelectedIconUrl=" + this.unSelectedIconUrl + ", selectedColor=" + this.selectedColor + ", unSelectedColor=" + this.unSelectedColor + ", selectBackgroundColor=" + this.selectBackgroundColor + ", selectedIndicatorColor=" + this.selectedIndicatorColor + ", tabBackgroundColor=" + this.tabBackgroundColor + ")";
    }

    public final WindowCategoryConfigDTO a() {
        return this.categoryConfig;
    }

    public final String b() {
        return this.id;
    }

    public final String c() {
        return this.name;
    }

    public final String d() {
        return this.selectBackgroundColor;
    }

    public final String e() {
        return this.selectedColor;
    }

    public final ECUrlModel f() {
        return this.selectedIconUrl;
    }

    public final String g() {
        return this.selectedIndicatorColor;
    }

    public final Integer getType() {
        return this.type;
    }

    public final a0 h() {
        return this.tabBackgroundColor;
    }

    public final String i() {
        return this.unSelectedColor;
    }

    public final ECUrlModel j() {
        return this.unSelectedIconUrl;
    }

    public p(String r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this.name = r3;
        this.id = r4;
        this.categoryConfig = null;
        this.type = null;
        this.selectedIconUrl = null;
        this.unSelectedIconUrl = null;
        this.selectedColor = null;
        this.unSelectedColor = null;
        this.selectBackgroundColor = null;
        this.selectedIndicatorColor = null;
        this.tabBackgroundColor = null;
    }
}

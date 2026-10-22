package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\r\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "", "isCustomized", "", "bgSkinStyle", "", "pageBackgroundImage", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getBgSkinStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPageBackgroundImage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "equals", "other", "hashCode", "isDarkTheme", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomizedMallBgSkin {

    @SerializedName("bg_skin_style")
    private final Integer bgSkinStyle;

    @SerializedName("is_customized")
    private final Boolean isCustomized;

    @SerializedName("page_background_image")
    private final String pageBackgroundImage;

    public CustomizedMallBgSkin() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CustomizedMallBgSkin copy$default(CustomizedMallBgSkin r0, Boolean r1, Integer r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isCustomized;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.bgSkinStyle;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.pageBackgroundImage;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Boolean component1() {
        return this.isCustomized;
    }

    public final Integer component2() {
        return this.bgSkinStyle;
    }

    public final String component3() {
        return this.pageBackgroundImage;
    }

    public final CustomizedMallBgSkin copy(Boolean r2, Integer r3, String r4) {
        return new CustomizedMallBgSkin(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CustomizedMallBgSkin) == false) goto L12;
        CustomizedMallBgSkin r4 = (CustomizedMallBgSkin) r3;
        if (Intrinsics.areEqual(this.isCustomized, r4.isCustomized) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgSkinStyle, r4.bgSkinStyle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageBackgroundImage, r4.pageBackgroundImage) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Boolean r0 = this.isCustomized;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.bgSkinStyle;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.pageBackgroundImage;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CustomizedMallBgSkin(isCustomized=" + this.isCustomized + ", bgSkinStyle=" + this.bgSkinStyle + ", pageBackgroundImage=" + this.pageBackgroundImage + ")";
    }

    public final Boolean isDarkTheme() {
        Boolean r0 = this.isCustomized;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L16;
        Integer r2 = this.bgSkinStyle;
        if (r2 != null) goto L8;
    L10:
        if (r2 == null) goto L16;
        if (r2.intValue() != 1) goto L16;
        return Boolean.FALSE;
    L8:
        if (r2.intValue() != 2) goto L10;
        return r1;
    L16:
        return null;
    }

    public final Integer getBgSkinStyle() {
        return this.bgSkinStyle;
    }

    public final String getPageBackgroundImage() {
        return this.pageBackgroundImage;
    }

    public final Boolean isCustomized() {
        return this.isCustomized;
    }

    public CustomizedMallBgSkin(Boolean r1, Integer r2, String r3) {
        this.isCustomized = r1;
        this.bgSkinStyle = r2;
        this.pageBackgroundImage = r3;
    }

    public /* synthetic */ CustomizedMallBgSkin(Boolean r2, Integer r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}

package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/ShopListHeaderSettingDTO;", "Ljava/io/Serializable;", "fontSize", "", "fontColor", "", "titlePicUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "bgColor", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getFontColor", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitlePicUrl", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/repository/dto/ShopListHeaderSettingDTO;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopListHeaderSettingDTO implements Serializable {

    @SerializedName("bg_colour_and_transparency_andriod")
    private final String bgColor;

    @SerializedName("shoplist_title_font_colour")
    private final String fontColor;

    @SerializedName("shoplist_title_font_size")
    private final Integer fontSize;

    @SerializedName("shoplist_title_pic_url")
    private final ECUrlModel titlePicUrl;

    public ShopListHeaderSettingDTO() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ShopListHeaderSettingDTO copy$default(ShopListHeaderSettingDTO r0, Integer r1, String r2, ECUrlModel r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.fontSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.fontColor;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.titlePicUrl;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.bgColor;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.fontSize;
    }

    public final String component2() {
        return this.fontColor;
    }

    public final ECUrlModel component3() {
        return this.titlePicUrl;
    }

    public final String component4() {
        return this.bgColor;
    }

    public final ShopListHeaderSettingDTO copy(Integer r2, String r3, ECUrlModel r4, String r5) {
        return new ShopListHeaderSettingDTO(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShopListHeaderSettingDTO) == false) goto L14;
        ShopListHeaderSettingDTO r4 = (ShopListHeaderSettingDTO) r3;
        if (Intrinsics.areEqual(this.fontSize, r4.fontSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fontColor, r4.fontColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.titlePicUrl, r4.titlePicUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgColor, r4.bgColor) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.fontSize;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.fontColor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.titlePicUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.bgColor;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "ShopListHeaderSettingDTO(fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", titlePicUrl=" + this.titlePicUrl + ", bgColor=" + this.bgColor + ")";
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final ECUrlModel getTitlePicUrl() {
        return this.titlePicUrl;
    }

    public ShopListHeaderSettingDTO(Integer r1, String r2, ECUrlModel r3, String r4) {
        this.fontSize = r1;
        this.fontColor = r2;
        this.titlePicUrl = r3;
        this.bgColor = r4;
    }

    public /* synthetic */ ShopListHeaderSettingDTO(Integer r2, String r3, ECUrlModel r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}

package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\u001d\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jh\u0010\u001f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006("}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/GsSalesInfo;", "Ljava/io/Serializable;", "avatarImages", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "amount", "", "suffixText", "backgroundGradientColor", "Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "textColor", "borderColor", "(Ljava/util/ArrayList;Ljava/lang/Long;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAvatarImages", "()Ljava/util/ArrayList;", "getBackgroundGradientColor", "()Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;", "getBorderColor", "()Ljava/lang/String;", "getSuffixText", "getTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/ArrayList;Ljava/lang/Long;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/ECGradientStruct;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/discover/model/GsSalesInfo;", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GsSalesInfo implements Serializable {

    @SerializedName("amount")
    private final Long amount;

    @SerializedName("avatar_images")
    private final ArrayList<String> avatarImages;

    @SerializedName("background_gradient_color")
    private final ECGradientStruct backgroundGradientColor;

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("suffix_text")
    private final String suffixText;

    @SerializedName("text_color")
    private final String textColor;

    public GsSalesInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GsSalesInfo copy$default(GsSalesInfo r100, ArrayList r101, Long r102, String r103, ECGradientStruct r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.avatarImages;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.amount;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.suffixText;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.backgroundGradientColor;
    L14:
        ECGradientStruct r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.textColor;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.borderColor;
    L20:
        ArrayList r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final ArrayList<String> component1() {
        return this.avatarImages;
    }

    public final Long component2() {
        return this.amount;
    }

    public final String component3() {
        return this.suffixText;
    }

    public final ECGradientStruct component4() {
        return this.backgroundGradientColor;
    }

    public final String component5() {
        return this.textColor;
    }

    public final String component6() {
        return this.borderColor;
    }

    public final GsSalesInfo copy(ArrayList<String> r100, Long r110, String r111, ECGradientStruct r112, String r113, String r114) {
        return new GsSalesInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GsSalesInfo) == false) goto L18;
        GsSalesInfo r101 = (GsSalesInfo) r100;
        if (Intrinsics.areEqual(this.avatarImages, r101.avatarImages) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.amount, r101.amount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.suffixText, r101.suffixText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundGradientColor, r101.backgroundGradientColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        ArrayList<String> r100 = this.avatarImages;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.amount;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.suffixText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECGradientStruct r110 = this.backgroundGradientColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.textColor;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.borderColor;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GsSalesInfo(avatarImages=" + this.avatarImages + ", amount=" + this.amount + ", suffixText=" + this.suffixText + ", backgroundGradientColor=" + this.backgroundGradientColor + ", textColor=" + this.textColor + ", borderColor=" + this.borderColor + ")";
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final ArrayList<String> getAvatarImages() {
        return this.avatarImages;
    }

    public final ECGradientStruct getBackgroundGradientColor() {
        return this.backgroundGradientColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getSuffixText() {
        return this.suffixText;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public GsSalesInfo(ArrayList<String> r100, Long r101, String r102, ECGradientStruct r103, String r104, String r105) {
        this.avatarImages = r100;
        this.amount = r101;
        this.suffixText = r102;
        this.backgroundGradientColor = r103;
        this.textColor = r104;
        this.borderColor = r105;
    }

    public /* synthetic */ GsSalesInfo(ArrayList r100, Long r101, String r102, ECGradientStruct r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        ArrayList r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Long r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        ECGradientStruct r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
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

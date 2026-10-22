package com.bytedance.locallife.groupon.struct;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003Jb\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\u0006\u0010+\u001a\u00020'J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u0006-"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/TopSloganStruct;", "Ljava/io/Serializable;", "couponAmount", "", "couponImage", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "sloganImageLeft", "sloganImageRight", "autoFullScreen", "", "autoFullDelayTime", "", "frequencyInfo", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "(Ljava/lang/String;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Integer;Ljava/lang/Long;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;)V", "getAutoFullDelayTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAutoFullScreen", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCouponAmount", "()Ljava/lang/String;", "getCouponImage", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getFrequencyInfo", "()Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "getSloganImageLeft", "getSloganImageRight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/Integer;Ljava/lang/Long;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;)Lcom/bytedance/locallife/groupon/struct/TopSloganStruct;", "equals", "", "other", "", "hashCode", "shouldAutoFullScreen", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TopSloganStruct implements Serializable {

    @SerializedName("auto_full_delay_time")
    private final Long autoFullDelayTime;

    @SerializedName("auto_full_screen")
    private final Integer autoFullScreen;

    @SerializedName("coupon_amount")
    private final String couponAmount;

    @SerializedName("coupon_image")
    private final UrlModel couponImage;

    @SerializedName("frequency_info")
    private final FrequencyInfo frequencyInfo;

    @SerializedName("slogan_image_left")
    private final UrlModel sloganImageLeft;

    @SerializedName("slogan_image_right")
    private final UrlModel sloganImageRight;

    public TopSloganStruct() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ TopSloganStruct copy$default(TopSloganStruct r100, String r101, UrlModel r102, UrlModel r103, UrlModel r104, Integer r110, Long r111, FrequencyInfo r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.couponAmount;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.couponImage;
    L8:
        UrlModel r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.sloganImageLeft;
    L11:
        UrlModel r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.sloganImageRight;
    L14:
        UrlModel r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.autoFullScreen;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.autoFullDelayTime;
    L20:
        Long r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.frequencyInfo;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.couponAmount;
    }

    public final UrlModel component2() {
        return this.couponImage;
    }

    public final UrlModel component3() {
        return this.sloganImageLeft;
    }

    public final UrlModel component4() {
        return this.sloganImageRight;
    }

    public final Integer component5() {
        return this.autoFullScreen;
    }

    public final Long component6() {
        return this.autoFullDelayTime;
    }

    public final FrequencyInfo component7() {
        return this.frequencyInfo;
    }

    public final TopSloganStruct copy(String r110, UrlModel r111, UrlModel r112, UrlModel r113, Integer r114, Long r115, FrequencyInfo r116) {
        return new TopSloganStruct(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TopSloganStruct) == true) goto L8;
        return false;
    L8:
        TopSloganStruct r101 = (TopSloganStruct) r100;
        if (Intrinsics.areEqual(this.couponAmount, r101.couponAmount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponImage, r101.couponImage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sloganImageLeft, r101.sloganImageLeft) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sloganImageRight, r101.sloganImageRight) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.autoFullScreen, r101.autoFullScreen) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.autoFullDelayTime, r101.autoFullDelayTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.frequencyInfo, r101.frequencyInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.couponAmount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UrlModel r104 = this.couponImage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        UrlModel r107 = this.sloganImageLeft;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UrlModel r110 = this.sloganImageRight;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.autoFullScreen;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.autoFullDelayTime;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        FrequencyInfo r119 = this.frequencyInfo;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "TopSloganStruct(couponAmount=" + this.couponAmount + ", couponImage=" + this.couponImage + ", sloganImageLeft=" + this.sloganImageLeft + ", sloganImageRight=" + this.sloganImageRight + ", autoFullScreen=" + this.autoFullScreen + ", autoFullDelayTime=" + this.autoFullDelayTime + ", frequencyInfo=" + this.frequencyInfo + ')';
    }

    public final boolean shouldAutoFullScreen() {
        Integer r100 = this.autoFullScreen;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public final Long getAutoFullDelayTime() {
        return this.autoFullDelayTime;
    }

    public final Integer getAutoFullScreen() {
        return this.autoFullScreen;
    }

    public final String getCouponAmount() {
        return this.couponAmount;
    }

    public final UrlModel getCouponImage() {
        return this.couponImage;
    }

    public final FrequencyInfo getFrequencyInfo() {
        return this.frequencyInfo;
    }

    public final UrlModel getSloganImageLeft() {
        return this.sloganImageLeft;
    }

    public final UrlModel getSloganImageRight() {
        return this.sloganImageRight;
    }

    public TopSloganStruct(String r100, UrlModel r101, UrlModel r102, UrlModel r103, Integer r104, Long r105, FrequencyInfo r106) {
        this.couponAmount = r100;
        this.couponImage = r101;
        this.sloganImageLeft = r102;
        this.sloganImageRight = r103;
        this.autoFullScreen = r104;
        this.autoFullDelayTime = r105;
        this.frequencyInfo = r106;
    }

    public /* synthetic */ TopSloganStruct(String r100, UrlModel r101, UrlModel r102, UrlModel r110, Integer r111, Long r112, FrequencyInfo r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        UrlModel r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        UrlModel r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        UrlModel r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Long r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        FrequencyInfo r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}

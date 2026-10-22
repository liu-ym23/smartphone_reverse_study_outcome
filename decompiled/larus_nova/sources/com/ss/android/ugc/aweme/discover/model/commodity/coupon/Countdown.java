package com.ss.android.ugc.aweme.discover.model.commodity.coupon;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006%"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/Countdown;", "Ljava/io/Serializable;", "countdownBackgroundColor", "", "countdownEndText", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;", "countdownTextColor", "endTime", "", "headText", "tailText", "(Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;Ljava/lang/String;Ljava/lang/Long;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;)V", "getCountdownBackgroundColor", "()Ljava/lang/String;", "getCountdownEndText", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;", "getCountdownTextColor", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHeadText", "getTailText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;Ljava/lang/String;Ljava/lang/Long;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;)Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/Countdown;", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Countdown implements Serializable {

    @SerializedName("countdown_background_color")
    private final String countdownBackgroundColor;

    @SerializedName("countdown_end_text")
    private final CouponText countdownEndText;

    @SerializedName("countdown_text_color")
    private final String countdownTextColor;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("head_text")
    private final CouponText headText;

    @SerializedName("tail_text")
    private final CouponText tailText;

    public Countdown() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Countdown copy$default(Countdown r100, String r101, CouponText r102, String r103, Long r104, CouponText r105, CouponText r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.countdownBackgroundColor;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.countdownEndText;
    L8:
        CouponText r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.countdownTextColor;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.endTime;
    L14:
        Long r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.headText;
    L17:
        CouponText r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.tailText;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.countdownBackgroundColor;
    }

    public final CouponText component2() {
        return this.countdownEndText;
    }

    public final String component3() {
        return this.countdownTextColor;
    }

    public final Long component4() {
        return this.endTime;
    }

    public final CouponText component5() {
        return this.headText;
    }

    public final CouponText component6() {
        return this.tailText;
    }

    public final Countdown copy(String r100, CouponText r110, String r111, Long r112, CouponText r113, CouponText r114) {
        return new Countdown(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Countdown) == false) goto L18;
        Countdown r101 = (Countdown) r100;
        if (Intrinsics.areEqual(this.countdownBackgroundColor, r101.countdownBackgroundColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.countdownEndText, r101.countdownEndText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.countdownTextColor, r101.countdownTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.headText, r101.headText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.tailText, r101.tailText) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.countdownBackgroundColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CouponText r104 = this.countdownEndText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.countdownTextColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.endTime;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        CouponText r113 = this.headText;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        CouponText r116 = this.tailText;
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
        return "Countdown(countdownBackgroundColor=" + this.countdownBackgroundColor + ", countdownEndText=" + this.countdownEndText + ", countdownTextColor=" + this.countdownTextColor + ", endTime=" + this.endTime + ", headText=" + this.headText + ", tailText=" + this.tailText + ")";
    }

    public final String getCountdownBackgroundColor() {
        return this.countdownBackgroundColor;
    }

    public final CouponText getCountdownEndText() {
        return this.countdownEndText;
    }

    public final String getCountdownTextColor() {
        return this.countdownTextColor;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final CouponText getHeadText() {
        return this.headText;
    }

    public final CouponText getTailText() {
        return this.tailText;
    }

    public Countdown(String r100, CouponText r101, String r102, Long r103, CouponText r104, CouponText r105) {
        this.countdownBackgroundColor = r100;
        this.countdownEndText = r101;
        this.countdownTextColor = r102;
        this.endTime = r103;
        this.headText = r104;
        this.tailText = r105;
    }

    public /* synthetic */ Countdown(String r100, CouponText r101, String r102, Long r103, CouponText r110, CouponText r111, int r112, DefaultConstructorMarker r113) {
        String r104 = "";
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        CouponText r105 = null;
    L11:
        if ((r112 & 4) != 0) goto L15;
        r104 = r102;
    L15:
        if ((r112 & 8) == 0) goto L17;
        r103 = 0L;
    L17:
        Long r106 = r103;
        if ((r112 & 16) == 0) goto L20;
        CouponText r107 = null;
    L22:
        if ((r112 & 32) == 0) goto L24;
        CouponText r115 = null;
    L25:
        this(r114, r105, r104, r106, r107, r115);
        return;
    L24:
        r115 = r111;
        goto L25
    L20:
        r107 = r110;
        goto L22
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}

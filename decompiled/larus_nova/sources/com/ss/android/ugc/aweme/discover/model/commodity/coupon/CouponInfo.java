package com.ss.android.ugc.aweme.discover.model.commodity.coupon;

import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponInfo;", "Ljava/io/Serializable;", "background", "", RXScreenCaptureService.KEY_CONTENT_TEXT, "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;", "countdown", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/Countdown;", "headIcon", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIcon;", "headText", "(Ljava/lang/String;Ljava/util/List;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/Countdown;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIcon;Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;)V", "getBackground", "()Ljava/lang/String;", "getContentText", "()Ljava/util/List;", "getCountdown", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/Countdown;", "getHeadIcon", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIcon;", "getHeadText", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponInfo implements Serializable {

    @SerializedName("background")
    private final String background;

    @SerializedName("content_text")
    private final List<CouponText> contentText;

    @SerializedName("countdown")
    private final Countdown countdown;

    @SerializedName("head_icon")
    private final CouponIcon headIcon;

    @SerializedName("head_text")
    private final CouponText headText;

    public CouponInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CouponInfo copy$default(CouponInfo r100, String r101, List r102, Countdown r103, CouponIcon r104, CouponText r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.background;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.contentText;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.countdown;
    L11:
        Countdown r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.headIcon;
    L14:
        CouponIcon r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.headText;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.background;
    }

    public final List<CouponText> component2() {
        return this.contentText;
    }

    public final Countdown component3() {
        return this.countdown;
    }

    public final CouponIcon component4() {
        return this.headIcon;
    }

    public final CouponText component5() {
        return this.headText;
    }

    public final CouponInfo copy(String r100, List<CouponText> r101, Countdown r110, CouponIcon r111, CouponText r112) {
        return new CouponInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CouponInfo) == false) goto L16;
        CouponInfo r101 = (CouponInfo) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.contentText, r101.contentText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.countdown, r101.countdown) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headIcon, r101.headIcon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.headText, r101.headText) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.background;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<CouponText> r104 = this.contentText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Countdown r107 = this.countdown;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        CouponIcon r110 = this.headIcon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        CouponText r113 = this.headText;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "CouponInfo(background=" + this.background + ", contentText=" + this.contentText + ", countdown=" + this.countdown + ", headIcon=" + this.headIcon + ", headText=" + this.headText + ")";
    }

    public final String getBackground() {
        return this.background;
    }

    public final List<CouponText> getContentText() {
        return this.contentText;
    }

    public final Countdown getCountdown() {
        return this.countdown;
    }

    public final CouponIcon getHeadIcon() {
        return this.headIcon;
    }

    public final CouponText getHeadText() {
        return this.headText;
    }

    public CouponInfo(String r100, List<CouponText> r101, Countdown r102, CouponIcon r103, CouponText r104) {
        this.background = r100;
        this.contentText = r101;
        this.countdown = r102;
        this.headIcon = r103;
        this.headText = r104;
    }

    public /* synthetic */ CouponInfo(String r100, List r101, Countdown r102, CouponIcon r103, CouponText r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = "";
    L5:
        CouponText r106 = null;
        if ((r105 & 2) == 0) goto L8;
        List r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        Countdown r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        CouponIcon r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
